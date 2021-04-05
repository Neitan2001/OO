package modelo;
import java.util.*;

public class Recebimento extends Entrada {
	private double dinheiroRecebido;

	public Recebimento (Date d, String des, String t, double din, Conta c) {
		data = d;
		descricao = des;
		tipo = t;
		dinheiroRecebido = din;
		conta = c;
	}
	
	public void adicionar() {
		int qtd;
		Conta c = this.getConta();
		qtd = c.getNumRecebimentos();
		c.setDinheiroRecebido(this, qtd);
		c.setNumRecebimentos(qtd+1);
	}
	
	public String toString() {
		return "Descrição do Recebimento: " + descricao + ", valor do Recebimento: " + dinheiroRecebido;
	}
	
	public double getDinheiroRecebido() {
		return dinheiroRecebido;
	}

	public void setDinheiroRecebido(double dinheiroRecebido) {
		this.dinheiroRecebido = dinheiroRecebido;
	}
	
}
