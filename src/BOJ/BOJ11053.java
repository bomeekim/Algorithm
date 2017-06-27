package BOJ;

import java.util.Scanner;

/**
 * Created by bomeekim on 2017-06-20.
 */
public class BOJ11053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] array = new int[1001];
        int[] dp = new int[1001];

        sc.nextLine();

        for (int i=1; i<=N; i++) {
            array[i] = sc.nextInt();
        }

        dp[1] = 1;
        int last = array[1];

        for (int i=2; i<=N; i++) {
            if (array[i-1] < array[i] || array[i] < array[i+1] && last <= array[i]) {
                last = array[i];
                dp[i] = dp[i - 1] + 1;
            }
            else
                dp[i] = dp[i-1];
        }

        System.out.println(dp[N]);
    }
}
