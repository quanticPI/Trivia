package logica;

public class PreguntaTF extends Pregunta{
	
	//el texto de la pregunta
	//private String textoPregunta;
	private boolean respuesta;
	
	public PreguntaTF(int tipo){
		super.textoPregunta = "";
		respuesta = false;
		super.tipo = tipo;
	}
	
	public PreguntaTF(String texto, boolean res, int tipo){
		super.textoPregunta = texto;
		respuesta = res;
		super.setTipo(tipo);
	}
	
	public void setPregunta(String pregunta){
		super.textoPregunta = pregunta;
	}
	
	public String getPregunta(){
		return super.textoPregunta;
	}
	
	public void setRespuesta(boolean res){
		this.respuesta = res;
	}
	
	public boolean responder(){
		return this.respuesta;
	}
	
	public boolean compararRespuesta(boolean res_jugador){
		if (this.respuesta == res_jugador)
			return true;
		return false;
	}
}
