package logica;
/*
 * La pregunta a decorar
 */
public class PreguntaBasica implements IPregunta{
	
	protected final static int SINCATEGORIA = 0;	
	protected final static int HISTORIA = 1;
	protected final static int DEPORTES = 2;
	protected final static int CINE = 3;
	protected final static int MUSICA = 4;
	protected int cat;
	protected String tipo;
	//el texto de la pregunta
	private String textoPregunta;
	// array con las posibles respuestas
	//private String[] respuestas;
	// indice de la respuesta correcta
	//PARA REFACTORIZAR
	private int respuestaCorrecta;	
	
	
	//Constructor
	public PreguntaBasica(){
		this.textoPregunta = "";
		this.respuestaCorrecta = 0;
		this.cat = SINCATEGORIA;
		//for(int i=0; i<numPreguntas; i++)
		//	respuestas[0]="";
	}
	
	public void setTextoPregunta(String p){
		this.textoPregunta = p;
	}
	
	public String getTextoPregunta(){
		return this.textoPregunta;
	}
	
	public void setRespuesta(int res){
		this.respuestaCorrecta = res;
	}
	
	public int getRespuestaCorrecta(){
		return this.respuestaCorrecta;
	}

}
