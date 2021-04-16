package modelo;
import java.util.*;

public class Recebimento extends Entrada {
	private double dinheiroRecebido;

	public Recebimento (Date d, String des, String t, double din, int i ,Conta c) {
		data = d;
		descricao = des;
		tipo = t;
		dinheiroRecebido = din;
		id = i;
		conta = c;
	}
	
	public String toString() {
		return descricao + "   Data: "+ data +"         R$ " + dinheiroRecebido;
	}
	
	public double getDinheiroRecebido() {
		return dinheiroRecebido;
	}

	public void setDinheiroRecebido(double dinheiroRecebido) {
		this.dinheiroRecebido = dinheiroRecebido;
	}
	
}
