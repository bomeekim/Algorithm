package BOJ;

import java.util.Scanner;

/**
 * Created by bomeekim on 2017-06-12.
 */
public class BOJ1912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] D = new int[100001];
        int[] array = new int [100001];

        for (int i=1; i<=N; i++) {
            array[i] = sc.nextInt();
        }

        D[1] = array[1];
        int max = D[1];

        for (int i=2; i<=N; i++) {
            D[i] = Math.max(D[i-1] + array[i], array[i]);

            if (D[i] > max) {
                max = D[i];
            }
        }

        System.out.println(max);
    }
}