package logica;

public class FabricaConcreta extends FabricaJuego {

	public Juego metodoFabrica(String categoria){
		return new JuegoConcreto(categoria);
	}
}