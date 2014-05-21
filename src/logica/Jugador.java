package logica;

public class Jugador {
	
	private String nombre;
	private int acertadasH;
	private int acertadasD;
	private int acertadasC;
	private int acertadasM;
	
	private int falladasH;
	private int falladasD;
	private int falladasC;
	private int falladasM;
	private int total;
	private int puntosActual;
	
	//private presentacion.pregunta observador;
	private Juego juego;
	
	public Jugador(String nombre){
		this.nombre = nombre;
		this.total = 0;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public int getPuntos(){
		return this.total;
	}
	
	public void addPunto(){
		puntosActual += 1;
		notificarObservador();
	}
	
	//la parte del observador
	//notoficar cambios en la puntuacion
	public void notificarObservador(){
		juego.notificar();
	}
	
	public void registrarObs(Juego j){
		juego = j;
	}
	
	public String puntosToString(){
		return ""+this.puntosActual;
	}
	
	//Utilizar despues para refactorizar
	public String puntosToStringg(){
		StringBuilder sb = new StringBuilder();	
		sb.append("");
		sb.append(puntosActual);
		return sb.toString();	
	}
}