package others;

import java.util.Scanner;

public class DecInc {
    static Scanner sc = new Scanner(System.in);

    public static void dec(int n) {
if(n==0)
    return;
System.out.println(n);
dec(n-1);
inc(n);
    }
    public static void inc(int n){
        System.out.println(n);
    }
    public static void main(String[] args) {
                dec(5);
    }

}
