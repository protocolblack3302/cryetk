/*

@author harsh chaudhary
fibonnaci using dynamic programming top bottom memoization


*/

import java.util.Scanner;  

public class fibonacci_dp{

static int[] arr;

public static int fibb(int n){
if(arr[n]!=-1){
	return arr[n];
}
if(n<=1){
	return 1;
}else{
	arr[n]=fibb(n-1)+fibb(n-2);
	return arr[n];
}

}


	public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
int number=sc.nextInt();
arr=new int[number+1];
int i=1;
while(i!=arr.length){
	arr[i]=-1;
	i++;
	}
System.out.println(fibb(number));
}

}