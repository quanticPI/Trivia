package logica;

public class PreguntaElegir extends Pregunta{
	
	
	//private String textoPregunta;
	//array para las posibles respuestas
	private String[] respuestas;
	// indice de la respuesta correcta
	private int respuestaCorrecta;
	
	public PreguntaElegir(int num_preguntas, int tipo){		
		this.textoPregunta = "";
		this.respuestaCorrecta = 0;
		for(int i=0; i<num_preguntas; i++)
			setRespuestaPosible("", i);
		this.tipo = tipo;
		
	}
	
	public void setPregunta(String p){
		super.textoPregunta = p;
	}
	
	public String getPregunta(){
		return super.textoPregunta;
	}
	
	//fijar una respuesta posible
	public void setRespuestaPosible(String text, int num){
		respuestas[num] = text;
	}
	
	public void setRespuesta(int res){
		this.respuestaCorrecta = res;
	}

	//devolver respuesta correcta
	public String responder(){
		return this.respuestas[respuestaCorrecta];
	}
	
	public boolean compararRespuesta(String res_jugador){
		if (this.respuestas[respuestaCorrecta].equals(res_jugador))
			return true;
		return false;
	}
}
