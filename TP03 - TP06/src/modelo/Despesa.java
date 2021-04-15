package modelo;
import java.util.Date;

public class Despesa extends Entrada{
	private double dinheiroGasto;

	public Despesa (Date d, String des, String t, double din, int i,Conta c) {
		data = d;
		descricao = des;
		tipo = t;
		dinheiroGasto = din;
		id = i;
		conta = c;
	}
	
	public void adicionar() {
		int qtd;
		Conta c = this.getConta();
		qtd = c.getNumDespesas();
		c.setDinheiroGasto(this, qtd);
		c.setNumDespesas(qtd+1);
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
