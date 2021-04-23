package pacoteDeTestes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import controle.*;

class TesteConta {
	ControleConta controlC = new ControleConta();
	
	@Test
	void testCalcularSaldoMes() {
		
		assertEquals(50, controlC.calcularSaldoMes(3));
		
	}

}
