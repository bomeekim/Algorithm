package codeground;

/**
 * Created by bomeekim on 2018-01-05.
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Practice03 {
    static int Answer;

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test_case = 0; test_case < T; test_case++) {

            int N = sc.nextInt();
            int K = sc.nextInt();

            Answer = solution(N, K, sc);

            // Print the answer to standard output(screen).
            System.out.println("Case #" + (test_case + 1));
            System.out.println(Answer);
        }
    }

    public static int solution(int N, int K, Scanner sc) {
//        System.out.println("check value : N = " + N + ", K = " + K);

        ArrayList<Integer> arrayList = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < N; i++) {
            arrayList.add(sc.nextInt());
        }

        Collections.sort(arrayList);
        Collections.reverse(arrayList);

        for (int j = 0; j < K; j++) {
            sum += arrayList.get(j);
        }

//        System.out.println("result = " + sum);

        return sum;
    }
}