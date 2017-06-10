package BOJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by bomeekim on 2017-04-13.
 */
public class BOJ2667 {

    static final int DIRECTIONS = 4;
    static final int DIRECTION[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, 1}, {-1, -1}, {1, -1}, {1, 1}};

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Integer> group = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        visited = new boolean[N][N];
        map = new int[N][N];

        for (int i=0; i<N; i++) {
            String str = scanner.next();

            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(str.charAt(j) + "");
            }
        }

        int groupCount = 0;

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    groupCount++;

                    int houseCount = dfs(i, j, 0);
                    group.add(houseCount);
                }
            }
        }

        Collections.sort(group);

        System.out.println(groupCount);

        for (int x : group) {
            System.out.println(x);
        }
    }

    public static int dfs(int row, int col, int houseCount) {

        houseCount++;
        visited[row][col] = true;

        for (int d=0; d<DIRECTIONS; d++) {
            int nextRow = row + DIRECTION[d][0];
            int nextCol = col + DIRECTION[d][1];

            if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) continue;
            if (map[nextRow][nextCol] == 0) continue;
            if (visited[nextRow][nextCol]) continue;

            houseCount = dfs(nextRow, nextCol, houseCount);
        }

        return houseCount;
    }
}
