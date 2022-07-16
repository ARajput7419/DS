package tree;
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
        boolean isFile=false;
        Node parent;
        Node(String name,long size,boolean isFile){
            this.name = name;
            this.size = size;
            this.isFile = isFile;
        }
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

    private Node root = new Node("",0,false);


    private Node search(String []tokens,int index,Node currentNode){
        if (index>=tokens.length)
            return null;

        if (currentNode.name.equals(tokens[index].trim())) {
            if (index==tokens.length-1)
                return currentNode;

            Child children = currentNode.head;
            Node res;
            while (children != null) {
                Child c = children;
                Node node = c.child;
                res = search(tokens, index + 1, node);
                if (res != null) return res;
                children = children.next;
            }
        }
        return null;
    }


    public Node search(String directory)
    {
        String [] tokens = directory.split("/");
       return  search(tokens,0,root);
    }


    void createFile(String directory_name , String file_name,long size){
        Node n = search(directory_name);
        if (n==null)
            throw  new RuntimeException("Directory does not exists ");
        else if (n.isFile)
            throw new RuntimeException("Directory name does not points to a file ");
        else if (isPresent(n,file_name))
            throw  new RuntimeException("File name already exists ");

        Node new_node =  new Node(file_name,size,true);
        new_node.parent = n;
        n.insertChild(new_node);
        while (n!=null){
            n.size+=size;
            n= n.parent;
        }
        System.out.println("Created Successfully ... ");
    }

    void createDirectory(String  directory_name,String new_directory){
        Node n = search(directory_name);
        if (n==null)
            throw new RuntimeException("Directory does not exist ");
        else if (n.isFile)
            throw  new RuntimeException("Directory name does not points to a file ");
        else if (isPresent(n,new_directory))
            throw  new RuntimeException("Directory name already exists ");
        Node new_node = new Node(new_directory,0,false);
        new_node.parent = n;
        n.insertChild(new_node);
        System.out.println("Created Successfully .... ");
    }

    public long calculateSize(){
        return root.size;
    }

    private double bytesToMB(long bytes){
        return bytes/(1024d*1024);
    }

    private void printDirectoryStructure(Node node,int level){
        if (node==null) return;
        Child child = node.head;
        System.out.println(" ".repeat(2*level)+node.name+" ( "+String.format("%.4f",bytesToMB(node.size))+" MB )");
        while(child!=null){
            printDirectoryStructure(child.child,level+1);
            child = child.next;
        }

    }
    public  void printDirectoryStructure(){
        printDirectoryStructure(root,0);
    }
    private boolean isPresent(Node n,String name){
        Child child = n.head;
        while (child!=null)
        {
            if(child.child.name.equals(name)) return true;
            child = child.next;
        }
        return  false;
    }

}
