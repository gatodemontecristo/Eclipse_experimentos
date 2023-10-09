package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class DlgGenerarReportes extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel lblTipoReporte;
	private JLabel lblImgDialogo;
	private JComboBox <String> cboTipoReporte;
	private JButton btnCerrar;
	private JScrollPane scrPanel;
	private JTextArea txtS;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgGenerarReportes dialog = new DlgGenerarReportes();
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
	public DlgGenerarReportes() {
		setResizable(false);
		setTitle("Ventas | Generar reportes");
		setBounds(100, 100, 459, 315);
		getContentPane().setLayout(null);
		
		lblTipoReporte = new JLabel("Tipo de Reporte");
		lblTipoReporte.setForeground(Color.WHITE);
		lblTipoReporte.setBounds(10, 20, 100, 23);
		getContentPane().add(lblTipoReporte);
		
		cboTipoReporte = new JComboBox<String>();
		cboTipoReporte.addActionListener(this);
		cboTipoReporte.setModel(new DefaultComboBoxModel <String>
		                       (new String[] {"Ventas por Maleta", "Maletas con Venta \u00D3ptima",
		                    		          "Maletas con Precios Menores al Precio Promedio",
		                    		          "Maletas con Precios Mayores al Precio Promedio",
		                    		          "Promedios, m\u00E1ximos y m\u00EDnimos"}));
		cboTipoReporte.setBounds(120, 20, 315, 23);
		getContentPane().add(cboTipoReporte);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(335, 240, 100, 23);
		getContentPane().add(btnCerrar);
		
		scrPanel = new JScrollPane();
		scrPanel.setBounds(10, 50, 425, 180);
		getContentPane().add(scrPanel);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrPanel.setViewportView(txtS);
		
		lblImgDialogo = new JLabel();
		lblImgDialogo.setIcon(new ImageIcon("imagenes/dialogo.png"));
		lblImgDialogo.setBounds(0, 0, 450, 300);
		getContentPane().add(lblImgDialogo);
		
		ventasPorMaleta();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
		if (arg0.getSource() == cboTipoReporte) {
			actionPerformedCboTipoReporte(arg0);
		}
	}
	protected void actionPerformedCboTipoReporte(ActionEvent arg0) {
		txtS.setText("");
		switch (cboTipoReporte.getSelectedIndex()) {
			case 0:
				ventasPorMaleta();
				break;
			case 1:
				maletasConVentaOptima();
				break;
			case 2:
				maletasConPreciosMenoresAlPrecioPromedio();
				break;
			case 3:
				maletasConPreciosMayoresAlPrecioPromedio();
				break;
			default:
				promediosMaximosYminimos();
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		dispose();
	}
	//  M�todos tipo void (sin par�metros)
	void ventasPorMaleta() {
		double importeAcumuladoGeneral = DlgVender.impAcumuladoMT0 +
						                 DlgVender.impAcumuladoMT1 +
						                 DlgVender.impAcumuladoMT2 +
						                 DlgVender.impAcumuladoMT3 +
						                 DlgVender.impAcumuladoMT4;
		imprimir("\r\n"
				+ "───────█───▄▀█▀▀█▀▄▄─▐█──────▄▀█▀▀█\r\n"
				+ "─────█──▀─▐▌───▐▌─▀▀──▐█─────▀─▐▌─────▐▌─█\r\n"
				+ "───▐▌───────▀▄▄▀──────▐█▄▄───────▀▄▄▀──▐▌\r\n"
				+ "──█───────────────────────▀█─────────────────────█\r\n"
				+ "─▐█────────────────────────█▌─────────────────────█\r\n"
				+ "─▐█────────────────────────█▌─────────────────────█\r\n"
				+ "──█─────────────────█▄───▄█─────────────────────█\r\n"
				+ "───▐▌────────────────▀███▀────────────────────▐▌\r\n"
				+ "─────█──────────▀▄───────────────────▄▀───────█\r\n"
				+ "───────█───────────▀▄▄▄▄▄▄▄▄▄▀────────█\r\n"
				+ "\r\n");
		imprimir("██████ VENTAS POR MALETA ██████");
		imprimir("");
		imprimir("Código :  " + Proyecto.codigo0);
		imprimir("Modelo :  " + Proyecto.modelo0);
		imprimir("Cantidad total de ventas           :  " + DlgVender.cantidadVentasMT0);
		imprimir("Cantidad total de maletas vendidas :  " + DlgVender.maletasVendidasMT0);
		imprimir("Importe total acumulado            : S/" + decimalFormat(DlgVender.impAcumuladoMT0));
		imprimir("");
		imprimir("Código :  " + Proyecto.codigo1);
		imprimir("Modelo :  " + Proyecto.modelo1);
		imprimir("Cantidad total de ventas           :  " + DlgVender.cantidadVentasMT1);
		imprimir("Cantidad total de maletas vendidas :  " + DlgVender.maletasVendidasMT1);
		imprimir("Importe total acumulado            : S/" + decimalFormat(DlgVender.impAcumuladoMT1));		
		imprimir("");
		imprimir("Código :  " + Proyecto.codigo2);
		imprimir("Modelo :  " + Proyecto.modelo2);
		imprimir("Cantidad total de ventas           :  " + DlgVender.cantidadVentasMT2);
		imprimir("Cantidad total de maletas vendidas :  " + DlgVender.maletasVendidasMT2);
		imprimir("Importe total acumulado            : S/" + decimalFormat(DlgVender.impAcumuladoMT2));
		imprimir("");
		imprimir("Código :  " + Proyecto.codigo3);
		imprimir("Modelo :  " + Proyecto.modelo3);
		imprimir("Cantidad total de ventas           :  " + DlgVender.cantidadVentasMT3);
		imprimir("Cantidad total de maletas vendidas :  " + DlgVender.maletasVendidasMT3);
		imprimir("Importe total acumulado            : S/" + decimalFormat(DlgVender.impAcumuladoMT3));
		imprimir("");
		imprimir("Código :  " + Proyecto.codigo4);
		imprimir("Modelo :  " + Proyecto.modelo4);
		imprimir("Cantidad total de ventas           :  " + DlgVender.cantidadVentasMT4);
		imprimir("Cantidad total de maletas vendidas :  " + DlgVender.maletasVendidasMT4);
		imprimir("Importe total acumulado            : S/" + decimalFormat(DlgVender.impAcumuladoMT4));
		imprimir("");
		imprimir("Importe total acumulado general    : S/" + decimalFormat(importeAcumuladoGeneral));
	}
	void maletasConVentaOptima() {
		
		imprimir("██████ MALETAS CON VENTA ÓPTIMA ██████");
		imprimir("");
		if (DlgVender.maletasVendidasMT0 >= Proyecto.cantidadOptima) {
			imprimir("Código :  " + Proyecto.codigo0);
			imprimir("Modelo :  " + Proyecto.modelo0);
			imprimir("Cantidad total de maletas vendidas :  " + DlgVender.maletasVendidasMT0);
		}
		if (DlgVender.maletasVendidasMT1 >= Proyecto.cantidadOptima) {
			imprimir("Código :  " + Proyecto.codigo1);
			imprimir("Modelo :  " + Proyecto.modelo1);
			imprimir("Cantidad total de maletas vendidas :  " + DlgVender.maletasVendidasMT1);
		}
		if (DlgVender.maletasVendidasMT2 >= Proyecto.cantidadOptima) {
			imprimir("Código :  " + Proyecto.codigo2);
			imprimir("Modelo :  " + Proyecto.modelo2);
			imprimir("Cantidad total de maletas vendidas :  " + DlgVender.maletasVendidasMT2);
		}
		if (DlgVender.maletasVendidasMT3 >= Proyecto.cantidadOptima) {
			imprimir("Código :  " + Proyecto.codigo3);
			imprimir("Modelo :  " + Proyecto.modelo3);
			imprimir("Cantidad Total de maletas vendidas :  " + DlgVender.maletasVendidasMT3);
		}
        if (DlgVender.maletasVendidasMT4 >= Proyecto.cantidadOptima) {
			imprimir("Código :  " + Proyecto.codigo4);
			imprimir("Modelo :  " + Proyecto.modelo4);
			imprimir("Cantidad Total de maletas vendidas :  " + DlgVender.maletasVendidasMT4);
		}
		if (DlgVender.maletasVendidasMT0 < Proyecto.cantidadOptima  &&
		    DlgVender.maletasVendidasMT1 < Proyecto.cantidadOptima  &&
			DlgVender.maletasVendidasMT2 < Proyecto.cantidadOptima  &&
			DlgVender.maletasVendidasMT3 < Proyecto.cantidadOptima  &&
			DlgVender.maletasVendidasMT4 < Proyecto.cantidadOptima)
			imprimir("*** Aún no hay maletas con venta óptima ***");
	}
	void maletasConPreciosMenoresAlPrecioPromedio() {
		double precioPromedio = calcularPromedio(Proyecto.precio0, Proyecto.precio1, Proyecto.precio2, 
                                                 Proyecto.precio3, Proyecto.precio4);
		int cantidadMaletasMenoresAlPrecioPromedio = 0;
		imprimir("██████ MALETAS CON PRECIOS MENORES AL PRECIO PROMEDIO ██████");
		imprimir("");
		if (Proyecto.precio0 < precioPromedio) {
			cantidadMaletasMenoresAlPrecioPromedio ++;
		    imprimir("Modelo :  " + Proyecto.modelo0);
		    imprimir("Precio :  S/" + decimalFormat(Proyecto.precio0));
		}
		if (Proyecto.precio1 < precioPromedio) {
			cantidadMaletasMenoresAlPrecioPromedio ++;
		    imprimir("Modelo :  " + Proyecto.modelo1);
		    imprimir("Precio :  S/" + decimalFormat(Proyecto.precio1));
		}
		if (Proyecto.precio2 < precioPromedio) {
			cantidadMaletasMenoresAlPrecioPromedio ++;
		    imprimir("Modelo :  " + Proyecto.modelo2);
		    imprimir("Precio :  S/" + decimalFormat(Proyecto.precio2));
		}
		if (Proyecto.precio3 < precioPromedio) {
			cantidadMaletasMenoresAlPrecioPromedio ++;
		    imprimir("Modelo :  " + Proyecto.modelo3);
		    imprimir("Precio :  S/" + decimalFormat(Proyecto.precio3));
		}
		if (Proyecto.precio4 < precioPromedio) {
			cantidadMaletasMenoresAlPrecioPromedio ++;
		    imprimir("Modelo :  " + Proyecto.modelo4);
		    imprimir("Precio :  S/" + decimalFormat(Proyecto.precio4));
		}
		if (cantidadMaletasMenoresAlPrecioPromedio == 0)
			imprimir("*** No hay maletas con precios menores al precio promedio ***");
		else
			imprimir("Cantidad de maletas :  " + cantidadMaletasMenoresAlPrecioPromedio);
	}
	void maletasConPreciosMayoresAlPrecioPromedio() {
		double precioPromedio = calcularPromedio(Proyecto.precio0, Proyecto.precio1, Proyecto.precio2, 
                                                 Proyecto.precio3, Proyecto.precio4);
		int cantidadMaletasMayoresAlPrecioPromedio = 0;
		imprimir("██████ MALETAS CON PRECIOS MAYORES AL PRECIO PROMEDIO ██████");
		imprimir("");
		if (Proyecto.precio0 > precioPromedio) {
			cantidadMaletasMayoresAlPrecioPromedio ++;
		    imprimir("Modelo :  " + Proyecto.modelo0);
		    imprimir("Precio :  S/" + decimalFormat(Proyecto.precio0));
		}
		if (Proyecto.precio1 > precioPromedio) {
			cantidadMaletasMayoresAlPrecioPromedio ++;
		    imprimir("Modelo :  " + Proyecto.modelo1);
		    imprimir("Precio :  S/" + decimalFormat(Proyecto.precio1));
		}
		if (Proyecto.precio2 > precioPromedio) {
			cantidadMaletasMayoresAlPrecioPromedio ++;
		    imprimir("Modelo :  " + Proyecto.modelo2);
		    imprimir("Precio :  S/" + decimalFormat(Proyecto.precio2));
		}
		if (Proyecto.precio3 > precioPromedio) {
			cantidadMaletasMayoresAlPrecioPromedio ++;
		    imprimir("Modelo :  " + Proyecto.modelo3);
		    imprimir("Precio :  S/" + decimalFormat(Proyecto.precio3));
		}
		if (Proyecto.precio4 > precioPromedio) {
			cantidadMaletasMayoresAlPrecioPromedio ++;
		    imprimir("Modelo :  " + Proyecto.modelo4);
		    imprimir("Precio :  S/" + decimalFormat(Proyecto.precio4));
		}
		if (cantidadMaletasMayoresAlPrecioPromedio == 0)
			imprimir("*** No hay maletas con precios mayores al precio promedio ***");
		else
			imprimir("Cantidad de maletas :  " + cantidadMaletasMayoresAlPrecioPromedio);
	}
	void promediosMaximosYminimos() {
		double precioPromedio, precioMinimo, precioMaximo,
		       anchoPromedio, anchoMinimo, anchoMaximo,
		       altoPromedio, altoMinimo, altoMaximo,
		       fondoPromedio, fondoMinimo, fondoMaximo;
		precioPromedio = calcularPromedio(Proyecto.precio0, Proyecto.precio1, Proyecto.precio2, 
                                          Proyecto.precio3, Proyecto.precio4);
		precioMinimo = calcularMinimo(Proyecto.precio0, Proyecto.precio1, Proyecto.precio2,
                                      Proyecto.precio3, Proyecto.precio4);
		precioMaximo = calcularMaximo(Proyecto.precio0, Proyecto.precio1, Proyecto.precio2,
                                      Proyecto.precio3, Proyecto.precio4);
		anchoPromedio = calcularPromedio(Proyecto.ancho0, Proyecto.ancho1, Proyecto.ancho2,
				                         Proyecto.ancho3, Proyecto.ancho4);
		anchoMinimo = calcularMinimo(Proyecto.ancho0, Proyecto.ancho1, Proyecto.ancho2,
				                     Proyecto.ancho3, Proyecto.ancho4);
		anchoMaximo = calcularMaximo(Proyecto.ancho0, Proyecto.ancho1, Proyecto.ancho2,
				                     Proyecto.ancho3, Proyecto.ancho4);
		altoPromedio = calcularPromedio(Proyecto.alto0, Proyecto.alto1, Proyecto.alto2,
				                        Proyecto.alto3, Proyecto.alto4);
		altoMinimo = calcularMinimo(Proyecto.alto0, Proyecto.alto1, Proyecto.alto2,
				                    Proyecto.alto3, Proyecto.alto4);
		altoMaximo = calcularMaximo(Proyecto.alto0, Proyecto.alto1, Proyecto.alto2,
				                    Proyecto.alto3, Proyecto.alto4);
		fondoPromedio = calcularPromedio(Proyecto.fondo0, Proyecto.fondo1, Proyecto.fondo2,
				                         Proyecto.fondo3, Proyecto.fondo4);
		fondoMinimo = calcularMinimo(Proyecto.fondo0, Proyecto.fondo1, Proyecto.fondo2,
				                     Proyecto.fondo3, Proyecto.fondo4);
		fondoMaximo = calcularMaximo(Proyecto.fondo0, Proyecto.fondo1, Proyecto.fondo2,
	    		                     Proyecto.fondo3, Proyecto.fondo4);
		imprimir("██████ PROMEDIOS, MAXIMOS Y MINIMOS ██████");
		imprimir("");
		imprimir("Precio promedio :  S/ " + decimalFormat(precioPromedio));
		imprimir("Precio mínimo   :  S/ " + decimalFormat(precioMinimo));
		imprimir("Precio máximo   :  S/ " + decimalFormat(precioMaximo));
		imprimir("");
		imprimir("Ancho promedio (cm) : " + decimalFormat(anchoPromedio));
		imprimir("Ancho mínimo (cm)   : " + decimalFormat(anchoMinimo));
		imprimir("Ancho máximo (cm)   : " + decimalFormat(anchoMaximo));
		imprimir("");
		imprimir("Alto promedio (cm)  : " + decimalFormat(altoPromedio));
		imprimir("Alto mínimo (cm)    : " + decimalFormat(altoMinimo));
		imprimir("Alto máximo (cm)    : " + decimalFormat(altoMaximo));
		imprimir("");
		imprimir("Fondo promedio (cm) : " + decimalFormat(fondoPromedio));
		imprimir("Fondo minimo (cm)   : " + decimalFormat(fondoMinimo));
		imprimir("Fondo máximo (cm)   : " + decimalFormat(fondoMaximo));
	}	
	//  M�todos tipo void (con par�metros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	//  M�todos que retornan valor (con par�metros)
	double calcularPromedio(double a, double b, double c, double d, double e) {
		 return (a + b + c + d + e) / 5;
	}
	double calcularMinimo(double a, double b, double c, double d, double e) {
		double minimo = a;
		if (minimo > b)
			minimo = b;
		if (minimo > c)
			minimo = c;
		if (minimo > d)
			minimo = d;
		if (minimo > e)
			minimo = e;
		return minimo;
	}
	double calcularMaximo(double a, double b, double c, double d, double e) {
		double maximo = a;
		if (maximo < b)
			maximo = b;
		if (maximo < c)
			maximo = c;
		if (maximo < d)
			maximo = d;
		if (maximo < e)
			maximo = e;
		return maximo;
	}
	String decimalFormat(double p) {
		return String.format("%.2f",p).replace(",", ".");
	}
	
}