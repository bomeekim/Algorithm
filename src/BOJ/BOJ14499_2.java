package BOJ;

import java.util.Scanner;

/**
 * Created by bomeekim on 2017-08-07.
 */
public class BOJ14499_2 {

    static final int[] dx = {0, 0, 0, -1, 1}; // 동 서 북 남
    static final int[] dy = {0, 1, -1, 0, 0}; // 동 서 북 남

    static final int EAST = 1;
    static final int WEST = 2;
    static final int NORTH = 3;
    static final int SOUTH = 4;

    static int N = 0; // 세로 크기
    static int M = 0; // 가로 크기
    static int X = 0;
    static int Y = 0;
    static int K = 0; // 명령어 개수

    static int[] dice = {0, 0, 0, 0, 0, 0, 0};
    static int[] nDice = {0, 0, 0, 0, 0, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 세로 크기
        M = sc.nextInt(); // 가로 크기
        X = sc.nextInt(); // X좌표
        Y = sc.nextInt(); // Y좌표
        K = sc.nextInt(); // 명령어 개수

        int[][] map = new int[N][M];
        int[] set = new int[K];

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i=0; i<K; i++) {
            set[i] = sc.nextInt();
        }

        solution(map, set);
    }

    public static void solution(int[][] map, int[] set) {
        for (int i=0; i<K; i++) {
            int nextX = X + dx[set[i]];
            int nextY = Y + dy[set[i]];

            if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;

            move(set[i]);

            if (map[nextX][nextY] == 0)
                map[nextX][nextY] = nDice[6];
            else {
                nDice[6] = map[nextX][nextY];
                map[nextX][nextY] = 0;
            }

            System.out.println(nDice[1]);

            for (int j=0; j<7; j++) {
                dice[j] = nDice[j];
            }

            X = nextX;
            Y = nextY;
        }
    }

    public static void move(int d) {
        switch (d) {
            case EAST:
                nDice[1] = dice[4];
                nDice[2] = dice[2];
                nDice[3] = dice[1];
                nDice[4] = dice[6];
                nDice[5] = dice[5];
                nDice[6] = dice[3];
                break;

            case WEST:
                nDice[1] = dice[3];
                nDice[2] = dice[2];
                nDice[3] = dice[6];
                nDice[4] = dice[1];
                nDice[5] = dice[5];
                nDice[6] = dice[4];
                break;

            case NORTH:
                nDice[1] = dice[5];
                nDice[2] = dice[1];
                nDice[3] = dice[3];
                nDice[4] = dice[4];
                nDice[5] = dice[6];
                nDice[6] = dice[2];
                break;

            case SOUTH:
                nDice[1] = dice[2];
                nDice[2] = dice[6];
                nDice[3] = dice[3];
                nDice[4] = dice[4];
                nDice[5] = dice[1];
                nDice[6] = dice[5];
                break;
        }
    }
}
