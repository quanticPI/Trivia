	
package logica;


public class PreguntaDificil extends Decorador{

	
	public PreguntaDificil(IPregunta p, String[] respuestas ){
		super(p);
		this.setRespuestas(respuestas);
	}
	@Override
	public void setRespuestas(String[] respuestas) {
		for(int i=0; i<3; i++)
		a�adirRespuesta(respuestas[i]);

	}


	@Override
	public void a�adirRespuesta(String respuesta) {
		this.getPregunta().a�adirRespuesta(respuesta);
		
	}

}
