package logica;

public class JuegoDeportes extends Juego{

	
	public JuegoDeportes(){
		this.setCategoria("DEPORTES");
 	}	

	public void ActualizarJugador(Jugador j) {
		j.actualizarTotal();
		j.setAcertadasD(j.getAcertadasD());
		
	}
}
