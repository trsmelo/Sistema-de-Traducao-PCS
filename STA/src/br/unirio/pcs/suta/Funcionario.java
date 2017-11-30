package br.unirio.pcs.suta;

public class Funcionario extends Pessoa{
	
	private int matricula;
	private String nomeUsuario;
	private String senha;
	
	public Funcionario(String nome, String sobreNome, String cpf, String telefone,int matricula,String nomeUsuario,String senha) {
		super(nome, sobreNome, cpf, telefone);
		this.matricula = matricula;
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;	
	}
	
}
