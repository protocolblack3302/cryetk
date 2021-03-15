package others;

import java.util.Arrays;
import java.util.Scanner;

public class PepCoding {

    public static int[] arr;

    public static int fibonnacci_dp(int n){
        if(n<=1)
            return n;
        if(arr[n]!=-1){
            return arr[n];
        }else{
            arr[n]=fibonnacci_dp(n-1) +fibonnacci_dp(n-2);
        }
            return arr[n];
    }


    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        arr=new int[n+1];
        Arrays.fill(arr,-1);
        arr[0]=0;
        arr[1]=1;

        fibonnacci_dp(n);

        Arrays.stream(arr).forEach(System.out::println);



    }
}
