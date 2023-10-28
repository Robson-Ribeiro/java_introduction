package matrix_multiplication;

import java.util.Scanner;

public class Matrix_multiplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numLinesMatrix1, numColumnsMatrix1, numLinesMatrix2, numColumnsMatrix2;
		
		System.out.println("Informe a quantidade de linhas da primeira matriz: ");
		numLinesMatrix1 = sc.nextInt();
		
		System.out.println("\nInforme a quantidade de colunas da primeira matriz: ");
		numColumnsMatrix1 = sc.nextInt();
		
		System.out.println("\nInforme a quantidade de linhas da segunda matriz: ");
		numLinesMatrix2 = sc.nextInt();
		
		System.out.println("\nInforme a quantidade de colunas da segunda matriz: ");
		numColumnsMatrix2 = sc.nextInt();
		
		if(numColumnsMatrix1 != numLinesMatrix2) {
			System.out.println("Não é possível realizar a operação de multiplicação entre as matrizes, haja vista que o número de colunas da primeira difere do número de linhas da segunda.");
			return;
		}
		
		
		System.out.println(" \n ------------------------------------ \n ");
		
		double[][] matrix1 = new double[numLinesMatrix1][numColumnsMatrix1];
		double[][] matrix2 = new double[numLinesMatrix2][numColumnsMatrix2];
		
		for(int i = 0; i < numLinesMatrix1; i++) {
			for(int j = 0; j < numColumnsMatrix1; j++) {
				System.out.println("\nPara a primeira matriz, informe o valor contido na linha " + (i + 1) + " coluna " + (j + 1) + ":");
				matrix1[i][j] = sc.nextDouble();
			}
		}
		
		System.out.println(" \n ------------------------------------ \n ");
		
		for(int i = 0; i < numLinesMatrix2; i++) {
			for(int j = 0; j < numColumnsMatrix2; j++) {
				System.out.println("\nPara a segunda matriz, informe o valor contido na linha " + (i + 1) + " coluna " + (j + 1) + ":");
				matrix2[i][j] = sc.nextDouble();
			}
		}
		
		System.out.println(" \n ------------------------------------ \n ");
		System.out.println(" Resultado:  \n ");
		
		double[][] result = new double[numLinesMatrix1][numColumnsMatrix2];
		
		for(int i = 0; i < numLinesMatrix1; i++) {
			for(int j = 0; j < numColumnsMatrix2; j++) {
				result[i][j] = singleResultElement(getLine(matrix1, i), getColumn(matrix2, j));
			}
		}
		
		printMatriz(matrix1);
		System.out.println("     X \n");
		printMatriz(matrix2);
		System.out.println("    ||\n");
		printMatriz(result);
	}
	
	public static double[] getLine(double[][] matrix, int line) {
		double[] vetor = new double[matrix[0].length];
		for(int i = 0; i < matrix[0].length; i++ ) {
			vetor[i] = matrix[line][i]; 
		}
		return vetor;
	}
	
	public static double[] getColumn(double[][] matrix, int column) {
		double[] vetor = new double[matrix.length];
		for(int i = 0; i < matrix.length; i++ ) {
			vetor[i] = matrix[i][column]; 
		}
		return vetor;
	}
	
	public static double singleResultElement(double[] line, double[] column) {
		double result = 0;
		
		for(int i = 0; i < line.length; i++) {
			result += line[i] * column[i];
		}
		
		return result;
	}
	
	public static void printMatriz (double[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				System.out.print(" " + matrix[i][j] + " ");
			}
			System.out.println(" \n ");
		}
	}
}





























