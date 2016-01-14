import java.util.Random;
import java.util.Scanner;

public class Maze2 {

	public static void main(String[] args) {

		boolean check=false;
		int i=0; int j=0; int count =1; int counter =0;

		System.out.println("Enter how many rowSize for the maze.");
		Scanner keyboard = new Scanner(System.in);
		int rowSize = keyboard.nextInt();
		System.out.println("Enter how many columnSize for the maze.");
		int columnSize = keyboard.nextInt();
		int[][] maze = new int[rowSize][columnSize]; 
		mazeFill(maze,rowSize,columnSize);
		Random randomGenerator = new Random();
		int forwardMove = (int) ((5 * Math.random()) + 1);
		while(!((i==rowSize-1) && (j==columnSize-1))) 
		{
			forwardMove = (int) ((5 * Math.random()) + 1);
			switch(forwardMove){
			 case 1: i--; j++; 
			 break; // possible legal moves the mouse can take
			 case 2: j++; 
			 break;
			 case 3: i++; j++; 
			 break;
			 case 4: i++; 
			 break;
			 case 5: i++; j--; 
			 break;
			default: i=0; j=0; count =1; check=true; mazeFill(maze,rowSize,columnSize);
			break; 
			}
			if(!check)
			{
				if((i>=rowSize)||(j>=columnSize)||(i<0)||(j<0))
				{ 
					i=0;j=0;count=1;mazeFill(maze,rowSize,columnSize); 
				}
				else 
				{
					count++;maze[i][j] = count; 
				counter++;
				} 
			}
			check=false;
		}


		for( i = 0;i<maze.length;i++)	
		{
			for( j = 0; j<maze[i].length;j++)
			{  System.out.print(maze[i][j] + " ");

			}

			System.out.println(); 
			}
		System.out.println("The mouse has succeeded!");
		System.out.println("It took the mouse " + counter + " tries to find the solution.");
	}

	public static void mazeFill (int[][]array, int rowSize, int columnSize)
	{ 
		for (int i=0; i<rowSize; i++)
		{
			for(int j=0; j<columnSize; j++)
			{
				array[i][j]=0;
			}
			array[0][0]=1;
		}

	}
}
