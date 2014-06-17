	
package logica;


public class PreguntaDificil extends Decorador{

	
	public PreguntaDificil(IPregunta p, String[] respuestas ){
		super(p);
		this.respuestas = new String[4];
		this.setRespuestas(respuestas);
	}
	@Override
	public void setRespuestas(String[] respuestas) {
		System.out.print(respuestas);
		this.respuestas[0] = this.getPregunta().getRespuestaCorrecta();
		for(int i=1; i<4; i++)
	this.respuestas[i] = respuestas[i-1];
	}


}
