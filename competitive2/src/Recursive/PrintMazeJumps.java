package Recursive;

import java.util.Scanner;

public class PrintMazeJumps {
    static Scanner sc = new Scanner(System.in);

    public static void printMazeJumps(int sourceRow,int sourceCol,int destinationRow,int destinationCol,String path) {

        if(sourceRow==destinationRow && sourceCol==destinationCol){
            System.out.println(path);
            return;
        }

        for(int moves=1;moves<=destinationCol-sourceCol;moves++){
            printMazeJumps(sourceRow,sourceCol+moves,destinationRow,destinationCol,path+"h"+moves);
        }

        for(int moves=1;moves<=destinationRow-sourceRow;moves++){
            printMazeJumps(sourceRow+moves,sourceCol,destinationRow,destinationCol,path+"v"+moves);
        }

        for(int moves=1;moves<=destinationCol-sourceCol && moves<=destinationRow-sourceRow;moves++){
            printMazeJumps(sourceRow+moves,sourceCol+moves,destinationRow,destinationCol,path+"d"+moves);
        }
    }

    public static void main(String[] args) {
printMazeJumps(1,1,3,3,"");
    }

}
