package logica;

public class JuegoCine extends Juego{
		
	public JuegoCine(){	
		this.setCategoria("CINE");
	}

	@Override
	public void ActualizarJugador(Jugador j) {
		j.setTotal(j.getPuntosActuales());
		j.setAcertadasC(j.getAcertadasC());
		
	}
		
	

}
