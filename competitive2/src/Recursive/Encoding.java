package Recursive;
import java.util.Scanner;

public class Encoding{
		static Scanner sc= new Scanner(System.in);

		static char mapIt(int alpabetNumber){
			alpabetNumber+=96;
			return (char) alpabetNumber;
		}

		static void function(String question , String answer){

			if(question.length()==0){
				System.out.println(answer);
				return;
			}

			int singleNumber=Character.getNumericValue(question.charAt(0));
			int doubleNumber = 0;
			if(question.length()>=2){
			doubleNumber=Integer.parseInt(question.substring(0,2));
			}
			if(singleNumber!=0){
				function(question.substring(1),answer+mapIt(singleNumber));
			}
			if(doubleNumber<=26 && doubleNumber/10!=0){
				function(question.substring(2),answer+mapIt(doubleNumber));

			}

		}



	public static void main(String[] args){

		function(sc.next(),"");

	}
}