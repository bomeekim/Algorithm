package BOJ;

import java.util.Scanner;

/**
 * Created by bomeekim on 2017-08-01.
 */
public class BOJ13458 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 시험장의 수
        int[] examinee = new int[N];

        for (int i=0; i<N; i++) {
            examinee[i] = sc.nextInt(); // 각 시험장에 있는 응시자의 수
        }

        int B = sc.nextInt(); // 총감독관이 감시할 수 있는 응시자 수
        int C = sc.nextInt(); // 부감독관이 감시할 수 있는 응시자 수

        long count = 0;

        for (int i=0; i<N; i++) {
            examinee[i] = examinee[i] - B;
            count++;

            if (examinee[i] > 0) {
                long temp1 = examinee[i] / C;
                long temp2 = examinee[i] % C;

                count += temp1;

                if (temp2 > 0)
                    count++;
            }
        }

        System.out.println(count);
    }
}
