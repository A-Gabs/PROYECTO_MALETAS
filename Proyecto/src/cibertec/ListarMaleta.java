package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarMaleta extends JDialog implements ActionListener {
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnListar;
	private JButton btnCerrar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarMaleta dialog = new ListarMaleta();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ListarMaleta() {
		setTitle("Listado de Maleta");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 424, 210);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setBounds(231, 237, 89, 23);
		getContentPane().add(btnListar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(104, 237, 89, 23);
		getContentPane().add(btnCerrar);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	protected void actionPerformedBtnListar(ActionEvent e) {
		txtS.setText("");
        txtS.append("LISTADO DE MALETAS" + "\n" + "\n");
		
		mostrarDatos(Tienda.modelo0,Tienda.precio0,Tienda.ancho0,Tienda.alto0,Tienda.fondo0,Tienda.peso0);
		mostrarDatos(Tienda.modelo1,Tienda.precio1,Tienda.ancho1,Tienda.alto1,Tienda.fondo1,Tienda.peso1);
		mostrarDatos(Tienda.modelo2,Tienda.precio2,Tienda.ancho2,Tienda.alto2,Tienda.fondo2,Tienda.peso2);
		mostrarDatos(Tienda.modelo3,Tienda.precio3,Tienda.ancho3,Tienda.alto3,Tienda.fondo3,Tienda.peso3);
		mostrarDatos(Tienda.modelo4,Tienda.precio4,Tienda.ancho4,Tienda.alto4,Tienda.fondo4,Tienda.peso4);
	}
    
	void mostrarDatos(String mod, double pre, int an, int al, int fon, double pes){
		imprimir("Modelo : "    + mod);
		imprimir("Precio : S/ " + pre);
		imprimir("Ancho  : "    + an + " cm");
		imprimir("Alto   : "    + al + " cm");
		imprimir("Fondo  : "    + fon + " cm");
		imprimir("Peso   : "    + pes + " kg" + "\n");
	}
	
	void imprimir(String cad){
		txtS.append(cad + "\n");
	}
}

