package BOJ;

import java.util.Scanner;

/**
 * Created by bomeekim on 2017-04-27.
 */
class Node {
    private char data;
    private Node left;
    private Node right;

    public Node(char data) {
        this.data = data;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

class Tree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void add(char parent, char leftChild, char rightChild) {
        if (root == null) {
            root = new Node(parent);

            if (leftChild != '.')
                root.setLeft(new Node(leftChild));

            if (rightChild != '.')
                root.setRight(new Node(rightChild));
        } else {
            search(root, parent, leftChild, rightChild);
        }
    }

    private void search(Node root, char data, char leftChild, char rightChild) {
        if (root == null) return;
        else if (root.getData() == data) {
            if (leftChild != '.')
                root.setLeft(new Node(leftChild));
            if (rightChild != '.')
                root.setRight(new Node(rightChild));
        } else {
            search(root.getLeft(), data, leftChild, rightChild);
            search(root.getRight(), data, leftChild, rightChild);
        }
    }

    public void preorder(Node root) {
        System.out.print(root.getData());

        if (root.getLeft() != null)
            preorder(root.getLeft());

        if (root.getRight() != null)
            preorder(root.getRight());
    }

    public void inorder(Node root) {
        if (root.getLeft() != null)
            inorder(root.getLeft());

        System.out.print(root.getData());

        if (root.getRight() != null)
            inorder(root.getRight());
    }

    public void postorder(Node root) {
        if (root.getLeft() != null)
            postorder(root.getLeft());

        if (root.getRight() != null)
            postorder(root.getRight());

        System.out.print(root.getData());
    }
}

public class BOJ1991 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 노드 개수
        sc.nextLine();

        Tree tree = new Tree();

        for (int i=0; i<N; i++) {
            char[] input = sc.nextLine().replaceAll(" ", "").toCharArray();
            tree.add(input[0], input[1], input[2]);
        }

        tree.preorder(tree.getRoot());
        System.out.println("");
        tree.inorder(tree.getRoot());
        System.out.println("");
        tree.postorder(tree.getRoot());
    }
}
