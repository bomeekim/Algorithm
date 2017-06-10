package BOJ;

import java.util.Scanner;

/**
 * Created by bomeekim on 2017-06-02.
 */
public class BOJ1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        System.out.println(solution(N));
    }

    static int solution(int N) {
        int[] D = new int[N+1];

        D[1] = 0;

        for (int i=2; i<=N; i++) {

            D[i] = D[i-1] + 1;

            if (i % 3 == 0 && D[i] > D[i/3] + 1)
                D[i] = D[i/3] + 1;

            if (i % 2 == 0 && D[i] > D[i/2] + 1)
                D[i] = D[i/2] + 1;
        }

        return D[N];
    }
}
