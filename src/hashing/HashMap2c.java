package hashing;

public class HashMap2c {


   public int totalcollisions = 0;
    private  class Node{
        Long data;
        Node next;
        Node(Long data){
            this.data = data;
        }
        boolean equals(Long d){
            return data.equals(d);
        }
    }


    Node[] table;
    int n ;
    public HashMap2c(int n){
        this.n=n;
        table = new Node[n];
    }
    public void insert(Long data){
        long temp1 = data;
        int secondpart = 0 , firstpart = 0;

        for (int i = 0;i<32;i++)
        {
            secondpart = (secondpart | (int)((temp1&1)<<i));
            temp1>>>=1;
        }
        for (int i = 0;i<32;i++)
        {
            firstpart = (firstpart | (int)((temp1&1)<<i));
            temp1>>>=1;
        }
        int sum = firstpart + secondpart;
        int index = (sum+n)%n;
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

    public boolean search(Long data){
        long temp1 = data;
        int secondpart = 0 , firstpart = 0;

        for (int i = 0;i<32;i++)
        {
            secondpart = (secondpart | (int)((temp1&1)<<i));
            temp1>>>=1;
        }
        for (int i = 0;i<32;i++)
        {
            firstpart = (firstpart | (int)((temp1&1)<<i));
            temp1>>>=1;
        }
        int sum = firstpart + secondpart;
        int index = (sum+n)%n;
        Node temp = table[index];
        while(temp!=null){
            if (temp.equals(data))
                return true;
            temp = temp.next;
        }
        return false;
    }


    public boolean delete(Long data){
        long temp1 = data;
        int secondpart = 0 , firstpart = 0;

        for (int i = 0;i<32;i++)
        {
            secondpart = (secondpart | (int)((temp1&1)<<i));
            temp1>>>=1;
        }
        for (int i = 0;i<32;i++)
        {
            firstpart = (firstpart | (int)((temp1&1)<<i));
            temp1>>>=1;
        }
        int sum = firstpart + secondpart;
        int index = (sum+n)%n;
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
