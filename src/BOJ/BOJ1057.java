package BOJ;

import java.util.Scanner;

/**
 * Created by bomeekim on 2017-08-04.
 */

public class BOJ1057 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 참가자 수
        int kim = sc.nextInt(); // 김지민의 번호
        int lim = sc.nextInt(); // 임한수의 번호

        int count = 0;

        if (N < kim || N < lim)
            count = -1;
        else {
            while (kim != lim) {
                kim = (kim / 2 + kim % 2);
                lim = (lim / 2 + lim % 2);
                count++;
            }
        }

        System.out.println(count);
    }
}
