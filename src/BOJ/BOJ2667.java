package BOJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by bomeekim on 2017-07-26.
 */
public class BOJ2667 {

    static final int DIRECTIONS = 4;
    static final int[] dx = {0, 0, 1, -1}; // 동 서 남 북
    static final int[] dy = {1, -1, 0, 0}; // 동 서 남 북

    static int N;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 지도 사이즈
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i=0; i<N; i++) {
            String str = sc.next();

            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(str.charAt(j) + "");
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        int groupCount = 0;

        // 단지 찾기
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                // (i,j)가 map에서 1이고, 아직 방문 안했을 때
                if (map[i][j] != 0 && !visited[i][j]) {
                    groupCount++;

                    Point startPoint = new Point(i, j); //시작 좌표 생성
                    int houseCount = dfs(startPoint, 0); // 해당 단지 내 집의 수를 dfs로 찾음

                    list.add(houseCount); // 찾은 단지내 집의 수를 list에 넣음
                }
            }
        }

        Collections.sort(list); // 오름차순으로 정렬

        System.out.println(groupCount); // 총 단지 수 출력

        for (int x : list) { // 각 단지내 집의 수를 출력
            System.out.println(x);
        }
    }

    public static int dfs(Point p, int count) {
        visited[p.x][p.y] = true; // 방문 표시
        count++; // 집의 수 1 증가

        for (int d=0; d<DIRECTIONS; d++) {
            Point nextP = new Point(p.x + dx[d], p.y + dy[d]);

            if (nextP.x < 0 || nextP.x >= N || nextP.y < 0 || nextP.y >= N) continue;
            if (visited[nextP.x][nextP.y]) continue;
            if (map[nextP.x][nextP.y] == 0) continue;

            count = dfs(nextP, count); // dfs 반복
        }

        return count;
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
