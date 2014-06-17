package logica;
/*
 * La pregunta a decorar
 */
public class PreguntaBasica implements IPregunta{
	
	private String respuestaCorrecta;
	private String cat;
	private String textoPregunta;
	private String[] respuestas;
	private int num_respuestas = 1;
	

	//Constructor
	public PreguntaBasica(){
		this.respuestas = new String[4];

	}

	public void setTextoPregunta(String p){
		this.textoPregunta = p;
	}
	
	public String getTextoPregunta(){
		return this.textoPregunta;
	}

	
	
	public String getRespuestaCorrecta(){
		return this.respuestaCorrecta;
	}
	
	public void setRespuestaCorrecta(String res){
		 this.respuestaCorrecta = res;
		 this.respuestas[0] = respuestaCorrecta;

	}


	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}
	

	public boolean compararRespuesta(String resp) {
		return this.getRespuestaCorrecta().equals(resp);	
	}



	@Override
	public String[] getRespuestas() {
 		
		return this.respuestas;
	}

	@Override
	public String getRespuesta(int i) {
		// TODO Auto-generated method stub
		return this.respuestas[i];
	} 
	
	public void añadirRespuesta(String respuesta){
		this.respuestas[num_respuestas] = respuesta;
		num_respuestas++;
	}
	


}
