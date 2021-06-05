package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoConsultar extends JDialog implements ActionListener {
	private JLabel lblModelo;
	private JLabel lblPrecio;
	private JLabel lblAncho;
	private JLabel lblAlto;
	private JLabel lblFondo;
	private JLabel lblPeso;
	private JComboBox<String> cboModelo;
	private JTextField txtPrecio;
	private JTextField txtAncho;
	private JTextField txtAlto;
	private JTextField txtFondo;
	private JTextField txtPeso;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogoConsultar dialog = new DialogoConsultar();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DialogoConsultar() {
		setResizable(false);
		setModal(true);
		setTitle("Consultar Maleta");
		setBounds(100, 100, 438, 233);
		getContentPane().setLayout(null);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(12, 15, 46, 14);
		getContentPane().add(lblModelo);
		
		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setBounds(10, 44, 82, 19);
		getContentPane().add(lblPrecio);
		
		lblAncho = new JLabel("Ancho (cm)");
		lblAncho.setBounds(10, 74, 82, 19);
		getContentPane().add(lblAncho);
		
		lblAlto = new JLabel("Alto (cm)");
		lblAlto.setBounds(10, 108, 82, 14);
		getContentPane().add(lblAlto);
		
		lblFondo = new JLabel("Fondo (cm)");
		lblFondo.setBounds(10, 139, 82, 14);
		getContentPane().add(lblFondo);
		
		lblPeso = new JLabel("Peso (kg)");
		lblPeso.setBounds(10, 173, 66, 14);
		getContentPane().add(lblPeso);
		
		cboModelo = new JComboBox<String>();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel<String>(new String[] {"Aviator", "Lucca", "Samsonite", "Century", "Saxoline"}));
		cboModelo.setBounds(105, 12, 135, 20);
		getContentPane().add(cboModelo);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(104, 43, 136, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtAncho = new JTextField();
		txtAncho.setEditable(false);
		txtAncho.setBounds(105, 74, 135, 20);
		getContentPane().add(txtAncho);
		txtAncho.setColumns(10);
		
		txtAlto = new JTextField();
		txtAlto.setEditable(false);
		txtAlto.setBounds(105, 105, 135, 20);
		getContentPane().add(txtAlto);
		txtAlto.setColumns(10);
		
		txtFondo = new JTextField();
		txtFondo.setEditable(false);
		txtFondo.setBounds(105, 136, 135, 20);
		getContentPane().add(txtFondo);
		txtFondo.setColumns(10);
		
		txtPeso = new JTextField();
		txtPeso.setEditable(false);
		txtPeso.setBounds(105, 167, 135, 20);
		getContentPane().add(txtPeso);
		txtPeso.setColumns(10);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(314, 15, 85, 23);
		getContentPane().add(btnCerrar);
		
		//Declaracion de datos
		txtPrecio.setText(Tienda.precio0 + "");
		txtAncho.setText(Tienda.alto0 + "");
		txtAlto.setText(Tienda.ancho0 + "");
		txtFondo.setText(Tienda.fondo0 + "");
		txtPeso.setText(Tienda.peso0 + "");
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboModelo) {
			actionPerformedCboModelo(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnNewButton(e);
		}
	}
	
	protected void actionPerformedBtnNewButton(ActionEvent arg0) {
		dispose();
	}
	
	private void mostrarValores(double precio, int ancho, int alto, int fondo, double peso){
		txtPrecio.setText(String.valueOf(precio));
		txtAncho.setText(Integer.toString(ancho));
		txtAlto.setText(Integer.toString(alto));
		txtFondo.setText(Integer.toString(fondo));
		txtPeso.setText(String.valueOf(peso));
	}
	
	protected void actionPerformedCboModelo(ActionEvent e) {
		int modelo = cboModelo.getSelectedIndex();
		switch (modelo){
			case 0:	mostrarValores(Tienda.precio0, Tienda.ancho0, Tienda.alto0, Tienda.fondo0, Tienda.peso0);	break;
			case 1:	mostrarValores(Tienda.precio1, Tienda.ancho1, Tienda.alto1, Tienda.fondo1, Tienda.peso1);	break;
			case 2:	mostrarValores(Tienda.precio2, Tienda.ancho2, Tienda.alto2, Tienda.fondo2, Tienda.peso2);	break;
			case 3:	mostrarValores(Tienda.precio3, Tienda.ancho3, Tienda.alto3, Tienda.fondo3, Tienda.peso3);	break;
			default:mostrarValores(Tienda.precio4, Tienda.ancho4, Tienda.alto4, Tienda.fondo4, Tienda.peso4);	break;
		}
	}
}
