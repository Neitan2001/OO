
public class Conta {
	private String nome;
	private Usuario dono;
	private double saldo;
	private Recebimento[] recebimentosCadastrados = new Recebimento[100];
	private Despesa[] despesasCadastradas = new Despesa[100];
	private int numDespesas = 0;
	private int numRecebimentos = 0;
	
	public Conta (String n, Usuario d) {
		nome = n;
		dono = d;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Usuario getDono() {
		return dono;
	}
	
	public void setDono(Usuario dono) {
		this.dono = dono;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public Recebimento[] getRecebimentosCadastrados() {
		return recebimentosCadastrados;
	}
	
	public void setArrayRecebimentosCadastrados(Recebimento[] recebimentosCadastrados) {
		this.recebimentosCadastrados = recebimentosCadastrados;
	}
	
	public Despesa[] getDespesasCadastradas() {
		return despesasCadastradas;
	}
	
	public void setArrayDespesasCadastradas(Despesa[] despesasCadastradas) {
		this.despesasCadastradas = despesasCadastradas;
	}
	
	public int getNumDespesas() {
		return numDespesas;
	}
	
	public void setNumDespesas(int numDespesas) {
		this.numDespesas = numDespesas;
	}
	
	public int getNumRecebimentos() {
		return numRecebimentos;
	}
	
	public void setNumRecebimentos(int numRecebimentos) {
		this.numRecebimentos = numRecebimentos;
	}
	
}
