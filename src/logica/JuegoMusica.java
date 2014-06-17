package logica;

public class JuegoMusica extends Juego{
		
	public JuegoMusica(){	
		this.setCategoria("MUSICA");
	}
		
	public void ActualizarJugador(Jugador j) {
		j.setTotal(j.getPuntosActuales());
		j.setAcertadasM(j.getAcertadasC());
		
	}

}
