package BOJ;

import java.util.Scanner;

/**
 * Created by bomeekim on 2017-06-07.
 */
public class BOJ2156 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] wine = new int[10001];
        int[] D = new int[10001];

        for (int i=1; i<=N; i++) {
            wine[i] = sc.nextInt();
        }

        D[0] = 0;
        D[1] = wine[1];
        D[2] = D[1] + wine[2];

        for (int i=3; i<=N; i++) {
            int case1 = D[i-3] + wine[i-1] + wine[i];
            int case2 = D[i-1];
            int case3 = D[i-2] + wine[i];

            D[i] = searchMaxValue(case1, case2, case3);
        }

        System.out.println(D[N]);
    }

    static int searchMaxValue (int a, int b, int c) {
        if (a >= b && a >= c)
            return a;
        else if (b >= a && b >= c)
            return b;
        else
            return c;
    }
}
