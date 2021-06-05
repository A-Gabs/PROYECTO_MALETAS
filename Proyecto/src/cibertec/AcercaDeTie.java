package cibertec;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSeparator;

public class AcercaDeTie extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JButton btnCerrar;
	
	public static void main(String[] args) {
		try {
			AcercaDeTie dialog = new AcercaDeTie();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AcercaDeTie() {
		setModal(true);
		setResizable(false);
		setTitle("Acerda de Tienda");
		setBounds(100, 100, 350, 385);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblTienda = new JLabel("Tienda 1.0");
		lblTienda.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTienda.setBounds(89, 11, 141, 37);
		contentPanel.add(lblTienda);
	
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 59, 352, 13);
		contentPanel.add(separator);
		
		JLabel lblAutores = new JLabel("Autores");
		lblAutores.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAutores.setBounds(119,62, 100, 37);
		contentPanel.add(lblAutores);
		
		JLabel lblChio = new JLabel("Luis E. Chio");
		lblChio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblChio.setBounds(119,110, 190, 13);
		contentPanel.add(lblChio);
		
		JLabel lblGarcia = new JLabel("Hugo Garcia");
		lblGarcia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGarcia.setBounds(119, 134, 190, 16);
		contentPanel.add(lblGarcia);
		
		JLabel lblAna = new JLabel("Ana Chavez");
		lblAna.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAna.setBounds(119,185, 190, 13);
		contentPanel.add(lblAna);
		
		JLabel lblJesus = new JLabel("Jesus Cubas");
		lblJesus.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblJesus.setBounds(119,209, 190, 16);
		contentPanel.add(lblJesus);
		
		JLabel lblLesly = new JLabel("Lesly Carrasco");
		lblLesly.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLesly.setBounds(119,161, 190, 13);
		contentPanel.add(lblLesly);
		
		JLabel lblSebas = new JLabel("Sebastian Del Castillo");
		lblSebas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSebas.setBounds(119,236, 190, 16);
		contentPanel.add(lblSebas);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(119, 291, 97, 25);
		contentPanel.add(btnCerrar);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		dispose();
	}

}