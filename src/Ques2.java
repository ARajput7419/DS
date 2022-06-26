import hashing.HashMap2a;
import hashing.HashMap2b;
import hashing.HashMap2c;
import java.util.Scanner;

public class Ques2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap2a map = new HashMap2a(10);
        System.out.println("Enter number of students ");
        int n = scanner.nextInt();
        String names[] = new String[n];

        for (int i = 0 ;i<n;i++)
            names[i]=scanner.next();

        System.out.println("Using h(x) = x mod 10 ");
        for (String name:names)
            map.insert(name);

        map.display();

        System.out.println("Total collisions ... "+map.totalcollisions);
        System.out.println("Using h(x) = x mod 17 ");
        map = new HashMap2a(17);
        for (String name:names)
            map.insert(name);
        map.display();
        System.out.println("Total collisions ... "+map.totalcollisions);



        System.out.println("===== DOUBLE ======");
        System.out.println("Enter total numbers ");
        n = scanner.nextInt();
        double numbers[] = new double[n];
        for (int i =0;i<n;i++)
            numbers [ i]= scanner.nextDouble();

        System.out.println("Using h(x) = x mod 10 ");
        HashMap2b map1 = new HashMap2b(10);

        for (double number :numbers)
            map1.insert(number);

        map1.display();

        System.out.println("Total collisions ... "+map1.totalcollisions);

        System.out.println("Using h(x) = x mod 17 ");
        map1 = new HashMap2b(17);
        for (double number:numbers)
            map1.insert(number);
        map1.display();
        System.out.println("Total collisions ... "+map1.totalcollisions);



        System.out.println("===== LONG ==== ");

        System.out.println("Enter number of elements ");
        n = scanner.nextInt();
        long num [] = new long[n];
        for (int i =0;i<n;i++)
            num[i] = scanner.nextLong();


        System.out.println("Using h(x) = x mod 10 ");
        HashMap2c map2 = new HashMap2c(10);

        for (long number :num)
            map2.insert(number);

        map2.display();

        System.out.println("Total collisions ... "+map2.totalcollisions);

        System.out.println("Using h(x) = x mod 17 ");
        map2 = new HashMap2c(17);
        for (long number:num)
            map2.insert(number);
        map2.display();
        System.out.println("Total collisions ... "+map2.totalcollisions);

    }

}
