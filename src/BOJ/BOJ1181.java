package BOJ;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by bomeekim on 2017-05-19.
 */
public class BOJ1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        sc.nextLine();

        Set<Word> treeSet = new TreeSet<Word>();

        for (int i=0; i<N; i++) {
            String s = sc.nextLine();
            Word word = new Word(s.length(), s);
            treeSet.add(word);
        }

        for (Word w : treeSet) {
            System.out.println(w.word);
        }
    }
}

class Word implements Comparable<Word> {
    int length;
    String word;

    public Word(int length, String word) {
        this.length = length;
        this.word = word;
    }

    @Override
    public int compareTo(Word o) {
//        System.out.printf("%s vs %s \n", this, o);

        if (word.equals(o.word)) {
            return 0;
        }

        if (length != o.length) {
            if (length > o.length) {
                return 1;
            } else {
                return -1;
            }
        }

        return word.compareTo(o.word);
    }
}
