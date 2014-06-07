package logica;

public abstract class Juego {
	
	//protected final static int SINCATEGORIA = 0;	
	//protected final static int HISTORIA = 1;
	//protected final static int DEPORTES = 2;
	//protected final static int CINE = 3;
	//protected final static int MUSICA = 4;
	private String categoria;
	
	public abstract void setPregunta(IPregunta p, int i);
	public abstract IPregunta getPregunta(int i);
	//public abstract void setCategoria(String categoria);
	public abstract String getCategoria();
	public abstract void setJugador(Jugador j);
	public abstract Jugador getJugador(int pos);
	
}
