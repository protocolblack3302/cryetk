package DynamicP;

import java.util.Scanner;

public class GetStairs {
    static Scanner sc = new Scanner(System.in);

    public static int getStairs(int stairs , int[] dp) {

        if(stairs==0){
            return dp[0];
        }else if(stairs<0){
            return 0;
        }

        if(dp[stairs]>0){
            return dp[stairs];
        }

     dp[stairs] = getStairs(stairs-1,dp) +
        getStairs(stairs-2,dp) +
        getStairs(stairs-3,dp);

     return dp[stairs];
    }

    public static void main(String[] args) {
        int stairs=sc.nextInt();
        int[] dp =new int[stairs+1];
        dp[0]=1; //draw recursion tree and get to know why 0 and 1 both calls return 1;
        System.out.println(getStairs(stairs,dp));



    }

}
