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
	
	private ArrayList<Observer> observadores = new ArrayList<Observer>();
	
	public Jugador(String nombre){
		this.nombre = nombre;
		this.puntosActual = 0;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public int getPuntos(){
		return this.total;
	}
	
	public int getAcertadasH() {
		return acertadasH;
	}

	public void setAcertadasH(int acertadasH) {
		this.acertadasH = acertadasH;
	}
	
	public void actualizarAcertadasH(int acertadasH) {
		this.acertadasH += acertadasH;
	}

	public int getAcertadasD() {
		return acertadasD;
	}

	public void setAcertadasD(int acertadasD) {
		this.acertadasD = acertadasD;
	}
	
	public void actualizarAcertadasD(int acertadasD) {
		this.acertadasD += acertadasD;
	}

	public int getAcertadasC() {
		return acertadasC;
	}

	public void setAcertadasC(int acertadasC) {
		this.acertadasC = acertadasC;
	}

	public void actualizarAcertadasC(int acertadasC) {
		this.acertadasC += acertadasC;
	}
	
	public int getAcertadasM() {
		return acertadasM;
	}

	public void setAcertadasM(int acertadasM) {
		this.acertadasM = acertadasM;
	}
	
	public void actualizarAcertadasM(int acertadasM) {
		this.acertadasM += acertadasM;
	}

	public int getFalladasH() {
		return falladasH;
	}

	public void setFalladasH(int falladasH) {
		this.falladasH += falladasH;
	}

	public int getFalladasD() {
		return falladasD;
	}

	public void setFalladasD(int falladasD) {
		this.falladasD += falladasD;
	}

	public int getFalladasC() {
		return falladasC;
	}

	public void setFalladasC(int falladasC) {
		this.falladasC += falladasC;
	}

	public int getFalladasM() {
		return falladasM;
	}

	public void setFalladasM(int falladasM) {
		this.falladasM += falladasM;
	}

	public void addPunto(){
		puntosActual += 1;
		notificarObservador();
	}
	
	//la parte del observador
	//notoficar cambios en la puntuacion
	public void notificarObservador(){
		Iterator<Observer> iter = observadores.iterator();
		while (iter.hasNext()){
		iter.next().actualizar();	
		}
	}
	
	public int getPuntosActuales() {
		return puntosActual;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	public void actualizarTotal() {
		this.total += getPuntosActuales();
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
}