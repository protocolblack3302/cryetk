package DynamicP;
import java.util.Scanner;

public class FractionalKnappSack {

	static Scanner sc=new Scanner(System.in);
	static double nextMaxPriceByWeight =-1;
	static int nextMaxPriceByWeightIndex =-1;
	static double maxProfit =0;

public static double fractionalKnappSack(int sackCapacity , int items , int[] weight , double[] price , double[] priceByWeight) {
	for(int i=0; i<items; i++){
			findNextPriceByWeight(priceByWeight);
			if(sackCapacity>=weight[nextMaxPriceByWeightIndex]){
				maxProfit+=price[nextMaxPriceByWeightIndex];
				sackCapacity-=weight[nextMaxPriceByWeightIndex];
				if(sackCapacity==0){
					break;
				}
			}else if(sackCapacity<weight[nextMaxPriceByWeightIndex]) {
				maxProfit+=sackCapacity* nextMaxPriceByWeight;
				break;
			}
		nextMaxPriceByWeight =-1;
		nextMaxPriceByWeightIndex =-1;
	}
	return maxProfit;

}

	static void findNextPriceByWeight(double[] priceByWeight){
		for(int i=0;i<priceByWeight.length;i++){
			if(priceByWeight[i]> nextMaxPriceByWeight){
				nextMaxPriceByWeight =priceByWeight[i];
				nextMaxPriceByWeightIndex =i;
			}
		}
		priceByWeight[nextMaxPriceByWeightIndex]=-1;
	}

	public static void main(String[] args) {
		int items = sc.nextInt();

		double[] price = new double[items];
		int[] weight = new int[items];
		double[] priceByWeight= new double[items];

		for(int i = 0; i < items; i++){
			price[i]=sc.nextInt();
			priceByWeight[i]=price[i]/weight[i];
		}
		for(int i = 0; i < items; i++){
			weight[i]=sc.nextInt();
		}

		for(int i = 0; i < items; i++){
			priceByWeight[i]=price[i]/weight[i];
		}
	
	int sackCapacity=sc.nextInt();
		System.out.println(
		fractionalKnappSack(sackCapacity,items,weight,price, priceByWeight)
);

	}

}