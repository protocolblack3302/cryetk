package Recursive;

import java.util.Scanner;

public class Subsequence {
    static Scanner sc = new Scanner(System.in);

    public static void printSS(String ques,String ans) {

        if(ques.length()==0){
            System.out.println(ans);
            return;
        }

        char c=ques.charAt(0);
        String restQuestion=ques.substring(1);
        printSS(restQuestion,ans+c);
        printSS(restQuestion,ans+"");

    }

    public static void main(String[] args) {
printSS(sc.next(),"");
    }

}
