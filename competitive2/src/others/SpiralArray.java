package others;

import java.util.Scanner;

public class SpiralArray {
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {

        int row=sc.nextInt();
        int column=sc.nextInt();
        int[][] arr=new int[row][column];
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                arr[i][j]=sc.nextInt();
            }
        }
int counter=0;
        int no_element=row*column;


        while(counter<no_element){
            int minrow=0;
            int mincol=0;
            int maxrow=row-1;
            int maxcol=column-1;
            //down
            for(int i=minrow ,j=mincol;i<=maxrow;i++){
                    System.out.println(arr[i][j]);
                    counter++;

            }

            mincol++;
            //right
            for(int i=maxrow,j=mincol;j<=maxcol;j++){
                System.out.println(arr[i][j]);
                counter++;
            }
            maxrow--;
            //up
            for(int i=maxrow,j=maxcol;i>=minrow;i--){
                System.out.println(arr[i][j]);
                counter++;
            }

            maxcol--;

            //left

            for(int i=minrow,j=maxcol;j>=mincol;j--){
                System.out.println(arr[i][j]);
                counter++;
            }
            minrow++;

        }

    }

}
