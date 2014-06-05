package persistencia;

import java.util.List;

import logica.PreguntaDificil;
import logica.PreguntaFacil;
import excepciones.DAOExcepcion;

public class PreguntaDAOImp implements IPreguntaDAO{

	public List<PreguntaFacil> get_pregunta_facil_por_tema(String tema)
			throws DAOExcepcion {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public  List<PreguntaDificil> get_pregunta_dificil_por_tema(String tema)
			throws DAOExcepcion {
		// TODO Auto-generated method stub
		return null;
	}

	public static PreguntaDAOImp dameDAO() throws DAOExcepcion {
		// TODO Auto-generated method stub
		PreguntaDAOImp instancia = null;
		instancia = new PreguntaDAOImp();
		return instancia;

	}
	


}
