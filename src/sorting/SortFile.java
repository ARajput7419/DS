package sorting;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SortFile {


    private static Object[] readFile(String file_name) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(file_name));
        HashMap<Integer,Integer> map = new HashMap<>();
        String temp;
        int lineNumber=1;
        while((temp=reader.readLine())!=null)
        {
            if (temp.length()!=0)
            map.put(Integer.parseInt(temp.substring(0,temp.indexOf(",")).trim()),lineNumber);
            lineNumber++;
        }
        int [] keys = new int[map.size()];
        int i = 0;
        for (int key:map.keySet())
            keys[i++]=key;
        return new Object[]{map,keys};
    }

    private static int partition (int []data,int low,int high){

        int pivot = data[high];
        while (low<high){
            if (data[low]<pivot)
                low++;
            else
            {
                data[high]=data[low];
                data[low]=data[high-1];
                high--;
            }
        }
        data[high]=pivot;
        return high;
    }


    private static void quickSort(int low,int high,int [] data){
        if (low<high){
            int p = partition(data,low,high);
            quickSort(low,p-1,data);
            quickSort(p+1,high,data);
        }
    }

    private static String getLine(String file_name,int line_number) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file_name));
        while (line_number-->1)
            reader.readLine();
        return reader.readLine();

    }
    private static  void sortFile(String file_name,HashMap <Integer,Integer> map , int [] keys) throws IOException {
        quickSort(0,keys.length-1,keys);
        String file_name2 = "/home/aniket/IdeaProjects/DS/src/sorting/file_aux.csv";
        BufferedWriter writer = new BufferedWriter(new FileWriter(file_name2));
        for (int key:keys){
            int line_number = map.get(key);
            String temp = getLine(file_name,line_number);
            writer.write(temp);
            writer.newLine();
        }
        writer.flush();
        copyAndDelete(file_name2,file_name);
    }

    private static  void copyAndDelete(String source,String destination) throws IOException {
        File file = new File(source);
        FileReader reader  = new FileReader(file);
        FileWriter writer = new FileWriter(destination);
        int c ;
        while ((c=reader.read())!=-1)
            writer.write(c);
        writer.close();
        file.delete();
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        final String file_name = "/home/aniket/IdeaProjects/DS/src/sorting/file.csv";
        Object [] data = readFile (file_name) ;
        HashMap<Integer,Integer> map = (HashMap<Integer, Integer>) data[0];
        int [] keys = (int[])data[1];
        sortFile(file_name,map,keys);

    }

}
