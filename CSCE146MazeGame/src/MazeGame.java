//RJ Allen
import java.util.Random;

public class MazeGame 
{
	public static final int MAZE_SIZE = 10;
	public static final int OBST_AMT = (MAZE_SIZE*MAZE_SIZE)/10;
	
	private char[][] maze;//index 0 = y, index 1 = x
	private static final char EMPTY = '_';
	private static final char PLAYER = 'O';
	private static final char PATH = '#';
	private static final char OBST = 'X';
	
	public static final String NORTH = "Go North";
	public static final String SOUTH = "Go South";
	public static final String EAST = "Go East";
	public static final String WEST = "Go West";
	public static final String BACK = "Go Back";
	
	private StackI<int[]> locations;//index 0 = y, index 1 = x
	private int[] currLoc;////index 0 = y, index 1 = x
	
	public MazeGame()
	{
		init();
	}
	
	private void init()
	{
		maze = new char[MAZE_SIZE][MAZE_SIZE];
		for(int i=0;i<maze.length;i++)
			for(int j=0;j<maze[i].length;j++)
				maze[i][j] = EMPTY;
		this.addObstacles();
		maze[0][0]= PLAYER;
		currLoc = new int[] {0,0};
		locations = new LLStack<int[]>();
		
	}
	private void addObstacles()
	{
		Random r = new Random();
		for(int i=0;i<OBST_AMT;i++)
		{
			int x = r.nextInt(MAZE_SIZE);
			int y = r.nextInt(MAZE_SIZE);
			if(maze[y][x] != EMPTY || 
					(x==0 && y==0) || 
					(x==MAZE_SIZE-1&&y==MAZE_SIZE-1))
				continue;
			maze[y][x] = OBST;
		}
	}
	public void printFullMaze()
	{
		for(int i=0;i<maze.length;i++)
		{
			for(int j=0;j<maze[i].length;j++)
			{
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}
	}
}
