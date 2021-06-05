package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Vender extends JDialog implements ActionListener {
	private JLabel lblModelo;
	private JComboBox<String> cboModelo;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JButton btnVender;
	private JButton btnCerrar;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vender dialog = new Vender();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Vender() {
		setTitle("Vender");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 11, 46, 14);
		getContentPane().add(lblModelo);
		
		cboModelo = new JComboBox<String>();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel<String>(new String[] {"Aviator", "Lucca", "Samsonite", "Century", "Saxoline"}));
		cboModelo.setBounds(83, 8, 142, 20);
		getContentPane().add(cboModelo);
		
		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setBounds(10, 42, 73, 14);
		getContentPane().add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(83, 39, 142, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 67, 61, 14);
		getContentPane().add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(83, 64, 142, 20);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnVender = new JButton("Vender");
		btnVender.addActionListener(this);
		btnVender.setBounds(322, 7, 89, 23);
		getContentPane().add(btnVender);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(322, 38, 89, 23);
		getContentPane().add(btnCerrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 92, 424, 168);
		getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cboModelo) {
			actionPerformedCboModelo(arg0);
		}
		if (arg0.getSource() == btnVender) {
			actionPerformedBtnVender(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		dispose();
	}
	
	void imprimir(String cad) {
		textArea.append(cad + "\n");
	}
	
	Tienda tienda = new Tienda();
	protected void actionPerformedCboModelo(ActionEvent arg0) {
		int modelo = cboModelo.getSelectedIndex();
		switch(modelo){
			case 0:	txtPrecio.setText(String.valueOf(Tienda.precio0));	break;
			case 1:	txtPrecio.setText(String.valueOf(Tienda.precio1));	break;
			case 2:	txtPrecio.setText(String.valueOf(Tienda.precio2));	break;
			case 3:	txtPrecio.setText(String.valueOf(Tienda.precio3));	break;
			default:txtPrecio.setText(String.valueOf(Tienda.precio4));	break;
		}
	}
	protected void actionPerformedBtnVender(ActionEvent arg0) {
		
		String mensaje=null;
		double porcCuotaDiaria=0;
		int mod, can;
		double pre, ipag = 0, ides, icom,des;
		String obs;
		if(!tienda.validarVacio("Precio",txtPrecio)) return;
		if(!tienda.validarEntero("Cantidad",txtCantidad)) return;
		mod = leerModelo();
		can = leerCantidad();
		pre = leerPrecio(mod);
		 switch(mod){
			 case 0: 
				 mostrarprecio(Tienda.precio0);
			     break;
			 case 1:
				 mostrarprecio(Tienda.precio1);
			     break;
			 case 2:
				 mostrarprecio(Tienda.precio2);
			     break;
			 case 3:
				 mostrarprecio(Tienda.precio3);
			     break;
			 default:
				 mostrarprecio(Tienda.precio4);
			     break;
		 }
		icom = calcularImporteCompra(mod, can, pre);
		des = leerdescuento(can);
		ides = calcularImporteDescuento(can, des,icom);
		ipag =calcularImportePagar(ipag, icom, ides);
		obs = Obsequios(can);
		realizarincrementos(mod,can,ipag);
		mostrarResultados(pre,can,icom, ides, ipag, obs);
		
		alertaventas(mensaje, porcCuotaDiaria);
		textArea.setCaretPosition(0);
	}
	void mostrarprecio(double pre){
		txtPrecio.setText(pre + "");
	}
	int leerModelo(){
		return cboModelo.getSelectedIndex();
		
	}
	int leerCantidad(){
		return Integer.parseInt(txtCantidad.getText());
	}
	//Extraer precios
	double leerPrecio(int h){
		switch(h){
			case 0: return Tienda.precio0;
			case 1: return Tienda.precio1;
			case 2: return Tienda.precio2;
			case 3: return Tienda.precio3;
			default: return Tienda.precio4;
		}
	}
	//Calcular Imorte compra
	double calcularImporteCompra(int h, int c, double p){
		switch(h){
			case 0: return p*c;
			case 1: return p*c;
			case 2: return p*c;
			case 3: return p*c;
			default: return p*c;
			
		}
	}
	//Extraer descuentos
	double leerdescuento(int c){
		switch(c){
			case 1: case 2: case 3: case 4: 
				return Tienda.porcentaje1;
			case 5: case 6: case 7: case 8: case 9:
				return Tienda.porcentaje2;
			case 10: case 11: case 12: case 13: case 14:
				return Tienda.porcentaje3;
			default:  return Tienda.porcentaje4;
				
		}
	}
		
	//Calcular Importe descuento
	double calcularImporteDescuento(int c, double d, double ic){
		switch(c){
			case 1: case 2: case 3: case 4: 
				return ic*(d/100);
			case 5: case 6: case 7: case 8: case 9:
				return ic*(d/100);
			case 10: case 11: case 12: case 13: case 14:
				return ic*(d/100);
			default:  return ic*(d/100);
		}
	 }		
	//Calcular Importe Pagar
	double calcularImportePagar(double ip, double ic, double id){
		return ip = ic - id;
		}
	String Obsequios( int c){
		switch(c){
			case 1:                                    return Tienda.obsequio1;
			case 2: case 3: case 4: case 5: case 6:    return Tienda.obsequio2;
			default:                                   return Tienda.obsequio3;
		}
	}
	
	//Salida de resultados
	void mostrarResultados(double p,int c, double ic, double id, double ip, String o){
		DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
		separadoresPersonalizados.setDecimalSeparator('.');
		DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);
		
		textArea.setText("BOLETA DE VENTA" + "\n" + "\n");
		imprimir("Modelo			: "    + cboModelo.getSelectedItem());
		imprimir("Precio			: "    + p);
		imprimir("Cantidad		: "    + c);
		imprimir("Importe Compra		: "    + formato1.format(ic));
		imprimir("Importe Descuento	: "    + formato1.format(id));
		imprimir("Importe pagar		: "    + formato1.format(ip));
		imprimir("Obsequio		: "    + o );
		
		
	}
	void alertaventas(String men, double pcd){
		DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
		separadoresPersonalizados.setDecimalSeparator('.');
		DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);
		
	if(Tienda.cantidadVentas % 5 == 0){
		pcd = Tienda.importeAcumulado * 100 / Tienda.cuotaDiaria;
		men = "Venta Nro. "+ Tienda.cantidadVentas +"\n"+
				"Importe total general acumulado : S/. "+ formato1.format(Tienda.importeAcumulado) +"\n"+
				"Porcentaje de la cuota diaria : "+ formato1.format(pcd) +"%";
		JOptionPane.showMessageDialog(this, men);
	}
	}
	void realizarincrementos(int m, int c, double ip){
			Tienda.cantidadVentas++;
			Tienda.importeAcumulado+=ip;
		switch(m){
			case 0: Tienda.univen0+= c ; Tienda.imptot0+=ip;Tienda.canven0++;break;
			case 1: Tienda.univen1+= c ; Tienda.imptot1+=ip;Tienda.canven1++;break;
			case 2: Tienda.univen2+= c ; Tienda.imptot2+=ip;Tienda.canven2++;break;
			case 3: Tienda.univen3+= c ; Tienda.imptot3+=ip;Tienda.canven3++;break;
			default: Tienda.univen4+= c ; Tienda.imptot4+=ip;Tienda.canven4++;
			
		}
	}
}
