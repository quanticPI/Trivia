package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import excepciones.*;
import logica.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class puntuacion extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tablePuntuacion;

	/**
	 * Launch the application.
	 */
	/*

	public static void main(String[] args) {
		try {
			puntuacion dialog = new puntuacion(control);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	
	public puntuacion(final Controlador control) throws LogicaExcepcion, DAOExcepcion{
		setBounds(130, 130, 433, 352);	
		setTitle("Consultar Puntuaci\u00F3n");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{309, 117, 0};
		gridBagLayout.rowHeights = new int[]{291, 29, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		getContentPane().add(scrollPane, gbc_scrollPane);
		
		tablePuntuacion = new JTable(new PuntuacionTableModel());
		scrollPane.setViewportView(tablePuntuacion);
		
		JButton aceptarButton = new JButton("Aceptar");
		aceptarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					dispose();
				}
				catch (Exception e){
					e.printStackTrace();
					
				}
			}
		});
		
		JButton avanzadaButton = new JButton("Puntuaci\u00F3n Avanzada");
		avanzadaButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				try{
					puntuacionAvanzada puAvan = new puntuacionAvanzada(control); 
					puAvan.setVisible(true);	
					
				}
				catch (Exception e){
					e.printStackTrace();
				}
			}
			
		});
		GridBagConstraints gbc_avanzadaButton = new GridBagConstraints();
		gbc_avanzadaButton.anchor = GridBagConstraints.NORTHEAST;
		gbc_avanzadaButton.insets = new Insets(0, 0, 0, 5);
		gbc_avanzadaButton.gridx = 0;
		gbc_avanzadaButton.gridy = 1;
		getContentPane().add(avanzadaButton, gbc_avanzadaButton);
		GridBagConstraints gbc_aceptarButton = new GridBagConstraints();
		gbc_aceptarButton.anchor = GridBagConstraints.NORTH;
		gbc_aceptarButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_aceptarButton.gridx = 1;
		gbc_aceptarButton.gridy = 1;
		getContentPane().add(aceptarButton, gbc_aceptarButton);
	}
	
	public void cargaPuntuacion(final Controlador control){ 
		try{
			List<Jugador> listaJugador= control.encontrarJugadores(); 
			Iterator<Jugador>it= listaJugador.iterator();
			Jugador ju;
			PuntuacionTableModel model = (PuntuacionTableModel) tablePuntuacion.getModel(); 
			model.clear();
			while (it.hasNext()){
				ju=it.next(); 
				model.addRow(ju);
			}
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(this,e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
		} 
	}
	
	
	class PuntuacionTableModel extends AbstractTableModel {
		
		private static final long serialVersionUID = 1L;
		private String[] columnNames = { "Usuario", "Puntuaci—n"};
		private ArrayList<Jugador> data = new ArrayList<Jugador>();
		
		public int getColumnCount(){ 
			return columnNames.length;
		}
		
		public int getRowCount(){ 
			return data.size();
		}
		
		public String getColumnName(int col){
			return columnNames[col]; 
		}
		
		public Object getValueAt(int row, int col){ 
			Jugador ju = data.get(row);
			switch(col){
				case 0: return ju.getNombre();
				case 1: return ju.getPuntos();
				default: return null;
			}
		}
		
		public void clear(){ 
			data.clear();
		}
		
		public Class<? extends Object> getColumnClass(int c){ 
			return getValueAt(0, c).getClass();
		}
		
		public void addRow(Jugador row){
			data.add(row); 
			this.fireTableDataChanged();
		}
		
		public void delRow(int row){
			data.remove(row); 
			this.fireTableDataChanged();
		} 
	}
}
