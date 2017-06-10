package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by bomeekim on 2017-04-14.
 */
public class BOJ2589 {

    static final int DIRECTIONS = 4;
    static final int[] dRow = {0, -1, 0, 1};
    static final int[] dCol = {-1, 0, 1, 0};

    static int rowNum;
    static int colNum;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        rowNum = scanner.nextInt();
        colNum = scanner.nextInt();

        map = new int[rowNum][colNum];
        visited = new boolean[rowNum][colNum];

        for (int i=0; i<rowNum; i++) {
            String str = scanner.next();

            for (int j=0; j<colNum; j++) {
                char c = str.charAt(j);

                map[i][j] = c == 'L' ? 0 : -1;
            }
        }

        int max = 0;

        for (int i=0; i<rowNum; i++) {
            for (int j=0; j<colNum; j++) {
                if (map[i][j] == -1) continue;

                max = Math.max(max, bfs(i, j));
            }
        }

        System.out.println(max);
    }

    public static int bfs(int row, int col) {
        int time = -1;

        for (int i=0; i<rowNum; i++) {
            for (int j=0; j<colNum; j++) {
                visited[i][j] = false;
            }
        }

        Queue<Point> q = new <Point>LinkedList();
        q.offer(new Point(row, col));
        visited[row][col] = true;

        while (!q.isEmpty()) {

            time++;

            int size = q.size();

            for (int i=0; i<size; i++) {
                Point point = q.poll();

                for (int d=0; d<DIRECTIONS; d++) {
                    int nextRow = point.row + dRow[d];
                    int nextCol = point.col + dCol[d];

                    if (nextRow < 0 || nextRow >= rowNum || nextCol < 0 || nextCol >= colNum) continue;
                    if (map[nextRow][nextCol] == -1) continue;
                    if (visited[nextRow][nextCol]) continue;

                    q.offer(new Point(nextRow, nextCol));
                    visited[nextRow][nextCol] = true;
                }
            }
        }

        return time;
    }

    public static class Point {
        int row;
        int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
