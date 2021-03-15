package others;

import java.util.Arrays;

import java.util.Scanner;

import java.util.stream.IntStream;

public class BenjaminBulbs {
    static Scanner sc = new Scanner(System.in);

    public static void fun() {

    }

    public static void main(String[] args) {
int fluctations=sc.nextInt();
int[] bulbs =new int[fluctations+1];
Arrays.fill(bulbs,0);
for(int i=1;i<=fluctations;i++){
    if(i==1){
        Arrays.fill(bulbs,1);
    }else{
        int counter=i;
        while(counter<=fluctations){
            toggle(bulbs,counter);
            counter*=counter;
        }
    }
}


IntStream.range(1,bulbs.length)
        .filter(i->bulbs[i]==1)
        .boxed()
        .forEach(System.out::println);
    }

    private static void toggle(int[] bulbs, int counter) {
if(bulbs[counter]==0){
    bulbs[counter]=1;
}else {
    bulbs[counter]=0;
}
    }


}
