package BOJ;

import java.util.Scanner;

/**
 * Created by bomeekim on 2017-04-25.
 */
class Queue {
    private int front;
    private int rear;
    private int size;
    private int[] queue;

    public Queue(int size) {
        this.front = 0;
        this.rear = -1;
        this.size = size;
        this.queue = new int[size];
    }

    public int peek() {
        return queue[front];
    }

    public int empty() {
        if (front == rear + 1)
            return 1;
        else
            return 0;
    }

    public void push(int x) {
        queue[++rear] = x;
    }

    public void pop() {
        int x = peek();

        if (empty() == 1)
            System.out.println("-1");
        else {
            System.out.println(x);
            front++;
        }
    }

    public int size() {
        return (rear - front + 1);
    }

    public void front() {
        if (empty() == 1)
            System.out.println("-1");
        else
            System.out.println(queue[front]);
    }

    public void back() {
        if (empty() == 1)
            System.out.println("-1");
        else
            System.out.println(queue[rear]);
    }
}

public class BOJ10845 {
    public static void main(String[] args) {
        int N = 0; // 명령의 수

        Scanner scanner = new Scanner(System.in);
        N = Integer.valueOf(scanner.nextLine());

        Queue queue = new Queue(N);

        for (int i=0; i<N; i++) {
            String str = scanner.nextLine();
            command(queue, str);
        }
    }

    public static void command(Queue q, String s) {
        String[] input = s.split(" ");

        switch (input[0]) {
            case "push":
                q.push(Integer.parseInt(input[1]));
                break;
            case "front":
                q.front();
                break;
            case "back":
                q.back();
                break;
            case "size":
                System.out.println(q.size());
                break;
            case "empty":
                System.out.println(q.empty());
                break;
            case "pop":
                q.pop();
                break;
        }
    }
}
