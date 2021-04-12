package controle;

import modelo.*;

public class ControleConta {
	private ControleUsuario controlU = new ControleUsuario();
	private Conta c;
	
	public ControleConta() {
		Usuario u = controlU.getUsuario();
		c = new Conta("Nome padrão", u);
		c.fillWithSomeData();
	}
	
	public Conta getConta() {
		return c;
	}
}
