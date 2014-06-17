package logica;

public class JuegoHistoria extends Juego{
		
	public JuegoHistoria(){	
		this.setCategoria("HISTORIA");
	}
	public void ActualizarJugador(Jugador j) {
		j.setTotal(j.getPuntosActuales());
		j.setAcertadasH(j.getAcertadasC());
		
	}


}
