package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarMaleta extends JDialog implements ActionListener {
	private JButton btnCerrar;
	private JButton btnGrabar;
	private JLabel lblModelo;
	private JLabel lblPrecio;
	private JLabel lblAncho;
	private JLabel lblAlto;
	private JLabel lblFondo;
	private JLabel lblPeso;
	private JComboBox<String> cmbModelo;
	private JTextField txtPrecio;
	private JTextField txtAncho;
	private JTextField txtAlto;
	private JTextField txtFondo;
	private JTextField txtPeso;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarMaleta dialog = new ModificarMaleta();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ModificarMaleta() {
		setModal(true);
		setResizable(false);
		setTitle("Modificar Maleta");
		setBounds(100, 100, 450, 229);
		getContentPane().setLayout(null);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(330, 11, 89, 23);
		getContentPane().add(btnCerrar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(330, 45, 89, 23);
		getContentPane().add(btnGrabar);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 15, 46, 14);
		getContentPane().add(lblModelo);
		
		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setBounds(10, 49, 70, 14);
		getContentPane().add(lblPrecio);
		
		lblAncho = new JLabel("Ancho (cm)");
		lblAncho.setBounds(10, 74, 70, 14);
		getContentPane().add(lblAncho);
		
		lblAlto = new JLabel("Alto (cm)");
		lblAlto.setBounds(10, 105, 70, 14);
		getContentPane().add(lblAlto);
		
		lblFondo = new JLabel("Fondo (cm)");
		lblFondo.setBounds(10, 134, 70, 14);
		getContentPane().add(lblFondo);
		
		lblPeso = new JLabel("Peso (kg)");
		lblPeso.setBounds(10, 163, 54, 17);
		getContentPane().add(lblPeso);
		
		cmbModelo = new JComboBox<String>();
		cmbModelo.addActionListener(this);
		cmbModelo.setModel(new DefaultComboBoxModel<String>(new String[] {"Aviator", "Lucca", "Samsonite", "Century", "Saxoline"}));
		cmbModelo.setBounds(92, 12, 133, 20);
		getContentPane().add(cmbModelo);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(92, 43, 133, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtAncho = new JTextField();
		txtAncho.setBounds(92, 71, 133, 20);
		getContentPane().add(txtAncho);
		txtAncho.setColumns(10);
		
		txtAlto = new JTextField();
		txtAlto.setBounds(92, 102, 133, 20);
		getContentPane().add(txtAlto);
		txtAlto.setColumns(10);
		
		txtFondo = new JTextField();
		txtFondo.setBounds(92, 131, 133, 20);
		getContentPane().add(txtFondo);
		txtFondo.setColumns(10);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(92, 161, 133, 20);
		getContentPane().add(txtPeso);
		txtPeso.setColumns(10);
		
		//Declaracion de datos
		txtPrecio.setText(Tienda.precio0 + "");
		txtAncho.setText(Tienda.alto0 + "");
		txtAlto.setText(Tienda.ancho0 + "");
		txtFondo.setText(Tienda.fondo0 + "");
		txtPeso.setText(Tienda.peso0 + "");
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
		if (arg0.getSource() == cmbModelo) {
			actionPerformedCmbModelo(arg0);
		}
	}
	
	private void mostrarValores(double precio, int ancho, int alto, int fondo, double peso){
		txtPrecio.setText(String.valueOf(precio));
		txtAncho.setText(Integer.toString(ancho));
		txtAlto.setText(Integer.toString(alto));
		txtFondo.setText(Integer.toString(fondo));
		txtPeso.setText(String.valueOf(peso));
	}
	
	//No me permite ver los datos inmediatamente
	protected void actionPerformedCmbModelo(ActionEvent arg0) {
		int modelo = cmbModelo.getSelectedIndex();
		switch (modelo){
			case 0:	mostrarValores(Tienda.precio0, Tienda.ancho0, Tienda.alto0, Tienda.fondo0, Tienda.peso0);	break;
			case 1:	mostrarValores(Tienda.precio1, Tienda.ancho1, Tienda.alto1, Tienda.fondo1, Tienda.peso1);	break;
			case 2:	mostrarValores(Tienda.precio2, Tienda.ancho2, Tienda.alto2, Tienda.fondo2, Tienda.peso2);	break;
			case 3:	mostrarValores(Tienda.precio3, Tienda.ancho3, Tienda.alto3, Tienda.fondo3, Tienda.peso3);	break;
			default:mostrarValores(Tienda.precio4, Tienda.ancho4, Tienda.alto4, Tienda.fondo4, Tienda.peso4);	break;
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		dispose();
	 }
	//@SuppressWarnings("unused")
	Tienda tienda = new Tienda();
	protected void actionPerformedBtnGrabar(ActionEvent arg0) {
		if(!tienda.validarDecimal("Precio",txtPrecio))	return;
		if(!tienda.validarEntero("Ancho",txtAncho))		return;
		if(!tienda.validarEntero("Alto",txtAlto))		return;
		if(!tienda.validarEntero("Fondo",txtFondo))		return;
		if(!tienda.validarDecimal("Peso",txtPeso))		return;
		
		if(cmbModelo.getSelectedIndex() == 0){
			Tienda.precio0 = Double.parseDouble(txtPrecio.getText());
			Tienda.ancho0 = Integer.parseInt(txtAncho.getText());
			Tienda.alto0 = Integer.parseInt(txtAlto.getText());
			Tienda.fondo0 = Integer.parseInt(txtFondo.getText());
			Tienda.peso0 = Double.parseDouble(txtPeso.getText());
		} else if(cmbModelo.getSelectedIndex() == 1){
			Tienda.precio1 = Double.parseDouble(txtPrecio.getText());
			Tienda.ancho1 = Integer.parseInt(txtAncho.getText());
			Tienda.alto1 = Integer.parseInt(txtAlto.getText());
			Tienda.fondo1 = Integer.parseInt(txtFondo.getText());
			Tienda.peso1 = Double.parseDouble(txtPeso.getText());
		} else if(cmbModelo.getSelectedIndex() == 2){
			Tienda.precio2 = Double.parseDouble(txtPrecio.getText());
			Tienda.ancho2 = Integer.parseInt(txtAncho.getText());
			Tienda.alto2 = Integer.parseInt(txtAlto.getText());
			Tienda.fondo2 = Integer.parseInt(txtFondo.getText());
			Tienda.peso2 = Double.parseDouble(txtPeso.getText());
		} else if(cmbModelo.getSelectedIndex() == 3){
			Tienda.precio3 = Double.parseDouble(txtPrecio.getText());
			Tienda.ancho3 = Integer.parseInt(txtAncho.getText());
			Tienda.alto3 = Integer.parseInt(txtAlto.getText());
			Tienda.fondo3 = Integer.parseInt(txtFondo.getText());
			Tienda.peso3 = Double.parseDouble(txtPeso.getText());
		} else {
			Tienda.precio4 = Double.parseDouble(txtPrecio.getText());
			Tienda.ancho4 = Integer.parseInt(txtAncho.getText());
			Tienda.alto4 = Integer.parseInt(txtAlto.getText());
			Tienda.fondo4 = Integer.parseInt(txtFondo.getText());
			Tienda.peso4 = Double.parseDouble(txtPeso.getText());
		} 
		dispose();
	}
}

