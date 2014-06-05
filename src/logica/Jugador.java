package logica;

import java.util.ArrayList;
import java.util.Iterator;

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
	private ArrayList<Observer> observadores = new ArrayList<Observer>();
	
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
		Iterator<Observer> iter = observadores.iterator();
		observadores.iterator().next().actualizar(puntosToString());	
	}
	
	public void registrarObs(Observer o){
		observadores.add(o);
	}
	
	public void detachObs(Observer o){
		observadores.remove(o);
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