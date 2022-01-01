package data;

import java.util.Date;

public class Pessoa {
	
	// Atributos de acesso local.
	private int id;
	private String nome;
	private String tel;
	private Date nasc;
	private Date dataCad;
	private Date ultAlteracao;

	/**
	 * Construtor para objetos da classe Pessoa.
	 * 
	 * @param (int, String, String, Date, Date, Date)
	 */
	public Pessoa(int id, String nome, String tel, Date nasc, Date dataCad, Date ultAlteracao) {
		this.id = id;
		this.nome = nome;
		this.tel = tel;
		this.nasc = nasc;
		this.dataCad = dataCad;
		this.ultAlteracao = ultAlteracao;
	}

	// Métodos "get" e "set" para os atributos.
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getNasc() {
		return nasc;
	}

	public void setNasc(Date nasc) {
		this.nasc = nasc;
	}

	public Date getDataCad() {
		return dataCad;
	}

	public void setDataCad(Date dataCad) {
		this.dataCad = dataCad;
	}

	public Date getUltAlteracao() {
		return ultAlteracao;
	}

	public void setUltAlteracao(Date ultAlteracao) {
		this.ultAlteracao = ultAlteracao;
	}
}
