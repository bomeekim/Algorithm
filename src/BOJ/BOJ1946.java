package BOJ;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by bomeekim on 2017-06-08.
 */
public class BOJ1946 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N;

        for (int i=0; i<T; i++) {
            N = sc.nextInt();

            Score[] newEmployeesList = new Score[N];

            for (int j=0; j<N; j++) {

                int document = sc.nextInt();
                int interview = sc.nextInt();

                Score score = new Score(document, interview);

                newEmployeesList[j] = score;
            }

            System.out.println(solution(N, newEmployeesList));
        }
    }

    public static int solution (int n, Score[] list) {

        Arrays.sort(list);

        int count = 1;
        int minInverview = list[0].interview;

        for (int i=1; i<n; i++) {
            if (list[i].interview < minInverview) {
                count++;
                minInverview = list[i].interview;
            }
        }

        return count;
    }

    public static class Score implements Comparable<Score> {
        private int document;
        private int interview;

        public Score(int document, int interview) {
            this.document = document;
            this.interview = interview;
        }

        @Override
        public int compareTo(Score o) {
            if (this.document < o.document)
                return -1;
            else if (this.document == o.document)
                return 0;
            else
                return 1;
        }
    }
}
