import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class PrefixAverage2 {

    public  static float[] prefixAverage(int data[]){
        float result [] = new float[data.length];
        float sum =0;
        for (int i =0;i<data.length;i++){
            sum+=data[i];
            result[i]=sum/(i+1);
        }
        return  result;
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
            float result[]=prefixAverage(data);
            long end = System.currentTimeMillis();
            System.out.println(Arrays.toString(result));
            writer.println(n+" "+(end-start));
        }
        writer.flush();
        ProcessBuilder builder = new ProcessBuilder();
        builder.command("/home/aniket/PycharmProjects/OOPS/venv/bin/python" ,"/home/aniket/IdeaProjects/DS/plot.py");
        builder.start();
    }
}
