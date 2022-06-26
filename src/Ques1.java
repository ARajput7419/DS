import hashing.HashMap1;

import java.util.Scanner;

public class Ques1 {
    public static void main(String[] args) {
        int n = 10;
        HashMap1 map = new HashMap1(n);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter height");
        for (int i = 0; i<n;i++)
        {
            double height = scanner.nextDouble();
            map.insert(height);
        }
        map.display();
    }

}
