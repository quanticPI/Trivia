package persistencia;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import logica.PreguntaBasica;
import logica.PreguntaDificil;
import logica.PreguntaFacil;
import excepciones.DAOExcepcion;

public class PreguntaDAOImp implements IPreguntaDAO{
	private ConnectionManager connManager;

	public PreguntaDAOImp() throws DAOExcepcion {
		try {
			connManager = new ConnectionManager("practica4");

		} catch (ClassNotFoundException e) {
			throw new DAOExcepcion(e);
		}
	}

	public List<PreguntaFacil> get_pregunta_facil_por_tema(String tema)
			throws DAOExcepcion {
		ArrayList<PreguntaFacil> listaPreguntas  = new ArrayList<PreguntaFacil>();
	
		connManager.connect();
		ResultSet rs = connManager.queryDB("SELECT * FROM PREGUNTA P where P.CATEGORIA =  '"
							+ tema + "' ORDER BY RAND() LIMIT 10");
		connManager.close();

		try {
			while (rs.next()) {
				PreguntaBasica pB = new PreguntaBasica();
				pB.setTextoPregunta(rs.getString("Texto_Pregunta"));
				pB.setRespuesta(rs.getString("Respuesta_Correcta"));
				pB.setCat(tema);
				PreguntaFacil p = new PreguntaFacil(pB);
				p.setPosibleRespuesta(rs.getString("Respuesta_Correcta"));
				p.setPosibleRespuesta(rs.getString("Respuesta_Falsa1"));		
				listaPreguntas.add(p);
			}
			return listaPreguntas;
		} catch (Exception e) {
			throw new DAOExcepcion(e);
		}
	
		
		// TODO Auto-generated method stub
	
	}

	public List<PreguntaDificil> get_pregunta_dificil_por_tema(String tema)
			throws DAOExcepcion {
		ArrayList<PreguntaDificil> listaPreguntas  = new ArrayList<PreguntaDificil>();
	
		connManager.connect();
		ResultSet rs = connManager.queryDB("SELECT * FROM PREGUNTA P where P.CATEGORIA =  '"
				+ tema + "' ORDER BY RAND() LIMIT 10");
		connManager.close();

		try {
			while (rs.next()) {
				PreguntaBasica pB = new PreguntaBasica();
				pB.setTextoPregunta(rs.getString("Texto_Pregunta"));
				pB.setRespuesta(rs.getString("Respuesta_Correcta"));
				pB.setCat(tema);
				PreguntaDificil p = new PreguntaDificil(pB);
				p.setPosibleRespuesta(rs.getString("Respuesta_Correcta"));
				p.setPosibleRespuesta(rs.getString("Respuesta_Falsa1"));	
				p.setPosibleRespuesta(rs.getString("Respuesta_Falsa2"));		
				p.setPosibleRespuesta(rs.getString("Respuesta_Falsa3"));		
				listaPreguntas.add(p);
			}
			return listaPreguntas;
		} catch (Exception e) {
			throw new DAOExcepcion(e);
		}
	
		
		// TODO Auto-generated method stub
	}

	public static PreguntaDAOImp dameDAO() throws DAOExcepcion {
		// TODO Auto-generated method stub
		PreguntaDAOImp instancia = null;
		instancia = new PreguntaDAOImp();
		return instancia;

	}
	


}
