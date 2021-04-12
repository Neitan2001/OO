package modelo;

import java.util.Calendar;
import java.util.Date;

public class Conta {
	private String nome;
	private Usuario dono;
	private double saldo = 0;
	private Recebimento[] recebimentosCadastrados = new Recebimento[100];
	private Despesa[] despesasCadastradas = new Despesa[100];
	private int numDespesas = 0;
	private int numRecebimentos = 0;
	
	public Conta (String n, Usuario d) {
		nome = n;
		dono = d;
	}
	
	public void fillWithSomeData() {
		Date d = Calendar.getInstance().getTime();
		Recebimento r1 = new Recebimento(d, "Recebimento01", "Salário", 30, this);
		Recebimento r2 = new Recebimento(d, "Recebimento02", "Salário", 50, this);
		this.setDinheiroRecebido(r1, 0);
		this.setDinheiroRecebido(r2, 1);
		this.setNumRecebimentos(2);
	}
	
	public String toString() {
		return "Nome da Conta: " + nome + ", saldo da Conta: " + saldo;
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
	
	public Recebimento getDinheiroRecebido(int i) {
		return recebimentosCadastrados[i];
	}
	
	public void setDinheiroRecebido(Recebimento dinR, int i) {
		this.recebimentosCadastrados[i] = dinR;
	}
	
	public void inserirEditarRecebimento(Recebimento r, int pos) {
		this.recebimentosCadastrados[pos] = r;
		if(pos == numRecebimentos) numRecebimentos++;
	}
	
	public Despesa[] getDespesasCadastradas() {
		return despesasCadastradas;
	}
	
	public void setArrayDespesasCadastradas(Despesa[] despesasCadastradas) {
		this.despesasCadastradas = despesasCadastradas;
	}
	
	public Despesa getDinheiroGasto(int i) {
		return despesasCadastradas[i];
	}
	
	public void setDinheiroGasto(Despesa dinG, int i) {
		this.despesasCadastradas[i] = dinG;
	}
	
	public void inserirEditarDespesa(Despesa d, int pos) {
		this.despesasCadastradas[pos] = d;
		if(pos == numDespesas) numDespesas++;
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
	
	// Método para calcular o Saldo da Conta
	public void calcularSaldo() {
		double dinR = 0;
		double dinG = 0;
		
		for(int i = 0; i < numRecebimentos; i++) {
			dinR = dinR + recebimentosCadastrados[i].getDinheiroRecebido();
		}
		
		for(int i = 0; i < numDespesas; i++) {
			dinG = dinG + despesasCadastradas[i].getDinheiroGasto();
		}
		
		this.setSaldo(dinR-dinG);
	}
	
	// Método para consultar o extrato da conta
	public String consultarSaldo() {
		String saida = "***Extrato da Conta***\n";
		
		for(int i = 0; i < numRecebimentos; i++) {
			saida = saida + "\n***Recebimento***\n" + recebimentosCadastrados[i].toString();
		}
		
		for(int i = 0; i < numDespesas; i++) {
			saida = saida + "\n***Despesas***\n" + despesasCadastradas[i].toString();
		}
		return saida;
	}
	
}
