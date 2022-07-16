package tree;

import java.util.Scanner;

public class Ques4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of keys ");
        int n = scanner.nextInt();
        int [] inOrder = new int[n];
        int [] postOrder = new int[n];
        System.out.println("Enter in-order traversal ");
        for (int i = 0 ; i < n ; i++) inOrder[i] = scanner.nextInt();
        System.out.println("Enter post-Order traversal ");
        for (int i = 0 ; i < n ; i++) postOrder[i] = scanner.nextInt();
        Tree tree = Tree.constructTreeFromInAndPostOrder(inOrder,postOrder);
        System.out.println("Tree ==> ");
        tree.printTree();
        System.out.println("\n In-Order traversal ");
        tree.inOrder();
        System.out.println("\n Pre-Order traversal ");
        tree.preOrder();
        System.out.println("\n Post-Order traversal ");
        tree.postOrder();
    }

}
