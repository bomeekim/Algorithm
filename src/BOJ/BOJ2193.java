package BOJ;

import java.util.Scanner;

/**
 * Created by bomeekim on 2017-06-12.
 */
public class BOJ2193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] dp = new long[91];

        dp[1] = 1;
        dp[2] = 1;

        for (int i=3; i<=N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[N]);
    }
}
