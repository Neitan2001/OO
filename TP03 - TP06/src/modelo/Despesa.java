package modelo;
import java.util.Date;

/**
 * Classe modeladora das Despesas do usuário
 * @author Natan Tavares Santana
 * @author Isaac Menezes Pereira
 * @version 1.0 (march 2021)
 */

public class Despesa extends Entrada{
	private double dinheiroGasto;

	/**
	 * Construtor da classe modeladora das Despesas, ela recebe a data de criação, a descrição, o tipo, o valor e a conta.
	 * @param d
	 * parâmetro data
	 * @param des
	 * parâmetro descrição
	 * @param t
	 * parâmetro tipo
	 * @param din
	 * parâmetro dinheiro gasto
	 * @param i
	 * parâmetro id
	 * @param c
	 * parâmetro conta
	 */
	
	public Despesa (Date d, String des, String t, double din, int i,Conta c) {
		data = d;
		descricao = des;
		tipo = t;
		dinheiroGasto = din;
		id = i;
		conta = c;
	}
	
	public String toString() {
		return descricao + "         R$ " + dinheiroGasto;
	}
	
	public double getDinheiroGasto() {
		return dinheiroGasto;
	}

	public void setDinheiroGasto(double dinheiroGasto) {
		this.dinheiroGasto = dinheiroGasto;
	}
	
}
