package logica;



public class FabricaConcreta extends FabricaJuego {

	public Juego metodoFabrica(String categoria){
		if(categoria.equalsIgnoreCase("Historia")) return new JuegoHistoria();
		if(categoria.equalsIgnoreCase("Cine")) return new JuegoCine();
		if(categoria.equalsIgnoreCase("Deportes")) return new JuegoDeportes();
		return new JuegoMusica();
	}
}