package presentacion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import logica.Controlador;
import logica.FabricaConcreta;
import logica.FabricaJuego;
import logica.Juego;

public class Trivia {

	private JFrame frame;
	private JButton btnCrearUsuario, btnJugar, btnVerPuntuacion;
	private Controlador controlador;
	
	private FabricaJuego fabricaJuego;
	private Juego juego;
	private jugar jugarDialog;
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
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(51, 153, 204));
		frame.setBounds(100, 100, 450, 260);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnCrearUsuario = new JButton("Crear Usuario");
		
		
		btnCrearUsuario.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent evt){
				crearUsuarioActionPerformed(evt);
			}
			});
	
		
		btnJugar = new JButton("Jugar");
		
		btnJugar.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent evt){
				jugarActionPerformed(evt);
			}
			});
	
		
		btnVerPuntuacion = new JButton("Ver Puntuaci\u00F3n");
		
		btnVerPuntuacion.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				verPuntuacionActionPerformed(evt);
			}
			});
	
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnVerPuntuacion, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
						.addComponent(btnCrearUsuario, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
						.addComponent(btnJugar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
					.addGap(308))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(57)
					.addComponent(btnJugar)
					.addGap(28)
					.addComponent(btnCrearUsuario)
					.addGap(29)
					.addComponent(btnVerPuntuacion)
					.addContainerGap(49, Short.MAX_VALUE))
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
			puntuacion pu = new puntuacion(); 
			pu.setVisible(true);		
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void empezarJuego(){
		fabricaJuego = new FabricaConcreta();
		juego = fabricaJuego.metodoFabrica(jugarDialog.get_categoria());
		try {
			juego.setJugador(controlador.encontrarJugador(jugarDialog.get_jugador()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
