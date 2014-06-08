package presentacion;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import logica.Controlador;
import logica.IPregunta;
import logica.Juego;

@SuppressWarnings("serial")
public class pregunta extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();



	/**
	 * Create the frame.
	 */
	public pregunta(final Controlador controlador, Juego juego, String dif) {
		setTitle("Pregunta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		initialize();
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		
			int i = 0; 	//TODO
			IPregunta p = juego.getPregunta(i);
			textArea.setText(p.getTextoPregunta());

		
		JRadioButton botonRes1 = new JRadioButton("New radio button");
		botonRes1.setText(p.getRespuesta(0));
		buttonGroup.add(botonRes1);
		
		JRadioButton botonRes2 = new JRadioButton("New radio button");
		botonRes2.setText(p.getRespuesta(1));
		buttonGroup.add(botonRes2);
		
		JRadioButton botonRes3 = new JRadioButton("New radio button");
		buttonGroup.add(botonRes3);
		botonRes3.setVisible(false);

		
		JRadioButton botonRes4 = new JRadioButton("New radio button");
		buttonGroup.add(botonRes4);
		botonRes4.setVisible(false);

		 
		if(dif.equals("Difícil")){
		botonRes3.setText(p.getRespuesta(2));
		botonRes3.setVisible(true);
		botonRes4.setText(p.getRespuesta(3));
		botonRes4.setVisible(true);

		}
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(158)
					.addComponent(botonRes4)
					.addContainerGap(157, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
					.addGap(12))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(158)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(botonRes1)
						.addComponent(botonRes2)
						.addComponent(botonRes3))
					.addContainerGap(157, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
					.addGap(31)
					.addComponent(botonRes1)
					.addComponent(botonRes2)
					.addComponent(botonRes3)
					.addComponent(botonRes4)
					.addGap(21))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void initialize(){
		
	}
	

}
