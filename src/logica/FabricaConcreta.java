package logica;

public class FabricaConcreta extends FabricaJuego {

	public Juego metodoFabrica(int categoria){
		return new JuegoConcreto(categoria);
	}
}