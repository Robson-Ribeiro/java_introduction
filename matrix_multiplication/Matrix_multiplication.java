package matrix_multiplication;

import java.util.Scanner;

public class Matrix_multiplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numLinhasMatriz1, numColunasMatriz1, numLinhasMatriz2, numColunasMatriz2;
		
		System.out.println("Informe a quantidade de linhas da primeira matriz: ");
		numLinhasMatriz1 = sc.nextInt();
		
		System.out.println("\nInforme a quantidade de colunas da primeira matriz: ");
		numColunasMatriz1 = sc.nextInt();
		
		System.out.println("\nInforme a quantidade de linhas da segunda matriz: ");
		numLinhasMatriz2 = sc.nextInt();
		
		System.out.println("\nInforme a quantidade de colunas da segunda matriz: ");
		numColunasMatriz2 = sc.nextInt();
		
		if(numColunasMatriz1 != numLinhasMatriz2) {
			System.out.println("Não é possível realizar a operação de multiplicação entre as matrizes, haja vista que o número de colunas da primeira difere do número de linhas da segunda.");
			return;
		}
		
		
		System.out.println(" \n ------------------------------------ \n ");
		
		double[][] matriz1 = new double[numLinhasMatriz1][numColunasMatriz1];
		double[][] matriz2 = new double[numLinhasMatriz2][numColunasMatriz2];
		
		for(int i = 0; i < numLinhasMatriz1; i++) {
			for(int j = 0; j < numColunasMatriz1; j++) {
				System.out.println("\nPara a primeira matriz, informe o valor contido na linha " + (i + 1) + " coluna " + (j + 1) + ":");
				matriz1[i][j] = sc.nextDouble();
			}
		}
		
		System.out.println(" \n ------------------------------------ \n ");
		
		for(int i = 0; i < numLinhasMatriz2; i++) {
			for(int j = 0; j < numColunasMatriz2; j++) {
				System.out.println("\nPara a segunda matriz, informe o valor contido na linha " + (i + 1) + " coluna " + (j + 1) + ":");
				matriz2[i][j] = sc.nextDouble();
			}
		}
		
		System.out.println(" \n ------------------------------------ \n ");
		System.out.println(" Resultado:  \n ");
		
		double[][] resultado = new double[numLinhasMatriz1][numColunasMatriz2];
		
		for(int i = 0; i < numLinhasMatriz1; i++) {
			for(int j = 0; j < numColunasMatriz2; j++) {
				resultado[i][j] = singleResultElement(getLine(matriz1, i), getColumn(matriz2, j));
			}
		}
		
		printMatriz(matriz1);
		System.out.println("     X \n");
		printMatriz(matriz2);
		System.out.println("    ||\n");
		printMatriz(resultado);
	}
	
	public static double[] getLine(double[][] matriz, int linha) {
		double[] vetor = new double[matriz[0].length];
		for(int i = 0; i < matriz[0].length; i++ ) {
			vetor[i] = matriz[linha][i]; 
		}
		return vetor;
	}
	
	public static double[] getColumn(double[][] matriz, int coluna) {
		double[] vetor = new double[matriz.length];
		for(int i = 0; i < matriz.length; i++ ) {
			vetor[i] = matriz[i][coluna]; 
		}
		return vetor;
	}
	
	public static double singleResultElement(double[] linha, double[] coluna) {
		double result = 0;
		
		for(int i = 0; i < linha.length; i++) {
			result += linha[i] * coluna[i];
		}
		
		return result;
	}
	
	public static void printMatriz (double[][] matriz) {
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[0].length; j++) {
				System.out.print(" " + matriz[i][j] + " ");
			}
			System.out.println(" \n ");
		}
	}
}





























