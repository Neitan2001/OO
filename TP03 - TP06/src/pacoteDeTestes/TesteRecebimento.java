package pacoteDeTestes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import controle.*;

class TesteRecebimento {
	ControleConta controlC = new ControleConta();
	ControleRecebimento controlR = new ControleRecebimento(controlC);
	
	
	@Test
	void testAdicionarEditarRecebimento() {
		String[] s = new String[9];
		s[0] = "2";
		s[1] = "salário";
		s[2] = "salário";
		s[3] = "2.50";
		assertTrue(controlR.adicionarEditarRecebimento(s, controlC, 1));
		
		s[0] = "2";
		s[1] = "salário";
		s[2] = "salário";
		s[3] = "aaaa";
		assertFalse(controlR.adicionarEditarRecebimento(s, controlC, 1));
	}

	@Test
	void testRemoverRecebimento() {
		assertTrue(controlR.removerRecebimento(0, controlC));
		
		assertFalse(controlR.removerRecebimento(10, controlC));
	}

}
