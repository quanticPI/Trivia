package logica;



public class FabricaConcreta extends FabricaJuego {

	public Juego metodoFabrica(String categoria){
		if(categoria.equals("Historia")) return new JuegoHistoria();
		if(categoria.equals("Cine")) return new JuegoCine();
		if(categoria.equals("Deportes")) return new JuegoDeportes();
		return new JuegoMusica();
	}
}