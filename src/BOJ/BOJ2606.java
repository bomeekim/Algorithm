package BOJ;

import java.util.Scanner;

/**
 * Created by bomeekim on 2017-04-13.
 */
public class BOJ2606 {

    static int vCount;
    static int eCount;
    static int[][] ad;
    static boolean[] visited;
    static int pCount;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        vCount = scanner.nextInt();
        eCount = scanner.nextInt();

        ad = new int[vCount+1][vCount+1];
        visited = new boolean[vCount+1];

        for (int i=0; i<eCount; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();

            ad[v1][v2] = ad[v2][v1] = 1;
        }

        dfs(1);
        System.out.println(pCount-1);
    }

    public static void dfs(int v) {
        visited[v] = true;

        for (int i=1; i<vCount+1; i++) {
            if (ad[v][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }

        pCount++;
    }
}
