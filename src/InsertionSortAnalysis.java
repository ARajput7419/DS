import java.util.Arrays;

public class InsertionSortAnalysis {
    static int perm[][];

    static int fact(int n ){
        if (n==0) return 1;
        return n*fact(n-1);
    }

    static  int current = 0;

    static int [] count ;

    static void permutations(int [] data,int index){
      if (index>=data.length)
      {
          for (int i=0;i<data.length;i++)
              perm[current][i]=data[i];
          current++;
          return;
      }
      for (int i = index;i<data.length;i++){
          int temp = data[index];
          data[index]=data[i];
          data[i]=temp;
          permutations(data,index+1);
          temp = data[index];
          data[index]=data[i];
          data[i]=temp;
      }
    }

    static void insert(int data[],int index){
        System.out.println("Before inserting "+ Arrays.toString(data));
        int ele = data[index];
        int k = index-1;
        while(k>=0&&data[k]>ele){
            data[k+1]=data[k];
            k--;
        }
        data[k+1]=ele;
        count[k+1]++;
        System.out.println("After inserting "+ Arrays.toString(data));
    }

    public static void main(String[] args) {
        int data[]={1,2,3,4};
        perm = new int [fact(data.length)][data.length];
        count = new int [data.length];
        int validperm=0;
        permutations(data,0);
        for (int i =0;i<perm.length;i++){
            if (perm[i][0]<=perm[i][1]&&perm[i][1]<=perm[i][2])
            {
                insert(perm[i],3 );
                validperm++;
            }
        }
        for (int j = 0;j<data.length;j++){
            System.out.println("Probability for inserting at location "+j+" is "+count[j]/(double)validperm);
        }
        for (int j = 0;j<data.length;j++)
            System.out.println("Probability for inserting at location "+j+" is "+1/(double)data.length);


    }

}
