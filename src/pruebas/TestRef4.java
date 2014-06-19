package pruebas;

import static org.junit.Assert.*;
import logica.FabricaConcreta;
import logica.FabricaJuego;
import logica.Juego;

import org.junit.Test;

public class TestRef4 {

	@Test
	public void testGetCategoria() {
		FabricaJuego fab = new FabricaConcreta();
		Juego j = fab.metodoFabrica("CINE");
		assertEquals("CINE", j.getCategoria());
		
		j = fab.metodoFabrica("historia");
		assertEquals("HISTORIA", j.getCategoria());
	}

}
