package persistencia;

import java.util.List;

import logica.Jugador;
import excepciones.DAOExcepcion;

public interface IJugadorDAO {
	public void crearJugador (String nombre) throws DAOExcepcion;
	public void actualizarJugador(Jugador j) throws DAOExcepcion;
	public List<Jugador> encontrarJugadores() throws DAOExcepcion;
	public Jugador encontrarJugador(String nombre) throws DAOExcepcion ;
	public void modificarJugador(Jugador j);
}
