package tree;

import java.util.Locale;
import java.util.Scanner;

public class Ques5 {

    static class Partition{
        String name;
        DirectoryStructure directoryStructure = new DirectoryStructure();
        Partition next;
        Partition(String name){
            this.name = name;
        }
    }

    static Partition head;
    static {
        head = new Partition("C:");
        head.next = new Partition("D:");
        head.next.next = new Partition("E:");
    }

    static Partition search(String name){
        Partition temp = head;
        while (temp!=null){
            if (temp.name.equals(name))
                return temp;
            temp = temp.next;
        }
        return null;
    }

    public  static double bytesToMB(long bytes ){
        return bytes/(1024d*1024);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("********* MENU ******** ");
            System.out.println("1. Create A File ");
            System.out.println("2. Create A Directory ");
            System.out.println("3. Print Directory Structure ");
            System.out.println("4. Get Size ");
            System.out.println("5. Exit ");
            System.out.println("\n Enter your choice ");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                {
                    System.out.println("Enter Partition name");
                    String partitionName = scanner.next().trim();
                    Partition p = search(partitionName);
                    if (p==null)
                    {
                        System.out.println("Partition is not found ");
                        break;
                    }
                    DirectoryStructure directoryStructure= p.directoryStructure;
                    System.out.println("Enter Directory Name ");
                    String directory_name = scanner.next().trim();
                    System.out.println("Enter File Name ");
                    String file_name = scanner.next().trim();
                    System.out.println("Enter File Size ");
                    long size = scanner.nextLong();
                    directoryStructure.createFile(directory_name.equals("/")?"":directory_name,file_name,size);
                    break;
                }
                case 2:{
                    System.out.println("Enter Partition name");
                    String partitionName = scanner.next().trim();
                    Partition p = search(partitionName);
                    if (p==null)
                    {
                        System.out.println("Partition is not found ");
                        break;
                    }
                    DirectoryStructure directoryStructure= p.directoryStructure;
                    System.out.println("Enter Directory Name ");
                    String directory_name = scanner.next().trim();
                    System.out.println("Enter New Directory Name ");
                    String new_directory_name = scanner.next().trim();
                    directoryStructure.createDirectory(directory_name.equals("/")?"":directory_name,new_directory_name);
                    break;
                }
                case 3:{
                    System.out.println("Enter Partition name");
                    String partitionName = scanner.next().trim();
                    Partition p = search(partitionName);
                    if (p==null)
                    {
                        System.out.println("Partition is not found ");
                        break;
                    }
                    DirectoryStructure directoryStructure= p.directoryStructure;
                    directoryStructure.printDirectoryStructure();
                    break;
                }
                case 4:{
                    Partition temp = head;
                    long size = 0 ;
                    while (temp!=null){
                        size+=temp.directoryStructure.calculateSize();
                        temp=temp.next;
                    }
                    System.out.println("Size Used : "+String.format("%.4f",bytesToMB(size)));
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
