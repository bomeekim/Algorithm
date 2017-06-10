package BOJ;

import java.util.Scanner;

/**
 * Created by bomeekim on 2017-05-24.
 */
public class BOJ9012 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        sc.nextLine();

        for (int i=0; i<T; i++) {
            char[] array = sc.nextLine().trim().toCharArray();
            if (checkBracket(array))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    private static boolean checkBracket(char[] array) {

        boolean check = true;
        int size = array.length;
        MyStack stack = new MyStack(size);

        for (int i=0; i<array.length; i++) {
            if (array[i] == '(') {
                stack.push(array[i]);
            } else {
                if (stack.top() == -1) {
                    check = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }

        if (check && stack.top() != -1)
            check = false;

        return check;
    }
}

class MyStack {
    private int top;
    private char[] stack;
    private int size;

    public MyStack(int size) {
        this.top = -1;
        this.stack = new char[size];
        this.size = size;
    }

    public int top() {
        if (top == -1)
            return -1;
        else
            return stack[top];
    }

    public void push(char c) {
        stack[++top] = c;
    }

    public char pop() {
        int c = top();

        if (top == -1)
            return 'n';
        else {
            return stack[top--];
        }
    }

    public int size() {
        return (top + 1);
    }
}
