package BOJ;

import java.util.Scanner;

/**
 * Created by bomeekim on 2017-07-25.
 */
public class BOJ14503 {

    static final int BLANK = 0;
    static final int WALL = 1;
    static final int CLEANED = 2;

    static final int DIRECTIONS = 4;
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    static int count = 0;
    static int N = 0;
    static int M = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 세로크기
        M = sc.nextInt(); // 가로크기
        int r = sc.nextInt(); // 북쪽으로부터 떨어진 칸의 개수
        int c = sc.nextInt(); // 서쪽으로부터 떨어진 칸의 개수
        int d = sc.nextInt(); // 바라보는 방향

        int array[][] = new int[N][M];

        sc.nextLine();

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                array[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }

        Point point = new Point(r, c);

        solution(point, array, d);
    }

    public static void solution(Point p, int[][] map, int d) {

        // 1. 현재 위치 청소
        while (true) {
            if (map[p.x][p.y] == BLANK) {
                count++;
                map[p.x][p.y] = CLEANED;
            }


            // 2. 현재 방향에서 왼쪽 방향으로 탐색 진행
            boolean check = false; // 다음 탐색 좌표가 BLANK인 경우 check를 true로 해줌

            for (int i=0; i<DIRECTIONS; i++) {
                int nextD = (d - 1 + 4) % 4;
                int nextR = p.x + dx[nextD];
                int nextC = p.y + dy[nextD];

                // 2-1
                if (map[nextR][nextC] == BLANK) {
                    d = nextD;
                    p.x = nextR;
                    p.y = nextC;

                    check = true;
                    break;
                } else { // 2-2
                    d = nextD;
                }
            }

            if (!check) {
                // 2-4
                if (map[p.x - dx[d]][p.y - dy[d]] == WALL) {
                    System.out.println(count);
                    break;
                } else { // 2-3
                    p.x = p.x - dx[d];
                    p.y = p.y - dy[d];
                }
            }
        }
    }
}
