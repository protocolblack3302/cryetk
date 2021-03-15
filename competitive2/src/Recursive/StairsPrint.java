package Recursive;

import java.util.Scanner;

public class StairsPrint {
    static Scanner sc = new Scanner(System.in);

    public static void printStairs(int stairs,String path) {

        if(stairs<0){
            return;
        }
        if(stairs==0){
            System.out.println(path);
            return;
        }

        printStairs(stairs-1,path+"1");
        printStairs(stairs-2,path+"2");
        printStairs(stairs-3,path+"3");


    }


    public static void main(String[] args) {
        printStairs(5,"");
    }

}
