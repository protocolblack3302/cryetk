package Patterns;

import java.util.Scanner;

public class AnyBaseConverter {
    static Scanner sc = new Scanner(System.in);

    public  static int convert(int num1,int base_a ,int base_b) {
        int counter=0;
        int actual_value=0;
while(num1!=0){
    int extr=num1%base_b;
    num1/=base_b;
    actual_value+=extr*(int)Math.pow(base_a,counter);
    counter++;
}
        return actual_value;

    }

    public static void main(String[] args) {
        int num=sc.nextInt();
        int base_a=sc.nextInt();
        int base_b=sc.nextInt();
System.out.println(convert(num,base_a,base_b));
    }

}
