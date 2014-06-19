package pruebas;

import static org.junit.Assert.*;
import logica.Jugador;

import org.junit.Test;

public class TestRef1 {

	@Test
	public void testActualizarTotal() {
		Jugador j = new Jugador("nombre");
		for(int i = 1; i<11; i++)
			j.addPunto();
		j.actualizarTotal();
		assertEquals(10, j.getPuntos());
		
		j.addPunto();
		j.actualizarTotal();
		assertEquals(21, j.getPuntos());
	}

}
