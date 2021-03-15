package DynamicP;

import java.util.Arrays;
import java.util.Scanner;

public class GoldMine {
    static Scanner sc = new Scanner(System.in);

    public static int goldDigger(int[][] maze, int row, int column, int[][] dp) {

        if (row < 0 || column == maze[0].length || row == maze.length) {
            return 0;
        }

        if(column==maze[0].length-1){
            dp[row][column]=maze[row][column];
            return dp[row][column];
        }

        if(dp[row][column]!=-1){
            return dp[row][column];
        }

        int maxGold = Integer.MIN_VALUE;

            dp[row][column]= maze[row][column] +
                    Math.max(
                    Math.max(
                            goldDigger(maze, row - 1, column + 1, dp),
                            goldDigger(maze, row, column + 1, dp)
                    ),
                    goldDigger(maze, row + 1, column + 1, dp)
                    );


        return dp[row][column];

    }

    public static void main(String[] args) {
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] maze = new int[rows][cols];
        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }


        int maxGold=Integer.MIN_VALUE;
        for(int i=0;i<maze.length;i++){


          int goldFound=  goldDigger(maze,i,0,dp);

          if(goldFound>maxGold){
              maxGold=goldFound;
          }

        }

        System.out.println(maxGold);

    }

}
