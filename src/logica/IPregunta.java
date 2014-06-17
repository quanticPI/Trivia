package logica;


public interface IPregunta {
	
	public void setTextoPregunta(String pregunta);
	public String getTextoPregunta();
	public String getRespuestaCorrecta();
	public boolean compararRespuesta(String resp);
	public  String[] getRespuestas();
	public String getRespuesta(int i);
	public void añadirRespuesta(String respuesta);
}
