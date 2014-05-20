package logica;

/**
 * @author Nikolay
 * No se utiliza ya.
 * La dejo por si acaso.
 */
public class Pregunta {	
	
	//fijar una respuesta posible
	public void setRespuestaPosible(String text, int num){
		respuestas[num] = text;
	}
	
	public void setRespuesta(int res){
		this.respuestaCorrecta = res;
	}

	//devolver respuesta correcta
	public String responder(){
		return this.respuestas[respuestaCorrecta];
	}
	
	public boolean compararRespuesta(String res_jugador){
		if (this.respuestas[respuestaCorrecta].equals(res_jugador))
			return true;
		return false;
	}
	
	public void setTipo(int cat){
		this.cat = cat;
	}
	
	public int getTipo(){
		return cat;
	}
}
