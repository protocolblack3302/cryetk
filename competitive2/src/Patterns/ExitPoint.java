package Patterns;


import java.util.Scanner;

public class ExitPoint {
    static Scanner sc = new Scanner(System.in);

    public static int[][] fun(int[][] arr, int rows , int cols) {
            int minRow=0;
            int minCol=0;
            int maxRow=rows-1;
            int maxCol=cols-1;
            System.out.println("enter rows and columns");



            int[][] result=new int[1][2];
            int[][] nowAt= new int[1][2];


        while(nowAt[0][1]!=maxCol){
            for(int i=nowAt[0][0],j=nowAt[0][1];j<=maxCol;j++){
                if(arr[i][j]==1){
                    nowAt[0][0]=i+1;
                    nowAt[0][1]=j;
                    break;
                }else if(j==maxCol) {
                    result[0][0]=i;
                    result[0][1]=j;
                    return result;
                }
            }

            for(int i=nowAt[0][0],j=nowAt[0][1];i<=maxRow;i++){
                if(arr[i][j]==1){
                    nowAt[0][0]=i;
                    nowAt[0][1]=j-1;
                    break;
                }else if(i==maxRow) {
                    result[0][0]=i;
                    result[0][1]=j;
                    return result;
                }
            }


            for(int i=nowAt[0][0],j=nowAt[0][1];j>=minCol;j--){
                if(arr[i][j]==1){
                    nowAt[0][0]=i-1;
                    nowAt[0][1]=j;
                    break;
                }else if(j==minCol) {
                    result[0][0]=i;
                    result[0][1]=j;
                    return result;
                }
            }

            for(int i=nowAt[0][0],j=nowAt[0][1];i>=minRow;i--){
                if(arr[i][j]==1){
                    nowAt[0][0]=i;
                    nowAt[0][1]=j+1;
                    break;
                }else if(i==minRow) {
                    result[0][0]=i;
                    result[0][1]=j;
                    return result;
                }
            }
        }
return result;
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

     int[][] result= fun(arr,rows,cols);

       for(int[] i:result){
           for(int j:i){
               System.out.println(j);
           }
       }

    }

}
