package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {


   private static class TreeNode{
        TreeNode left ;
        TreeNode right;
        int value;
        TreeNode(int value){
            this.value=value;
        }
    }

    private  TreeNode root;
    private TreeNode insert(TreeNode node,int key){
        if (node==null) return new TreeNode(key);
        if (node.value<=key)
            node.right=insert(node.right,key);
        else
            node.left=insert(node.left,key);
        return node;
    }

    public void insert(int value){
        root = insert(root,value);
    }

     private void inOrder(TreeNode node){
       if (node==null) return;
       inOrder(node.left);
       System.out.print(node.value+" , ");
       inOrder(node.right);
    }
    public void inOrder(){
        inOrder(root);
        System.out.println();
    }


    private int levels(TreeNode node){
        if (node==null) return 0;
        else return Math.max(levels(node.left),levels(node.right))+1;
    }

    public int totalLevel(){
       return levels(root);
    }


    public void printTree(){
        int totalLevels = totalLevel();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (--totalLevels>=0){
            int size = queue.size();
            for (int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                System.out.println(node.value + " L -> " + (node.left == null ? null : node.left.value));
                System.out.println(node.value + " R -> " + ((node.right == null) ? null : node.right.value));
            }
        }
    }



     private void preOrder(TreeNode node){
       if (node==null) return;
       System.out.print(node.value+" , ");
       preOrder(node.left);
       preOrder(node.right);
    }

    public void preOrder(){
        preOrder(root);
        System.out.println();
    }


     private void postOrder(TreeNode node){
       if (node==null) return;
       postOrder(node.left);
       postOrder(node.right);
       System.out.print(node.value+" , ");
    }


    public void postOrder(){
        postOrder(root);
        System.out.println();
    }

    private   static TreeNode construct(int low, int high, int [] inOrder,HashMap<Integer,Integer> postOrder )
    {
        if (low==high) return new TreeNode(inOrder[low]);
        else if (low>high) return null;

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





    private  static TreeNode construct2(int low, int high, int [] inOrder,HashMap<Integer,Integer> preOrder )
    {
        if (low==high) return new TreeNode(inOrder[low]);
        else if (low>high) return null;

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





    public static  Tree constructTreeFromInAndPreOrder(int [] inorder, int [] preOrder){

        HashMap<Integer,Integer> pre = new HashMap<>();
        for (int i=0;i<preOrder.length;i++)
            pre.put(preOrder[i],i);

        Tree tree = new Tree();
        tree.root=construct2(0,inorder.length-1,inorder,pre);
        return tree;
    }

    public   static Tree constructTreeFromInAndPostOrder(int [] inorder , int [] postOrder)
    {
        HashMap<Integer,Integer> post = new HashMap<>();
        for (int i=0;i<postOrder.length;i++)
            post.put(postOrder[i],i);
        Tree tree = new Tree();
        tree.root=construct(0,inorder.length-1,inorder,post);
        return tree;
    }

}
