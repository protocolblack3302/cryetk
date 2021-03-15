package Patterns;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class BarChart {
    static Scanner sc = new Scanner(System.in);

    public static void fun() {

    }

    public static void main(String[] args) {
int numbers=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();
while(numbers!=0){
    arr.add(sc.nextInt());
    numbers--;
}

Optional<Integer> max__ =arr.stream().reduce(Integer::max);
int max= max__.get();

for(int i=0;i<max;i++){
    for(int j=0;j<arr.size();j++){
        if(max- arr.get(j) <=i){
            System.out.print('*');
        }else {
            System.out.print(" ");
        }
    }
    System.out.println();
}

    }

}
