package BOJ;

import java.util.Scanner;

/**
 * Created by bomeekim on 2017-06-20.
 */
public class BOJ11727 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 3;

        for (int i=3; i<=N; i++) {
            dp[i] = (dp[i-1] + 2 * dp[i-2]) % 10007;
        }

        System.out.println(dp[N]);
    }
}
