package tree;

import java.util.Scanner;

public class Ques1 {

    public static void main(String[] args) {
        System.out.println("Enter number of keys ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Tree tree = new Tree();
        for (int i =0;i<n;i++)
            tree.insert(scanner.nextInt());
        System.out.println("Tree ====>  ");
        tree.printTree();
        System.out.println("\nPre Order Traversal");
        tree.preOrder();
        System.out.println("\nPost Order Traversal");
        tree.postOrder();

    }
}
