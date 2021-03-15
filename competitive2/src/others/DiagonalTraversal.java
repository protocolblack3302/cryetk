package others;

import java.util.Scanner;

public class DiagonalTraversal {
    static Scanner sc = new Scanner(System.in);

    public static void diagonalTraversal(int[][] arr , int rows , int cols) {

        int nowAtRow=0;
        int nowAtCol=0;
        int counter =0;

        while(counter<rows){

            for(int i=nowAtRow,j=nowAtCol;j<cols;j++,i++){
                    System.out.println(arr[i][j]);
            }
            nowAtRow=0;
            counter++;
            nowAtCol=counter;
        }



    }

    public static void main(String[] args) {

        int rows=sc.nextInt();
        int cols=sc.nextInt();

        int[][] arr= new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                arr[i][j]=sc.nextInt();
            }
        }

        diagonalTraversal(arr,rows,cols);


    }

}
