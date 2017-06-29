package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by bomeekim on 2017-06-29.
 */
public class BOJ1697 {

    static final int DIRECTIONS = 3;
    static final int[] DIRECTION = {-1, 1, 2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        bfs(N, K);
    }

    public static void bfs(int start, int end) {
        boolean[] visited = new boolean[100001];
        visited[start] = true;

        Queue queue = new LinkedList<Point>();
        queue.offer(new Point(start, 0));

        while (!queue.isEmpty()) {
            Point point = (Point) queue.poll();

            for (int i=0; i<DIRECTIONS; i++) {
                int nextPosition = point.x + DIRECTION[i];

                if (i == 2)
                    nextPosition = point.x * DIRECTION[i];

                if (nextPosition >= 0 && nextPosition <= 100000)
                    if (!visited[nextPosition]) {
                        visited[nextPosition] = true;
                        queue.offer(new Point(nextPosition, point.count + 1));
                    }

                if (point.x == end) {
                    System.out.println(point.count);
                    break;
                }
            }
        }
    }

    static class Point {
        int x;
        int count;

        public Point(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }
}
