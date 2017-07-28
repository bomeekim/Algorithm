package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by bomeekim on 2017-07-26.
 */
public class BOJ7576 {

    static final int DIRECTIONS = 4;
    static final int[] dx = {0, 0, 1, -1}; // 동 서 남 북
    static final int[] dy = {1, -1, 0, 0}; // 동 서 남 북

    static final int RED = 1; // 익은 토마토
    static final int GREEN = 0; // 익은 토마토

    static int N; // 상자의 세로 칸의 수
    static int M; // 상자의 가로 칸의 수

    static int[][] box;
    static Queue queue = new LinkedList<Tomato>();

    static int greenCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        box = new int[N][M];

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                box[i][j] = sc.nextInt();

                if (box[i][j] == RED) {
                    Tomato tomato = new Tomato(i, j);
                    queue.offer(tomato); // 익은 토마토인 경우 bfs 탐색을 위해 queue에 넣음
                } else if (box[i][j] == GREEN) {
                    greenCount++; // 안 익은 토마토 개수 증가
                }
            }
        }

        bfs();
    }


    public static void bfs() {
        int result = 1;

        while (!queue.isEmpty()) {
            Tomato tomato = (Tomato) queue.poll();

            for (int d=0; d<DIRECTIONS; d++) {
                int nextX = tomato.x + dx[d];
                int nextY = tomato.y + dy[d];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                else {
                    if (box[nextX][nextY] == GREEN) {
                        greenCount--;
                        box[nextX][nextY] = box[tomato.x][tomato.y] + 1;
                        queue.offer(new Tomato(nextX, nextY));

                        if (result < box[nextX][nextY])
                            result = box[nextX][nextY];
                    }
                }

                System.out.println(greenCount + " , " + result);
            }

            if (greenCount == 0) break;
        }

        if (greenCount == 0)
            result -= 1;
        else
            result = -1;

        System.out.println("----------------");

        print();

        System.out.println("----------------");


        System.out.println(result);
    }

    public static void print() {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                System.out.print(box[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static class Tomato {
        int x;
        int y;

        public Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
