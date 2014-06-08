package persistencia;


import java.util.ArrayList;

import excepciones.DAOExcepcion;
import logica.Jugador;
import logica.PreguntaBasica;
import logica.PreguntaDificil;
import logica.PreguntaFacil;

public class DAL {
	
		private static DAL dal;
		private IPreguntaDAO preguntaDAO;
		private IJugadorDAO jugadorDAO;

		
		// constructor privado
		private DAL() throws DAOExcepcion {
			// Objectos para comunicarse con la capa de acceso a datos
			preguntaDAO = PreguntaDAOImp.dameDAO();
			jugadorDAO = JugadorDAOImp.dameDAO();
			
		}

		// Patrón Singleton
		public static DAL dameDAL() throws DAOExcepcion {
			if (dal == null)
				dal = new DAL();
			return dal;
		}

		public void crearJugador(String nombre) throws DAOExcepcion {
			jugadorDAO.crearJugador(nombre);
		}
		public Jugador encontrarJugador(String nombre)throws DAOExcepcion {
			return jugadorDAO.encontrarJugador(nombre);

		}

		public ArrayList<Jugador> encontrarJugadores() throws DAOExcepcion {
			return jugadorDAO.encontrarJugadores();
		}

		public ArrayList<PreguntaBasica> get_preguntas_por_tema(String tema) throws DAOExcepcion {
			// TODO Auto-generated method stub
			return preguntaDAO.get_preguntas_por_tema(tema);
		}
		
		public  String[] get_respuestas(PreguntaBasica pB) throws DAOExcepcion {
			// TODO Auto-generated method stub
			return preguntaDAO.get_respuestas(pB);
		}

		public void actualizarJugador(Jugador j) throws DAOExcepcion {
			// TODO Auto-generated method stub
			jugadorDAO.actualizarJugador(j);
		}
		

		}
		
