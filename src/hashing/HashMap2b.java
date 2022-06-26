package hashing;

public class HashMap2b {
    public int totalcollisions = 0;
    private  class Node{
        Double data;
        Node next;
        Node(Double data){
            this.data = data;
        }
        boolean equals(Double d){
            return data.equals(d);
        }
    }


    Node[] table;
    int n ;
    public HashMap2b(int n){
        this.n=n;
        table = new Node[n];
    }
    public void insert(Double data){
        long firstpart = (long)(double)data;
        double secondtemp  = data - firstpart;
        while (secondtemp!=(long)secondtemp)
            secondtemp*=10;
        long secondpart = (long)secondtemp;
        long sum = firstpart + secondpart;
        int index = (int)((sum+n)%n);
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

    public boolean search(Double data){
        long firstpart = (long)(double)data;
        double secondtemp  = data - firstpart;
        while (secondtemp!=(long)secondtemp)
            secondtemp*=10;
        long secondpart = (long)secondtemp;
        long sum = firstpart + secondpart;
        int index = (int)((sum+n)%n);
        Node temp = table[index];
        while(temp!=null){
            if (temp.equals(data))
                return true;
            temp = temp.next;
        }
        return false;
    }


   public  boolean delete(Double data){

        long firstpart = (long)(double)data;
        double secondtemp  = data - firstpart;
        while (secondtemp!=(long)secondtemp)
            secondtemp*=10;
        long secondpart = (long)secondtemp;
        long sum = firstpart + secondpart;
        int index = (int)((sum+n)%n);
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
