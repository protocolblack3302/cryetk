package Recursive;

import java.util.Scanner;

public class NQueen {
    static Scanner sc = new Scanner(System.in);
    static int boardSize = sc.nextInt();
    static int[][] boardConfig = new int[boardSize][boardSize];

    public static void placeQueen(int row, int column) {
        boardConfig[row][column] = 1;
    }

    public static boolean isSafe(int row, int column) {
        boolean flag = true;
        //check rows of same column

        for (int i = 0; i < row; i++) {
            if (boardConfig[i][column] == 1) {
                flag = false;
                break;
            }
        }

        //right top diagonal

        for (int i = row - 1, j = column + 1; i >= 0 && j < boardSize; i--, j++) {
            if (boardConfig[i][j] == 1) {
                flag = false;
                break;
            }
        }

        //top left diagonal
        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
            if (boardConfig[i][j] == 1) {
                flag = false;
                break;
            }
        }

        return flag;

    }


    public static void printBoard() {
        for (int[] i : boardConfig) {
            for (int j : i) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void removeQueen(int row, int column) {
        boardConfig[row][column] = 0;
    }


    public static boolean solveIt(int rowNumber) {


        if (rowNumber == boardSize) {
            printBoard();
            return true;
        }

        for (int j = 0; j < boardSize; j++) {
            if (isSafe(rowNumber, j)) {
                placeQueen(rowNumber, j);

                boolean solveNext = solveIt(rowNumber + 1);
                if (solveNext) {
                    return true;
                }
                removeQueen(rowNumber, j);
            }
        }

        return false;

    }

    public static void main(String[] args) {
        solveIt(0);
    }

}
