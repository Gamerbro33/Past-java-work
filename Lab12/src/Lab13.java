//RJ Allen
import java.util.Scanner;

public class Lab13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key = new Scanner(System.in);
		
		System.out.println("Enter the rows of matrix 1: ");
		
		int mat1_rows = key.nextInt();
		
		System.out.println("Enter the columns of matrix 1:");
		
		int mat1_cols = key.nextInt();
		
		System.out.println("Enter the rows of matrix 2:");
		int mat2_rows = key.nextInt();
		
		
		System.out.println("Enter the cols of matrix 2:");		
		int mat2_cols = key.nextInt();
	    //if 
		if(mat1_cols != mat2_cols || mat1_rows != mat2_rows)
		{
			System.out.println("Cannot subtract these matrices, dimension mismatch!");
			System.exit(0);
		}
		int[][] matrix1 = new int[mat1_rows][mat1_cols];
		int[][] matrix2 = new int[mat2_rows][mat2_cols];
		
		//populate the matrices
		for(int i=0; i<mat1_rows; i++)
		{
			for(int j = 0; j < mat1_cols; j++)
			{
				System.out.println("Enter the matrix value at position("+i+", "+j+"):");
				
				matrix1[i][j] =key.nextInt();
			}
		}
		
		for(int i=0; i < mat2_rows; i++)
		{
			for(int j = 0; j < mat2_cols; j++)
			{
				System.out.println("Enter the matrix value at position("+i+", "+j+"):");
				
				matrix2[i][j] = key.nextInt();
			}
		}
		int sum = 0;
		int[][] subtractMatrix = new int[mat1_rows][mat2_cols];
		
		//Subtracting the 2 matrices
		
		for(int i = 0; i < mat1_rows; i++)
		{
			for(int j = 0; j < mat2_cols; j++)
			{
				
					sum += matrix1[i][j] - matrix2[i][j];
					subtractMatrix[i][j] = sum;
				sum = 0;
			}
			
		}
		
		for(int i = 0; i < mat1_rows; i++)
		{
			for(int j = 0; j < mat1_cols; j++)
			{
				System.out.print(matrix1[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("-");
		for(int i = 0; i < mat2_rows; i++)
		{
			for(int j = 0; j < mat2_cols; j++)
			{
				System.out.print(matrix2[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("=");
		for(int i = 0; i < mat1_rows; i++)
		{
			for(int j = 0; j < mat2_cols; j++)
			{
				System.out.print(subtractMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}


