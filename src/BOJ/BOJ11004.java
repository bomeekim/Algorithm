package BOJ;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by bomeekim on 2017-08-08.
 */
public class BOJ11004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] array = new int[N];

        for (int i=0; i<N; i++) {
            array[i] = sc.nextInt();
        }

//        Arrays.sort(array);

        Quick quick = new Quick();
        quick.sort(array, 0, N-1);

        for (int i=0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println(array[K-1]);
    }

    private static class Quick {
        public void sort(int[] data, int l, int r) {
            int left = l;
            int right = r;
            int pivot = data[(l+r) / 2];

            do {
                while (data[left] < pivot) left++;
                while (data[right] > pivot) right--;

                if (left <= right) {
                    int temp = data[left];
                    data[left] = data[right];
                    data[right] = temp;

                    left++;
                    right--;
                }
            } while (left <= right);

            if (l < right) sort(data, l, right);
            if (r > left) sort(data, left, r);
        }
    }
}
