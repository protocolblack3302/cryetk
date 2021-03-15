package others;

import java.util.Scanner;

public class Binary_to_anything {
    static Scanner sc = new Scanner(System.in);

    public static void fun() {

    }

    public static void main(String[] args) {
int number =sc.nextInt();
int base= sc.nextInt();
int counter=0;
int rem=0;
int temp=0;
        while (number != 0) {
             rem=number%base;
             number/=base;
             temp+=rem*(int)Math.pow(10,counter);
             counter++;
        }
        System.out.println(temp);
    }

}
