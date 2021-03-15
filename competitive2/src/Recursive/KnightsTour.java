package Recursive;
import java.io.IOException;
import java.util.Scanner;
public class KnightsTour {

static  int counter=0;


    public static void printKnightsTour(int[][] chessBoard ,int row , int col , int totalMoves ) {
        counter++;

        if(row<0 || col<0 || row >chessBoard.length -1 || col > chessBoard[0].length-1 || chessBoard[row][col]!=0){
            return;
        } else if(totalMoves== chessBoard.length*chessBoard.length){
            chessBoard[row][col]=totalMoves;
            for(int[] wholeRow : chessBoard){
                for ( int data :wholeRow){
                    System.out.print(data + " ");
                }
                System.out.println();
            }
            System.out.println();
            chessBoard[row][col]=0;

            return;
        }

        chessBoard[row][col]=totalMoves;
        printKnightsTour(chessBoard,row-2,col+1,totalMoves+1);
        printKnightsTour(chessBoard,row-1,col+2,totalMoves+1);
        printKnightsTour(chessBoard,row+1,col+2,totalMoves+1);
        printKnightsTour(chessBoard,row+2,col+1,totalMoves+1);
        printKnightsTour(chessBoard,row+2,col-1,totalMoves+1);
        printKnightsTour(chessBoard,row+1,col-2,totalMoves+1);
        printKnightsTour(chessBoard,row-1,col-2,totalMoves+1);
        printKnightsTour(chessBoard,row-2,col-1,totalMoves+1);

        chessBoard[row][col]=0;

    }

    public static void main(String[] args) throws IOException {
        Scanner sc= new Scanner(System.in);
        int boardSize=sc.nextInt();
        int[][] chessBoard =new int[boardSize][boardSize];

        printKnightsTour(chessBoard , sc.nextInt() ,sc.nextInt(),1);
System.out.println(counter);

    }
}
