package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logica.Jugador;
import excepciones.DAOExcepcion;

public class JugadorDAOImp implements IJugadorDAO{
	private ConnectionManager connManager;

	public JugadorDAOImp() throws DAOExcepcion {
		try {
			connManager = new ConnectionManager("practica4");

		} catch (ClassNotFoundException e) {
			throw new DAOExcepcion(e);
		}
	}

	@Override
	public void crearJugador(String nombre) throws DAOExcepcion {
		// TODO Auto-generated method stub
		try {
			connManager.connect();

			connManager
					.updateDB("insert into USUARIO (NOMBRE, CINE_ACERTADAS, CINE__FALLADAS, DEPORTE_ACERTADAS, DEPORTE_FALLADAS, HISTORIA_ACERTADAS, HISTORIA_FALLADAS, MUSICA_ACERTADAS, MUSICA__FALLADAS, PUNTUACION_TOTAL)values('" 
							+ nombre 
							+ "','"
							+0
							+ "','"
							+0
							+ "','"
							+0
							+ "','"
							+0
							+ "','"
							+0
							+ "','"
							+0
							+ "','"
							+0
							+ "','"
							+0
							+ "','"
							+ 0
							+ "')");

			connManager.close();
		} catch (Exception e) {
			throw new DAOExcepcion(e);
		}
		
	}

	@Override
	public void actualizarJugador(Jugador j) throws DAOExcepcion {
		// TODO Auto-generated method stub
		try {
			connManager.connect();

			connManager
					.updateDB("insert into USUARIO (NOMBRE, CINE_ACERTADAS, CINE__FALLADAS, DEPORTE_ACERTADAS, DEPORTE_FALLADAS, HISTORIA_ACERTADAS, HISTORIA_FALLADAS, MUSICA_ACERTADAS, MUSICA__FALLADAS, PUNTUACION_TOTAL)values('"
							+ j.getNombre()
							+ "','"
							+ j.getAcertadasC()
							+ "','"
							+j.getFalladasC()
							+ "','"
							+j.getAcertadasD()
							+ "','"
							+j.getFalladasD()
							+ "','"
							+j.getAcertadasH()
							+ "','"
							+j.getFalladasH()
							+ "','"
							+j.getAcertadasM()
							+ "','"
							+j.getFalladasM()
							+ "','"
							+ j.getPuntos()
							+ "')");

			connManager.close();
		} catch (Exception e) {
			throw new DAOExcepcion(e);
		}
		
	}

	@Override
	public ArrayList<Jugador> encontrarJugadores() throws DAOExcepcion {
		// TODO Auto-generated method stub

		connManager.connect();
		ResultSet rs = connManager.queryDB("select * from USUARIO");
		connManager.close();

		ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();
		try {
			while (rs.next()) {
				Jugador j = encontrarJugador(rs
						.getString("nombre"));
				listaJugadores.add(j);
			}
			return listaJugadores;
		} catch (Exception e) {
			throw new DAOExcepcion(e);
		}
	
	}


	
	public Jugador encontrarJugador(String nombre) throws DAOExcepcion {
		// TODO Auto-generated method stub
		try {
			connManager.connect();

			ResultSet rs = connManager
					.queryDB("select * from USUARIO where NOMBRE= '"
							+ nombre + "'");
			connManager.close();
			if (rs.next()){
				Jugador j = new Jugador(nombre);
				j.setAcertadasC(rs.getInt("CINE_ACERTADAS"));
				j.setAcertadasH(rs.getInt("HISTORIA_ACERTADAS"));
				j.setAcertadasD(rs.getInt("DEPORTE_ACERTADAS"));
				j.setAcertadasM(rs.getInt("MUSICA_ACERTADAS"));
				j.setFalladasC(rs.getInt("CINE__FALLADAS"));
				j.setFalladasH(rs.getInt("HISTORIA_FALLADAS"));
				j.setFalladasD(rs.getInt("DEPORTE_FALLADAS"));
				j.setFalladasM(rs.getInt("MUSICA__FALLADAS"));
				j.setTotal(rs.getInt("PUNTUACION_TOTAL"));
				return j;
			}
				else
				return null;
		} catch (SQLException e) {
			throw new DAOExcepcion(e);
		}
	}


	public static JugadorDAOImp dameDAO() throws DAOExcepcion {
		// TODO Auto-generated method stub
		JugadorDAOImp instancia = null;
		instancia = new JugadorDAOImp();
		return instancia;

	}

}
