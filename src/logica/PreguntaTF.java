package logica;

public class PreguntaTF extends Pregunta{
	
	//el texto de la pregunta
	private String textoPregunta;
	private String respuesta;
		
	public PreguntaTF(){
		textoPregunta = "";
		respuesta = "";
	}
	
	public PreguntaTF(String texto, String res){
		this.textoPregunta = texto;
		respuesta = res;
	}
	
	public void setPregunta(String pregunta){
		textoPregunta = pregunta;
	}
	
	public String getPregunta(){
		return this.textoPregunta;
	}
	
	public void setRespuesta(String res){
		this.respuesta = res;
	}
}
