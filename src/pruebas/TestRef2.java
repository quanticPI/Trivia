package pruebas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import logica.Controlador;
import logica.FabricaConcreta;
import logica.FabricaJuego;
import logica.IPregunta;
import logica.Juego;
import logica.Jugador;
import logica.PreguntaBasica;
import logica.PreguntaFacil;

import org.junit.Test;

import presentacion.pregunta;

public class TestRef2 {

	@Test
	public void testPregunta() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRespuesta() {
		FabricaJuego fabrica = new FabricaConcreta();
		Juego juego = fabrica.metodoFabrica("HISTORIA");
		String[] res = {"res1","res2","res3"};
		IPregunta[] p = {new PreguntaFacil(new PreguntaBasica(),res)};
		Jugador[] j = {new Jugador("niko"), null};
		juego.setPreguntas(p);
		juego.setJugadores(j);
		pregunta pr = new pregunta(Controlador.getInstance(), juego, "Facil", j[0]);
		assertEquals(j[0].getPuntosActuales()-1,j[0].getPuntosActuales());
	}

}
