package logica;

import java.util.ArrayList;
import java.util.List;

import persistencia.DAL;
import excepciones.DAOExcepcion;
import excepciones.LogicaExcepcion;

public class Controlador {
	
	private static Controlador instance;
	private DAL dal;

	private Controlador() throws LogicaExcepcion {
		try {
			// Objeto para comunicarse con la capa de acceso a datos
			dal = DAL.dameDAL();
		} catch (DAOExcepcion e) {
			throw new LogicaExcepcion(e);
		}
	}
	public static Controlador getInstance() {
		if(instance==null){
			try {
				instance=new Controlador();
			} catch (LogicaExcepcion e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return instance;
	}

	public void crearJugador(String nombre) throws LogicaExcepcion {

		try {
			if (dal.encontrarJugador(nombre) == null)
				dal.crearJugador(nombre);
			else
				throw new LogicaExcepcion("Jugador EXISTE");
		} catch (DAOExcepcion e) {
			throw new LogicaExcepcion(e);
		}

	}
	
	public Jugador encontrarJugador(String nombre) throws LogicaExcepcion{
		try{
			return dal.encontrarJugador(nombre); 				
		}
		catch(DAOExcepcion e){
			throw new LogicaExcepcion(e);
		}
	}

	public ArrayList<Jugador> encontrarJugadores() throws LogicaExcepcion {
		try {
			return dal.encontrarJugadores();
		} catch (DAOExcepcion e) {
			throw new LogicaExcepcion(e);
		}
	}
	public ArrayList<PreguntaBasica> get_preguntas_por_tema(String tema) throws LogicaExcepcion, DAOExcepcion {
		return dal.get_preguntas_por_tema(tema);
	}
	public String[]	 get_respuestas(PreguntaBasica pB) throws DAOExcepcion {
		return dal.get_respuestas(pB);
	}
	
	public void actualizarJugador(Jugador j) throws DAOExcepcion{
	dal.actualizarJugador(j);
	}
}
