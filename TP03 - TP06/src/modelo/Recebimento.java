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
	
	public String toString() {
		return "Descrição do Recebimento: " + descricao + ", valor do Recebimento: R$ " + dinheiroRecebido;
	}
	
	public double getDinheiroRecebido() {
		return dinheiroRecebido;
	}

	public void setDinheiroRecebido(double dinheiroRecebido) {
		this.dinheiroRecebido = dinheiroRecebido;
	}
	
}
