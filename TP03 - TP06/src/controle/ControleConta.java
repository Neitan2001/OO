package controle;

import modelo.*;

/**
 * Classe controladora da Conta do usuário
 * @author Natan Tavares Santana
 * @author Isaac Menezes Pereira
 * @version 1.0 (march 2021)
 */

public class ControleConta {
	private ControleUsuario controlU = new ControleUsuario();
	private Usuario u = controlU.getUsuario();
	private Conta c = new Conta("Nome padrão", u);
	
	
/**
 * Contrutor da classe controlado da conta. Ao ser instanciado, a classe controladora executa o método para preencher o programa com alguns dados e calcula o saldo da conta.
 */
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
	
	/**
	 * Método para calcular o saldo de um mês específico da conta
	 * @param m
	 * parâmetro mês
	 * @return retorna um Double que é o saldo do usuário em certo mês
	 */
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
	
	/**
	 * Método para calcular o saldo total do usuário
	 */
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
