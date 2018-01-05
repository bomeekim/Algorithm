package codeground;

/**
 * Created by bomeekim on 2017-07-02.
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;


public class Practice01 {
    static int Answer;

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test_case = 0; test_case < T; test_case++) {

            Answer = 0;

            int n = sc.nextInt();

            sc.nextLine();
            String[] strarr = sc.nextLine().split(" ");

            Answer = solution(strarr);


            // Print the answer to standard output(screen).
            System.out.println("Case #" + (test_case + 1));
            System.out.println(Answer);
        }
    }

    public static int solution(String[] arr) {
        int result = 0;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        Iterator it;
        int[] oddarr;
        int oddcnt = 0;
        int key;
        int value;

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i]) + 1);
            else
                map.put(arr[i], 1);
        }

        it = map.entrySet().iterator();
        oddarr = new int[map.size()];
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry) it.next();

            key = Integer.parseInt(pair.getKey().toString());
            value = (int) pair.getValue();

            if (value % 2 == 1) {
                oddarr[oddcnt] = key;
                oddcnt++;
            }

        }

        for (int j = 0; j < oddcnt; j++) {
            if (j == 0)
                result = oddarr[j];
            else
                result ^= oddarr[j];
        }


        return result;
    }
}