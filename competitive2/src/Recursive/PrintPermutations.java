package Recursive;

import java.util.Scanner;

public class PrintPermutations {
    static Scanner sc = new Scanner(System.in);

    public static void printPermutations( String question , String answer) {

        if(question.length()==0){
            System.out.println(answer);
            return;
        }

        for(int i=0;i<question.length();i++){
            char currentCharacter=question.charAt(i);
            String leftString=question.substring(0,i);
            String rightString=question.substring(i+1);
            String wholeString =leftString+rightString; //char i deleted
            printPermutations(wholeString,answer+currentCharacter);

        }
    }

    public static void main(String[] args) {

        printPermutations(sc.next(),"");

    }

}
