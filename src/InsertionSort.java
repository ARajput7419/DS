import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

 public class InsertionSort {


    static  void insertionSort(int data []){


        for(int i = 1; i<data.length ;i++){
            int k = i;
            int val = data[i];
            while (k>0 && data[k-1]>val){
                data[k] = data[k-1];
                k--;
            }
            data[k]=val;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Total Test cases ");
        int Testcase=scanner.nextInt();
        PrintWriter writer = new PrintWriter("data.txt");
        while(Testcase-->0) {
            System.out.println("Enter size ");
            int n = scanner.nextInt();
            int [] data = new int[n];
            System.out.println("Enter data ");
            for (int i = 0; i < n; i++)
                data [i] = scanner.nextInt();
            long start = System.currentTimeMillis();
            insertionSort(data);
            long end = System.currentTimeMillis();
            System.out.println(Arrays.toString(data));
            writer.println(n+" "+(end-start));
        }
        writer.flush();
        ProcessBuilder builder = new ProcessBuilder();
        builder.command("/home/aniket/PycharmProjects/OOPS/venv/bin/python" ,"/home/aniket/IdeaProjects/DS/plot.py");
        builder.start();

    }
}