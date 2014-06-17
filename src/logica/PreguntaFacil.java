package logica;


public class PreguntaFacil extends Decorador{
	
	
	public PreguntaFacil(IPregunta p, String[] respuestas){
		super(p);
		this.respuestas = new String[2];
		this.setRespuestas(respuestas);
	}
	@Override
	public void setRespuestas(String[] respuestas) {
		this.respuestas[0] = this.getPregunta().getRespuestaCorrecta();
		this.respuestas[1] = respuestas[1];
	}



}
