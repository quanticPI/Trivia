package logica;

public class Jugador {
	
	private String nombre;
	private int puntos;
	
	public Jugador(String nombre){
		this.nombre = nombre;
		this.puntos = 0;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public int getPuntos(){
		return this.puntos;
	}
	
	public void addPunto(){
		puntos += 1;
	}
}
