package modelo;

/**
 * Classe modeladora do Usuário
 * @author Natan Tavares Santana and Isaac Menezes Pereira
 * @version 1.0 (march 2021)
 */

public class Usuario {
	private String nome;
	private int idade;
	private int cpf;
	
	/**
	 * Construtor da classe modeladora do usuário. Ele recebe nome, idade e cpf.
	 * @param n
	 * parâmetro nome
	 * @param i
	 * parâmetro idade
	 * @param c
	 * parâmetro cpf
	 */
	public Usuario (String n, int i, int c) {
		nome = n;
		idade = i;
		cpf = c;
	}
	
	public String toString() {
		return "Nome do Dono: " + nome + ", idade do dono: " + idade;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public int getCpf() {
		return cpf;
	}
	
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
}
