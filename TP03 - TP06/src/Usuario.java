
public class Usuario {
	private String nome;
	private int idade;
	private int cpf;
	
	public Usuario (String n, int i, int c) {
		nome = n;
		idade = i;
		cpf = c;
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
