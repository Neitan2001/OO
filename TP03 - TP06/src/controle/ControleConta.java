package controle;

import modelo.*;

public class ControleConta {
	private ControleUsuario controlU = new ControleUsuario();
	private Usuario u = controlU.getUsuario();
	private Conta c = new Conta("Nome padrão", u);
	
	
	public ControleConta() {
		c.fillWithSomeData();
		calcularSaldo();
	}
	
	public Conta getConta() {
		return c;
	}
	
	public Usuario getUsuario() {
		return u;
	}
	
	// Método para calcular o Saldo da Conta
	public void calcularSaldo() {
		double dinR = 0;
		double dinG = 0;
		
		for(int i = 0; i < c.getNumRecebimentos(); i++) {
			dinR = dinR + c.getDinheiroRecebido(i).getDinheiroRecebido();
		}
		
		for(int i = 0; i < c.getNumDespesas(); i++) {
			dinG = dinG + c.getDinheiroGasto(i).getDinheiroGasto();
		}
		
		c.setSaldo(dinR-dinG);
	}
}
