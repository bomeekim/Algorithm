package BOJ;

import java.util.Scanner;

/**
 * Created by bomeekim on 2017-06-12.
 */
public class BOJ2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] score = new int[N+1];
        int[] dp = new int[N+1];

        for (int i=1; i<=N; i++) {
            score[i] = sc.nextInt();
        }

        dp[1] = score[1];
        dp[2] = Math.max(dp[1] + score[2], score[2]);
        dp[3] = Math.max(dp[1] + score[3], score[2] + score[3]);

        for (int i=4; i<=N; i++) {
            dp[i] = Math.max(dp[i-3] + score[i-1] + score[i], dp[i-2] + score[i]);
        }

        System.out.println(dp[N]);
    }
}
