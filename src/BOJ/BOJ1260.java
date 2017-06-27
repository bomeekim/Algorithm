package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by bomeekim on 2017-06-27.
 */
public class BOJ1260 {

    static int N;
    static int M;
    static int[][] array;
    static boolean[] visited;
    static Queue queue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int start = sc.nextInt();

        sc.nextLine();

        array = new int[N+1][M+1];
        visited = new boolean[N+1];
        queue = new LinkedList<Integer>();

        for (int i=0; i<M; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();

            array[first][second] = array[second][first] = 1;
        }

        dfs(start);
        System.out.println();

        bfs(start);
        System.out.println();
    }

    public static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int i=1; i<=N; i++) {
            if (array[v][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int v) {
        boolean[] visited = new boolean[N+1];
        visited[v] = true;
        queue.offer(v);

        while(!queue.isEmpty()) {
            int temp = (int) queue.poll();

            System.out.print(temp + " ");

            for (int i=1; i<=M; i++) {
                if (array[v][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
