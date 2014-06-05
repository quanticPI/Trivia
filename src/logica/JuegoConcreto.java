package logica;

import presentacion.pregunta;
import presentacion.trivial;

public class JuegoConcreto extends Juego{
	/*
	protected final static int HISTORIA = 1;
	protected final static int DEPORTES = 2;
	protected final static int CINE = 3;
	protected final static int MUSICA = 4;
	*/
	private IPregunta[] preguntas;
	private Jugador[] jugadores;
	
	public JuegoConcreto(int categoria){
		super.categoria = categoria;
		preguntas = new IPregunta[10];
		jugadores = new Jugador[2]; 	
	}
		
	public void setPregunta(IPregunta p, int i){
		preguntas[i] = p;
	}
	
	public IPregunta getPregunta(int i){
		return preguntas[i];
	}
	
	public Jugador getJugador(int pos){
		return this.jugadores[pos];
	}
	
	public void setJugador(Jugador j){
		this.jugadores[jugadores.length] = j; //poner if si no hay espacio
	}
	
	public void setCategoria(int categoria){
		super.categoria = categoria;
	}
	
	public int getCategoria(){
		return super.categoria;
	}
		
}
