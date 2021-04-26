package modelo;
import java.util.*;

/**
 * Classe modeladora dos Recebimentos do usuário
 * @author Natan Tavares Santana and Isaac Menezes Pereira
 * @version 1.0 (march 2021)
 */

public class Recebimento extends Entrada {
	private double dinheiroRecebido;

	/**
	 * Construtor da classe modeladora dos Recebimentos, ela recebe a data de criação, a descrição, o tipo, o valor e a conta.
	 * @param d
	 * parâmetro data
	 * @param des
	 * parâmetro descrição
	 * @param t
	 * parâmetro tipo
	 * @param din
	 * parâmetro dinheiro recebido
	 * @param i
	 * parâmetro id
	 * @param c
	 * parâmetro conta
	 */
	public Recebimento (Date d, String des, String t, double din, int i ,Conta c) {
		data = d;
		descricao = des;
		tipo = t;
		dinheiroRecebido = din;
		id = i;
		conta = c;
	}
	
	public String toString() {
		return descricao +"         R$ " + dinheiroRecebido;
	}
	
	public double getDinheiroRecebido() {
		return dinheiroRecebido;
	}

	public void setDinheiroRecebido(double dinheiroRecebido) {
		this.dinheiroRecebido = dinheiroRecebido;
	}
	
}
