import java.util.Scanner;
import java.util.ArrayList;

public class MakeProduct{
	static Scanner sc = new Scanner(System.in);
	static long money=0;
	static int even_odd=0;
	static int zero_even_odd=0;
	public static long fun(ArrayList<Integer> list){
		for(int i=0; i<list.size(); i++){

			if(list.get(i)<0){
				even_odd++;
			}else if(list.get(i)==0){
				zero_even_odd++;
			}
		}

		if(even_odd%2==0){
			even_odd=0;

		}
		else{
			even_odd=1;
		}

		if(zero_even_odd%2==0){
			zero_even_odd=0;

		}
		else{
			zero_even_odd=1;
		}

		for(int i=0;i<list.size();i++){
			if(list.get(i)<0){
				money+=Math.abs(-1-(list.get(i)));
				list.set(i,-1);
			}else if(list.get(i)>0){
			money+=Math.abs(1-(list.get(i)));
			list.set(i,1);
		}
}

if(list.contains(0)) {
	for (int i = 0; i < list.size(); i++) {
		if (list.get(i) == 0 && even_odd == 0) {
			money += 1;
			list.set(i, 1);
		} else if (list.get(i) == 0 && even_odd == 1 && zero_even_odd == 1) {
			money += 1;
			list.set(i, -1);
		} else if (list.get(i) == 0 && even_odd == 1 && zero_even_odd == 0) {
			money += 1;
			list.set(i, 1);
		}

	}
	return money;
}else if(even_odd==1 && !list.contains(0)){

		for(int i=0;i<list.size(); i++){
			if(list.get(i)<0){
				money+=2;
				list.set(i,1);
				return money;

			}
		}}else if(even_odd==0 && !list.contains(0)){
		return money;
	}


return money;
	}


	public static void main(String[] args){
		int numbers=sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		while(numbers!=0){
			list.add(sc.nextInt());
			numbers--;
		}

		System.out.println(fun(list));

	}
}