package BOJ;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by bomeekim on 2017-06-20.
 */
public class BOJ11054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] array = new int[1001];
        int[] dp = new int[1001];
        int count = 0;

        sc.nextLine();

        for (int i=1; i<=N; i++) {
            array[i] = sc.nextInt();
        }

        dp[1] = 1;

        if (array[2] > array[1])
            dp[2] = 1;

        for (int i=3; i<=N; i++) {
            if (array[i] > array[i-1] && array[i-1] > array[i-3])
                dp[i] = dp[i-1] + 1;
        }

        System.out.println(dp[N]);
    }
}
