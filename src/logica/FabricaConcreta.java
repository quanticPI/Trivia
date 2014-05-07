package logica;

public class FabricaConcreta extends FabricaPregunta {

	public Pregunta crearPregunta(int tipo){
		switch(tipo){
		case tipo = 1:
			return new PreguntaTF();
		case tipo = 2:
			return new PreguntaAbierta();
		case tipo = 3:
			return new PreguntaElegir();
		}
	}
	
}
