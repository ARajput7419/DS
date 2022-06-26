import hashing.HashMap3;

import java.util.Scanner;

public class Ques3 {
    public static void main(String[] args) {
        HashMap3 map = new HashMap3(10);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of students ");
        int n  = scanner.nextInt();
        String names [] = new String[n];
        for (int i =0;i<n;i++)
            names[i] = scanner.next();

        System.out.println("Using h(x) = x mod 10 ");
        for (String name:names)
            map.insert(name);
        map.display();
        System.out.println("Total collisions .... "+map.totalcollisions);


        System.out.println("Using h(x) = x mod 17 ");
        map = new HashMap3(17);
        for (String name:names)
            map.insert(name);
        map.display();
        System.out.println("Total collisions .... "+map.totalcollisions);




    }
}
