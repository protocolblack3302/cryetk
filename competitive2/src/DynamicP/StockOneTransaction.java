package DynamicP;

import java.util.Scanner;

public class StockOneTransaction {
    static Scanner sc = new Scanner(System.in);

    public static void buyAndSell(int[] stockPrice) {
        int maxProfit = 0;
        int minStockPointYet = 0;

        for(int i=0;i<stockPrice.length;i++){
            if(stockPrice[i]<stockPrice[minStockPointYet]){
                minStockPointYet=i;
            }
            if(stockPrice[i]-stockPrice[minStockPointYet]>maxProfit){
                maxProfit=stockPrice[i]-stockPrice[minStockPointYet];
            }

        }
        System.out.println(maxProfit);
    }

    public static void main(String[] args) {
        int numberOfStock = sc.nextInt();
        int[] stockPrice = new int[numberOfStock];
        for(int i=0;i<numberOfStock;i++){
            stockPrice[i]=sc.nextInt();
        }

        buyAndSell(stockPrice);
    }

}
