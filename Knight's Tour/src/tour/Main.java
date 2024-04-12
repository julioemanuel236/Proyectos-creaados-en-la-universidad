package tour;
import java.util.Scanner;

public class Main {
	
	static int[][] board = new int[8][8];

	
	static int cont = 1;
	static int solutions;
	
	public static void main(String[] args) {
		Scanner entry = new Scanner(System.in);
		while(solutions<1) {
			System.out.println("How many solutions you want to see (1-100): ");
			solutions = entry.nextInt();			
		}
		recursiveKnightTour(board, 0, 0, 1);
	}
	
	
	public static void recursiveKnightTour(int[][] board,int x,int y,int step) {
		if(!canGo(x,y,board,8))return;
		if(cont > solutions) return;
		board[x][y] = step;
		
		if(step == 64) {
			display(board);			
			board[x][y] = 0;
			return;		
		}
		
		
		recursiveKnightTour(board,x-2,y+1,step+1);//move 1
		recursiveKnightTour(board,x-1,y+2,step+1);//move 2		
		recursiveKnightTour(board,x+1,y+2,step+1);//move 3
		recursiveKnightTour(board,x+2,y+1,step+1);//move 4
		recursiveKnightTour(board,x+2,y-1,step+1);//move 5
		recursiveKnightTour(board,x+1,y-2,step+1);//move 6
		recursiveKnightTour(board,x-1,y-2,step+1);//move 7
		recursiveKnightTour(board,x-2,y-1,step+1);//move 8
		
		
		board[x][y] = 0;
		
		
	}
	
	public static void display(int[][] board) {
		System.out.println("Solution "+cont);
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				System.out.print(String.format("%4d", board[i][j])+" ");
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("");
		cont++;
	}
	
	public static boolean isIn(int x,int y,int size) {
		return x>=0&&x<size&&y>=0&&y<size;
	}
	
	public static boolean canGo(int x,int y,int[][]board,int size) {
		return isIn(x,y,size) && board[x][y] == 0;
	}
}