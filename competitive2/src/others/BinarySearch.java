package others;

import java.util.Scanner;

public class BinarySearch {
    static Scanner sc = new Scanner(System.in);

    public static int binarySearch(int element ,int[] arr,int l ,int h) {

        int store=0;
        int mid=(l+h)/2;
        while(l<=h){
            if(element<arr[mid]){
               h=mid;
            }else if(element>arr[mid]){
                l=mid;
            }else {
                return mid;
            }
            mid=(l+h)/2;
            if(store==mid){
                return mid;
            }
            store=mid;

        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println("how many numbers to enter : ");

        int n=sc.nextInt();
        int[] arr=new int[n];

        System.out.println("enter numbers");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();

        }
        System.out.println("enter element to search");
        int elem=sc.nextInt();
        int found_at=binarySearch(elem,arr,0,arr.length-1);
        if(arr[found_at]==elem){
            System.out.println("ceil = floor = "+elem);
        }else{
            System.out.println("floor = "+arr[found_at]+" ceil = "+arr[found_at+1]);
        }



    }

}
