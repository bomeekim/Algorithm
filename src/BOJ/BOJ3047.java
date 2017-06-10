package BOJ;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by bomeekim on 2017-05-18.
 */
public class BOJ3047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[3];

        for (int i=0; i<3; i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);

        sc.nextLine();

        String s = sc.nextLine();

        for (int i=0; i<s.length(); i++) {
            System.out.print(array[s.charAt(i) - 65] + " ");
        }
    }
}
