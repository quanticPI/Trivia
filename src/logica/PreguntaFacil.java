package logica;

import java.util.ArrayList;
import java.util.List;

public class PreguntaFacil extends Decorador{
	
	
	public PreguntaFacil(IPregunta p, String[] respuestas){
		super(p);
		this.respuestas = new String[2];
		this.setRespuestas(respuestas);
	}
	@Override
	public void setRespuestas(String[] respuestas) {
		for(int i=0; i<2;i++)
	
	this.respuestas[i] = respuestas[i];
	}
	@Override
	public String[] getRespuestas() {
		return respuestas;
	}



}
