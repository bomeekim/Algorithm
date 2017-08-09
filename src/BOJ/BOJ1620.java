package BOJ;

import java.util.*;

/**
 * Created by bomeekim on 2017-08-08.
 */
public class BOJ1620 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        HashMap<String, Integer> pokedex = new HashMap<>();
        String[] names = new String[N+1];

        for (int i=1; i<=N; i++) {
            names[i] = sc.next();
            pokedex.put(names[i], i);
        }

        for (int i=0; i<M; i++) {
            // 번호인 경우
            if (sc.hasNextInt())
                System.out.println(names[sc.nextInt()]);
            else // 문자인 경우
                System.out.println(pokedex.get(sc.next()));
        }

//        HashMap<String, String> pokedex = new HashMap<>();
//
//        for (int i=1; i<=N; i++) {
//            String name = sc.next();
//
//            pokedex.put(String.valueOf(i), name);
//        }
//
//        Set set = pokedex.entrySet();
//
//        for (int i=0; i<M; i++) {
//            String str = sc.next();
//
//            if (pokedex.containsKey(str)) // 포켓몬 번호
//                System.out.println(pokedex.get(str)); // 포켓몬 이름 출력
//
//            if (pokedex.containsValue(str)) { // 포켓몬 이름
//                Iterator iterator = set.iterator();
//
//                while (iterator.hasNext()) {
//                    Map.Entry entry = (Map.Entry) iterator.next();
//
//                    String key = (String) entry.getKey();
//                    String value = (String) entry.getValue();
//
//                    if (str.equals(value)) {
//                        System.out.println(key);
//                        break;
//                    }
//                }
//            }
//        }
    }
}
