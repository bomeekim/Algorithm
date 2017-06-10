package BOJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by bomeekim on 2017-05-22.
 */
public class BOJ2455 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Station> list = new ArrayList<>();
        int max = 0;
        int[] result = new int[4];

        for (int i=0; i<4; i++) {
            Station station = new Station(sc.nextInt(), sc.nextInt());
            list.add(station);

            if (i == 0) {
                result[0] = station.getOn;
            } else {
                result[i] = result[i-1] - station.getOff + station.getOn;
            }

            max = Math.max(max, result[i]);
        }

        System.out.println(max);
    }
}

class Station {
    int getOff;
    int getOn;

    public Station(int getOff, int getOn) {
        this.getOff = getOff;
        this.getOn = getOn;
    }
}
