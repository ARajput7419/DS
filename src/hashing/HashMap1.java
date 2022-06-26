package hashing;

public class HashMap1 {
    Double marker = Double.POSITIVE_INFINITY;
    Double [] table;
    int n ;
   public HashMap1(int n){
        this.n=n;
        table = new  Double[n];
    }
   public void insert(double height){
        int key = (int)height;
        int index = key%n;
        int temp = index;
        for (int i = 0;i<n;i++){
            if (table[temp]==null || table[temp]==marker){
                table[temp]=height;
                break;
            }
            temp = (temp+1)%n;
        }
    }

    public boolean search(double height){
        int key = (int)height;
        int index = key%n;
        int temp = index;
        for (int i = 0;i<n;i++){
            if (table[temp]==null){
                return false;
            }
            else if (table[temp]==height){
                return true;
            }
            temp = (temp+1)%n;
        }
        return false;
    }

   public void delete(double height){

        int key = (int)height;
        int index = key%n;
        int temp = index;
        for (int i = 0;i<n;i++){
            if (table[temp]==null){
                return;
            }
            else if (table[temp]==height){
                table[temp]=marker;
                return;
            }
            temp = (temp+1)%n;
        }

    }
    public void display(){
       for (int i = 0;i<n;i++)
           System.out.println(table[i]);
    }


}
