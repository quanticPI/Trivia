package logica;

public abstract class Decorador implements IPregunta{

	private IPregunta pregunta;
	protected String[] respuestas;
	
	public Decorador(IPregunta p){
		pregunta = p;
		respuestas = new String[4];
	}
	
	//fijar el texto de la pregunta. Delegacion
	public void setTextoPregunta(String p){
		pregunta.setTextoPregunta(p);
	}
	
	//devolver el texto de la pregunta. Delegacion
	public String getTextoPregunta(){
		return pregunta.getTextoPregunta();
	}
	
	//fijar una respuesta.
	public void setRespuesta(String res){
		pregunta.setRespuesta(res);
	}
	
	public String getRespuestaCorrecta(){
		return pregunta.getRespuestaCorrecta();
	}
}
