package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    static Scanner sc = new Scanner(System.in);

    public static void selectionSort(int[] numbers) {
        int min=0;
        int temp;
        for(int i=0;i<numbers.length;i++){
            min=i;
            for(int j=i+1;j<numbers.length;j++){
                if(numbers[j]<numbers[min]){
                    min=j;
                }
            }
            temp=numbers[i];
            numbers[i]=numbers[min];
            numbers[min]=temp;

        }

    }

    public static void main(String[] args) {
        System.out.println("enter the size of array");
        int[] numbers = new int[sc.nextInt()];
        for(int i=0;i<numbers.length;i++){
            numbers[i]= sc.nextInt();
        }

        selectionSort(numbers);
        Arrays.stream(numbers).forEach(System.out::println);

    }

}
