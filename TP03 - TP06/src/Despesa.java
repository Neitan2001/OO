import java.util.Date;

public class Despesa extends Entrada{
	private double dinheiroGasto;

	public Despesa (Date d, String des, String t, double din ) {
		data = d;
		descricao = des;
		tipo = t;
		dinheiroGasto = din;
	}
	
	public String toString() {
		return "Descrição do Despesa: " + descricao + ", valor do Despesa: " + dinheiroGasto;
	}
	
	public double getDinheiroGasto() {
		return dinheiroGasto;
	}

	public void setDinheiroGasto(double dinheiroGasto) {
		this.dinheiroGasto = dinheiroGasto;
	}
	
}
