package main;

import java.util.NoSuchElementException;

// Importações da própria aplicação. 
import interaction.Entrada;
import system.Sistema;

/**
 * Classe de inicialização do sistema de cadastros de Pessoa/Aluno.
 * 
 * @author Henrik
 * @version HKC (Ant.1.0)
 */
public class Principal {
	

	public static void main(String[] args) {
		
		// Variável para guardar a operação que o usuário deseja realizar.
		int opt = 0;
		
		// Variável para armazenar os id´s dos cadastros.
		int id = 1;
		
		Sistema.Cabecalho();
		
		while(opt != 5) {
			
			try {
				
				System.out.println("\n***************************************");
				System.out.println("*     INFORME A OPERAÇÃO DESEJADA     *");
				System.out.println("***************************************");
				System.out.println("*            1 - Cadastrar            *");
				System.out.println("*            2 - Atualizar            *");
				System.out.println("*            3 - Listar               *");
				System.out.println("*            4 - Deletar              *");
				System.out.println("*            5 - Encerrar             *");
				System.out.println("***************************************\n");
				
				// Leitura da operação.
				System.out.print("-> ");
				opt = Entrada.lerInt();
				
				// Efetuar a operação desejada pelo usuário.
				switch(opt) {
				
				case 1: 
					Sistema.Cadastrar(id);
					id++;
					break;
					
				case 2: 
					Sistema.Atualizar();
					break;
					
				case 3: 
					Sistema.Listar();
					break;
					
				case 4: 
					Sistema.Deletar();
					break;
					
				case 5: 
					System.out.println("\nAplicação encerrada com sucesso!");
					break;
					
				default: 
					System.out.println("\nOperação inválida!");
				}
				
			// Tratamento de Exceções.
			} catch(NumberFormatException e) {
				
				System.out.println("\nTipo de dado inserido inválido!");
				System.out.println("Redirecionando para o menu principal...\n"); 
				
			} catch(NoSuchElementException e) {
				
				System.out.println("\n\nAplicação encerrada durante a leitura de dados!");
				break;
			}	
		}	
	}	
}
