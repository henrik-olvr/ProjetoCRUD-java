package interaction;

import java.util.Scanner;

/**
 * Classe para efetuar a leitura de dados que será fornecida pelo usuário.
 * 
 * @author Henrik
 */
public class Entrada {

	// Inicialização da classe Scanner para a leitura de dados.
	private static Scanner input = new Scanner(System.in);
	
	/** Método para a leitura de texto(String).
	 * 
	 * @return (String)
	 */ 
	public static String lerString() {
		
		String dado;
		
		dado = input.nextLine();
		
		return dado;
	}
	
	/** Método para a leitura específica do nome.
	 * 
	 * @return (String)
	 */
	public static String lerNome() {
		
		// Expressão regular para o nome.
		String nome = "^[A-Za-záàâãéèêíïóôõöúçñÀÂÃÉÈÓÔÕÖÚÇÑ ]{1,16}$";
		
		String dado = "";
		
		System.out.println("\nInforme o nome (máximo de 16 caracteres).");
		
		// Comparação entre o dado e o Regex.
		// Armazenamento do dado.
		dado = analisaDado(dado, nome, "Nome: ");
				
		return dado;
	}
	
	/** Método para a leitura específica do telefone.
	 * 
	 * @return (String)
	 */
	public static String lerTelefone() {
		
		// Expressão regular para o telefone.
		String tel = "0\\d{11}";
		
		String dado = "";
		
		System.out.println("\nInforme o Nro de telefone com 12 digitos (incluido o DDD com o zero na frente).");
		System.out.println("Ex: 051XXXXXXXXX");
		
		// Comparação entre o dado e o Regex.
		// Armazenamento do dado.
		dado = analisaDado(dado, tel, "Telefone: ");
				
		return dado;
	}
	
	/** Método para a leitura específica da data.
	 * 
	 * @return (String)
	 */
	public static String lerData() {
		
		// Expressão regular para a data.
		String data = "^((([1-9]|[12]\\d)\\/([1-9]|1[0-2])|30\\/(0[13-9]|1[0-2])|31\\/(0[13578]|1[02]))\\/\\d{4}$)|(((0[1-9]|[12]\\d)\\/(0[1-9]|1[0-2])|30\\/(0[13-9]|1[0-2])|31\\/(0[13578]|1[02]))\\/\\d{4}$)";
		String dado = "";
		
		System.out.println("\nInforme a data de nascimento (dd/mm/aaaa).");
		
		// Comparação entre o dado e o Regex.
		// Armazenamento do dado.
		dado = analisaDado(dado, data, "Data de nascimento: ");
		
		return dado;
	}
	
	/** Método para a leitura da nota(Float).
	 * 
	 * @return (Float)
	 */
	public static Float lerNota() {
		
		Float dado;
		
		do {
			// Leitura e armazenamento do dado.
			System.out.print("Nota: ");
			dado = Float.parseFloat(input.nextLine());
			
		} while(dado > 10);
		
		return dado;
	}
	
	/** Método para a leitura de um valor(int).
	 * 
	 * @return (int)
	 */
	public static int lerInt() {
		
		int dado;
		
		// Leitura do dado.
		dado = Integer.parseInt(input.nextLine());
		
		return dado;	
	}
	
	/** Método para efetuar a comparação entre um dado
	 *  e uma expressão regular(regex).
	 *  E imprimir um texto.
	 *  
	 * @return (String)
	 */
	public static String analisaDado(String dado, String rgx, String saida) {
		
		while(dado.matches(rgx) != true) {
			
			// Leitura e armazenamento do dado.
			System.out.print(saida);
			dado = input.nextLine();
		} 
		
		return dado;
	}
}
