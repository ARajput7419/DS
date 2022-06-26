package hashing;

public class HashMap4 {

   public int totalcollisions = 0;
    public int totalcollision_search = 0;
    private  class Node{
        int  data;
        Node next;
        Node(int data){
            this.data = data;
        }
        boolean equals(int data){
            return data==this.data;
        }
    }


    Node[] table;
    int n ;
    public HashMap4(int n){
        this.n=n;
        table = new Node[n];
    }
    public void insert(int data){
        int index = data%n;
        if (table[index]==null){
            table[index] = new Node(data);
        }
        else {
            Node temp = new Node(data);
            Node t = table[index];
            while (t.next!=null)
            {
                t= t.next;
                totalcollisions++;
            }
            totalcollisions++;
            t.next=temp;
        }

    }


    public void display(){
        for (int  index = 0 ; index<n;index++) {

            System.out.print(index+"  ====  ");
            Node temp = table[index];
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public boolean search(int data){
        int index = data%n;
        Node temp = table[index];
        while(temp!=null){
            totalcollision_search++;
            if (temp.equals(data))
                return true;
            temp = temp.next;
        }
        return false;
    }


    public boolean delete(int data){
        int index = data%n;
        Node temp = table[index];
        Node prev=null;
        while (temp!=null){
            if (temp.equals(data)){
                if (prev==null)
                    table[index]= temp.next;
                else{
                    prev.next=temp.next;
                }
                return true;
            }
            prev = temp;
            temp = temp.next;
        }
        return false;
    }

}
