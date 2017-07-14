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

    static int N;
    static int[][] array;
    static int max;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        array = new int[N][N];

        Point3 startMaxPoint = null;
        max = 0;
        count = 0;

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                array[i][j] = sc.nextInt();

                if (max < array[i][j]) {
                    max = array[i][j];

                    startMaxPoint = new Point3(i, j, max);
                }
            }
        }

        dfs(startMaxPoint);

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void dfs (Point3 maxPoint) {

        for (int d=0; d<DIRECTIONS; d++) {
            int nextX = maxPoint.x + DIRECTION[d][0];
            int nextY = maxPoint.y + DIRECTION[d][1];

            if (nextX < 0 || nextX >= N || nextY < 0 || nextX >= N) continue;

//			if (array[nextX][nextY] == 0) continue; // 4 0 4 이런 경우에 처리할 수가 없음

            if (array[nextX][nextY] == maxPoint.value || array[nextX][nextY] == 0) {
                go(d, maxPoint);
                count++;

                System.out.println("count = " + count);

                if (count < 5) {
                    System.out.println("x = " + findMaxPoint().x + ", y = " + findMaxPoint().y + ", value = " + findMaxPoint().value);
                    dfs(findMaxPoint());
                }
            }

//			else {
//				Point3 p = new Point3(nextX, nextY, array[nextX][nextY]);
//
//				System.out.println("x = " + nextX + " , y = " + nextY);
//
//				dfs(p);
//			}
        }
    }

    public static void go (int d, Point3 maxPoint) {

        if (d == 0) {
            for (int i=0; i<N; i++) {
                if (array[maxPoint.x][i] == array[maxPoint.x+1][i]) { // 아래쪽에 같은 값이 있는 경우
                    array[maxPoint.x+1][i] = array[maxPoint.x+1][i] + array[maxPoint.x][i]; // 아래쪽 행을 더해줌
                    array[maxPoint.x][i] = 0; // 이전 값은 0으로 변경
                }
            }
        } else if (d == 1) {
            for (int i=0; i<N; i++) {
                if (array[maxPoint.x][i] == array[maxPoint.x-1][i]) { // 위쪽에 같은 값이 있는 경우
                    array[maxPoint.x-1][i] = array[maxPoint.x-1][i] + array[maxPoint.x][i]; // 위쪽 행을 더해줌
                    array[maxPoint.x][i] = 0; // 이전 값은 0으로 변경
                }
            }
        } else if (d == 2) {
            for (int i=0; i<N; i++) {
                if (array[i][maxPoint.y] == array[i][maxPoint.y-1]) { // 왼쪽에 같은 값이 있는 경우
                    array[i][maxPoint.y-1] = array[i][maxPoint.y-1] + array[i][maxPoint.y]; //왼쪽 행과 더해줌
                    array[i][maxPoint.y] = 0; // 이전 값은 0으로 변경
                }
            }
        } else if (d == 3) {// 최대값을 기준으로 오른쪽에 같은 값이 있는지 확인
            for (int i=0; i<N; i++) {
                if (array[i][maxPoint.y] == array[i][maxPoint.y+1]) { // 오른 쪽에 같은 값이 있는 경우
                    array[i][maxPoint.y+1] = array[i][maxPoint.y+1] + array[i][maxPoint.y]; //오른쪽 행과 더해줌
                    array[i][maxPoint.y] = 0; // 이전 값은 0으로 변경
                }
            }
        }
    }

    public static Point3 findMaxPoint() {

        Point3 p = null;
        int tempMax = 0;

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (tempMax < array[i][j]) {
                    tempMax = array[i][j];

                    p = new Point3(i, j, tempMax);
                }
            }
        }

        return p;
    }
}

class Point3 {
    int x;
    int y;
    int value;

    public Point3(int x, int y, int value) {

        this.x = x;
        this.y = y;
        this.value = value;
    }
}
