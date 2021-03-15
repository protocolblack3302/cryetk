//The solutions should be written, for compiler compatibility : j2se jdk 8u51
package tets;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

 class MyClass
{

    public  static long convert(long num1,int base_a ,int base_b) {
        int counter=0;
        long actual_value=0;
        while(num1!=0){
            long extr=num1%base_b;
            num1/=base_b;
            actual_value+=extr*(long)Math.pow(base_a,counter);
            counter++;
        }
        return actual_value;

    }

   static Scanner sc=new Scanner(System.in);
    public static void main (String[] args) throws java.lang.Exception
    {
        //use the following code to fetch input from console
        String line;
            ArrayList<Long> list=new ArrayList<>();


        DataInputStream in = new DataInputStream(System.in);

        while((line=in.readLine())!=null)
        {
            if(!line.equals("")){
        list.add(Long.parseLong(line));}
            else break;
        }

        List<String> mylist=  list.stream().map(Long::toBinaryString).collect(Collectors.toList());

        System.out.println(mylist);

        ArrayList<StringBuilder> newlist=new ArrayList<>();
        for(int i=0;i<mylist.size();i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<mylist.get(i).length();j++){
                if(mylist.get(i).charAt(j)=='0'){
                    sb.append('1');
                }else {
                    sb.append('0');
                }

            }
            newlist.add(sb);

        }
ArrayList<StringBuilder> new2=new ArrayList<>();
        for(StringBuilder s :newlist){
            for(int i=1;i<=32-s.length();i++){
                s.insert(0,1);
            }
            new2.add(s);
        }

        System.out.println(new2);

ArrayList<Long> finallist=new ArrayList<>();
for(StringBuilder s:new2){
   finallist.add(convert( Long.parseLong(s.toString()),2,10));
}

for(Long l:finallist){
    System.out.print(l+","+" ");
}
    }



}