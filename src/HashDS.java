import java.util.Scanner;
public class HashDS <T> {
    private int tablesize;
    private class Node<T>{
        T data;
        Node next;
        Node(T data){
            this.data = data;
            next = null;
        }
        @Override
        public boolean equals(Object obj){
            Integer node1 = (Integer) obj;
            return this.data.equals(node1);
        }

    }
    Node []table;
    Node []tail;
    HashDS(){
        this(100);
    }
    HashDS(int tablesize){
        this.tablesize = tablesize;
        table = new Node[tablesize];
        tail = new Node[tablesize];
    }
    void insert(T data){
        int index = data.hashCode()%tablesize;
        if (table[index]==null){
            table[index] = new Node(data);
            tail[index]=table[index];
        }
        else {
            Node temp = new Node(data);
            tail[index].next = temp;
            tail[index] = temp;
        }

    }


    void display(){
       for (int  index = 0 ; index<tablesize;index++) {

          System.out.print(index+"  ====  ");
           Node temp = table[index];
           while (temp != null) {
               System.out.print(temp.data + " -> ");
               temp = temp.next;
           }
           System.out.println();
       }
    }

    boolean search(T data){
        int index = data.hashCode()%tablesize;
        Node temp = table[index];
        while(temp!=null){
            if (temp.equals(data))
                return true;
            temp = temp.next;
        }
        return false;
    }


    boolean delete(T data){
        int index = data.hashCode()%tablesize;
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
class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of table");
        int n = scanner.nextInt();
        HashDS<Integer> hashDS = new HashDS<>(n);
        System.out.println("***********MENU***********");
        System.out.println("1. Insert ");
        System.out.println("2. Delete ");
        System.out.println("3. Search ");
        System.out.println("4. Display ");
        System.out.println("5. Exit ");
        while(true) {
            System.out.println("\nEnter your choice");
            int choice  = scanner.nextInt();
            switch (choice){
                case 1:{
                    int ele = scanner.nextInt();
                    hashDS.insert(ele);
                    break;
                }
                case 2:{
                    int ele = scanner.nextInt();
                    hashDS.delete(ele);
                    break;
                }
                case 3:{
                    int ele = scanner.nextInt();
                    System.out.println(hashDS.search(ele));
                    break;
                }
                case 4:{
                    hashDS.display();
                    break;
                }
                case 5:{
                    System.out.println("Good Bye ........");
                    System.exit(0);
                }

            }
        }
    }
}