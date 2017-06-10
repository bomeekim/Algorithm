package BOJ;

import java.util.Scanner;

/**
 * Created by bomeekim on 2017-05-25.
 */
public class BOJ9996 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String[] result = new String[N];

        sc.nextLine();

        String[] s = sc.nextLine().split("[*]");

        for (int i=0; i<N; i++) {
            String input = sc.nextLine();
            String pattern = "(^" + s[0] + ".*" + s[1] +"$)";

            if (input.matches(pattern)) {
                result[i] = "DA";
            } else {
                result[i] = "NE";
            }
        }

        for (int i=0; i<N; i++) {
            System.out.println(result[i]);
        }
    }
}
