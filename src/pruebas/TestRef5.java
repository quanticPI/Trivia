package pruebas;

import static org.junit.Assert.assertEquals;
import logica.PreguntaBasica;
import logica.PreguntaFacil;

import org.junit.Test;

public class TestRef5 {

	@Test
	public void testSetRespuestas() {
		PreguntaBasica pb = new PreguntaBasica();
		pb.setRespuestaCorrecta("resOK");
		String[] res = {"res1"};
		PreguntaFacil p = new PreguntaFacil(pb, res);
		assertEquals("res1", p.getRespuestas()[0]);
	}

}
