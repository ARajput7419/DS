package tree;

import java.util.Locale;

public class DirectoryStructure {


    private class Child{
        Node child;
        Child next;
        Child(Node child){
            this.child = child;
        }
    }
    private class Node{
        String name;
        long size;
        Node parent;
        Child head;
        private void insertChild(Node node){
            Child new_child = new Child(node);
            Child temp =  head;
            if (temp==null)
            {
                head = new_child;
                return;
            }
            while (temp.next!=null)
                temp = temp.next;
            temp.next=new_child;
        }
    }

    private Node root;

    private Node search(String []tokens,int index,Node currentNode){
        if (index>=tokens.length)
            return null;

        Child children = currentNode.head;
        while (children!=null){
            Child c = children;
            Node node = c.child;
            if (node.name.equals(tokens[index].trim())){
                if (index==tokens.length-1)
                    return node;
                return search(tokens,index+1,node);
            }
            children=children.next;
        }
        return null;
    }
    public void search(String directory){
        search(directory.split("/"),0,root);
    }


    void createFile(String file_name,long size){

    }


}
