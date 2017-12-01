package br.unirio.pcs.suta;

public abstract class Pessoa {
	
	public String nome;
	public String sobreNome;
	public String cpf;
	public String telefone;
	
	public Pessoa(){
		
	}
	public Pessoa(String nome, String sobreNome, String cpf, String telefone) {
		super();
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.cpf = cpf;
		this.telefone = telefone;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobreNome() {
		return sobreNome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}

