package BOJ;

import java.util.Scanner;

/**
 * Created by bomeekim on 2017-05-19.
 */
public class BOJ1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split("");

        int[] array = new int[str.length];
        Quick quick = new Quick();

        for (int i=0; i<str.length; i++) {
            array[i] = Integer.parseInt(str[i]);
        }

        quick.sort(array, 0, array.length-1);

        for (int i=array.length-1; i>=0; i--) {
            System.out.print(array[i]);
        }
    }
}

class Quick {
    public void sort(int[] data, int l, int r) {
        int left = l;
        int right = r;
        int pivot = data[(l+r)/2];

        do {
            while (data[left] < pivot)
                left++;
            while (data[right] > pivot)
                right--;

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