package BOJ;

import java.util.Scanner;

/**
 * Created by bomeekim on 2017-05-23.
 */
public class BOJ11403 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] map = new int[N][N];

        sc.nextLine();

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int k=0; k<N; k++) {
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (map[i][k] == 1 && map[k][j] == 1)
                        map[i][j] = 1;
                }
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
