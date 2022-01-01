package data;

import java.util.Date;

public class Aluno extends Pessoa {

	// Atributo de acesso local.
	private Float nota;
	
	/**
	 * Construtor para objetos da classe Aluno.
	 * 
	 * @param (int, String, String, Date, Date, Date, Float)
	 */
	public Aluno(int id, String nome, String tel, Date nasc, Date dataCad, Date ultAlteracao, Float nota) {
		
		// Chamada para o contrutor da classe pai.
		super(id, nome, tel, nasc, dataCad, ultAlteracao);
		
		// Inicialização de variáveis especificas da classe.
		this.nota = nota;
	}

	// Métodos "get" e "set" para o atributo nota.
	public Float getNota() {
		return nota;
	}

	public void setNota(Float nota) {
		this.nota = nota;
	}
}
