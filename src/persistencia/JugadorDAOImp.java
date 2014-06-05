package persistencia;

import java.util.List;

import logica.Jugador;
import excepciones.DAOExcepcion;

public class JugadorDAOImp implements IJugadorDAO{

	@Override
	public void crearJugador(String nombre) throws DAOExcepcion {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarJugador(Jugador j) throws DAOExcepcion {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Jugador> encontrarJugadores() throws DAOExcepcion {
		// TODO Auto-generated method stub
		return null;
	}

	public static JugadorDAOImp dameDAO() throws DAOExcepcion {
		// TODO Auto-generated method stub
		JugadorDAOImp instancia = null;
		instancia = new JugadorDAOImp();
		return instancia;

	}

	
	public Jugador encontrarJugador(String nombre) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return null;
	}
}
