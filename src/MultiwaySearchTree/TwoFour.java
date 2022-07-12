package MultiwaySearchTree;




public class TwoFour {
    private class Node{
        int total_keys=0;
        Node [] nodes = new Node[4];
        int [] keys = new int[3];
    }
    Node root = new Node();
    boolean isLeaf(Node node){
        for(int i=0;i<4;i++)
            if (node.nodes[i]!=null) return false;

            return true;
    }
    Object[] insertKey(int value,Node node){
        if (isLeaf(node)){
         if (node.total_keys==3){
             Node first =  new Node();
             Node second = new Node();
             for (int i =0;i<3;i++){
                 if (node.keys[i]>value){
                    int tosend=0;
                    if ( i == 0 ){
                        first.keys[0]=value;
                        second.keys[0]=node.keys[1];
                        second.keys[1]=node.keys[2];
                        tosend = node.keys[0];
                    }
                    else if (i==1){
                        first.keys[0]=node.keys[0];
                        second.keys[0]=node.keys[1];
                        second.keys[1]=node.keys[2];
                        tosend=value;
                    }
                    else {
                        first.keys[0]=node.keys[0];
                        second.keys[0]=value;
                        second.keys[1]=node.keys[2];
                        tosend= node.keys[1];
                    }
                    return new Object[]{tosend,first,second};
                 }
             }
             first.keys[0]=node.keys[0];
             int tosend = node.keys[1];
             second.keys[0]=node.keys[2];
             second.keys[1]=value;
             return new Object[]{tosend,first,second};

         }
         else{

         }
        }
        else{

        }
        return null;
    }



}
