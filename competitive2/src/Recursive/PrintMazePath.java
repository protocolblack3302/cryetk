package Recursive;

import java.util.Scanner;

public class PrintMazePath {
    static Scanner sc = new Scanner(System.in);

    public static void printMazePath(int sr,int sc,int dr,int dc,String path) {
        if(sr==dr&&sc==dc){
            System.out.println(path);
            return;
        }

        if(sr<dr){
            printMazePath(sr+1,sc,dr,dc,path+"v");
        }
        if(sc<dc) {
            printMazePath(sr, sc + 1, dr, dc, path + "h");
        }
    }

    public static void main(String[] args) {
        printMazePath(1,1,3,3,"");
    }

}
