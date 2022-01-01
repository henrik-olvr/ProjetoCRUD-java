package interaction;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

//Importa��es da pr�pria aplica��o.
import data.Aluno;
import data.Pessoa;

/**
 * Classe para efetuar a impress�o da lista de dados cadastrados.
 * 
 * @author Henrik
 */
public class Saida {
	
	// Formatos espec�ficos de alguns dados para a impress�o.
	private static DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static DateFormat fmtNasc = new SimpleDateFormat("dd/MM/yyyy");
	private static DecimalFormat deci = new DecimalFormat("0.00");
	
	/** M�todo para montar uma tabela com dados cadastrados.
	 *  Dependendo da acao realiza uma forma de impress�o de dados.
	 *  1 - Lista Pessoas e Alunos.
	 *  2 - Lista Apenas Pessoas.
	 *  3 - Lista apenas Alunos.
	 *   
	 * @param (int, ArrayList<Pessoa>)
	 */ 
	public static void montarLista(int acao,  ArrayList<Pessoa> dados) {
	
		// Caso o array estiver vazio.
		if(dados.isEmpty() == true) {
			
			System.out.println("\nN�o existem dados a serem listados!");
			
		} else {
			
			// Imprimir tabela com Pessoas e Alunos cadastrados.
			if(acao == 1) {
				
				System.out.println("\n------------------------------------------");
				System.out.println("--         Tabela de Cadastros          --");
				System.out.println("------------------------------------------\n");
				
				desenhaLinha(true);
				desenhaCabecalho(true);
				
				for(Pessoa p: dados) {
					
					// Imprimir o Aluno.
					if(p != null && p instanceof Aluno) {
						
						desenhaLinha(true);
						listaAluno(p);
							
					} else {
						
						// Imprimir a Pessoa.
						desenhaLinha(true);
						listaPessoa(p, true);
					}
				}
				
				desenhaLinha(true);
				
				// Impress�o do Total de Cadastros.
				System.out.println("------------------------------------------");
				System.out.println("- Total de cadastros: " + dados.size());
				System.out.println("------------------------------------------");
			}
			
			// Imprimir tabela somente de Pessoas.
			if(acao == 2) {
				
				int totalPessoas = 0;
				
				System.out.println("\n------------------------------------------");
				System.out.println("--          Tabela de Pessoas           --");
				System.out.println("------------------------------------------\n");
				
				desenhaLinha(false);
				desenhaCabecalho(false);
				desenhaLinha(false);
				
				for(Pessoa p: dados) {
					
					// Imprimir a Pessoa.
					if(p != null && !(p instanceof Aluno)) {
						listaPessoa(p, false);
						desenhaLinha(false);
						totalPessoas++;
					}
				}
				
				// Impress�o do Total de Pessoas cadastradas.
				System.out.println("------------------------------------------");
				System.out.println("- Total de Pessoas: " + totalPessoas);
				System.out.println("------------------------------------------");
			}
			
			// Imprimir tabela somente de Alunos.
			if(acao == 3) {
				
				int totalAlunos = 0;
				
				System.out.println("\n------------------------------------------");
				System.out.println("--           Tabela de Alunos           --");
				System.out.println("------------------------------------------\n");
				
				desenhaLinha(true);
				desenhaCabecalho(true);
				desenhaLinha(true);
				
				for(Pessoa p: dados) {
					
					// Imprimir o Aluno.
					if(p != null && p instanceof Aluno) {
						
						listaAluno(p);
						desenhaLinha(true);
						totalAlunos++;
					}
				}
				
				// Impress�o do Total de Alunos cadastrados.
				System.out.println("------------------------------------------");
				System.out.println("- Total de Alunos: " + totalAlunos);
				System.out.println("------------------------------------------");
			}
		}
	}
	
	/**
	 * M�todo para imprimir os dados de uma Pessoa.
	 * Caso o dado(boolean) for verdadeiro, imprime
	 * tra�os no lugar referente a nota.
	 * 
	 * @param (Pessoa, boolean)
	 */
	private static void listaPessoa(Pessoa p, boolean dado) {
		
		// Obten��o de dados da Pessoa.
		String id = imprimirForma(String.valueOf(p.getId()), "id");
		String nome = imprimirForma(p.getNome(), "nome");
		
		// Impress�o dos dados da Pessoa.
		System.out.print("| Pessoa |");
		System.out.print(" " + id); 
		System.out.print(" " + nome);
		System.out.print(" " + p.getTel() + " |");
		System.out.print(" " + fmtNasc.format(p.getNasc()) + " |");
		
		if(dado == true) {
			
			System.out.print(" ----- |");
		}
		
		System.out.print(" " + fmt.format(p.getDataCad()) + " |");
		System.out.print(" " + fmt.format(p.getUltAlteracao()) + " |\n");
	}
	
	/**
	 * M�todo para imprimir os dados de um Aluno.
	 * 
	 * @param (Pessoa)
	 */
	private static void listaAluno(Pessoa p) {
		
		// Convers�o da Pessoa para o tipo Aluno.
		Aluno al = (Aluno)p;
		
		// Obten��o de dados do Aluno.
		String id = imprimirForma(String.valueOf(al.getId()), "id");
		String nome = imprimirForma(al.getNome(), "nome");
		String nota = imprimirForma(String.valueOf(deci.format(al.getNota())), "nota");
		
		// Impress�o dos dados do Aluno.
		System.out.print("| Aluno  |");
		System.out.print(" " + id); 
		System.out.print(" " + nome);
		System.out.print(" " + al.getTel() + " |");
		System.out.print(" " + fmtNasc.format(al.getNasc()) + " |");
		System.out.print(" " + nota);
		System.out.print(" " + fmt.format(al.getDataCad()) + " |");
		System.out.print(" " + fmt.format(al.getUltAlteracao()) + " |\n");	  	
	}
	
	/**
	 * M�todo para imprimir uma linha que segue um padr�o
	 * para o layout de uma tabela.
	 * Caso o dado(boolean) for verdadeiro, imprime um tra�o
	 * para o espa�o referente a nota.
	 * 
	 * @param (boolean)
	 */
	public static void desenhaLinha(boolean dado) {
		
		System.out.print("+ ------ +");
		System.out.print(" ---- +");
		System.out.print(" ---------------- +");
		System.out.print(" ------------ +");
		System.out.print(" ---------- +");
		
		if(dado == true) {
			
			System.out.print(" ----- +");
		}

		System.out.print(" ------------------- +");
		System.out.println(" ------------------- +");
	}
	
	/**
	 * M�todo para imprimir um cabe�alho que segue um padr�o
	 * para o layout de uma tabela.
	 * Caso o dado(boolean) for verdadeiro, imprime o espa�o
	 * referente a nota.
	 * 
	 * @param (boolean)
	 */
	public static void desenhaCabecalho(boolean dado) {
		
		System.out.print("|  Tipo  |");
		System.out.print("  ID  |"); 
		System.out.print("       Nome       |");
		System.out.print("   Telefone   |");
		System.out.print(" Nascimento |");
		
		if(dado == true) {
			
			System.out.print(" Nota  |");
		}
	
		System.out.print("     Dt Cadastro     |");
		System.out.println("   Dt Atualizacao    |");	
	}
	
	/**
	 * M�todo para o ajustar o tamanho de um dado dentro da tabela
	 * para que n�o ocorra a quebra de layout.
	 * 
	 * @param (String, String)
	 * @return (String)
	 */
	public static String imprimirForma(String dado, String forma) {
		
		// Ajustar o tamanho do ID no layout.
		if(forma.equalsIgnoreCase("id")) {
			
			int tamanho = 5;
			int tamanhoDado = dado.length();
			
			while(tamanhoDado < tamanho) {
				dado += " ";
				tamanhoDado++;
			}
		}
		
		// Ajustar o tamanho do Nome no layout.
		if(forma.equalsIgnoreCase("nome")) {
			
			int tamanho = 17;
			int tamanhoDado = dado.length();
			
			while(tamanhoDado < tamanho) {
				dado += " ";
				tamanhoDado++;
			}
		}
		
		// Ajustar o tamanho da Nota no layout.
		if(forma.equalsIgnoreCase("nota")) {
			
			int tamanho = 6;
			int tamanhoDado = dado.length();
			
			while(tamanhoDado < tamanho) {
				dado += " ";
				tamanhoDado++;
			}
		}
		
		return dado.concat("|");
	}
}
