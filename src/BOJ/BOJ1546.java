package BOJ;

import java.util.Scanner;

/**
 * Created by bomeekim on 2017-04-25.
 */
public class BOJ1546 {
    public static void main(String[] args) {
        int N = 0;
        int M = 0;
        int[] array;
        double total = 0;

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        array = new int[N];

        for (int i=0; i<N; i++) {
            array[i] = scanner.nextInt();
            M = Math.max(M, array[i]);
        }

        for (int i=0; i<N; i++) {
            double score = (double) array[i]/M*100;
            total += score;
        }

        System.out.printf("%.2f", total/N);
    }
}
