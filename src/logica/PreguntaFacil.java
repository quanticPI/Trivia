package logica;


public class PreguntaFacil extends Decorador{
	
	
	public PreguntaFacil(IPregunta p, String[] respuestas){
		super(p);
		this.setRespuestas(respuestas);
	}
	@Override
	public void setRespuestas(String[] respuestas) {
		a�adirRespuesta(respuestas[0]);

	}


	@Override
	public void a�adirRespuesta(String respuesta) {
		this.getPregunta().a�adirRespuesta(respuesta);
		
	}

}
