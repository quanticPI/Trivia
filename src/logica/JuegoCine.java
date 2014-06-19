package logica;

public class JuegoCine extends Juego{
		
	public JuegoCine(){	
		this.setCategoria("CINE");
	}

	@Override
	public void ActualizarJugador(Jugador j) {
		j.actualizarTotal();
		j.setAcertadasC(j.getAcertadasC());
		
	}
		
	

}
