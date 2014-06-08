package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import excepciones.*;
import logica.*;

public class puntuacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Controlador control;
	private JTable tablePuntuacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			puntuacion dialog = new puntuacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public puntuacion() throws LogicaExcepcion, DAOExcepcion{
		setBounds(130, 130, 760, 348);	
		setTitle("Consultar Puntuacion");
		control = Controlador.getInstance();
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 749, 314);
		getContentPane().add(scrollPane);
		
		tablePuntuacion = new JTable(new PuntuacionTableModel());
		scrollPane.setViewportView(tablePuntuacion);
	}
	
	public void cargaPuntuacion(){ 
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
