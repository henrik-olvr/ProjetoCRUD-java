package main;

import java.util.NoSuchElementException;

// Importa��es da pr�pria aplica��o. 
import interaction.Entrada;
import system.Sistema;

/**
 * Classe de inicializa��o do sistema de cadastros de Pessoa/Aluno.
 * 
 * @author Henrik
 * @version HKC (Ant.1.0)
 */
public class Principal {
	

	public static void main(String[] args) {
		
		// Vari�vel para guardar a opera��o que o usu�rio deseja realizar.
		int opt = 0;
		
		// Vari�vel para armazenar os id�s dos cadastros.
		int id = 1;
		
		Sistema.Cabecalho();
		
		while(opt != 5) {
			
			try {
				
				System.out.println("\n***************************************");
				System.out.println("*     INFORME A OPERA��O DESEJADA     *");
				System.out.println("***************************************");
				System.out.println("*            1 - Cadastrar            *");
				System.out.println("*            2 - Atualizar            *");
				System.out.println("*            3 - Listar               *");
				System.out.println("*            4 - Deletar              *");
				System.out.println("*            5 - Encerrar             *");
				System.out.println("***************************************\n");
				
				// Leitura da opera��o.
				System.out.print("-> ");
				opt = Entrada.lerInt();
				
				// Efetuar a opera��o desejada pelo usu�rio.
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
					System.out.println("\nAplica��o encerrada com sucesso!");
					break;
					
				default: 
					System.out.println("\nOpera��o inv�lida!");
				}
				
			// Tratamento de Exce��es.
			} catch(NumberFormatException e) {
				
				System.out.println("\nTipo de dado inserido inv�lido!");
				System.out.println("Redirecionando para o menu principal...\n"); 
				
			} catch(NoSuchElementException e) {
				
				System.out.println("\n\nAplica��o encerrada durante a leitura de dados!");
				break;
			}	
		}	
	}	
}
