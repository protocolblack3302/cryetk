package Sorting;
import java.util.Scanner;

public class QuickSort {
    static Scanner sc = new Scanner(System.in);


    public static int quickSelect(int[] number, int low , int high ,int thSmallest){
        int partition =partition(number,low,high);
        if(thSmallest>partition){
           return quickSelect(number,partition+1,high,thSmallest);
        }else if(thSmallest<partition){
           return quickSelect(number,0,partition-1,thSmallest);
        }else{
            return number[partition];
        }
    }

    public static void quicksort(int[] numbers, int low , int high) {
        if(low<high) {
            int partition = partition(numbers, low, high);
            quicksort(numbers, low, partition - 1);
            quicksort(numbers, partition + 1, high);

        }

    }

    static void swap(int[] numbers , int i , int j){
        int temp=numbers[i];
        numbers[i]=numbers[j];
        numbers[j]=temp;
    }

    static int partition(int[] numbers , int low ,int high){
        int pivot=numbers[high];
        int i=low-1;
        for(int j=low ; j<high ;j++){
            if(numbers[j]<=pivot){
                ++i;
               swap(numbers,i,j);
            }

        }
        swap(numbers,i+1,high);
        return i+1;
    }

    public static void main(String[] args) {
        System.out.println("enter the size of array");
        int[] numbers = new int[sc.nextInt()];
        for(int i=0;i<numbers.length;i++){
            numbers[i]= sc.nextInt();
        }
        System.out.println(quickSelect(numbers,0,numbers.length-1,sc.nextInt()-1));

        quicksort(numbers,0,numbers.length-1);

        for(int i:numbers){
            System.out.print(i+" ");
        }
        }

}
