package csvApp;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvApp {
	// C:\\CSV\\doacoes.csv
	public static void main(String[] args) {
		int option;
		String filePath = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Seja bem vindo! Informe o caminho e nome do arquivo CSV: ");
		filePath = sc.nextLine();
		
		do {
			showMenu();
			do {
				option = sc.nextInt();
				if(option != 1 && option != 2 && option != 3 && option != 9) {
					System.out.println("\nOpção inválida! Informe um valor novamente: ");
				}
			} while(option != 1 && option != 2 && option != 3 && option != 9);
			
			switch(option) {
				case 1:
					
					read(filePath);
					System.out.println("\nAperte Enter para continuar...");
					try {
						System.in.read();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
					
				case 2:

					String content = "";
					System.out.println("");
					System.out.println("Informe o código da doação: ");
					content += sc.next();
					content += ",";
					System.out.println("Informe o nome do doador: ");
					content += sc.next();
					content += ",";
					System.out.println("Informe o CPF do doador: ");
					content += sc.next();
					content += ",";
					System.out.println("Informe a data de nascimento do doador: ");
					content += sc.next();
					content += ",";
					System.out.println("Informe o tipo sanguíneo do doador: ");
					content += sc.next();
					content += ",";
					System.out.println("Informe a quantidade em ml de sangue doado: ");
					content += sc.next();
					write(filePath, content);
					System.out.println("\nAperte Enter para continuar...");
					try {
						System.in.read();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
					
				case 3: 
					
					break;
					
				case 9:
					break;
			}
		} while(option != 9);

		System.out.println("\nAplicação finalizada!");
		return;
	}
	
	public static void showMenu() {
		System.out.println("\nEssa aplicação oferece as seguintes opções: ");
		System.out.println("1 - Efetuar a leitura do arquivo e apresentar na tela o seu conteúdo. ");
		System.out.println("2 - Efetuar a inserção de uma nova doação. ");
		System.out.println("3 - Efetuar a deleção de linhas do arquivo de acordo com o código da doação especificado. ");
		System.out.println("9 - Sair. ");
		System.out.println("\nDigite o número correspondente a sua opção: ");
	}
	
	public static void read(String path) {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			System.out.println("");
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} 
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	/*
	 File log = new File("log.txt");
	 if(log.exists()==false)
	 */
	
	public static void write(String path, String line) {
		try(PrintWriter writer = new PrintWriter(new FileWriter(path, true))) {
			writer.println(line);
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	
}
