package persistencia;

import java.util.List;

import logica.Jugador;
import logica.PreguntaDificil;
import logica.PreguntaFacil;
import excepciones.DAOExcepcion;

public interface IPreguntaDAO {


	public List<PreguntaFacil> get_pregunta_facil_por_tema(String tema) throws DAOExcepcion;

	public List<PreguntaDificil> get_pregunta_dificil_por_tema(String tema) throws DAOExcepcion;




}
