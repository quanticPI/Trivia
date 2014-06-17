package logica;


public class PreguntaFacil extends Decorador{
	
	
	public PreguntaFacil(IPregunta p, String[] respuestas){
		super(p);
		this.setRespuestas(respuestas);
	}
	@Override
	public void setRespuestas(String[] respuestas) {
		añadirRespuesta(respuestas[0]);

	}


	@Override
	public void añadirRespuesta(String respuesta) {
		this.getPregunta().añadirRespuesta(respuesta);
		
	}

}
