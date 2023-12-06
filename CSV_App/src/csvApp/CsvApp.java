package csvApp;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
* Classe voltada para realizar a manipulação de arquivo CSV, sendo possível visualizar, inserir ou apagar o conteúdo do arquivo.
* @author Robson Ribeiro
* @version 1.0
* @see <a href="https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javadoc.html">Veja a documentação do javaDOC!</a>
*/


public class CsvApp {
	
	/**
     * Método estático utilizado para iniciar o programa.
     * @param args  Recebe um array de strings. São os argumentos da command line.
     */
	
	public static void main(String[] args) {
		int option;
		String filePath = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Seja bem vindo! Informe o caminho e nome do arquivo CSV: ");
		File log = null;
		
		do {
			filePath = sc.nextLine();
			
			 log = new File(filePath);
			 if(log.exists()==false) {
				 System.out.println("\nCaminho/nome incorreto! Informe o caminho e o nome do arquivo novamente: ");
			 }
		} while(log.exists() == false);
		
		
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
					
					readFile(filePath);
					System.out.println("\nAperte Enter para continuar...");
					try {
						System.in.read();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
					
				case 2:

					String content;
					System.out.println("");
					System.out.println("Informe o código da doação: ");
					sc.nextLine();
					content = sc.nextLine();
					content += ",";
					System.out.println("Informe o nome do doador: ");
					content += sc.nextLine();
					content += ",";
					System.out.println("Informe o CPF do doador: ");
					content += sc.nextLine();
					content += ",";
					System.out.println("Informe a data de nascimento do doador: ");
					content += sc.nextLine();
					content += ",";
					System.out.println("Informe o tipo sanguíneo do doador: ");
					content += sc.nextLine();
					content += ",";
					System.out.println("Informe a quantidade em ml de sangue doado: ");
					content += sc.nextLine();
					writeLine(filePath, content);
					System.out.println("\nAperte Enter para continuar...");
					try {
						System.in.read();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
					
				case 3:
					
					String donationCode;
					System.out.println("\nInforme o código da doação que deseja deletar: ");
					donationCode = sc.next();
					deleteLine(filePath, donationCode);
					System.out.println("\nAperte Enter para continuar...");
					try {
						System.in.read();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
					
				case 9:
					break;
			}
		} while(option != 9);

		sc.close();
		System.out.println("\nAplicação finalizada!");
		return;
	}
	
	/**
     * Método estático responsável por apresentar o menu de opções para o usuário. Não possui parâmetro ou retorno.
     */
	
	public static void showMenu() {
		System.out.println("\nEssa aplicação oferece as seguintes opções: ");
		System.out.println("1 - Efetuar a leitura do arquivo e apresentar na tela o seu conteúdo. ");
		System.out.println("2 - Efetuar a inserção de uma nova doação. ");
		System.out.println("3 - Efetuar a deleção de linhas do arquivo de acordo com o código da doação especificado. ");
		System.out.println("9 - Sair. ");
		System.out.println("\nDigite o número correspondente a sua opção: ");
	}
	
	/**
     * Método estático responsável por ler um arquivo CSV e apresentar seu conteúdo para o usuário. Não possui retorno.
     * @param path Representa o caminho para acessar o arquivo. É do tipo String.
     */
	
	public static void readFile(String path) {
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
	
	/**
     * Método estático responsável por escrever uma linha no arquivo CSV. Não possui retorno.
     * @param path Informa o caminho para acessar o arquivo. É do tipo String.
     * @param line Informa a linha que será adicionada no arquivo. É do tipo String.
     */
	
	public static void writeLine(String path, String line) {
		try(PrintWriter writer = new PrintWriter(new FileWriter(path, true))) {
			writer.println(line);
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	/**
     * Método estático responsável por apagar uma linha no arquivo CSV. Não possui retorno.
     * @param path Informa o caminho para acessar o arquivo. É do tipo String.
     * @param code Informa o código da linha que deverá ser deletada. É do tipo String.
     */
	
	public static void deleteLine(String path, String code) {
		ArrayList<String> fileLines = new ArrayList<>();
		ArrayList<String> deletedLines = new ArrayList<>();
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {
				if(code.intern() != line.split(",")[0].intern()) {
					fileLines.add(line);
				} else {
					deletedLines.add(line);
				}
				
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		try(PrintWriter writer = new PrintWriter(new FileWriter(path))) {
			for(String fileLine : fileLines) {
				writer.println(fileLine);
			}
			System.out.println("\nProcesso Finalizado!!!");
			if(deletedLines.isEmpty()) {
				System.out.println("Nenhuma linha apresentou o código de doação especificado.");
			} else {
				System.out.println("\nLinhas apagadas: ");
				for(String deletedLine : deletedLines) {
					System.out.println(deletedLine);
				}
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
}
