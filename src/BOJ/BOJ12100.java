package BOJ;

import java.util.Scanner;

/**
 * Created by bomeekim on 2017-07-14.
 */
public class BOJ12100 {
    static final int DIRECTIONS = 4;
    static final int[][] DIRECTION = {
            {1, 0}, //동
            {-1, 0}, //서
            {0, -1}, //남
            {0, 1} //북
    };

    static final int LIMIT = 5;
    static final int ZERO = 0;

    static int N;
    static int[][] array;
    static int max = 0;
    static int step = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        array = new int[N][N];

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        Point startPoint = new Point(0, 0);

        dfs(startPoint);
//        dfs(startPoint, 0);

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

//    public static void dfs (Point p, int count) {
    public static void dfs (Point p) {

        for (int d=0; d<DIRECTIONS; d++) {
//            int nextX = p.x + DIRECTION[d][0];
//            int nextY = p.y + DIRECTION[d][1];
//
//            if (nextX < 0 || nextX >= N || nextY < 0 || nextX >= N) continue;


            step = go(d, p);

            if (step == LIMIT) {
                return;
            } else {
                dfs(new Point(0, 0));
            }
        }
    }

    public static int go (int d, Point point) {

        int[][] temp = new int[N][N];
        int count = 0;

        System.out.println("step = " + step);

        if (d == 0) { // 아래
            for (int i=point.x; i<N; i++) {
                for (int j=0; j<N; j++) {

                    if (i+1 >= N) {
                        temp[i][j] = array[i][j];
                        System.out.println(temp[i][j]);
                        break;
                    }

                    if (array[i][j] == array[i+1][j] || array[i+1][j] == ZERO) {
                        array[i+1][j] = array[i+1][j] + array[i][j];
                        array[i][j] = 0;
                    }
                }
            }
        } else if (d == 1) { // 위
            for (int i=point.x; i<N; i++) {
                for (int j=0; j<N; j++) {

                    if (i-1 >= N) {
                        temp[i][j] = array[i][j];
                        System.out.println(temp[i][j]);
                        break;
                    }

                    if (array[i][j] == array[i-1][j] || array[i-1][j] == ZERO) {
                        array[i-1][j] = array[i-1][j] + array[i][j];
                        array[i][j] = 0;
                    }
                }
            }
        } else if (d == 2) { //왼쪽
            for (int i=0; i<N; i++) {
                for (int j=point.y; j<N; j++) {

                    if (j-1 >= N) {
                        temp[i][j] = array[i][j];
                        System.out.println(temp[i][j]);
                        break;
                    }

                    if (array[i][j] == array[i][j-1] || array[i][j] == ZERO) {
                        array[i][j-1] = array[i][j-1] + array[i][j];
                        array[i][j] = 0;
                    }
                }
            }
        } else if (d == 3) {// 최대값을 기준으로 오른쪽에 같은 값이 있는지 확인
            for (int i=0; i<N; i++) {
                for (int j=point.y; j<N; j++) {

                    if (j+1 >= N) {
                        temp[i][j] = array[i][j];
                        System.out.println(temp[i][j]);
                        break;
                    }

                    if (array[i][j] == array[i][j+1] || array[i][j] == ZERO) {
                        array[i][j-1] = array[i][j+1] + array[i][j];
                        array[i][j] = 0;
                    }
                }
            }
        }

//        dfs(new Point(0, 0), step + 1);

        count += 1;

        return count;
    }

//    public static Point findMaxPoint() {
//
//        Point p = null;
//        int tempMax = 0;
//
//        for (int i=0; i<N; i++) {
//            for (int j=0; j<N; j++) {
//                if (tempMax < array[i][j]) {
//                    tempMax = array[i][j];
//
//                    p = new Point(i, j, tempMax);
//                }
//            }
//        }
//
//        return p;
//    }
}

class Point {
    int x;
    int y;
//    int value;

    public Point(int x, int y) {

        this.x = x;
        this.y = y;
//        this.value = value;
    }
}
