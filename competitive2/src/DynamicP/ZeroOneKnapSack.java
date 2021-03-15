package DynamicP;

import java.util.Scanner;

public class ZeroOneKnapSack {

    static Scanner sc = new Scanner(System.in);

    public static int maxProfit(int[] objectWeights, int[] objectProfits, int[][] dp, int sackWeight) {

        for (int i = 1; i <dp.length; i++) {
            for (int j = objectWeights[i]; j <=sackWeight; j++) {
                if (j >= objectWeights[i]) {
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            dp[i - 1][j - objectWeights[i]] + objectProfits[i]
                    );
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];

    }

    public static void main(String[] args) {

        int totalObjects = sc.nextInt();
        int[] objectWeights = new int[totalObjects + 1];
        int[] objectProfits = new int[totalObjects + 1];

        for (int i = 1; i < objectWeights.length; i++) {
            objectProfits[i] = sc.nextInt();
        }
        for (int i = 1; i < objectWeights.length; i++) {

            objectWeights[i] = sc.nextInt();
        }
        int sackWeight = sc.nextInt();
        int[][] dp = new int[totalObjects + 1][sackWeight + 1];
        System.out.println(maxProfit(objectWeights, objectProfits, dp, sackWeight));

    }


}