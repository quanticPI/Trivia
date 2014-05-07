package logica;

public class PreguntaAbierta extends Pregunta {
	
	private String textoPregunta;
	private String respuesta;
	
	public PreguntaAbierta(int tipo){
		this.textoPregunta = "";
		this.respuesta = "";
		super.tipo = tipo;
	}
	
	public PreguntaAbierta(String texto, String res){
		this.textoPregunta = texto;
		this.respuesta = res;
	}
	
	public void setPregunta(String p){
		this.textoPregunta = p;
	}
	
	public String getPregunta(){
		return this.textoPregunta;
	}
	
	public void setRespuesta(String res){
		this.respuesta = res;
	}
	
	public boolean compararRespuesta(String res_jugador){
		if (this.respuesta.equals(res_jugador))
			return true;
		return false;
	}
	
}
