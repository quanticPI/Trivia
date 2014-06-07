package logica;
/*
 * La pregunta a decorar
 */
public class PreguntaBasica implements IPregunta{
		
	protected String cat;
	//el texto de la pregunta
	private String textoPregunta;
	// array con las posibles respuestas
	//private String[] respuestas;
	// indice de la respuesta correcta
	//PARA REFACTORIZAR
	private String respuestaCorrecta;	
	
	
	//Constructor
	public PreguntaBasica(){
		this.textoPregunta = "";
		this.respuestaCorrecta = "";
		//for(int i=0; i<numPreguntas; i++)
		//	respuestas[0]="";
	}
	
	public String getCat() {
		return this.cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	
	public void setTextoPregunta(String p){
		this.textoPregunta = p;
	}
	
	public String getTextoPregunta(){
		return this.textoPregunta;
	}
	
	public void setRespuesta(String res){
		this.respuestaCorrecta = res;
	}
	
	public String getRespuestaCorrecta(){
		return this.respuestaCorrecta;
	}

}
