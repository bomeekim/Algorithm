package BOJ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by bomeekim on 2017-05-21.
 */
public class BOJ1026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        Integer[] B = new Integer[N];
        sc.nextLine();

        int sum = 0;

        for (int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }


        for (int i=0; i<N; i++) {
            B[i] = sc.nextInt();
        }

        Arrays.sort(A);
        Arrays.sort(B, new ComparatorSort());

        for (int i=0; i<N; i++) {
            sum += A[i] * B[i];
        }

        System.out.println(sum);
    }
}

class ComparatorSort implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {

        if (o1 > o2) {
            return -1;
        } else if (o1 == o2) {
            return 0;
        } else {
            return 1;
        }
    }
}