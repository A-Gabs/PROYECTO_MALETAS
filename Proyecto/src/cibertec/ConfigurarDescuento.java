package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfigurarDescuento extends JDialog implements ActionListener {
	private JTextField txtA;
	private JLabel lblA;
	private JLabel lblB;
	private JTextField txtB;
	private JLabel lblC;
	private JTextField txtC;
	private JLabel lblD;
	private JTextField txtD;
	private JLabel lblA1;
	private JLabel lblB1;
	private JLabel lblC1;
	private JLabel lblD1;
	private JButton btnAceptar;
	private JButton btnCancelar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigurarDescuento dialog = new ConfigurarDescuento();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ConfigurarDescuento() {
		setTitle("Configurar porcentajes de descuento");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 150);
		getContentPane().setLayout(null);
		
		txtA = new JTextField();
		txtA.setBounds(134, 11, 116, 20);
		getContentPane().add(txtA);
		txtA.setColumns(10);
		
		lblA = new JLabel("1 a 5 unidades");
		lblA.setBounds(10, 14, 124, 14);
		getContentPane().add(lblA);
		
		lblB = new JLabel("6 a 10 unidades");
		lblB.setBounds(10, 39, 124, 14);
		getContentPane().add(lblB);
		
		txtB = new JTextField();
		txtB.setBounds(134, 36, 116, 20);
		getContentPane().add(txtB);
		txtB.setColumns(10);
		
		lblC = new JLabel("11 a 15 unidades");
		lblC.setBounds(10, 64, 124, 14);
		getContentPane().add(lblC);
		
		txtC = new JTextField();
		txtC.setBounds(134, 61, 116, 20);
		getContentPane().add(txtC);
		txtC.setColumns(10);
		
		lblD = new JLabel("M\u00E1s de 15 unidades");
		lblD.setBounds(10, 89, 124, 14);
		getContentPane().add(lblD);
		
		txtD = new JTextField();
		txtD.setBounds(134, 86, 116, 20);
		getContentPane().add(txtD);
		txtD.setColumns(10);
		
		lblA1 = new JLabel("%");
		lblA1.setBounds(260, 14, 46, 14);
		getContentPane().add(lblA1);
		
		lblB1 = new JLabel("%");
		lblB1.setBounds(260, 39, 46, 14);
		getContentPane().add(lblB1);
		
		lblC1 = new JLabel("%");
		lblC1.setBounds(260, 64, 46, 14);
		getContentPane().add(lblC1);
		
		lblD1 = new JLabel("%");
		lblD1.setBounds(260, 89, 46, 14);
		getContentPane().add(lblD1);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(331, 10, 89, 23);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(331, 35, 89, 23);
		getContentPane().add(btnCancelar);
		
		//Datos a la panatalla
		txtA.setText(Tienda.porcentaje1 + "");
		txtB.setText(Tienda.porcentaje2 + "");
		txtC.setText(Tienda.porcentaje3 + "");
		txtD.setText(Tienda.porcentaje4 + "");
	}
	
	//Aumentra código de Jesus
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
		if(!tienda.validarDecimal("% 1 a 5",txtA))		return;
		if(!tienda.validarDecimal("% 6 a 10",txtB))		return;
		if(!tienda.validarDecimal("% 11 a 15",txtC))	return;
		if(!tienda.validarDecimal("% mas de 15",txtD))	return;
		
		Tienda.porcentaje1 = LeerPorcentajeA();
		Tienda.porcentaje2 = LeerPorcentajeB();
		Tienda.porcentaje3 = LeerPorcentajeC();
		Tienda.porcentaje4 = LeerPorcentajeD();
	
		dispose();
	}
	
	double LeerPorcentajeA(){
		return Double.parseDouble(txtA.getText());
    }
	double LeerPorcentajeB(){
		return Double.parseDouble(txtB.getText());
    }
	double LeerPorcentajeC(){
		return Double.parseDouble(txtC.getText());
    }
	double LeerPorcentajeD(){
		return Double.parseDouble(txtD.getText());
    }
	
}

