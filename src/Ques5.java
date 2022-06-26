import java.util.Scanner;

public class Ques5 {
    public static class HashMap1 {
        Double marker = Double.POSITIVE_INFINITY;
        Double [] table;
        int n ;
        public HashMap1(int n){
            this.n=n;
            table = new  Double[n];
        }
        public void insert(double height){
            int key = (int)height;
            final double A = 0.5;
            int index = (int)Math.floor(n*(key*A%1));
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
            final double A = 0.5;
            int index = (int)Math.floor(n*(key*A%1));
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
            final double A = 0.5;
            int index = (int)Math.floor(n*(key*A%1));
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

    public static class HashMap2a {

        int totalcollisions = 0;
        private  class Node{
            String data;
            Node next;
            Node(String data){
                this.data = data;
            }
            boolean equals(String data){
                return data.equals(this.data);
            }
        }


        Node [] table;
        int n ;
        public HashMap2a(int n){
            this.n=n;
            table = new  Node[n];
        }
        void insert(String name){
            int sum = 0;
            for (char c :name.toCharArray())
                sum+=c;
            final double A = 0.5;
            int index = (int)Math.floor(n*(sum*A%1));
            if (table[index]==null){
                table[index] = new Node(name);
            }
            else {
                Node temp = new Node(name);
                Node t = table[index];
                while (t.next!=null)
                {
                    t= t.next;
                    totalcollisions++;
                }
                totalcollisions++;
                t.next=temp;
            }

        }


        void display(){
            for (int  index = 0 ; index<n;index++) {

                System.out.print(index+"  ====  ");
                Node temp = table[index];
                while (temp != null) {
                    System.out.print(temp.data + " -> ");
                    temp = temp.next;
                }
                System.out.println();
            }
        }

        boolean search(String data){
            int sum = 0;
            for (char c :data.toCharArray())
                sum+=c;
            final double A = 0.5;
            int index = (int)Math.floor(n*(sum*A%1));
            Node temp = table[index];
            while(temp!=null){
                if (temp.equals(data))
                    return true;
                temp = temp.next;
            }
            return false;
        }


        boolean delete(String data){
            int sum = 0;
            for (char c :data.toCharArray())
                sum+=c;
            final double A = 0.5;
            int index = (int)Math.floor(n*(sum*A%1));
            Node temp = table[index];
            Node prev=null;
            while (temp!=null){
                if (temp.equals(data)){
                    if (prev==null)
                        table[index]= temp.next;
                    else{
                        prev.next=temp.next;
                    }
                    return true;
                }
                prev = temp;
                temp = temp.next;
            }
            return false;
        }
    }


    public static class HashMap2b {
        int totalcollisions = 0;
        private  class Node{
            Double data;
            Node next;
            Node(Double data){
                this.data = data;
            }
            boolean equals(Double d){
                return data.equals(d);
            }
        }


        Node[] table;
        int n ;
        public HashMap2b(int n){
            this.n=n;
            table = new Node[n];
        }
        void insert(Double data){
            long firstpart = (long)(double)data;
            double secondtemp  = data - firstpart;
            while (secondtemp!=(long)secondtemp)
                secondtemp*=10;
            long secondpart = (long)secondtemp;
            long sum = firstpart + secondpart;
            final double A = 0.5;
            int index = (int)Math.floor(n*(sum*A%1));
            if (table[index]==null){
                table[index] = new Node(data);
            }
            else {
                Node temp = new Node(data);
                Node t = table[index];
                while (t.next!=null)
                {
                    t= t.next;
                    totalcollisions++;
                }
                totalcollisions++;
                t.next=temp;
            }

        }


        void display(){
            for (int  index = 0 ; index<n;index++) {

                System.out.print(index+"  ====  ");
                Node temp = table[index];
                while (temp != null) {
                    System.out.print(temp.data + " -> ");
                    temp = temp.next;
                }
                System.out.println();
            }
        }

        boolean search(Double data){
            long firstpart = (long)(double)data;
            double secondtemp  = data - firstpart;
            while (secondtemp!=(long)secondtemp)
                secondtemp*=10;
            long secondpart = (long)secondtemp;
            long sum = firstpart + secondpart;
            final double A = 0.5;
            int index = (int)Math.floor(n*(sum*A%1));
            Node temp = table[index];
            while(temp!=null){
                if (temp.equals(data))
                    return true;
                temp = temp.next;
            }
            return false;
        }


        boolean delete(Double data){

            long firstpart = (long)(double)data;
            double secondtemp  = data - firstpart;
            while (secondtemp!=(long)secondtemp)
                secondtemp*=10;
            long secondpart = (long)secondtemp;
            long sum = firstpart + secondpart;
            final double A = 0.5;
            int index = (int)Math.floor(n*(sum*A%1));
            Node temp = table[index];
            Node prev=null;
            while (temp!=null){
                if (temp.equals(data)){
                    if (prev==null)
                        table[index]= temp.next;
                    else{
                        prev.next=temp.next;
                    }
                    return true;
                }
                prev = temp;
                temp = temp.next;
            }
            return false;
        }
    }

    public static class HashMap2c {


        int totalcollisions = 0;
        private  class Node{
            Long data;
            Node next;
            Node(Long data){
                this.data = data;
            }
            boolean equals(Long d){
                return data.equals(d);
            }
        }


        Node[] table;
        int n ;
        public HashMap2c(int n){
            this.n=n;
            table = new Node[n];
        }
        void insert(Long data){
            long temp1 = data;
            int secondpart = 0 , firstpart = 0;

            for (int i = 0;i<32;i++)
            {
                secondpart = (secondpart | (int)((temp1&1)<<i));
                temp1>>>=1;
            }
            for (int i = 0;i<32;i++)
            {
                firstpart = (firstpart | (int)((temp1&1)<<i));
                temp1>>>=1;
            }
            int sum = firstpart + secondpart;
            final double A = 0.5;
            int index = (int)Math.floor(n*(sum*A%1));
            if (table[index]==null){
                table[index] = new Node(data);
            }
            else {
                Node temp = new Node(data);
                Node t = table[index];
                while (t.next!=null)
                {
                    t= t.next;
                    totalcollisions++;
                }
                totalcollisions++;
                t.next=temp;
            }

        }


        void display(){
            for (int  index = 0 ; index<n;index++) {

                System.out.print(index+"  ====  ");
                Node temp = table[index];
                while (temp != null) {
                    System.out.print(temp.data + " -> ");
                    temp = temp.next;
                }
                System.out.println();
            }
        }

        boolean search(Long data){
            long temp1 = data;
            int secondpart = 0 , firstpart = 0;

            for (int i = 0;i<32;i++)
            {
                secondpart = (secondpart | (int)((temp1&1)<<i));
                temp1>>>=1;
            }
            for (int i = 0;i<32;i++)
            {
                firstpart = (firstpart | (int)((temp1&1)<<i));
                temp1>>>=1;
            }
            int sum = firstpart + secondpart;
            final double A = 0.5;
            int index = (int)Math.floor(n*(sum*A%1));
            Node temp = table[index];
            while(temp!=null){
                if (temp.equals(data))
                    return true;
                temp = temp.next;
            }
            return false;
        }


        boolean delete(Long data){
            long temp1 = data;
            int secondpart = 0 , firstpart = 0;

            for (int i = 0;i<32;i++)
            {
                secondpart = (secondpart | (int)((temp1&1)<<i));
                temp1>>>=1;
            }
            for (int i = 0;i<32;i++)
            {
                firstpart = (firstpart | (int)((temp1&1)<<i));
                temp1>>>=1;
            }
            int sum = firstpart + secondpart;
            final double A = 0.5;
            int index = (int)Math.floor(n*(sum*A%1));
            Node temp = table[index];
            Node prev=null;
            while (temp!=null){
                if (temp.equals(data)){
                    if (prev==null)
                        table[index]= temp.next;
                    else{
                        prev.next=temp.next;
                    }
                    return true;
                }
                prev = temp;
                temp = temp.next;
            }
            return false;
        }
    }



    public static class HashMap3 {
        int totalcollisions = 0;
        private  class Node{
            String data;
            Node next;
            Node(String data){
                this.data = data;
            }
            boolean equals(String data){
                return data.equals(this.data);
            }
        }


        Node[] table;
        int n ;
        public HashMap3(int n){
            this.n=n;
            table = new Node[n];
        }
        void insert(String name){
            int num = 1;
            int sum = 0;
            final int mod =1_00_00_00_00_7;
            for (char c :name.toCharArray()){
                sum=(sum+(num*c)%mod)%mod;
                num=(num*33)%mod;
            }
            final double A = 0.5;
            int index = (int)Math.floor(n*(sum*A%1));
            if (table[index]==null){
                table[index] = new Node(name);
            }
            else {
                Node temp = new Node(name);
                Node t = table[index];
                while (t.next!=null)
                {
                    t= t.next;
                    totalcollisions++;
                }
                totalcollisions++;
                t.next=temp;
            }

        }


        void display(){
            for (int  index = 0 ; index<n;index++) {

                System.out.print(index+"  ====  ");
                Node temp = table[index];
                while (temp != null) {
                    System.out.print(temp.data + " -> ");
                    temp = temp.next;
                }
                System.out.println();
            }
        }

        boolean search(String data){
            int num = 1;
            int sum = 0;
            final int mod =1_00_00_00_00_7;
            for (char c :data.toCharArray()){
                sum=(sum+(num*c)%mod)%mod;
                num=(num*33)%mod;
            }
            final double A = 0.5;
            int index = (int)Math.floor(n*(sum*A%1));
            Node temp = table[index];
            while(temp!=null){
                if (temp.equals(data))
                    return true;
                temp = temp.next;
            }
            return false;
        }


        boolean delete(String data){
            int num = 1;
            int sum = 0;
            final int mod =1_00_00_00_00_7;
            for (char c :data.toCharArray()){
                sum=(sum+(num*c)%mod)%mod;
                num=(num*33)%mod;
            }
            final double A = 0.5;
            int index = (int)Math.floor(n*(sum*A%1));
            Node temp = table[index];
            Node prev=null;
            while (temp!=null){
                if (temp.equals(data)){
                    if (prev==null)
                        table[index]= temp.next;
                    else{
                        prev.next=temp.next;
                    }
                    return true;
                }
                prev = temp;
                temp = temp.next;
            }
            return false;
        }
    }


    public static class HashMap4 {

        int totalcollisions = 0;
        int totalcollision_search = 0;
        private  class Node{
            int  data;
            Node next;
            Node(int data){
                this.data = data;
            }
            boolean equals(int data){
                return data==this.data;
            }
        }


        Node[] table;
        int n ;
        public HashMap4(int n){
            this.n=n;
            table = new Node[n];
        }
        void insert(int data){
            final double A = 0.5;
            int index = (int)Math.floor(n*(data*A%1));
            if (table[index]==null){
                table[index] = new Node(data);
            }
            else {
                Node temp = new Node(data);
                Node t = table[index];
                while (t.next!=null)
                {
                    t= t.next;
                    totalcollisions++;
                }
                totalcollisions++;
                t.next=temp;
            }

        }


        void display(){
            for (int  index = 0 ; index<n;index++) {

                System.out.print(index+"  ====  ");
                Node temp = table[index];
                while (temp != null) {
                    System.out.print(temp.data + " -> ");
                    temp = temp.next;
                }
                System.out.println();
            }
        }

        boolean search(int data){
            final double A = 0.5;
            int index = (int)Math.floor(n*(data*A%1));
            Node temp = table[index];
            while(temp!=null){
                totalcollision_search++;
                if (temp.equals(data))
                    return true;
                temp = temp.next;
            }
            return false;
        }


        boolean delete(int data){
            final double A = 0.5;
            int index = (int)Math.floor(n*(data*A%1));
            Node temp = table[index];
            Node prev=null;
            while (temp!=null){
                if (temp.equals(data)){
                    if (prev==null)
                        table[index]= temp.next;
                    else{
                        prev.next=temp.next;
                    }
                    return true;
                }
                prev = temp;
                temp = temp.next;
            }
            return false;
        }

    }


    public static void main(String[] args) {


        System.out.println("==========   Ques  1 ============");
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


        System.out.println("============  Ques 2  ==============");

        HashMap2a map1 = new HashMap2a(10);
        System.out.println("Enter number of students ");
        int n1 = scanner.nextInt();
        String names[] = new String[n1];

        for (int i = 0 ;i<n1;i++)
            names[i]=scanner.next();

        System.out.println("Using h(x) = x mod 10 ");
        for (String name:names)
            map1.insert(name);

        map1.display();

        System.out.println("Total collisions ... "+map1.totalcollisions);
        System.out.println("Using h(x) = x mod 17 ");
        map1 = new HashMap2a(17);
        for (String name:names)
            map1.insert(name);
        map1.display();
        System.out.println("Total collisions ... "+map1.totalcollisions);



        System.out.println("===== DOUBLE ======");
        System.out.println("Enter total numbers ");
        n = scanner.nextInt();
        double numbers[] = new double[n];
        for (int i =0;i<n;i++)
            numbers [ i]= scanner.nextDouble();

        System.out.println("Using h(x) = x mod 10 ");
        HashMap2b map2 = new HashMap2b(10);

        for (double number :numbers)
            map2.insert(number);

        map2.display();

        System.out.println("Total collisions ... "+map2.totalcollisions);

        System.out.println("Using h(x) = x mod 17 ");
        map2 = new HashMap2b(17);
        for (double number:numbers)
            map2.insert(number);
        map2.display();
        System.out.println("Total collisions ... "+map2.totalcollisions);



        System.out.println("===== LONG ==== ");

        System.out.println("Enter number of elements ");
        n = scanner.nextInt();
        long num [] = new long[n];
        for (int i =0;i<n;i++)
            num[i] = scanner.nextLong();


        System.out.println("Using h(x) = x mod 10 ");
        HashMap2c map3 = new HashMap2c(10);

        for (long number :num)
            map3.insert(number);

        map3.display();

        System.out.println("Total collisions ... "+map3.totalcollisions);

        System.out.println("Using h(x) = x mod 17 ");
        map3 = new HashMap2c(17);
        for (long number:num)
            map3.insert(number);
        map3.display();
        System.out.println("Total collisions ... "+map3.totalcollisions);


        System.out.println("=============  Ques 3 ================");

        HashMap3 map4 = new HashMap3(10);
        System.out.println("Enter number of students ");
        n  = scanner.nextInt();
        names = new String[n];
        for (int i =0;i<n;i++)
            names[i] = scanner.next();

        System.out.println("Using h(x) = x mod 10 ");
        for (String name:names)
            map4.insert(name);
        map4.display();
        System.out.println("Total collisions .... "+map4.totalcollisions);


        System.out.println("Using h(x) = x mod 17 ");
        map4 = new HashMap3(17);
        for (String name:names)
            map4.insert(name);
        map4.display();
        System.out.println("Total collisions .... "+map4.totalcollisions);

        System.out.println("=============   Ques 4 =============");

        System.out.println("Enter table size ");
        int  m = scanner.nextInt();
        HashMap4  map5 = new HashMap4(m);
        System.out.println("Enter total numbers ");
        n = scanner.nextInt();
        int [] data = new int[n];
        for (int i =0 ;i<n;i++)
            data[i] = scanner.nextInt();

        for (int num1:data)
            map5.insert(num1);
        map5.display();
        System.out.println("Average probes while inserting  .... "+(map5.totalcollisions/(double)n));
        for (int num1 :data)
            map5.search(num1);
        System.out.println("Average probes  while searching .... "+(map5.totalcollision_search)/(double)n);


    }
}
