package DynamicP;

import java.util.Arrays;
import java.util.Scanner;

public class MazeTraversal {
    static Scanner sc = new Scanner(System.in);

    public static int mazeTraversal(int[][] maze , int row , int column,int[][] dp) {

        if(row ==maze.length-1 && column==maze[0].length-1){
            dp[row][column]=maze[row][column];
        }

         if(row==maze.length || column == maze[0].length){
          return Integer.MAX_VALUE-500;
         }
        if(dp[row][column]!=-1){
            return dp[row][column];
        }

      dp[row][column]= Math.min(
              maze[row][column]+
                      mazeTraversal(maze,row+1,column,dp),
              maze[row][column]+
                      mazeTraversal(maze,row,column+1,dp));

        return dp[row][column];
    }

    public static void main(String[] args) {
        int rows=sc.nextInt();
        int cols = sc.nextInt();
        int[][] maze =new int[rows][cols];
        int[][] dp = new int[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                maze[i][j]=sc.nextInt();
            }
        }
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }

        System.out.println(mazeTraversal(maze,0,0,dp));
    }

}
