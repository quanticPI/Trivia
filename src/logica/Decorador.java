package logica;


public abstract class Decorador implements IPregunta{

	private IPregunta pregunta;
	public IPregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(IPregunta pregunta) {
		this.pregunta = pregunta;
	}

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

	public String[] getRespuestas() {
		return respuestas;
	}

	
	@Override
	public String getRespuesta(int i) {
		// TODO Auto-generated method stub
		return respuestas[i];
	}

	@Override
	public String getRespuestaCorrecta() {
		return pregunta.getRespuestaCorrecta();
	}
	@Override
	public boolean compararRespuesta(String resp) {
		 return pregunta.compararRespuesta(resp);
	}
	public abstract void setRespuestas(String[] respuestas);	


}
