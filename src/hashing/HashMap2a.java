package hashing;

public class HashMap2a {

    public int totalcollisions = 0;
    private  class Node{
        String data;
        Node next;
        Node(String data){
            this.data = data;
        }
        boolean equals(String data){
            return data.equals(this.data);
        }
    }


    Node [] table;
    int n ;
    public HashMap2a(int n){
        this.n=n;
        table = new  Node[n];
    }
    public void insert(String name){
        int sum = 0;
        for (char c :name.toCharArray())
            sum+=c;
        int index = sum%n;
        if (table[index]==null){
            table[index] = new Node(name);
        }
        else {
            Node temp = new Node(name);
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

    public boolean search(String data){
        int sum = 0;
        for (char c :data.toCharArray())
            sum+=c;
        int index = sum%n;
        Node temp = table[index];
        while(temp!=null){
            if (temp.equals(data))
                return true;
            temp = temp.next;
        }
        return false;
    }


    public boolean delete(String data){
        int sum = 0;
        for (char c :data.toCharArray())
            sum+=c;
        int index = sum%n;
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
