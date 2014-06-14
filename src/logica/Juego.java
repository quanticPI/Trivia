package logica;

public abstract class Juego {
	

	private String categoria;
	private IPregunta[] preguntas;
	private Jugador[] jugadores;
	
	//public abstract void setCategoria(String categoria);
	public  String getCategoria(){
		return this.categoria;
	};
	public  void setCategoria(String cat){
		 this.categoria = cat;
	};
	//TO DO
	public void setPreguntas(IPregunta[] p ){
		this.preguntas = p;
	}
	
	public IPregunta[] getPreguntas(){
		return this.preguntas;
	}
	//TO DO
	public IPregunta getPregunta(int i){
		return preguntas[i];
	}
	
	public Jugador getJugador(int pos){
		return this.jugadores[pos];
	}
	
	public void setJugadores(Jugador[] j){
		this.jugadores  = j; //poner if si no hay espacio
	}
}