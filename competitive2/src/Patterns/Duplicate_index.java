package Patterns;

import java.util.Scanner;

public class Duplicate_index {
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {

        int search_elem=sc.nextInt();
        int no_elem=sc.nextInt();
        int[] arr =new int[no_elem];
        for(int i=0;i<no_elem;i++){
            arr[i]=sc.nextInt();
        }
        int index=BinaryS.binarySearch(search_elem,arr,0,arr.length-1);
        int back_index=index;
        int front_index=index;
        while(arr[back_index-1]==arr[index]){
            back_index--;
        }
        while(arr[front_index+1]==arr[index]){
            front_index++;
        }

        System.out.println(back_index+" "+front_index);

    }

}
