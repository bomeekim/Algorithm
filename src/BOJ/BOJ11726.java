package BOJ;

import java.util.Scanner;

/**
 * Created by bomeekim on 2017-06-02.
 */
public class BOJ11726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        System.out.println(solution(N));
    }

    static int solution(int N) {
        int[] D = new int[1001];

        D[0] = 0;
        D[1] = 1;
        D[2] = 2;
        D[3] = 3;
        D[4] = 5;

        for (int i=5; i<=N; i++) {
            D[i] = D[i-1] + D[i-2];
            D[i] %= 10007;
        }

        return D[N];
    }
}
