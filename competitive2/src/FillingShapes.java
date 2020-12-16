import java.util.Scanner;
public class FillingShapes{
	static Scanner sc=new Scanner(System.in);


	public static void main(String[] args){
		int n=sc.nextInt();
		if(n<2){
		System.out.println(0);
		}else{
		if(n%2==0){
	 		System.out.println((int)Math.pow(2,(n/2)));
		}else{
		 System.out.println((0));
		}
		}
		
	}
}