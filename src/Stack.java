import java.util.Arrays;
import java.util.Scanner;


class Stack{
    int size;
    int top;
    int [] data ;
    Stack(){
        this(10);
    }
    Stack(int size){
        this.size = size;
        this.top = -1;
        data = new int[size];
    }
    boolean isFull(){
        return top == size - 1;
    }
    boolean isEmpty(){
        return  top == -1;
    }
    void push(int ele){
        if (!isFull()){
            data[++top]=ele;
        }
        else System.out.println("Stack is Full");
    }
    Integer pop(){
        if (isEmpty()){
            return null;
        }
        else
            return data[top--];
    }
    int [] display(){
        int res[] = new int[top+1];
        for (int i=0;i<top+1;i++)
            res[i]=data[i];
        return res;
    }
    Integer top(){
        if (isEmpty()) return null;
        else return  data[top];
    }
    int size(){
        return top+1;
    }

}

class Driver {
    public static void main(String[] args) {
    System.out.println("Enter stack size ");
    Scanner scanner = new Scanner(System.in);
    int size = scanner.nextInt();
    Stack stack = new Stack(size);
    while(true){
        System.out.println("***********MENU***********");
        System.out.println("1. Push");
        System.out.println("2. Pop");
        System.out.println("3. Top");
        System.out.println("4. Display");
        System.out.println("5. Is Full ? ");
        System.out.println("6. Is Empty ? ");
        System.out.println("7. Get Size ");
        System.out.println("8. Exit");
        System.out.println();
        System.out.println("Enter your choice");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:{
                int ele = scanner.nextInt();
                stack.push(ele);
                break;
            }
            case 2:{
                Integer ele = stack.pop();
                if (ele==null) System.out.println("Stack is empty");
                else System.out.println(ele);
                break;
            }
            case 3:{
                Integer ele = stack.top();
                if (ele == null) System.out.println("Stack is empty");
                else System.out.println(ele);
                break;
            }
            case 4:{
                int [] data = stack.display();
                System.out.println(Arrays.toString(data));
                break;
            }
            case 5:{
                System.out.println(stack.isFull());
                break;
            }
            case 6:{
                System.out.println(stack.isEmpty());
                break;
            }
            case 7:{
                System.out.println(stack.size());
                break;
            }
            case 8:{
                System.out.println("Good Bye ......");
                System.exit(0);
            }
            default:{
                System.out.println("Invalid Choice ....");
                break;

            }

        }

    }




    }
}
