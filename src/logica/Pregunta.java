package logica;

/**
 * @author Nikolay
 */
public abstract class Pregunta {
	
	//numero de respuestas
	//private int num_respuestas;
	//tipos de juego
	public static final int SINTIPO = 0;
	public static final int TRUEFALSE = 1;
	public static final int ABIERTA = 2;
	public static final int ELEGIR = 3;
	protected int tipo; 
	//el texto de la pregunta
	protected String textoPregunta;
	
	//Fijar la pregunta
	public abstract void setPregunta(String p);
	
	//devolver la pregunta
	public abstract String getPregunta();
	
	//fijar la respuesta correcta
	//public abstract void setRespuesta(String res);
	//{
	//	this.respuestaCorrecta = num;
	//}
	
	
	
	//respuesta TRUEFALSE
	//public void setTrueOrFalse(String s){
	//	setRespuestaPosible(s, 0);
	//}
	
	//respuesta abierta
	//public void setRespuestaAbierta(String s){
	//	setRespuestaPosible(s, 0);
	//}	
	
	public void setTipo(int tipo){
		this.tipo = tipo;
	}
	
	public int getTipo(){
		return tipo;
	}
}
