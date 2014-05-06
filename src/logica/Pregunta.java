package logica;

/**
 * @author Nikolay
 */
public class Pregunta {
	
	//numero de respuestas
	//private int num_respuestas;
	//tipos de juego
	public static final int TRUEFALSE = 1;
	public static final int ABIERTA = 2;
	public static final int ELEGIR = 3;
	private int tipo; 
	//el texto de la pregunta
	private String textoPregunta;
	//array para las posibles respuestas
	private String[] respuestas;
	// indice de la respuesta correcta
	private int respuestaCorrecta;
	
	//Constructor
	public Pregunta(int num_preguntas, int tipo){
		int i;
		this.textoPregunta = "";
		this.respuestaCorrecta = 0;
		if(tipo == TRUEFALSE || tipo == ABIERTA)
			respuestas[0] = "";
		else for(i=0; i<num_preguntas; i++)
					setRespuestaPosible("", i);
		this.tipo = tipo;
	}
	
	//Fijar la pregunta
	public void setPregunta(String p){
		this.textoPregunta = p;
	}
	
	//devolver la pregunta
	public String getPregunta(){
		return textoPregunta;
	}
	
	//fijar la respuesta correcta
	public void setRespuestaCorrecta(int num){
		this.respuestaCorrecta = num;
	}
	
	//fijar una respuesta posible
	public void setRespuestaPosible(String text, int num){
		respuestas[num] = text;
	}
	
	//respuesta TRUEFALSE
	public void setTrueOrFalse(String s){
		setRespuestaPosible(s, 0);
	}
	
	//respuesta abierta
	public void setRespuestaAbierta(String s){
		setRespuestaPosible(s, 0);
	}
	
	//devolver respuesta correcta
	public String responder(){
		return this.respuestas[respuestaCorrecta];
	}
	
	public int getTipo(){
		return tipo;
	}
}
