package others;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Pythagoras {
    static Scanner sc = new Scanner(System.in);

    public static void fun() {

    }

    public static void main(String[] args) {

        int a= sc.nextInt();
        int b =sc.nextInt();
        int c= sc.nextInt();
        List<Integer> arr=Arrays.asList(a,b,c);
        Optional<Integer> maximum=arr.stream()
                .reduce(Integer::max);

      System.out.println(arr.stream().filter(i->i<maximum.get())
                .map(i->i*i)
                .reduce(0, Integer::sum)
                .equals((int)Math.pow(maximum.get(), 2)));


    }

}
