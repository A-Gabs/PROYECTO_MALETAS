package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfigurarCuoDiar extends JDialog implements ActionListener {
	private JLabel lblCuotaDiariaEsperada;
	private JTextField txtCuotaDiaria;
	private JButton btnAceptar;
	private JButton btnCancelar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigurarCuoDiar dialog = new ConfigurarCuoDiar();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ConfigurarCuoDiar() {
		setTitle("Configurar cuota diaria");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 316, 109);
		getContentPane().setLayout(null);
		
		lblCuotaDiariaEsperada = new JLabel("Cuota diaria esperada (S/.)");
		lblCuotaDiariaEsperada.setBounds(18, 11, 167, 14);
		getContentPane().add(lblCuotaDiariaEsperada);
		
		txtCuotaDiaria = new JTextField();
		txtCuotaDiaria.setBounds(197, 8, 86, 20);
		getContentPane().add(txtCuotaDiaria);
		txtCuotaDiaria.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(52, 41, 89, 23);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(176, 41, 89, 23);
		getContentPane().add(btnCancelar);
		
		//Declaracion de variable
		txtCuotaDiaria.setText(Tienda.cuotaDiaria + "");
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}
	
	Tienda tienda = new Tienda();
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		double cuo;
		
		if(!tienda.validarDecimal("Cuota Diaria",txtCuotaDiaria))	return;	
		cuo = LeerCuota();
		Tienda.cuotaDiaria = cuo;
		dispose();
	}
	
	double LeerCuota(){
		return Double.parseDouble(txtCuotaDiaria.getText());
	}
	
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
}
