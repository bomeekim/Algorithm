package BOJ;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by bomeekim on 2017-05-02.
 */
public class BOJ2751 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] array = new int[N];

        for (int i=0; i<N; i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);

        for (int a : array) {
            System.out.println(a);
        }
    }
}
