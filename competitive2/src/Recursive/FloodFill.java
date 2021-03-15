package Recursive;
import java.util.Scanner;

public class FloodFill{


static Scanner sc = new Scanner(System.in);
static boolean[][] visited;

	public static void floodFill(int[][] maze, int row , int column , String path ){

		if(row<0||column<0|| row>maze.length-1 || column>maze[0].length-1 || maze[row][column]==1 || visited[row][column]==true){
			return;
		}
		if(row==maze.length-1 && column==maze[0].length-1){
			System.out.println(path);
			return;
		}

		visited[row][column]=true;
		floodFill(maze,row-1,column,path+"t");
		floodFill(maze,row,column-1,path+"l");
		floodFill(maze,row+1,column,path+"d");
		floodFill(maze,row,column+1,path+"r");
		visited[row][column]=false;

	}

public static void main(String[] args){

System.out.print("enter the size of the maze : ");
int row=sc.nextInt();
int column=sc.nextInt();

int[][] maze =new int[row][column];

for(int i=0;i<maze.length;i++){
	for(int j=0;j<maze[0].length;j++){
		maze[i][j]=sc.nextInt();
	}
}
visited=new boolean[row][column];

floodFill(maze,0,0,"");

}
}