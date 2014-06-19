package presentacion;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import logica.Controlador;
import logica.FabricaConcreta;
import logica.FabricaJuego;
import logica.IPregunta;
import logica.Juego;
import logica.Jugador;
import logica.Observer;
import logica.PreguntaBasica;
import logica.PreguntaDificil;
import logica.PreguntaFacil;
import excepciones.DAOExcepcion;
import excepciones.LogicaExcepcion;

@SuppressWarnings("serial")
public class jugar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JLabel lblUsuario2;
	private JRadioButton radioButton1;
	private JRadioButton radioButton2;
	private JComboBox comboBoxUsuario;
	private JComboBox comboBoxUsuario2;
	private JComboBox comboBoxCategoria;
	private JComboBox comboBoxDificultad;
	private FabricaJuego fabricaJuego;
	private Juego juego;
	private Observer ob;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			jugar dialog = new jugar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 * @throws LogicaExcepcion 
	 */
	public jugar(final Controlador controlador) throws LogicaExcepcion {

		setResizable(false);
		setTitle("Jugar");
		setBounds(100, 100, 478, 327);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		{
			lblUsuario2 = new JLabel("Usuario 2:");
		}
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton empezarButton = new JButton("Empezar");
				empezarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							empezarJuego(controlador);
						} catch (LogicaExcepcion e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (DAOExcepcion e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						

					}
				});
				empezarButton.setActionCommand("");
				buttonPane.add(empezarButton);
				getRootPane().setDefaultButton(empezarButton);
			}
			{
				JButton cancelarButton = new JButton("Cancelar");
				cancelarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelarButton.setActionCommand("Cancelar");
				buttonPane.add(cancelarButton);
			}
		}
		
		comboBoxUsuario2 = new JComboBox();
		comboBoxUsuario2.setEnabled(false);
		comboBoxUsuario2.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar Usuario"}));

		
		JLabel lblCategoria = new JLabel("Categoria:");
		
		comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar Categoria", "Historia", "Cine", "Musica", "Deportes"}));
		JLabel lblDificultad = new JLabel("Dificultad:");
		comboBoxDificultad = new JComboBox();
		comboBoxDificultad.setToolTipText("");
		comboBoxDificultad.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar Dificultad", "Facil", "Dificil"}));
		
		JLabel lblUsuario1 = new JLabel("Usuario 1:");
		
		comboBoxUsuario = new JComboBox();
		comboBoxUsuario.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar Usuario"}));
		comboBoxUsuario.setToolTipText("");
		ArrayList<Jugador> jugadores = controlador.encontrarJugadores();
		Iterator<Jugador> iterador = jugadores.iterator();
		while(iterador.hasNext()){
			String nombre = iterador.next().getNombre();
		this.comboBoxUsuario2.addItem(nombre);
		this.comboBoxUsuario.addItem(nombre);

		}
		
		JLabel lblNDeUsuarios = new JLabel("N\u00BA de Usuarios:");
		
		radioButton1 = new JRadioButton("1");
		radioButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				radioButton1.setSelected(true);
				if(radioButton2.isSelected())
					radioButton2.setSelected(false);
				if(comboBoxUsuario2.isEnabled())
					comboBoxUsuario2.setEnabled(false);
			}
		});
		radioButton1.setSelected(true);
		radioButton2 = new JRadioButton("2");
		radioButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				radioButton2.setSelected(true);
				comboBoxUsuario2.setEnabled(true);
				if(radioButton1.isSelected())
					radioButton1.setSelected(false);
			}
		});
		
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(81)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
									.addComponent(lblUsuario2)
									.addComponent(lblCategoria))
								.addGap(31))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addComponent(lblUsuario1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
								.addGap(18)))
						.addComponent(lblDificultad)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNDeUsuarios)))
					.addGap(25)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(radioButton1)
							.addGap(11)
							.addComponent(radioButton2))
						.addComponent(comboBoxCategoria, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(comboBoxUsuario2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(comboBoxDificultad, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(comboBoxUsuario, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(87, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNDeUsuarios)
						.addComponent(radioButton2)
						.addComponent(radioButton1))
					.addPreferredGap(ComponentPlacement.UNRELATED, 11, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxUsuario, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsuario1))
					.addGap(13)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxUsuario2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsuario2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxCategoria, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCategoria))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxDificultad, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDificultad))
					.addGap(39))
		);
		contentPanel.setLayout(gl_contentPanel);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(276, Short.MAX_VALUE)
					.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addGap(12))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
					.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11))
		);
		getContentPane().setLayout(groupLayout);
	}
	
	public void empezarJuego(final Controlador controlador) throws LogicaExcepcion, DAOExcepcion{
		fabricaJuego = new FabricaConcreta();
		juego = fabricaJuego.metodoFabrica(comboBoxCategoria.getSelectedItem().toString());
		Jugador[] j = new Jugador[2];
		j[0] = controlador.encontrarJugador( comboBoxUsuario.getSelectedItem().toString());
		if (this.radioButton2.isSelected()){
			j[1] = controlador.encontrarJugador( comboBoxUsuario2.getSelectedItem().toString());
		}
		juego.setJugadores(j);
		//juego.setCategoria(comboBoxCategoria.getSelectedItem().toString());
		ArrayList<PreguntaBasica> pB = controlador.get_preguntas_por_tema(juego.getCategoria());
		PreguntaBasica[] preguntas = pB.toArray(new PreguntaBasica[10]);
		IPregunta[] preguntaDecorada = new IPregunta[10];
		String dif = this.get_dificultad();
		if (dif.equals("Facil")) {
			for (int i =0; i < preguntas.length; i++){
				String[] res =  controlador.get_respuestas(preguntas[i]);
				IPregunta p = new PreguntaFacil(preguntas[i], res);
				preguntaDecorada[i] = p ;
			}
			
		} else if (dif.equals("Dificil")){
			for (int i =0; i < preguntas.length; i++){
				IPregunta p = new PreguntaDificil(preguntas[i], controlador.get_respuestas(preguntas[i]));
				preguntaDecorada[i] = p ;
			} 
		}
	 	juego.setPreguntas(preguntaDecorada);
	 
	 
		try {
			pregunta pregWindow1 = new pregunta(controlador, juego, dif, j[0]);
			pregWindow1.setVisible(true);
			pregWindow1.setTitle("Jugador 1");
			j[0].registrarObs(pregWindow1);
			
			if (this.radioButton2.isSelected()){
			pregunta pregWindow2 = new pregunta(controlador, juego, dif, j[1]);
			pregWindow2.setVisible(true);
			pregWindow2.setTitle("Jugador 2");
			j[0].registrarObs(pregWindow2);

			j[1].registrarObs(pregWindow1);
			j[1].registrarObs(pregWindow2);


			pregWindow2.setLocation(pregWindow1.getX()+pregWindow1.getWidth(), pregWindow1.getY());
			}

			dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public String get_dificultad(){
		return comboBoxDificultad.getSelectedItem().toString();
	}

}
