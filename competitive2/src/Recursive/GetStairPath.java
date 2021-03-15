package Recursive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GetStairPath {
    static Scanner sc = new Scanner(System.in);

    public static ArrayList<Integer> methodsToAdd(int stairs) {

        if(stairs==1){
            return new ArrayList<>(Collections.singletonList(1));
        }

       ArrayList<Integer> result= methodsToAdd(stairs-1);
       ArrayList<Integer> myResult=new ArrayList<>();
       for(int i=0;i<result.size();i++){
           int currentNumber=result.get(i);
           myResult.add(1+result.get(i));
           myResult.add(result.get(i)*10+1);
       }

return myResult;


    }

    public static void main(String[] args) {


        System.out.println(methodsToAdd(sc.nextInt()));

    }

}
