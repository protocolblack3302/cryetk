package others;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveArrListPrime {
    static Scanner sc = new Scanner(System.in);
    public static Boolean isNotPrime(int num){
        for(int i=2;i<=(int)Math.sqrt(num);i++){
            if(num%i==0){
                return true;
            }
        }
        return false;
    }


    public static void fun(ArrayList<Integer> arrayList) {

      List mylist=arrayList.parallelStream().filter(RemoveArrListPrime::isNotPrime).collect(Collectors.toList());
      mylist.forEach(System.out::println);

    }

    public static void main(String[] args) {

        ArrayList<Integer> arrayList=new ArrayList<>();
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(11);
        arrayList.add(21);


        fun(arrayList);
    }

}
