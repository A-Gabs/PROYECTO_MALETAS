package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class GenerarReportes extends JDialog implements ActionListener {
	private JLabel lblTipoDeReporte;
	private JComboBox<String> cboventa;
	private JButton btnCerrar;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerarReportes dialog = new GenerarReportes();
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
	public GenerarReportes() {
		setTitle("Generar Reportes");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 683, 300);
		getContentPane().setLayout(null);
		
		lblTipoDeReporte = new JLabel("Tipo de reporte");
		lblTipoDeReporte.setBounds(10, 11, 85, 14);
		getContentPane().add(lblTipoDeReporte);
		
		cboventa = new JComboBox<String>();
		cboventa.addActionListener(this);
		cboventa.setModel(new DefaultComboBoxModel<String>(new String[] {"Ventas por modelo", "Ventas en relaci\u00F3n a la venta \u00F3ptima", "Precios en relaci\u00F3n al precio promedio", "General"}));
		cboventa.setBounds(106, 8, 390, 20);
		getContentPane().add(cboventa);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(553, 7, 89, 23);
		getContentPane().add(btnCerrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 657, 220);
		getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cboventa) {
			actionPerformedCboventa(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
	}
	
	protected void actionPerformedCboventa(ActionEvent arg0) {
		int lis ;
		textArea.setText("");
		lis = leerlista();
		
		seleccionarlista(lis);
		textArea.setCaretPosition(0);
	}
	
	int leerlista(){
		return cboventa.getSelectedIndex();
	}
	void seleccionarlista(int l){
		switch(l){
			case 0: ventapormodelo(); break;
			case 1: ventaoptima();break;
			case 2: ventapromedio();break;
			default:ventageneral(); break;
		}
	}
	void ventapormodelo(){
		textArea.setText("VENTAS POR MODELO"+"\n"+"\n");
		imprimirmodelo(Tienda.imptot0, Tienda.modelo0, Tienda.univen0, Tienda.canven0);
		imprimirmodelo(Tienda.imptot1, Tienda.modelo1, Tienda.univen1, Tienda.canven1);
		imprimirmodelo(Tienda.imptot2, Tienda.modelo2, Tienda.univen2, Tienda.canven2);
		imprimirmodelo(Tienda.imptot3, Tienda.modelo3, Tienda.univen3, Tienda.canven3);
		imprimirmodelo(Tienda.imptot4, Tienda.modelo4, Tienda.univen4, Tienda.canven4);
			
	}
	void imprimirmodelo(double it, String mod, int uv, int cv){
		DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
		separadoresPersonalizados.setDecimalSeparator('.');
		DecimalFormat formato1 = new DecimalFormat("0.00", separadoresPersonalizados);
		double apocuo;
		
		apocuo = (it * 100)/Tienda.cuotaDiaria;
		
		textArea.append("Modelo				:"+ mod +"\n");
		textArea.append("Cantidad de Ventas		:"+ cv +"\n");
		textArea.append("Cantidad de unidades vendidas	:" + uv +"\n");
		textArea.append("Importe total vendido		:"+ formato1.format(it) + "\n");
		textArea.append("Aporte a la cuota diaria	:"+ formato1.format(apocuo) +"%" + "\n" +"\n");
	}
	void ventaoptima(){
		
		textArea.setText("VENTAS EN RELACION A LA VENTA OPTIMA" +"\n" +"\n");
		imprimiroptimo(Tienda.modelo0, Tienda.univen0);
		imprimiroptimo(Tienda.modelo1, Tienda.univen1);
		imprimiroptimo(Tienda.modelo2, Tienda.univen2);
		imprimiroptimo(Tienda.modelo3, Tienda.univen3);
		imprimiroptimo(Tienda.modelo4, Tienda.univen4);
		
	}
	void imprimiroptimo(String mod,int cv){
		int optimo;
		textArea.append("Modelo				: " + mod + "\n");
		if(cv > Tienda.cantidadOptima){
			optimo = cv - Tienda.cantidadOptima;
			textArea.append("Cantidad de unidades vendidas	: " + cv +"("+ optimo + " más que la cantidad optima)" + "\n" + "\n");
		}
		else if(cv == Tienda.cantidadOptima){
			textArea.append("Cantidad de unidades vendidas	: " + cv +"(igual que la cantidad optima)" + "\n" + "\n");
		}
		else {
			optimo = Tienda.cantidadOptima - cv;
			textArea.append("Cantidad de unidades vendidas	: " + cv +"("+ optimo + " menos que la cantidad optima)" + "\n" + "\n");
		}
	}
	void ventapromedio(){
		double promedio;
		promedio = (Tienda.precio0 + Tienda.precio1 + Tienda.precio2 + Tienda.precio3 +Tienda.precio4)/5;
		
		textArea.setText("VENTAS EN RELACION AL PRECIO PROMEDIO" +"\n" +"\n");
		
		imprimirpromedio(promedio, Tienda.modelo0, Tienda.precio0);
		imprimirpromedio(promedio, Tienda.modelo1, Tienda.precio1);
		imprimirpromedio(promedio, Tienda.modelo2, Tienda.precio2);
		imprimirpromedio(promedio, Tienda.modelo3, Tienda.precio3);
		imprimirpromedio(promedio, Tienda.modelo4, Tienda.precio4);
		
		
		
	}
	void imprimirpromedio(double pro, String mod, double p){
		textArea.append("Modelo	: " + mod + "\n");
		if(pro > p)
		textArea.append("Precio	:" +p + "(menor al promedio)" +"\n" + "\n");
		else if (pro == p)
			textArea.append("Precio	:" +p + "(igual al promedio)" +"\n" + "\n");
		else 
			textArea.append("Precio	:" +p + "(mayor al promedio)" +"\n" + "\n");
	}
	void ventageneral(){
		double promedio, pmen=0, pmay=0;
		promedio = (Tienda.precio0 + Tienda.precio1 + Tienda.precio2 + Tienda.precio3 +Tienda.precio4)/5;
		int canvenmay=0, cansinven=0;		
		
		//Acumulador de cantidad de ventas mayores promedio
		if(Tienda.precio0 > promedio) canvenmay++;
		if(Tienda.precio1 > promedio) canvenmay++;
		if(Tienda.precio2 > promedio) canvenmay++;
		if(Tienda.precio3 > promedio) canvenmay++;
		if(Tienda.precio4 > promedio) canvenmay++;
		
		//Acumulador de cantidad de modelos sin vender
		if(Tienda.canven0 == 0) cansinven++;
		if(Tienda.canven1 == 0) cansinven++;
		if(Tienda.canven2 == 0) cansinven++;
		if(Tienda.canven3 == 0) cansinven++;
		if(Tienda.canven4 == 0) cansinven++;
		
		
		//Precio mayor
		if (Tienda.precio0 >= Tienda.precio1 && Tienda.precio0 >= Tienda.precio2 && Tienda.precio0 >= Tienda.precio3 && Tienda.precio0 >= Tienda.precio4)
			pmay = Tienda.precio0;
		else if (Tienda.precio1 >= Tienda.precio0 && Tienda.precio1 >= Tienda.precio2 && Tienda.precio1 >= Tienda.precio3 && Tienda.precio1 >= Tienda.precio4)
			pmay = Tienda.precio1; 		
		else if (Tienda.precio2 >= Tienda.precio0 && Tienda.precio2 >= Tienda.precio1 && Tienda.precio2 >= Tienda.precio3 && Tienda.precio2 >= Tienda.precio4)
			pmay = Tienda.precio2; 
		else if (Tienda.precio3 >= Tienda.precio0 && Tienda.precio3 >= Tienda.precio1 && Tienda.precio3 >= Tienda.precio2 && Tienda.precio3 >= Tienda.precio4)
			pmay = Tienda.precio2; 
		else if (Tienda.precio4 >= Tienda.precio0 && Tienda.precio4 >= Tienda.precio1 && Tienda.precio4 >= Tienda.precio2 && Tienda.precio4 >= Tienda.precio4)
			pmay = Tienda.precio4;
		
		//Precio menor
		if (Tienda.precio0 <= Tienda.precio1 && Tienda.precio0 <= Tienda.precio2 && Tienda.precio0 <= Tienda.precio3 && Tienda.precio0 <= Tienda.precio4)
			pmen = Tienda.precio0;
		else if (Tienda.precio1 <= Tienda.precio0 && Tienda.precio1 <= Tienda.precio2 && Tienda.precio1 <= Tienda.precio3 && Tienda.precio1 <= Tienda.precio4)
			pmen = Tienda.precio1;
		else if (Tienda.precio2 <= Tienda.precio0 && Tienda.precio2 <= Tienda.precio1 && Tienda.precio2 <= Tienda.precio3 && Tienda.precio2 <= Tienda.precio4)
			pmen = Tienda.precio2;
		else if (Tienda.precio3 <= Tienda.precio0 && Tienda.precio3 <= Tienda.precio1 && Tienda.precio3 <= Tienda.precio2 && Tienda.precio3 <= Tienda.precio4)
			pmen = Tienda.precio3;
		else if (Tienda.precio4 <= Tienda.precio0 && Tienda.precio4 <= Tienda.precio1 && Tienda.precio4 <= Tienda.precio2 && Tienda.precio4 <= Tienda.precio4)
			pmen = Tienda.precio4;
		
		textArea.setText("GENERAL" +"\n" +"\n");
		textArea.append("Precio promedio..................................:S/. " +promedio + "\n");
		textArea.append("Precio menor.....................................:S/. " + pmen + "\n");
		textArea.append("Precio mayor.....................................:S/. " + pmay + "\n");
		textArea.append("Cantidad de precios mayores al promedio..........:" + canvenmay + "\n");
		textArea.append("Cantidad de modelos sin vender...................:" + cansinven + "\n");
		
	}
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		dispose();
	}
}
//HUGO
