package logica;

public class JuegoConcreto extends Juego{
	/*
	protected final static int SINCATEGORIA = 0;	
	protected final static int HISTORIA = 1;
	protected final static int DEPORTES = 2;
	protected final static int CINE = 3;
	protected final static int MUSICA = 4;
	*/
	private IPregunta[] preguntas;

	public JuegoConcreto(int categoria){
		super.categoria = categoria;
		preguntas = new IPregunta[10];
	}
		
	public void setPregunta(IPregunta p, int i){
		preguntas[i] = p;
	}
	
	public IPregunta getPregunta(int i){
		return preguntas[i];
	}
	
	public void setCategoria(int categoria){
		super.categoria = categoria;
	}
	
	public int getCategoria(){
		return super.categoria;
	}
}
