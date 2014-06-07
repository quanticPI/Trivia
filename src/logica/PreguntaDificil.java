package logica;

public class PreguntaDificil extends Decorador{
	
	//private String[] respuestas = new String[4];
	private int j = 0;
	//private int respuestaCorrecta;
	
	public PreguntaDificil(IPregunta p){
		super(p);
		for(int i = 2; i < 4; i++)
			respuestas[0]="";
	}
	
	public void setPosibleRespuesta(String res){
		if(j < 2){
			respuestas[j] = res;
			j++;
		}
		else System.out.print("No puede insertar mas respuestas");
	}
	
	public void setRespuesta(String res){
		super.setRespuesta(res);
	}
	
	public String getTextoPregunta(){
		return super.getTextoPregunta();
	}
	
	public boolean compararRespuesta(String res){
		if(super.getRespuestaCorrecta().equals(res))
			return true;
		return false;
	}
}
