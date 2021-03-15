package Recursive;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class KPC {
    static Scanner sc = new Scanner(System.in);
    static String[] keypadList=new String[]{".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

    public static ArrayList<String> kpc(String str) {
        if(str.equals("")){
            return new ArrayList<>(Collections.singletonList(""));
        }
        int firstChar=Character.getNumericValue(str.charAt(0));
        String rest=str.substring(1);
        ArrayList<String> result=kpc(rest);
        ArrayList<String> myresult=new ArrayList<>();
       for(int j=0;j<result.size();j++){
           for(int i=0;i<keypadList[firstChar].length();i++){
               char diffChar =keypadList[firstChar].charAt(i);
               myresult.add(diffChar+result.get(j));
           }
       }
            return myresult;
    }

    public static void main(String[] args) {

        String str=sc.next();
        ArrayList<String> combinations = kpc(str);
        System.out.println(combinations);

    }
}