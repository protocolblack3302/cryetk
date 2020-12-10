import java.util.Scanner;
import java.util.ArrayList;

public class NCS{
static Scanner sc;

public static void fun(){

ArrayList<Boolean> list = new ArrayList<>();
int string_length=sc.nextInt();
int queries_length=sc.nextInt();
sc.nextLine();
String s=sc.nextLine();

while(queries_length!=0){
	Boolean flag=false;
int i=sc.nextInt()-1;
int j=sc.nextInt()-1;
	for(int z=0;z<string_length;z++){
		if(z<i&&s.charAt(i)==s.charAt(z)){
			flag=true;
		}

		if(z>j&&s.charAt(z)==s.charAt(j)){
			flag=true;
		}
	}
list.add(flag);
queries_length--;
	}
for(Boolean b:list){
	if(b){
		System.out.println("YES");
	}else{
		System.out.println("NO");
	}
}
}

	public static void main(String[] args) {
		sc=new Scanner(System.in);
int cases=sc.nextInt();
while(cases!=0){
	fun();
	cases--;

	}
}
}