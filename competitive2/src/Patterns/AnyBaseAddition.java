package Patterns;

import java.util.Scanner;

public class AnyBaseAddition {
    static Scanner sc = new Scanner(System.in);

    public static int add(int num1,int num2 ,int base) {

        int carry=0;
        int counter=0;
        int actual_number=0;
        while(num1!=0||num2!=0||carry>0){
            int a=num1%10;
            int b=num2%10;
            num1=num1/10;
            num2=num2/10;
            int sumExtract=a+b;
            if(sumExtract+carry>base-1){
                sumExtract+=carry;
                actual_number+=(sumExtract%base)*(int)Math.pow(10,counter);
                carry=sumExtract/base;


            }else {
                actual_number+=(sumExtract+carry)*(int)Math.pow(10,counter);
                carry=0;
            }
            counter++;
        }

        return actual_number;
    }

    public static void subtract(int num1,int num2, int base){

        int counter=0;
        int actual_number=0;
        while(num1!=0||num2!=0) {
            int a = num1 % 10;
            int b = num2 % 10;
            num1 = num1 / 10;
            num2 = num2 / 10;
            if(a<b){
                num1-=1;
                a+=8;
            }

            actual_number+=(a-b)*(int)Math.pow(10,counter);
            counter++;

        }
        System.out.println(actual_number);
    }


   static int multiply(int num1,int num2,int base){
        int result=0;
        int counter=0;
        while(num2!=0) {
            int extr2 = num2 % 10;
            num2 /= 10;
            result = add(result, multiply_util(num1, extr2, base) * (int) Math.pow(10, counter), base);
        }
        return  result;
    }

     static int multiply_util(int num1, int extr2,int base) {
        int carry=0;
        int counter=0;
        int actual_value=0;
        int product;
        while(num1!=0||carry!=0){
            int extr1=num1%10;
            num1/=10;
            product=add(extr1*extr2,carry,base);
            actual_value+=(product%base)*(int)Math.pow(10,counter);
            carry=product/base;
            counter++;
        }

        return actual_value;
    }




    public static void main(String[] args) {
       System.out.println(
               AnyBaseConverter.convert((AnyBaseConverter.convert(177,8,10)
                       *AnyBaseConverter.convert(7,8,10)),10,8)
       );

    }

}
