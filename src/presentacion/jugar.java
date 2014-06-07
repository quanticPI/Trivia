package presentacion;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import logica.Jugador;

@SuppressWarnings("serial")
public class jugar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JLabel lblUsuario2;
	private JRadioButton radioButton1;
	private JRadioButton radioButton2;
	private JComboBox<Jugador> comboBoxUsuario;
	private JComboBox<Jugador> comboBoxUsuario2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jugar dialog = new jugar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jugar() {
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
		
		JComboBox comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar Categoria", "Historia", "Cine", "Musica", "Deportes"}));
		JLabel lblDificultad = new JLabel("Dificultad:");
		JComboBox comboBoxDificultad = new JComboBox();
		comboBoxDificultad.setToolTipText("");
		comboBoxDificultad.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar Dificultad", "F\u00E1cil", "Dif\u00EDcil"}));
		
		JLabel lblUsuario1 = new JLabel("Usuario 1:");
		
		comboBoxUsuario = new JComboBox<Jugador>();
		comboBoxUsuario.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar Usuario"}));
		comboBoxUsuario.setToolTipText("");
		
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
	
	private void buscarJugadores(final Controlador controlador){
		java.util.List<Jugador> jugadores = null;		
		try{
			jugadores = controlador.encontrarJugadores();
		}
		catch(Exception e){e.printStackTrace();}		
		comboBoxUsuario.addItem(jugadores.iterator().next()); // refactor with Jugador item = jugadores.iterator().next(); ... .addItem(item);
	}
}
