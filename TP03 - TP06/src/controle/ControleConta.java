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
	
	public ControleUsuario getControlU() {
		return controlU;
	}
	
	public Double calcularSaldoMes(int m) {
		int mes = m;
		double dinR = 0;
		double dinG = 0;
		double saldoMes = 0;
		
		//Calcular saldo por mes de recebimentos
		for(int i = 0; i < c.getNumRecebimentos(); i++) {
			
			//Verificar se o mes passado é o mesmo do recebimento
			if(mes== c.getDinheiroRecebido(i).getData().getMonth()) {
				dinR = dinR + c.getDinheiroRecebido(i).getDinheiroRecebido();
			}
		}
		
		//Calcular saldo por mes de despesas
		for(int i = 0; i < c.getNumDespesas(); i++) {
			
			//Verificar se o mes passado é o mesmo da despesa
			if(mes == c.getDinheiroGasto(i).getData().getMonth()) {
				dinG = dinG + c.getDinheiroGasto(i).getDinheiroGasto();
			}
		}
		
		saldoMes = dinR - dinG;
		return saldoMes;
	}
	
	// Método para calcular o Saldo Total da Conta
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
