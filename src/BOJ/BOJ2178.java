package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by bomeekim on 2017-06-27.
 */
public class BOJ2178 {
    static final int DIRECTIONS = 4;
    static final int[][] DIRECTION = { // 동, 서, 남, 북 이동 방향에 대한 배열
            {1, 0}, // 동쪽
            {-1, 0}, // 서쪽
            {0, -1}, // 남쪽
            {0, 1} // 북쪽
    };

    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int M;
    static Queue queue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // row
        M = sc.nextInt(); // column

        sc.nextLine();

        map = new int[N][M];
        visited = new boolean[N][M];

        // map 에 input 값 넣기
        String str = "";
        for (int i=0; i<N; i++) {

            str = sc.next();

            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(str.charAt(j) + "");
            }
        }

        bfs(0, 0);
    }

    private static void bfs(int row, int col) {
        int count = 1;
        visited[row][col] = true;

        queue = new LinkedList<Point>();
        queue.offer(new Point(row, col));

        while (!queue.isEmpty()) {
            int size = queue.size(); // 현재 큐의 원소 개수

            for (int i=0; i<size; i++) { // 개수만큼 for문 실행
                Point temp = (Point) queue.poll();

                for (int d=0; d<DIRECTIONS; d++) {
                    int nextRow = temp.row + DIRECTION[d][0];
                    int nextCol = temp.col + DIRECTION[d][1];

                    if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M)
                        continue;

                    if (map[nextRow][nextCol] == 0)
                        continue;

                    if (visited[nextRow][nextCol])
                        continue;

                    if (map[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                        visited[nextRow][nextCol] = true;
                        queue.offer(new Point(nextRow, nextCol));

//                        System.out.println("nextRow = " + nextRow + " , nextCol = " + nextCol);

                        if (nextRow == N-1 && nextCol == M-1) {
                            System.out.println(count + 1);
                            break;
                        }
                    }
                }
            }
            count++;
        }
    }

    private static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
