import java.util.Scanner;

public class Lab12 {
	
	public int mat1_rows;
	public int mat2_rows;
	public int mat1_cols;
	public int mat2_cols;
	
	public int sum;
	//storing user input
		public void readInput()
		{
			Scanner key = new Scanner(System.in);
			System.out.println("Enter the rows of matrix 1: ");
			
			mat1_rows = key.nextInt();
			
			System.out.println("Enter the columns of matrix 1:");
			
			mat1_cols = key.nextInt();
			
			System.out.println("Enter the rows of matrix 2:");
			mat2_rows = key.nextInt();
			
			if(mat1_cols != mat2_rows)
			{
				System.out.println("Cannot subtract these matrices, dimension mismatch!");
				System.exit(0);
			}
			System.out.println("Enter the cols of matrix 2:");
			
			mat2_cols = key.nextInt();
			
			
			
			//populate the matrices
			for(int i=0; i<mat1_rows; i++)
			{
				for(int j = 0; j < mat1_cols; j++)
				{
					System.out.println("Enter the matrix value at postion("+i+", "+j+"):");
					
					matrix1[i][j] = key.nextInt();
				}
			}
			
			for(int i=0; i < mat2_rows; i++)
			{
				for(int j = 0; j < mat2_cols; j++)
				{
					System.out.println("Enter the matrix value at postion("+i+", "+j+"):");
					
					matrix2[i][j] = key.nextInt();
				}
			}
		
			
			
			
			
			
		}
		public int[][] matrix1 = new int[mat1_rows][mat1_cols];
	public int[][] matrix2 = new int[mat2_rows][mat2_cols];
	public int[][] productMatrix = new int[mat1_rows][mat2_cols];
		/*
		 * Pre-Condition: calling object contains values
		 * Post-condition: The value are displayed on the console of a particular matrix 
		 */
		public void writeOutPut()
		{
			//multiply the 2 matrices
			
			for(int i = 0; i < mat1_rows; i++)
			{
				for(int j = 0; j < mat2_cols; j++)
				{
					for(int k = 0; k < mat1_cols; k++)
					{
						sum += matrix1[i][k] * matrix2[k][j];
						
						
					}
					productMatrix[i][j] = sum;
					sum = 0;
				}
			}
			
			for(int i = 0; i < mat1_rows; i++)
			{
				for(int j = 0; j<mat2_cols; j++)
				{
					System.out.print(productMatrix[i][j]+" ");
				}
				System.out.println();
			}
		}
}
