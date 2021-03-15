package Sorting;
import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    static Scanner sc = new Scanner(System.in);

    public static void insertionSort(int[] numbers) {
        for(int i=1;i<numbers.length;i++){
            for(int j=i-1;j>=0;j--){
                if(numbers[j]>numbers[j+1]){
                    int temp=numbers[j];
                    numbers[j]=numbers[j+1];  //swap
                    numbers[j+1]=temp;
                }else {
                    break;
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


        insertionSort(numbers);

        Arrays.stream(numbers).forEach(System.out::println);
    }

}
