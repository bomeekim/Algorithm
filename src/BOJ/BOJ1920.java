package BOJ;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by bomeekim on 2017-05-05.
 */
public class BOJ1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] array = new int[N];

        for (int i=0; i<N; i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);

        int M = sc.nextInt();
        int[] input = new int[M];

        for (int i=0; i<M; i++) {
            input[i] = sc.nextInt();
        }

        BinarySearch bs = new BinarySearch();

        for (int i=0; i<M; i++) {
            System.out.println(bs.search(array, input[i]));
        }
    }
}

class BinarySearch {
    public int search (int[] arr, int target) {
        int first = 0;
        int last = arr.length - 1;
        int mid;

        while (first <= last) {
            mid = (first + last) / 2;

            if (target == arr[mid]) {
                return 1;
            }
            else {
                if (target < arr[mid])
                    last = mid - 1;
                else
                    first = mid + 1;
            }
        }
        return 0;
    }
}