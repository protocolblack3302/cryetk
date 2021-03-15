package Recursive;

import java.util.Scanner;

public class PrintKPC {
    static Scanner sc = new Scanner(System.in);
    static String[] keypadList=new String[]{".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

    public static void printkpc(String typed,String answer) {
        if(typed.length()==0){
            System.out.println(answer);
            return;
        }
        String code=keypadList[Character.getNumericValue(typed.charAt(0))];
        String restQuestion=typed.substring(1);
        for(int i=0;i<code.length();i++){
            char currentLetter=code.charAt(i);
            printkpc(restQuestion,answer+currentLetter);
        }

    }

    public static void main(String[] args) {
printkpc("78","");
    }

}
