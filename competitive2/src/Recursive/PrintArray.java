package Recursive;

import java.util.Arrays;
import java.util.Scanner;

public class PrintArray {



    static Scanner sc = new Scanner(System.in);


    public static void fun(int[] arr,int index) {
        if(index==arr.length){
            return;
        }
        System.out.println(arr[index]);
        fun(arr,index+1);

    }

    public static void reverse_fun(int[] arr, int index){
        if(index== arr.length)
            return;
        reverse_fun(arr,index+1);
        System.out.println(arr[index]);
    }

    public static int max_arr(int[] arr , int index){
        if(index==0){
            return index;
        }
        return Math.max(arr[index],max_arr(arr,index-1));
    }

    public static int first_index(int[] arr , int index, int number){
        if(index==arr.length){
            return -1;
        }
        if(arr[index]==number){
            return index;
        }
        return first_index(arr,++index,number);
    }


    public static int last_index(int[] arr,int index, int number){
        if(index==arr.length-1){
            return index;
        }
        int last_found=last_index(arr,++index,number);
        if(index==0 && arr[index]!=number)
            return -1;
        if(arr[last_found]==number)
            return last_found;
        return --index;
    }


    public static int[] all_index(int[] arr, int index,int number,int fsf){
        if(index==arr.length){
            return new int[]{-1};
        }
        if(arr[index]==number){
            ++fsf;
        }
        int[] answers =new int[fsf];
        Arrays.fill(answers,-1);

        int[] foundIndex=all_index(arr,index+1,number,fsf);

        if(arr[index]==number){

            int i;
            int j;

            for(i=foundIndex.length-1,j=answers.length-1;i>=0;i--,j--){
                answers[j]=foundIndex[i];
            }
            answers[j]=index;
            return answers;
        }
        return foundIndex;



    }

    public static void main(String[] args) {

        int[] arr=new int[6];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        fun(arr,0);
        reverse_fun(arr,0);
        System.out.println("max is : " +max_arr(arr,5));
        System.out.println("first index is : " + first_index(arr,0,11));
        System.out.println("last index found is : "+ last_index(arr,0,11));
        all_index(arr,0,11,0);
    }

}
