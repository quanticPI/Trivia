package presentacion;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class trivial {

	private JFrame frame;
	private JButton btnCrearUsuario, btnJugar, btnVerPuntuacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					trivial window = new trivial();
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
	public trivial() {
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
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnVerPuntuacion, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
						.addComponent(btnCrearUsuario, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
						.addComponent(btnJugar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(298))
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
			crearUsuario su = new crearUsuario(); 
			su.setVisible(true);		
			crearUsuario ventanaCrear = new crearUsuario();
			ventanaCrear.setVisible(true);
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}		

	public void jugarActionPerformed(ActionEvent evt){
		try{
			jugar ju = new jugar(); 
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
}
