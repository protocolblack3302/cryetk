package others;

import java.util.Scanner;

public class ArrayMultiplication {
    static Scanner sc = new Scanner(System.in);

    public static void fun() {
        int[][] arr1 = new int[2][3];
        int[][] arr2 = new int[3][4];
        int[][] arr3 = new int[2][4];

        if (arr1[0].length == arr2.length) {
            for(int i=0;i<arr1.length;i++){
                for(int j=0;j<arr2[0].length;j++){
                    for(int k=0;i<arr3[0].length;k++){
                        arr3[i][j]+=arr1[i][k]*arr2[k][j];
                    }
                }
            }

        }
    }
    public static void main(String[] args) {

    }

}
