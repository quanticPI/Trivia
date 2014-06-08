package logica;
/*
 * La pregunta a decorar
 */
public class PreguntaBasica implements IPregunta{
	
	private String respuestaCorrecta;
	private String cat;
	private String textoPregunta;
	

	//Constructor
	public PreguntaBasica(){

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
	}
	
	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}
	

	@Override
	public boolean compararRespuesta(String resp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setRespuestas(String[] respuestas) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[] getRespuestas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRespuesta(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
