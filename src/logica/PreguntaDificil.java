	
package logica;


public class PreguntaDificil extends Decorador{

	
	public PreguntaDificil(IPregunta p, String[] respuestas ){
		super(p);
		this.respuestas = new String[4];
		this.setRespuestas(respuestas);
	}
	@Override
	public void setRespuestas(String[] respuestas) {
		for(int i=0; i<4; i++)
	this.respuestas[i] = respuestas[i];
	}
	@Override
	public String[] getRespuestas() {
		return respuestas;
	}


}
