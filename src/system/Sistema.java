package system;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

//Importa��es da pr�pria aplica��o.
import data.*;
import interaction.*;

/**
 * Classe para efetuar as opera��es solicitadas na classe Principal.
 * 
 * @author Henrik
 */
public class Sistema {
	
	// Vari�vel que armazenar� os dados cadastrados.
	private static ArrayList<Pessoa> dados = new ArrayList<Pessoa>();
	
	// Formatos espec�ficos de alguns dados.
	private static DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static DateFormat fmtNasc = new SimpleDateFormat("dd/MM/yyyy");
	
	/**
	 * M�todo que imprime algumas informa��es sobre a Aplica��o.
	 */
	public static void Cabecalho() {
		
		Date dataInicio = new Date();
		
		System.out.println("Programa iniciado em: " + fmt.format(dataInicio) + "\n");
		
		System.out.println("********************* HK CORPORATION *********************\n");
		
		System.out.println("*************** Gest�o de Pessoas-Alunos *****************\n");
		
		System.out.println("Criado e Desenvolvido por:\n");
		System.out.println("- Henrik Oliveira");
		System.out.println("  From HK CORPORATION");
		
		System.out.println("\nVers�o do Software:\n");
		System.out.println("- HKC (Ant.1.0)");
	}
	
	/**
	 * M�todo para efetuar o cadastro de uma Pessoa/Aluno.
	 * 
	 * @param (int)
	 * @throws NumberFormatException (Ser� criado uma Pessoa)
	 * @throws ParseException
	 */
	public static void Cadastrar(int id) {
		
		// Inicializa��o de vari�veis.
		String nome = "", tel = "";
		Date nasc = null, cadastro = null, ultAlteracao = null;
		Float nota = null;
		Pessoa p = null;
		
		try {
			
			System.out.println("\n---------------------------------------");
			System.out.println("--             Cadastrar             --");
			System.out.println("---------------------------------------");
			
			// Leitura de dados.
			nome = Entrada.lerNome();
			tel = Entrada.lerTelefone();
			nasc = fmtNasc.parse(Entrada.lerData());
			
			System.out.println("\nInforme a nota do Aluno(a) utilizando ponto, caso haja parte fracion�ria.");
			System.out.println("(Nota m�xima permitida = 10.00)");
			System.out.println("Caso deseje criar uma Pessoa, pressione a tecla 'Enter'.");
			
			nota = Entrada.lerNota();
			
			cadastro = new Date();
			ultAlteracao = cadastro;
			
			// Cria��o do objeto Aluno.
			p = new Aluno(id, nome, tel, nasc, cadastro, ultAlteracao, nota);
			
			System.out.println("\nAluno(a) cadastrado(a) com sucesso!");
		
		// Tratamento de Exce��es.
		} catch(NumberFormatException e) {
			
			cadastro = new Date();
			ultAlteracao = cadastro;
			
			// Cria��o do objeto Pessoa.
			p = new Pessoa(id, nome, tel, nasc, cadastro, ultAlteracao);
			
			System.out.println("\nPessoa cadastrada com sucesso!");
			
		} catch(ParseException e) {
			
			System.out.println(e);
			System.out.println("Imposs�vel efetuar a convers�o dos dados!");	
		}
		
		// Inclus�o no Array.
		dados.add(p);
		System.out.println("\nID do cadastro: " + id);	
	}
	
	/**
	 * M�todo para efetuar a listagem dos dados cadastrados.
	 */
	public static void Listar() {
		
		// Vari�vel para guardar a opera��o que o usu�rio deseja realizar.
		int opt = 0;
		
		while(opt != 4) {
				
				System.out.println("\n***************************************");
				System.out.println("*     INFORME A OPERA��O DESEJADA     *");
				System.out.println("***************************************");
				System.out.println("*      1 - Listar Pessoas-Alunos      *");
				System.out.println("*      2 - Listar Pessoas             *");
				System.out.println("*      3 - Listar Alunos              *");
				System.out.println("*      4 - Voltar                     *");
				System.out.println("***************************************\n");
				
				// Leitura da opera��o.
				System.out.print("-> ");
				opt = Entrada.lerInt();
				
				// Efetuar a opera��o desejada pelo usu�rio.
				switch(opt) {
				
				case 1:
					Saida.montarLista(1, dados);
					break;
					
				case 2:
					Saida.montarLista(2, dados);
					break;
					
				case 3:
					Saida.montarLista(3, dados);
					break;
					
				case 4:
					break;
					
				default: 
					System.out.println("\nOpera��o inv�lida!");	
				}	
		}
	}
	
	/**
	 * M�todo para efetuar a exclus�o do cadastro de uma Pessoa/Aluno.
	 */
	public static void Deletar() {
		
		// Declara��o de algumas vari�veis.
		Iterator<Pessoa> pessoaIterator = dados.iterator();
		int id;
		int contDel = 0;
		
		System.out.println("\n---------------------------------------");
		System.out.println("--              Deletar              --");
		System.out.println("---------------------------------------");
		
		System.out.println("\nPor favor, informe abaixo o ID a ser deletado.");
		
		// Leitura do dado.
		System.out.print("-> ");
		id = Entrada.lerInt();
		
		// Verificar se existe o ID cadastrado. Caso exista, deletar.
		while(pessoaIterator.hasNext()) {
			
			if(pessoaIterator.next().getId() == id) {
				
				pessoaIterator.remove();
				
				contDel = 1;
			}	
		}
		
		if(contDel == 1) {
			
			System.out.println("\nDado deletado com sucesso!");
			
		} else {
			
			System.out.println("\nDado n�o encontrado!");
		}
	}
	
	/**
	 * M�todo para efetuar a atualiza��o do cadastro de uma Pessoa/Aluno.
	 * 
	 * @throws NumberFormatException (� mantida a mesma nota)
	 * @throws ParseException
	 */
	public static void Atualizar() {
		
		// Declara��o de algumas vari�veis.
		String nome = "", tel = "";
		Date nasc = null;
		Float nota = null;
		int id;
		int contAtt = 0;
		Aluno al = null;
		
		System.out.println("\n---------------------------------------");
		System.out.println("--             Atualizar             --");
		System.out.println("---------------------------------------");
		
		System.out.println("\nPor favor, informe abaixo o ID a ser atualizado.");
		
		// Leitura do dado.
		System.out.print("-> ");
		id = Entrada.lerInt();
		
		for(Pessoa p : dados) {
			
			// Se for um Aluno, atualizar seus dados.
			if(p.getId() == id && p instanceof Aluno) {
				
				try {
					
					// Convers�o da Pessoa para o tipo Aluno.
					al = (Aluno)p;
					
					// Leitura de dados.
					nome = Entrada.lerNome();
					tel = Entrada.lerTelefone();
					nasc = fmtNasc.parse(Entrada.lerData());
					
					System.out.println("\nInforme a nota do Aluno(a) utilizando ponto, caso haja parte fracion�ria.");
					System.out.println("(Nota m�xima permitida = 10.00)");
					System.out.println("Caso deseje manter a mesma nota, pressione a tecla 'Enter'.");
					
					nota = Entrada.lerNota();
				
				// Tratamento de Exce��es.
				} catch (NumberFormatException e) {
					
					nota = al.getNota();

				} catch(ParseException e) {
					
					System.out.println(e);
					System.out.println("Imposs�vel efetuar a convers�o dos dados!");
				}
				
				// Efetua��o da atualiza��o.
				al.setNome(nome);
				al.setTel(tel);
				al.setNasc(nasc);
				al.setNota(nota);
				al.setUltAlteracao(new Date());
				
				contAtt = 1;	
			} 
			
			// Se n�o for Aluno, atualizar seus dados.
			if(p.getId() == id && !(p instanceof Aluno)) {
				
				try {
					
					// Leitura de dados.
					nome = Entrada.lerNome();
					tel = Entrada.lerTelefone();
					nasc = fmtNasc.parse(Entrada.lerData());
				
				// Tratamento de Exce��o.
				} catch (ParseException e) {
					
					System.out.println(e);
					System.out.println("Imposs�vel efetuar a convers�o dos dados!");
				}
				
				// Efetua��o da atualiza��o.
				p.setNome(nome);
				p.setTel(tel);
				p.setNasc(nasc);
				p.setUltAlteracao(new Date());
				
				contAtt = 1;	
			} 
		}
		
		if(contAtt == 1) {
			
			System.out.println("\nDado atualizado com sucesso!");
			
		} else {
			
			System.out.println("\nDado n�o encontrado!");
		}
	}	
}
