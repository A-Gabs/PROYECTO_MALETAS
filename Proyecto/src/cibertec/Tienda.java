package cibertec;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Tienda extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	// Datos mínimos del primer maleta
	public static String modelo0 = "Aviator";
	public static double precio0 = 134.9;
	public static int ancho0 = 50;
	public static int alto0 = 70;
	public static int fondo0 = 25;
	public static double peso0 = 2.4;
	public static int canven0=0;
	
	
	// Datos mínimos del segunda maleta
	public static String modelo1 = "Lucca";
	public static double precio1 = 169.9;
	public static int ancho1 = 60;
	public static int alto1 = 90;
	public static int fondo1 = 35;
	public static double peso1 = 4.8;
	public static int canven1=0;
	
	
	// Datos mínimos del tercera maleta
	public static String modelo2 = "Samsonite";
	public static double precio2 = 136.9;
	public static int ancho2 = 55;
	public static int alto2 = 75;
	public static int fondo2 = 30;
	public static double peso2 = 3.2;
	public static int canven2=0;
	
	
	// Datos mínimos del cuarta maleta
	public static String modelo3 = "Century";
	public static double precio3 = 119.9;
	public static int ancho3 = 45;
	public static int alto3 = 60;
	public static int fondo3 = 27;
	public static double peso3 = 2.3;
	public static int canven3=0;
	
	
	// Datos mínimos del quinta maleta
	public static String modelo4 = "Saxoline";
	public static double precio4 = 159.9;
	public static int ancho4 = 70;
	public static int alto4 = 80;
	public static int fondo4 = 37;
	public static double peso4 = 5.2;
	public static int canven4=0;
	
	
	// Porcentajes de descuento
	public static double porcentaje1 = 7.5;
	public static double porcentaje2 = 10.0;
	public static double porcentaje3 = 12.5;
	public static double porcentaje4 = 15.0;
	
	// Obsequios
	public static String obsequio1 = "Lapicero";
	public static String obsequio2 = "Cuaderno";
	public static String obsequio3 = "USB";
	
	// Cantidad óptima de unidades vendidas
    public static int cantidadOptima = 10;
    
    // Cuota diaria
    public static double cuotaDiaria = 30000;
    
    public static int cantidadVentas = 0;
	public static double importeAcumulado = 0.0;
	
	public static int univen0 = 0;
	public static int univen1 = 0;
	public static int univen2 = 0;
	public static int univen3 = 0;
	public static int univen4 = 0;	
	
	
	public static double imptot0 = 0.0;
	public static double imptot1 = 0.0;
	public static double imptot2 = 0.0;
	public static double imptot3 = 0.0;
	public static double imptot4 = 0.0;	
	
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JMenu mnMantenimiento;
	private JMenuItem mntmConsultarMaleta;
	private JMenuItem mntmModificarMaleta;
	private JMenuItem mntmListarMaleta;
	private JMenu mnVentas;
	private JMenuItem mntmVender;
	private JMenuItem mntmGenerarReportes;
	private JMenu mnConfiguracin;
	private JMenuItem mntmConfigurarDescuentos;
	private JMenuItem mntmConfigurarObsequios;
	private JMenuItem mntmConfigurarCantidadptima;
	private JMenuItem mntmConfigurarCuotaDiaria;
	private JMenu mnAyuda;
	private JMenuItem mntmAcercaDeTienda;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tienda frame = new Tienda();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Tienda() {
		setTitle("Tienda ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 746, 21);
		contentPane.add(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmConsultarMaleta = new JMenuItem("Consultar Maleta");
		mntmConsultarMaleta.addActionListener(this);
		mnMantenimiento.add(mntmConsultarMaleta);
		
		mntmModificarMaleta = new JMenuItem("Modificar Maleta");
		mntmModificarMaleta.addActionListener(this);
		mnMantenimiento.add(mntmModificarMaleta);
		
		mntmListarMaleta = new JMenuItem("Listar Maleta");
		mntmListarMaleta.addActionListener(this);
		mnMantenimiento.add(mntmListarMaleta);
		
		mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		mntmVender = new JMenuItem("Vender");
		mntmVender.addActionListener(this);
		mnVentas.add(mntmVender);
		
		mntmGenerarReportes = new JMenuItem("Generar Reportes");
		mntmGenerarReportes.addActionListener(this);
		mnVentas.add(mntmGenerarReportes);
		
		mnConfiguracin = new JMenu("Configuraci\u00F3n");
		menuBar.add(mnConfiguracin);
		
		mntmConfigurarDescuentos = new JMenuItem("Configurar descuentos");
		mntmConfigurarDescuentos.addActionListener(this);
		mnConfiguracin.add(mntmConfigurarDescuentos);
		
		mntmConfigurarObsequios = new JMenuItem("Configurar obsequios");
		mntmConfigurarObsequios.addActionListener(this);
		mnConfiguracin.add(mntmConfigurarObsequios);
		
		mntmConfigurarCantidadptima = new JMenuItem("Configurar cantidad \u00F3ptima");
		mntmConfigurarCantidadptima.addActionListener(this);
		mnConfiguracin.add(mntmConfigurarCantidadptima);
		
		mntmConfigurarCuotaDiaria = new JMenuItem("Configurar cuota diaria");
		mntmConfigurarCuotaDiaria.addActionListener(this);
		mnConfiguracin.add(mntmConfigurarCuotaDiaria);
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		mntmAcercaDeTienda = new JMenuItem("Acerca de Tienda");
		mntmAcercaDeTienda.addActionListener(this);
		mnAyuda.add(mntmAcercaDeTienda);
	}
	
	public void accionesValidar(JTextField campo){
		campo.requestFocus();
		campo.selectAll();
	}
	
	public boolean validarVacio(String mensaje, JTextField campo){
		if(campo.getText().length()==0){
			JOptionPane.showMessageDialog(null, "El campo "+mensaje+" esta vacio!!");
			accionesValidar(campo);
			return false;
		}
		return true;
	}
	
	public boolean validarEntero(String mensaje, JTextField campo){
		if(!validarVacio(mensaje,campo))	return false;	
		if(!campo.getText().matches("[0-9]+")){
			JOptionPane.showMessageDialog(null, "El campo "+mensaje+" debe ser entero y positivo!!");
			accionesValidar(campo);
			return false;
		}
		return true;
	}
	
	public boolean validarDecimal(String mensaje, JTextField campo){
		if(!validarVacio(mensaje,campo))	return false;	
		if(!campo.getText().matches("^[0-9]+(\\.[0-9]{1,2})?$")){
			JOptionPane.showMessageDialog(null, "El campo "+mensaje+" tiene caracteres extraños!!");
			accionesValidar(campo);
			return false;
		}
		return true;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmAcercaDeTienda) {
			actionPerformedMntmAcercaDeTienda(e);
		}
		if (e.getSource() == mntmConfigurarCuotaDiaria) {
			actionPerformedMntmConfigurarCuotaDiaria(e);
		}
		if (e.getSource() == mntmConfigurarCantidadptima) {
			actionPerformedMntmConfigurarCantidadptima(e);
		}
		if (e.getSource() == mntmConfigurarObsequios) {
			actionPerformedMntmConfigurarObsequios(e);
		}
		if (e.getSource() == mntmConfigurarDescuentos) {
			actionPerformedMntmConfigurarDescuentos(e);
		}
		if (e.getSource() == mntmGenerarReportes) {
			actionPerformedMntmGenerarReportes(e);
		}
		if (e.getSource() == mntmVender) {
			actionPerformedMntmVender(e);
		}
		if (e.getSource() == mntmListarMaleta) {
			actionPerformedMntmListarMaleta(e);
		}
		if (e.getSource() == mntmModificarMaleta) {
			actionPerformedMntmModificarMaleta(e);
		}
		if (e.getSource() == mntmConsultarMaleta) {
			actionPerformedMntmConsultarMaleta(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
		
	}
	protected void actionPerformedMntmSalir(ActionEvent e) {
		System.exit(0);
	}
	protected void actionPerformedMntmConsultarMaleta(ActionEvent e) {
		//Declarar una variable referencia de tipo Dialogo Consultar para controlar el objeto a crear
		DialogoConsultar cm = new DialogoConsultar();
		//Fijar la localizacion de la caja de dialogo en relacion de la ventana Tienda
		cm.setLocationRelativeTo(this);
		//Hacer visible la caja de Diálogo
		cm.setVisible(true);
	}
	protected void actionPerformedMntmModificarMaleta(ActionEvent e) {
		ModificarMaleta mm = new ModificarMaleta();
		mm.setLocationRelativeTo(this);
		mm.setVisible(true);
	}
	protected void actionPerformedMntmListarMaleta(ActionEvent e) {
		ListarMaleta lm = new ListarMaleta();
		lm.setLocationRelativeTo(this);
		lm.setVisible(true);
	}
	protected void actionPerformedMntmVender(ActionEvent e) {
		Vender v = new Vender();
        v.setLocationRelativeTo(this);
        v.setVisible(true);
	}
	protected void actionPerformedMntmGenerarReportes(ActionEvent e) {
		GenerarReportes gr = new GenerarReportes();
		gr.setLocationRelativeTo(this);
		gr.setVisible(true);
	}
	protected void actionPerformedMntmConfigurarDescuentos(ActionEvent e) {
		ConfigurarDescuento cd = new ConfigurarDescuento();
	    cd.setLocationRelativeTo(this);
		cd.setVisible(true);
	}
	protected void actionPerformedMntmConfigurarObsequios(ActionEvent e) {
		ConfigurarObsequios co = new ConfigurarObsequios();
		co.setLocationRelativeTo(this);
		co.setVisible(true);
	}
	protected void actionPerformedMntmConfigurarCantidadptima(ActionEvent e) {
		ConfigurarCantOpt cco = new ConfigurarCantOpt();
		cco.setLocationRelativeTo(this);
		cco.setVisible(true);
	}
	protected void actionPerformedMntmConfigurarCuotaDiaria(ActionEvent e) {
		ConfigurarCuoDiar ccd = new ConfigurarCuoDiar();
		ccd.setLocationRelativeTo(this);
		ccd.setVisible(true);
	}
	protected void actionPerformedMntmAcercaDeTienda(ActionEvent e) {
		//Declarar una variable referencia de tipo Acerca de Tienda para controlar el objeto a crear
		AcercaDeTie adt;
		//Crear el objeto Dialogo Consultar y asignar el control a la variable referencia
		adt = new AcercaDeTie();
		//Fijar la localizacion de la caja de dialogo en relacion de la ventana Tienda
		adt.setLocationRelativeTo(this);
		//Hacer visible la caja de Dialogo
		adt.setVisible(true);
	}
	
}
