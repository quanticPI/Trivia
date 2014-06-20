package presentacion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import logica.Controlador;

public class Trivia {

	private JFrame frame;
	private JButton btnCrearUsuario, btnJugar, btnVerPuntuacion;
	private Controlador controlador;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Trivia window = new Trivia();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Trivia() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Trivia.class.getResource("/imagenes/interrogante-o-ayuda-049.png")));
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 480, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Fondo f = new Fondo();
		f.setBounds(5, 5, 5, 5);
		frame.setContentPane(f);
		
		btnCrearUsuario = new JButton("Crear Usuario");
		btnCrearUsuario.setBounds(10, 113, 230, 23);
		controlador = Controlador.getInstance();
		
		btnCrearUsuario.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent evt){
				crearUsuarioActionPerformed(evt);
			}
			});
	
		
		btnJugar = new JButton("Jugar");
		btnJugar.setBounds(10, 11, 230, 23);
		
		btnJugar.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent evt){
				jugarActionPerformed(evt);
			}
			});
	
		
		btnVerPuntuacion = new JButton("Ver Puntuaci\u00F3n");
		btnVerPuntuacion.setBounds(10, 166, 230, 23);
		
		btnVerPuntuacion.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				verPuntuacionActionPerformed(evt);
			}
			});
		f.setLayout(null);
	
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnCrearUsuario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(309))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnVerPuntuacion, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(309, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnJugar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(309))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addComponent(btnJugar)
					.addGap(46)
					.addComponent(btnCrearUsuario)
					.addGap(37)
					.addComponent(btnVerPuntuacion)
					.addContainerGap(64, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
				
	}
	


	public void crearUsuarioActionPerformed(ActionEvent evt){
		try{
			crearUsuario su = new crearUsuario(controlador); 
			su.setVisible(true);
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}		

	public void jugarActionPerformed(ActionEvent evt){
		try{
			jugar ju = new jugar(controlador);
			ju.setVisible(true);	
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void verPuntuacionActionPerformed(ActionEvent evt){
		try{
			puntuacion pu = new puntuacion(controlador); 
			pu.cargaPuntuacion(controlador);
			pu.setVisible(true);		
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
}
