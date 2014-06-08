package logica;


public abstract class Decorador implements IPregunta{

	private IPregunta pregunta;
	protected   String[] respuestas;
	
	public Decorador(IPregunta p){
		pregunta = p;
	}
	
	//fijar el texto de la pregunta. Delegacion
	public void setTextoPregunta(String p){
		pregunta.setTextoPregunta(p);
	}
	
	//devolver el texto de la pregunta. Delegacion
	public String getTextoPregunta(){
		return pregunta.getTextoPregunta();
	}

	
	public String getRespuestaCorrecta(){
		return pregunta.getRespuestaCorrecta();
	}

	public boolean compararRespuesta(String resp){
	return this.getRespuestaCorrecta() == resp;	
	}
	
	@Override
	public String getRespuesta(int i) {
		// TODO Auto-generated method stub
		return respuestas[i];
	}

}
