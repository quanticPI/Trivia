package presentacion;


import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import logica.Controlador;
import logica.IPregunta;
import logica.Juego;
import logica.Jugador;
import logica.Observer;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class pregunta extends JFrame implements Observer {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblPuntosRival;
	private JLabel lblMisPuntos;
	private Juego juego;
	private IPregunta preguntaActual;


	/**
	 * Create the frame.
	 */
	public pregunta(final Controlador controlador, Juego juego, String dif) {
		this.juego = juego;
		setTitle("Pregunta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		initialize();
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		
			int i = 0; 	//TODO
			IPregunta p = juego.getPregunta(i);
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
		
		JRadioButton botonRes3 = new JRadioButton("New radio button");
		buttonGroup.add(botonRes3);
		botonRes3.setActionCommand(botonRes3.getText());
		botonRes3.setVisible(false);

		
		JRadioButton botonRes4 = new JRadioButton("New radio button");
		buttonGroup.add(botonRes4);
		botonRes4.setActionCommand(botonRes4.getText());
		botonRes4.setVisible(false);

		 
		if(dif.equals("Difícil")){
		botonRes3.setText(p.getRespuesta(2));
		botonRes3.setVisible(true);
		botonRes4.setText(p.getRespuesta(3));
		botonRes4.setVisible(true);

		}
		 
		if(dif.equals("Difícil")){
		botonRes3.setText(p.getRespuesta(2));
		botonRes3.setVisible(true);
		botonRes4.setText(p.getRespuesta(3));
		botonRes4.setVisible(true);

		}
		
		JLabel lblPuntosRival = new JLabel("New label");
		lblPuntosRival.setText("Jugador2 lleva  0 puntos");
		if (juego.getJugador(1) ==  null){ lblPuntosRival.setVisible(false);}

	
		JLabel lblMisPuntos = new JLabel("New label");
		lblMisPuntos.setText("Jugador " +  juego.getJugador(0).getNombre() + " lleva 0 puntos" );
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("correcto");
				String respuesta = buttonGroup.getSelection().getActionCommand();
				System.out.print(respuesta);

				if(preguntaActual.compararRespuesta(respuesta) == true)
					System.out.print("correcto");
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(158)
							.addComponent(botonRes4))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(158)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(botonRes1)
								.addComponent(botonRes2)
								.addComponent(botonRes3))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblPuntosRival)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnOk)
									.addComponent(lblMisPuntos)))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(botonRes1)
						.addComponent(lblPuntosRival))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(botonRes2)
						.addComponent(lblMisPuntos))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(botonRes3)
							.addComponent(botonRes4)
							.addGap(21))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnOk)
							.addContainerGap())))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void initialize(){
		
	}

	@Override
	public void actualizar() {
		Jugador	jugador0 = juego.getJugador(0);
		lblMisPuntos.setText("Jugador" + jugador0.getNombre() + " lleva " + jugador0.getPuntos() + " puntos");
		if (!juego.getJugador(1).equals(null)){
		Jugador jugador1 = juego.getJugador(1);
		lblPuntosRival.setText("Jugador " + jugador1.getNombre() + "lleva " + jugador1.getPuntos() + " puntos");
		
		
	}}
}
