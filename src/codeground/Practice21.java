package codeground;

/**
 * Created by bomeekim on 2018-01-05.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Practice21 {
    static int Answer;

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test_case = 0; test_case < T; test_case++) {

            Answer = solution(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc);

            // Print the answer to standard output(screen).
            System.out.println("Case #" + (test_case + 1));

            if (Answer == 1)
                System.out.println("Y");
            else
                System.out.println("N");
        }
    }

    public static int solution(int N, int M, int K, Scanner sc) {

        int[] coffeePreference = new int[N];
        ArrayList<Starbucks> starbucksMenu = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < N; i++) {
            coffeePreference[i] = sc.nextInt();
        }

        for (int j = 0; j < M; j++) {
            Starbucks starbucks = new Starbucks(j + 1, sc.nextInt());
            starbucksMenu.add(starbucks);
        }

        for (int k = 0; k < coffeePreference.length; k++) {
            for (int p = 0; p < starbucksMenu.size(); p++) {
                if (coffeePreference[k] == starbucksMenu.get(p).code) {
                    sum += starbucksMenu.get(p).price;
                }
            }
        }

        if (sum <= K) return 1;
        else return 0;
    }

    public static class Starbucks {
        int code; // 커피 종류
        int price; // 커피 가격

        public Starbucks(int code, int price) {
            this.code = code;
            this.price = price;
        }
    }
}