package BOJ;

import java.util.Scanner;

/**
 * Created by bomeekim on 2017-04-26.
 */
class Stack {
    private int top;
    private int size;
    private int[] stack;

    public Stack(int size) {
        this.top = -1;
        this.size = size;
        this.stack = new int[size];
    }

    public int top() {
        if (top == -1)
            return -1;
        else
            return stack[top];
    }

    public void push(int x) {
        stack[++top] = x;
    }

    public int pop() {
        int x = top();

        if (top == -1)
            return -1;
        else {
            return stack[top--];
        }
    }

    public int size() {
        return (top + 1);
    }

    public int empty() {
        if (top == -1)
            return 1;
        else
            return 0;
    }
}

public class BOJ10828 {
    public static void main(String[] args) {
        int N = 0; // 명령의 수

        Scanner sc = new Scanner(System.in);
        N = Integer.valueOf(sc.nextLine());

        Stack stack = new Stack(N);

        for (int i=0; i<N; i++) {
            String str = sc.nextLine();
            command(stack, str);
        }
    }

    public static void command(Stack stack, String s) {
        String[] input = s.split(" ");

        switch (input[0]) {
            case "push":
                stack.push(Integer.parseInt(input[1]));
                break;
            case "top":
                System.out.println(stack.top());
                break;
            case "size":
                System.out.println(stack.size());
                break;
            case "empty":
                System.out.println(stack.empty());
                break;
            case "pop":
                System.out.println(stack.pop());
                break;
        }
    }
}
