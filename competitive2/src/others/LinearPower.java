package others;

import java.util.Scanner;

public class LinearPower {
    static Scanner sc = new Scanner(System.in);

    public static int fun(int x,int n) {
        if(n==0)
            return 1;
        return x*fun(x,--n);

    }

    public static void main(String[] args) {
        System.out.println(fun(sc.nextInt(),sc.nextInt()));

    }

}
