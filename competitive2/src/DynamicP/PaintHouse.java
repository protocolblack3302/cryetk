package DynamicP;

import java.util.Scanner;

public class PaintHouse {
    static Scanner sc = new Scanner(System.in);

    public static int paintHouse(int colors,int houses, int[][] prices , int[][] dp) {

        if (colors >= 0) System.arraycopy(prices[0], 0, dp[0], 0, colors);

        for(int i=1;i<houses;i++){
           for(int j=0;j<colors ;j++){
               int min=Integer.MAX_VALUE;
               for(int k=0;k<colors;k++){
                   if(dp[i-1][k]<min && k!=j){
                       min=dp[i-1][k];
                   }
               }
               dp[i][j]=min+prices[i][j];
           }
            }

        int min=Integer.MAX_VALUE;
        for(int i=0;i<colors;i++){
            if(dp[houses-1][i]<min){
                min=dp[houses-1][i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
            int houses = sc.nextInt();
            int colors = sc.nextInt();

            int[][] prices = new int[houses][colors];
            for(int i=0;i<houses;i++){
               for (int j=0;j<3;j++){
                   prices[i][j]=sc.nextInt();
               }
            }

            int[][] dp= new int[houses][colors];

            System.out.println(paintHouse(colors,houses,prices, dp));
    }

}
