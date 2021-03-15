package Sorting;
import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    static Scanner sc = new Scanner(System.in);

    public static void bubbleSort(int[] numbers) {
        for(int i=0;i<numbers.length-1;i++){
            for(int j=0;j<numbers.length-1-i;j++){
                if(numbers[j]>numbers[j+1]){
                    int temp=numbers[j];
                    numbers[j]=numbers[j+1];  //swap
                    numbers[j+1]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("enter the size of array");
        int[] numbers = new int[sc.nextInt()];
        for(int i=0;i<numbers.length;i++){
            numbers[i]= sc.nextInt();
        }
        bubbleSort(numbers);
        Arrays.stream(numbers).forEach(System.out::println);
    }
}