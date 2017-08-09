package BOJ;

import java.util.Scanner;

/**
 * Created by bomeekim on 2017-08-04.
 */
public class BOJ1094 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int stickSize = 64; // 처음에 가지고 있는 막대
        int X = sc.nextInt(); // 만들고 싶은 막대 길이
        int num = 0; // X cm를 만드는 막대의 개수

        while (X != 0) {
            if (stickSize > X) stickSize /= 2;
            else {
                X -= stickSize;
                num++;
            }
        }

        System.out.println(num);
    }
}
