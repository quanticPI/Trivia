package presentacion;

import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import excepciones.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import logica.Controlador;
import logica.Jugador;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class puntuacionAvanzada extends JDialog {

	private JPanel contentPane;
	private JTable tablePuntuacionAvanzada;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			puntuacionAvanzada dialog = new puntuacionAvanzada(control);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	
	public puntuacionAvanzada(final Controlador control) throws LogicaExcepcion, DAOExcepcion{
		setBounds(130, 130, 639, 311);	
		setTitle("Consultar Puntuaci\u00F3n Avanzada");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{5, 0};
		gridBagLayout.rowHeights = new int[]{5, 5, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		
		tablePuntuacionAvanzada = new JTable(new PuntuacionTableModel());
		scrollPane.setViewportView(tablePuntuacionAvanzada);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		getContentPane().add(scrollPane, gbc_scrollPane);
		
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
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{tablePuntuacionAvanzada, scrollPane, aceptarButton}));
		GridBagConstraints gbc_aceptarButton = new GridBagConstraints();
		gbc_aceptarButton.anchor = GridBagConstraints.NORTHEAST;
		gbc_aceptarButton.gridx = 0;
		gbc_aceptarButton.gridy = 1;
		getContentPane().add(aceptarButton, gbc_aceptarButton);
	}
	
	
	public void cargaPuntuacion(final Controlador control){ 
		try{
			List<Jugador> listaJugador= control.encontrarJugadores(); 
			Iterator<Jugador> it= listaJugador.iterator();
			Jugador ju;
			PuntuacionTableModel model = (PuntuacionTableModel) tablePuntuacionAvanzada.getModel(); 
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
		private String[] columnNames = { "Usuario", "Cine Acertadas", "Cine Falladas", "Deporte Acertadas", "Deporte Falladas", "Historia Acertadas", "Historia Falladas", "Mœsica Acertadas", "Mœsica Falladas", "Total Acertadas"};
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
				case 1: return ju.getAcertadasC(); 
				case 2:	return ju.getFalladasC();
				case 3: return ju.getAcertadasD(); 
				case 4:	return ju.getFalladasD();
				case 5: return ju.getAcertadasH(); 
				case 6:	return ju.getFalladasH();
				case 7: return ju.getAcertadasM(); 
				case 8:	return ju.getFalladasM();
				case 9:return ju.getPuntos();
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
