package logica;

public class FabricaConcreta extends FabricaPregunta {

	public Pregunta crearPregunta(int tipo){
		if(tipo == Pregunta.TRUEFALSE)
			return new PreguntaTF(tipo);
		else
			if (tipo == Pregunta.ABIERTA)
				return new PreguntaAbierta(tipo);
			else
				return new PreguntaElegir(4,tipo);
		}
}