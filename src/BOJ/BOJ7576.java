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

                if (box[i][j] == 1) {
                    Tomato tomato = new Tomato(i, j);
                    queue.offer(tomato); // 익은 토마토인 경우 bfs 탐색을 위해 queue에 넣음
                } else {
                    greenCount++; // 안 익은 토마토 개수 증가
                }
            }
        }

        bfs();
    }

    public static void bfs() {
        int result = 0;

        while (!queue.isEmpty()) {
            Tomato t = (Tomato) queue.poll();

            if (greenCount == 0) break;

            for (int d=0; d<DIRECTIONS; d++) {

                Tomato next = new Tomato(t.x + dx[d], t.y + dy[d]);

                if (next.x < 0 || next.x >= N || next.y < 0 || next.y >= M) continue;

                greenCount--; // 익지 않은 토마토 개수 감소
                box[next.x][next.y] = RED; // 익지않은 토마토 -> 익음
                queue.offer(next);
            }
            result++;
        }

        if (greenCount != 0) // 토마토가 모두 익지 못하는 상황일 때
            result = -1;

        System.out.println(result);
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
