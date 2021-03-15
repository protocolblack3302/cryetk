package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {
    static Scanner sc = new Scanner(System.in);

    public static void fun() {

    }

    public static void main(String[] args) {


        int arr_size=sc.nextInt();
        int rotation =sc.nextInt();
        int[] arr =new int[arr_size];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }

        int[] rotatedArray = new int[arr_size];
        int counter=0;
        for(int i=rotation-1;i<arr_size;i++){
            rotatedArray[counter]=arr[i];
            counter++;

        }

        for(int i=0;i<(arr_size-rotation);i++){
            rotatedArray[counter]=arr[i];
            counter++;
        }

        Arrays.stream(rotatedArray).forEach(System.out::println);

    }

}
