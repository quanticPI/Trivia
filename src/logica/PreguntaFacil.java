package logica;


public class PreguntaFacil extends Decorador{
	
	
	public PreguntaFacil(IPregunta p, String[] respuestas){
		super(p);
		this.setRespuestas(respuestas);
	}
	@Override
	public void setRespuestas(String[] respuestas) {
		anadirRespuesta(respuestas[0]);

	}


	@Override
	public void anadirRespuesta(String respuesta) {
		this.getPregunta().anadirRespuesta(respuesta);
		
	}

}
