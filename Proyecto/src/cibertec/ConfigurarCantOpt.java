package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfigurarCantOpt extends JDialog implements ActionListener {
	private JLabel lblCantidadptimaDe;
	private JTextField txtCOUV;
	private JButton btnAceptar;
	private JButton btnCancelar;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigurarCantOpt dialog = new ConfigurarCantOpt();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ConfigurarCantOpt() {
		setTitle("Configurar cantidad \u00F3ptima");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 337, 106);
		getContentPane().setLayout(null);
		
		lblCantidadptimaDe = new JLabel("Cantidad \u00F3ptima de unidades vendidas");
		lblCantidadptimaDe.setBounds(12, 11, 229, 14);
		getContentPane().add(lblCantidadptimaDe);
		
		txtCOUV = new JTextField();
		txtCOUV.setBounds(257, 8, 53, 20);
		getContentPane().add(txtCOUV);
		txtCOUV.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(47, 38, 89, 23);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(193, 38, 89, 23);
		getContentPane().add(btnCancelar);
		
		//txtCOUV = Cantidad Optima de Unidad Vendida
		//Declaracion de variables
		txtCOUV.setText(Tienda.cantidadOptima + "");
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
	
	Tienda tienda = new Tienda();
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		if(!tienda.validarEntero("Cantidad Optima",txtCOUV))	return;	
		Tienda.cantidadOptima = leerCantidad();
		dispose();
	}
	
	int leerCantidad(){
		return Integer.parseInt(txtCOUV.getText());
	}
	
}
