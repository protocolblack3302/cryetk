package others;

import java.util.Scanner;
import java.util.Stack;

public class PrimeFactor {
    static Scanner sc = new Scanner(System.in);

    public static void fun() {

    }

    public static void main(String[] args) {
        int num=sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        int i=2;
        while(num!=1){
            if(num%i==0){
                num=num/i;
                stack.push(i);
            }else{
                i++;
            }
        }

        stack.forEach(System.out::println);
    }

}
