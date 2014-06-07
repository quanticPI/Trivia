package logica;

public class PreguntaFacil extends Decorador{
	
	//private String[] respuestas = new String[2];
	private int j = 0;
	
	public PreguntaFacil(IPregunta p){
		super(p);
		for(int i = 0; i < 2; i++)
			super.respuestas[i]="";
	}
	
	public void setPosibleRespuesta(String res){
		if(j < 2){
			respuestas[j] = res;
			j++;
		}
		else System.out.print("No puede insertat mas respuestas");
	}
	
	public void setRespuesta(String res){
		super.setRespuesta(res);
	}
	
	public String getTextoPregunta(){
		return super.getTextoPregunta();
	}
	
	public void setCategoria(int cat){
		
	}
	
	public boolean respuestaOK(String res){
		if(super.getRespuestaCorrecta().equals(res))
			return true;
		return false;
	}
}
