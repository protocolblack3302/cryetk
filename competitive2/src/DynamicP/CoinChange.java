package DynamicP;

import java.util.Scanner;

public class CoinChange {
    static Scanner sc = new Scanner(System.in);
    public static int coinChange(int[] coinArray,int target)  {


        int[] storage = new int[target+1];

        storage[0]=1;

        for (int k : coinArray) {
            for (int j = k; j < storage.length; j++) {
                storage[j] = storage[j] + storage[j - k];
            }
        }

        return storage[storage.length-1];


    }

    public static void main(String[] args) {

        int numberOfCoins=sc.nextInt();
        int[] coinArray = new int[numberOfCoins];
        for(int i=0;i<coinArray.length;i++){
            coinArray[i]=sc.nextInt();
        }

        System.out.println(coinChange(coinArray, sc.nextInt()));


    }

}
