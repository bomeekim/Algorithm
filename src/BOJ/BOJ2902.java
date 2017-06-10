package BOJ;

import java.util.Scanner;

/**
 * Created by bomeekim on 2017-05-26.
 */
public class BOJ2902 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.next().split("-");

        for (int i=0; i<input.length; i++) {
            System.out.print(input[i].charAt(0));
        }
    }
}
