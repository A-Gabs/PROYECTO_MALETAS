package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfigurarObsequios extends JDialog implements ActionListener {
	private JLabel lblA;
	private JLabel lblB;
	private JLabel lblC;
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtC;
	private JButton btnAceptar;
	private JButton btnCancelar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigurarObsequios dialog = new ConfigurarObsequios();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ConfigurarObsequios() {
		setTitle("Configurar obsequios");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 130);
		getContentPane().setLayout(null);
		
		lblA = new JLabel("1 unidad");
		lblA.setBounds(10, 11, 88, 14);
		getContentPane().add(lblA);
		
		lblB = new JLabel("2 a 5 unidades");
		lblB.setBounds(10, 36, 88, 14);
		getContentPane().add(lblB);
		
		lblC = new JLabel("6 a m\u00E1s unidades");
		lblC.setBounds(10, 61, 101, 14);
		getContentPane().add(lblC);
		
		txtA = new JTextField();
		txtA.setBounds(134, 8, 121, 20);
		getContentPane().add(txtA);
		txtA.setColumns(10);
		
		txtB = new JTextField();
		txtB.setBounds(134, 33, 121, 20);
		getContentPane().add(txtB);
		txtB.setColumns(10);
		
		txtC = new JTextField();
		txtC.setBounds(134, 58, 121, 20);
		getContentPane().add(txtC);
		txtC.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(327, 11, 89, 23);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(327, 52, 89, 23);
		getContentPane().add(btnCancelar);
		
		//Declaracion de variables
		txtA.setText(Tienda.obsequio1);
		txtB.setText(Tienda.obsequio2);
		txtC.setText(Tienda.obsequio3);
	}
    
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
	}
	protected void actionPerformedBtnCancelar(ActionEvent e){
		dispose();
	}
	
	Tienda tienda = new Tienda();
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		if(!tienda.validarVacio("1 unidad",txtA))			return; 
		if(!tienda.validarVacio("2 a 5 unidades",txtB))		return;
		if(!tienda.validarVacio("6 a mas unidades",txtC))	return;
			
		Tienda.obsequio1 = txtA.getText();
		Tienda.obsequio2 = txtB.getText();
		Tienda.obsequio3 = txtC.getText();
			
		dispose();
	}
}
	
	
	

