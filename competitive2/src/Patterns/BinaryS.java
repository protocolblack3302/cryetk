package Patterns;

import java.util.Scanner;

public class BinaryS {
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

        }
        return -1;
    }

    public static void main(String[] args) {

    }

}
