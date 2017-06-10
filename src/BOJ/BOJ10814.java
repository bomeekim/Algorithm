package BOJ;

import java.util.*;

/**
 * Created by bomeekim on 2017-05-18.
 */
public class BOJ10814 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        sc.nextLine();

        List<Person> list = new ArrayList<>();

        for (int i=0; i<N; i++) {
            String[] s = sc.nextLine().split(" ");
            Person person = new Person(Integer.valueOf(s[0]), s[1]);
            list.add(person);
        }

        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        });

        for (Person p : list) {
            System.out.println(p.age + " " + p.name);
        }
    }
}

class Person {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
}