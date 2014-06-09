package presentacion;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import logica.Controlador;
import logica.IPregunta;
import logica.Juego;
import logica.Jugador;
import logica.Observer;
import java.awt.Font;
import java.awt.Component;
import java.util.Enumeration;

import javax.swing.Box;

@SuppressWarnings("serial")
public class pregunta extends JFrame implements Observer {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblPuntosRival;
	private JLabel lblMisPuntos;
	private Juego juego;
	private IPregunta preguntaActual;
	private JTextArea textArea;
	private JRadioButton botonRes3;
	private int i = 1;


	/**
	 * Create the frame.
	 */
	public pregunta(final Controlador controlador, Juego juego, String dif, final Jugador j) {
		this.juego = juego;
		setTitle("Pregunta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		initialize();
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		textArea.setWrapStyleWord(true);
		
		final IPregunta p = juego.getPregunta(0);
		preguntaActual = p;
		textArea.setText(p.getTextoPregunta());
		
		JRadioButton botonRes1 = new JRadioButton("New radio button");
		botonRes1.setText(p.getRespuesta(0));
		botonRes1.setActionCommand(botonRes1.getText());
		buttonGroup.add(botonRes1);
		
		JRadioButton botonRes2 = new JRadioButton("New radio button");
		botonRes2.setText(p.getRespuesta(1));
		botonRes2.setActionCommand(botonRes2.getText());
		buttonGroup.add(botonRes2);
		
		botonRes3 = new JRadioButton("New radio button");
		buttonGroup.add(botonRes3);
		botonRes3.setActionCommand(botonRes3.getText());
		botonRes3.setVisible(false);

		
		JRadioButton botonRes4 = new JRadioButton("New radio button");
		buttonGroup.add(botonRes4);
		botonRes4.setActionCommand(botonRes4.getText());
		botonRes4.setVisible(false);

		 
		if(dif.equals("Dificil")){
		botonRes3.setText(p.getRespuesta(2));
		botonRes3.setVisible(true);
		botonRes4.setText(p.getRespuesta(3));
		botonRes4.setVisible(true);

		}
		
		lblPuntosRival = new JLabel("New label");
		//lblPuntosRival.setText("Jugador2 lleva  0 puntos");
		if (juego.getJugador(1) ==  null){ lblPuntosRival.setVisible(false);}
		else lblPuntosRival.setText("Jugador " +  juego.getJugador(1).getNombre() + " lleva 0 puntos");
	
		lblMisPuntos = new JLabel("New label");
		lblMisPuntos.setText("Jugador " +  juego.getJugador(0).getNombre() + " lleva 0 puntos" );
		
		JButton btnOk = new JButton("Responder");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String respuesta = buttonGroup.getSelection().getActionCommand();
				if(preguntaActual.compararRespuesta(respuesta)){
					j.addPunto();
					cambiarPregunta();
				}
				else JOptionPane.showMessageDialog(rootPane, "Respuesta incorrecta", "Error", EXIT_ON_CLOSE);
			}
			
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(294)
					.addComponent(lblPuntosRival))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(294)
					.addComponent(lblMisPuntos))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(158)
					.addComponent(botonRes1))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(158)
					.addComponent(botonRes2))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(158)
					.addComponent(botonRes3))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(158)
					.addComponent(botonRes4)
					.addGap(117)
					.addComponent(btnOk))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(lblPuntosRival)
					.addComponent(lblMisPuntos)
					.addGap(41)
					.addComponent(botonRes1)
					.addComponent(botonRes2)
					.addComponent(botonRes3)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(botonRes4)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(btnOk))))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void initialize(){
		
	}
	
	private void cambiarPregunta(){
		preguntaActual = juego.getPregunta(i);
		textArea.setText(preguntaActual.getTextoPregunta());
		int aux = 4;
		if(!botonRes3.isVisible())
			aux = 2;
		Enumeration<AbstractButton> botones = buttonGroup.getElements();
		while(botones.hasMoreElements()){
			for(int j = 0; j<aux; j++){
				botones.nextElement().setText(preguntaActual.getRespuesta(j));				
			}
		}
		i++;
	}

	@Override
	public void actualizar() {
		Jugador	jugador0 = juego.getJugador(0);
		lblMisPuntos.setText("Jugador " + jugador0.getNombre() + " lleva " + jugador0.getPuntosActuales() + " puntos");
		if (!(juego.getJugador(1) == null)){
		Jugador jugador1 = juego.getJugador(1);
		lblPuntosRival.setText("Jugador " + jugador1.getNombre() + " lleva " + jugador1.getPuntosActuales() + " puntos");
		
		
	}}
}
