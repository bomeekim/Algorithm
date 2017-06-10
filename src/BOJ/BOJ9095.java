package BOJ;

import java.util.Scanner;

/**
 * Created by bomeekim on 2017-06-02.
 */
public class BOJ9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i=0; i<T; i++) {
            int N = sc.nextInt();
            System.out.println(solution(N));
        }
    }

    static int solution(int N) {
        int[] D = new int[11];

        D[0] = 0;
        D[1] = 1;
        D[2] = 2;
        D[3] = 4;

        for (int i=4; i<=N; i++) {
            D[i] = D[i-1] + D[i-2] + D[i-3];
        }

        return D[N];
    }
}
