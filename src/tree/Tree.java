package tree;

import java.util.HashMap;
import java.util.Scanner;

class TreeNode{
    TreeNode left ;
    TreeNode right;
    int value;
    TreeNode(int value){
        this.value=value;
    }
}

public class Tree {

    private static TreeNode root;


   static  private TreeNode insert(TreeNode node,int key){
        if (node==null) return new TreeNode(key);
        if (node.value>=key)
            node.right=insert(node.right,key);
        else
            node.left=insert(node.left,key);
        return node;
    }

    static private void inOrder(TreeNode node){
       if (node==null) return;
       inOrder(node.left);
       System.out.print(node.value+" , ");
       inOrder(node.right);
    }


    static private void preOrder(TreeNode node){
       if (node==null) return;
       System.out.print(node.value+" , ");
       preOrder(node.left);
       preOrder(node.right);
    }


    static private void postOrder(TreeNode node){
       if (node==null) return;
       postOrder(node.left);
       postOrder(node.right);
       System.out.println(node.value+" , ");
    }

    private  static TreeNode construct(int low, int high, int [] inOrder,HashMap<Integer,Integer> postOrder )
    {
        int max_index=Integer.MIN_VALUE;
        int index=0;
        for (int i = low;i<=high;i++){
            if (max_index<postOrder.get(inOrder[i]))
            {
                max_index=postOrder.get(inOrder[i]);
                index=i;
            }

        }
        TreeNode node = new TreeNode(inOrder[index]);
        node.left=construct(low,index-1,inOrder,postOrder);
        node.right=construct(index+1,high,inOrder,postOrder);
        return node;
    }





    private static TreeNode construct2(int low, int high, int [] inOrder,HashMap<Integer,Integer> preOrder )
    {
        int min_index=Integer.MAX_VALUE;
        int index=0;
        for (int i = low;i<=high;i++){
            if (min_index>preOrder.get(inOrder[i]))
            {
                min_index=preOrder.get(inOrder[i]);
                index=i;
            }

        }
        TreeNode node = new TreeNode(inOrder[index]);
        node.left=construct2(low,index-1,inOrder,preOrder);
        node.right=construct2(index+1,high,inOrder,preOrder);
        return node;
    }





    private static TreeNode constructTreeFromInAndPreOrder(int [] inorder, int [] preOrder){

        HashMap<Integer,Integer> pre = new HashMap<>();
        for (int i=0;i<preOrder.length;i++)
            pre.put(preOrder[i],i);

       return construct2(0,inorder.length-1,inorder,pre);
    }

    private static TreeNode constructTreeFromInAndPostOrder(int [] inorder , int [] postOrder)
    {
        HashMap<Integer,Integer> post = new HashMap<>();
        for (int i=0;i<postOrder.length;i++)
            post.put(postOrder[i],i);
        return construct(0,inorder.length-1,inorder,post);
    }




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of keys ");
        int n =  scanner.nextInt();
        for (int i =0;i<n;i++)
            root = insert(root,scanner.nextInt());
        inOrder(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();


        System.out.println("\nEnter number of elements present in inorder and preorder and postorder");
        int m = scanner.nextInt();
        System.out.println("Enter preOrder");
        int [] preOrder = new int[m];
        for (int i =0;i<m;i++) preOrder[i] = scanner.nextInt();
        System.out.println("Enter postOrder");
        int [] postOrder = new int[m];
        for (int i =0;i<m;i++) postOrder[i] = scanner.nextInt();
        System.out.println("Enter Inorder ");
        int [] inorder = new int[m];
        for (int i =0;i<m;i++) inorder[i] = scanner.nextInt();

        System.out.println("\nTree Build Using InOrder and PreOrder");
        TreeNode inorder_preorder = constructTreeFromInAndPreOrder(inorder,preOrder);
        System.out.println("\nTree Build Using InOrder and PostOrder");
        TreeNode inorder_postorder = constructTreeFromInAndPostOrder(inorder,postOrder);
    }


}
