package logica;

public abstract class Decorador implements IPregunta{

	private IPregunta pregunta;
	
	public Decorador(IPregunta p){
		pregunta = p;
	}
	
	public void setTextoPregunta(String p){
		pregunta.setTextoPregunta(p);
	}
	
	public String getTextoPregunta(){
		return pregunta.getTextoPregunta();
	}
	
	public void setRespuesta(int res){
		pregunta.setRespuesta(res);
	}
}
