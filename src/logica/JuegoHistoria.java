package logica;

public class JuegoHistoria extends Juego{
		
	public JuegoHistoria(){	
		this.setCategoria("HISTORIA");
	}
	public void ActualizarJugador(Jugador j) {
		j.actualizarTotal();
		j.setAcertadasH(j.getAcertadasH());
		
	}


}
