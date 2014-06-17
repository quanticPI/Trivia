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

	public ArrayList<PreguntaBasica> get_preguntas_por_tema(String tema)
			throws DAOExcepcion {
		ArrayList<PreguntaBasica > listaPreguntas  = new ArrayList<PreguntaBasica>();
	
		connManager.connect();
		ResultSet rs = connManager.queryDB("SELECT * FROM PREGUNTA P where P.CATEGORIA =  '"
							+ tema + "' ORDER BY RAND() LIMIT 10");
		connManager.close();

		try {
			while (rs.next()) {
				PreguntaBasica pB = new PreguntaBasica();
				pB.setTextoPregunta(rs.getString("Texto_Pregunta"));
				pB.setRespuestaCorrecta(rs.getString("Respuesta_Correcta"));
				pB.setCat(tema);
						
				listaPreguntas.add(pB);
			}
			return listaPreguntas;
		} catch (Exception e) {
			throw new DAOExcepcion(e);
		}
	
		
		// TODO Auto-generated method stub
	
	}

	public String[] get_respuestas(PreguntaBasica pB)
			throws DAOExcepcion {
		String[] respuestas  = new String[3];
	
		connManager.connect();
		ResultSet rs = connManager.queryDB("SELECT * FROM PREGUNTA P where P.Texto_Pregunta =  '"
				+ pB.getTextoPregunta()  + "'");
		connManager.close();

		try {
			if (rs.next()) {
				
				respuestas[0] = rs.getString("Respuesta_Falsa1");	
				respuestas[1] = rs.getString("Respuesta_Falsa2");		
				respuestas[2] = rs.getString("Respuesta_Falsa3");		
			}
			return respuestas;
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
