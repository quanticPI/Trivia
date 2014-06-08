package persistencia;

import java.util.ArrayList;
import java.util.List;

import logica.PreguntaBasica;
import logica.PreguntaDificil;
import logica.PreguntaFacil;
import excepciones.DAOExcepcion;

public interface IPreguntaDAO {


	public ArrayList<PreguntaBasica> get_preguntas_por_tema(String tema) throws DAOExcepcion;

	public String[] get_respuestas(PreguntaBasica pB) throws DAOExcepcion;




}
