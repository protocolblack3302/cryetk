package tets;

import java.io.*;
import java.util.ArrayList;

public class BinaryReverse {


    public static int reverse(int input){
        int times=1;
        int output=0;
        while (times<33){
            int bit=input&1;
            input=input>>>1;
            output=output|bit;
            output=output<<1;
            ++times;
        }
        return output;
    }


    public static void main(String[] args) throws IOException {
        String in;
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arrayList =new ArrayList<>();

        while(!(in=bufferedReader.readLine()).equals("")){
            arrayList.add(Integer.parseInt(in));
        }

        ArrayList<Integer> reversedList=new ArrayList<>();

        for(Integer i:arrayList){
            reversedList.add(reverse(i));
        }

        System.out.println(reversedList);


    }

}
