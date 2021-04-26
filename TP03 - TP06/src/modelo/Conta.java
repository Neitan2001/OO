package modelo;

import java.util.Calendar;
import java.util.Date;

/**
 * Classe modeladora da Conta do usuário
 * @author Natan Tavares Santana and Isaac Menezes Pereira
 * @version 1.0 (march 2021)
 */

public class Conta {
	private String nome;
	private Usuario dono;
	private double saldo = 0;
	private Recebimento[] recebimentosCadastrados = new Recebimento[100];
	private Despesa[] despesasCadastradas = new Despesa[100];
	private int numDespesas = 0;
	private int numRecebimentos = 0;
	
	/**
	 * Construtor da classe modeladora da Conta, ela recebe o nome da conta e o usuário dono.
	 * @param n
	 * parâmetro nome
	 * @param d
	 * parâmetro dono
	 */
	public Conta (String n, Usuario d) {
		nome = n;
		dono = d;
	}
	
	//Sobrecarga de um método
	public Conta (String n) {
		nome = n;
	}
	
	/**
	 * Método para preencher o programa com alguns dados a fim de testar o mesmo.
	 */
	public void fillWithSomeData() {
		Date d = Calendar.getInstance().getTime();
		Recebimento r1 = new Recebimento(d, "Recebimento01", "Salário", 80, 0 ,this);
		Recebimento r2 = new Recebimento(d, "Recebimento02", "Salário", 50, 1 ,this);
		this.setDinheiroRecebido(r1, 0);
		this.setDinheiroRecebido(r2, 1);
		this.setNumRecebimentos(2);
		
		Despesa d1 = new Despesa(d, "Despesa01", "Salário", 30, 0, this);
		Despesa d2 = new Despesa(d, "Despesa02", "Salário", 50, 1, this);
		this.setDinheiroGasto(d1, 0);
		this.setDinheiroGasto(d2, 1);
		this.setNumDespesas(2);
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
	
	/**
	 * Método para fazer a adição ou edição de recebimentos na conta do usuário. O método verifica se é uma adição por comparar a posição do recebimento com a quantidade de recebimentos e se for igual, implementa mais um na quantidade
	 * @param r
	 * parâmetro Recebimento
	 * @param pos
	 * parâmetro posição do recebimento
	 */
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
	
	/**
	 * Método para fazer a adição ou edição de despesa na conta do usuário. O método verifica se é uma adição por comparar a posição do recebimento com a quantidade de recebimentos e se for igual, implementa mais um na quantidade
	 * @param d
	 * parâmetro despesa
	 * @param pos
	 * parâmetro posição da despesa
	 */
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
	
}
