package Patterns;

import java.util.Scanner;

public class Pattern {
    static Scanner sc = new Scanner(System.in);

    public static void fun() {

    }

    public static void main(String[] args) {
int num= sc.nextInt();
for(int i=5;i>=1;i--){
    for(int j=i;j>=1;j--) {
        System.out.print('*');
    }
    System.out.println();
}
    }

}
