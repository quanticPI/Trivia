package logica;

public class JuegoHistoria extends Juego{
	
	private IPregunta[] preguntas;
	private Jugador[] jugadores;
	private final String categoria = "Historia";
	
	public JuegoHistoria(){
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
	
	public String getCategoria(){
		return this.categoria;
	}
}
