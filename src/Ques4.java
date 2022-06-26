import hashing.HashMap4;

import java.util.Scanner;

public class Ques4 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter table size ");
        int  m = scanner.nextInt();
        HashMap4  map = new HashMap4(m);
        System.out.println("Enter total numbers ");
        int n = scanner.nextInt();
        int [] data = new int[n];
        for (int i =0 ;i<n;i++)
            data[i] = scanner.nextInt();

        for (int num:data)
            map.insert(num);
        map.display();
        System.out.println("Average probes while inserting  .... "+(map.totalcollisions/(double)n));
        for (int num :data)
            map.search(num);
        System.out.println("Average probes  while searching .... "+(map.totalcollision_search)/(double)n);

    }
}
