package pruebas;

import static org.junit.Assert.*;
import logica.Jugador;

import org.junit.Test;

public class TestRef3 {

	@Test
	public void testActualizarTotal() {
		Jugador j = new Jugador("nom");
		for(int i=1;i<11;i++){
			j.addPunto();
			assertEquals(i, j.getPuntosActuales());
		}
	}

}
