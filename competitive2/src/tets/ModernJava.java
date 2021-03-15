package tets;

import java.util.Arrays;

import java.util.OptionalInt;


public class ModernJava {


    public static void main(String[] args) {

int[] arr= new int[6];
arr[0]=5;
arr[1]=10;
arr[2]=16;
arr[3]=17;
arr[4]=18;
arr[5]=20;

      OptionalInt opt= Arrays.stream(arr).reduce(Integer::max);
      opt.ifPresent(System.out::println);

    }

}
