package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.JLayeredPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class DlgVender extends JDialog implements ActionListener, Runnable, KeyListener {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel lblCantidad;
	private JLabel lblCodigo;
	private JLabel lblPrecio;
	private JLabel lblApagar;
	private JLabel lblVuelto;
	private JLabel lblImgDialogo;
	private JLabel lblFechaHora;
	private JTextField txtPrecio;
	private JTextField txtApagar;
	private JTextField txtEfectivo;
	private JTextField txtVuelto;
	private JComboBox <String> cboCodigo;
	private JLayeredPane layeredPane;
	private JButton btnVender;
	private JButton btnEfectivo;
	private JButton btnCerrar;
	private JScrollPane scrollPane;
	private JTextArea txtS;

	private Thread hilo;
	private double aPagar;
	
	public static int numeroCliente = 0,
	          
			          cantidadVentasMT0 = 0,
	                  cantidadVentasMT1 = 0,
	                  cantidadVentasMT2 = 0,
	                  cantidadVentasMT3 = 0,
	                  cantidadVentasMT4 = 0,
	          
	                  maletasVendidasMT0 = 0,
	                  maletasVendidasMT1 = 0,
	                  maletasVendidasMT2 = 0,
	                  maletasVendidasMT3 = 0,
	                  maletasVendidasMT4 = 0;
                      
	public static double impAcumuladoMT0 = 0.0,
	                     impAcumuladoMT1 = 0.0,
	                     impAcumuladoMT2 = 0.0,
	                     impAcumuladoMT3 = 0.0,
	                     impAcumuladoMT4 = 0.0;
	private JTextField txtCantidad;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgVender dialog = new DlgVender();
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
	public DlgVender() {
		setResizable(false);
		setTitle("Vender");
		setBounds(100, 100, 570, 450);
		getContentPane().setLayout(null);
		
		txtCantidad = new JTextField();
		txtCantidad.addKeyListener(this);
		txtCantidad.setBounds(135, 11, 70, 21);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
	
		lblCantidad = new JLabel("Cantidad de maletas");
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setBounds(10, 10, 120, 23);
		getContentPane().add(lblCantidad);
		
		lblCodigo = new JLabel("C\u00F3digo de la maleta");
		lblCodigo.setForeground(Color.WHITE);
		lblCodigo.setBounds(10, 40, 120, 23);
		getContentPane().add(lblCodigo);
		
		lblPrecio = new JLabel("Precio unitario (S/)");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setBounds(10, 70, 120, 23);
		getContentPane().add(lblPrecio);
		
		cboCodigo = new JComboBox <String> ();
		cboCodigo.addActionListener(this);
		cboCodigo.setModel(new DefaultComboBoxModel <String>
		                  (new String[] {"MT0", "MT1", "MT2", "MT3", "MT4"}));
		cboCodigo.setBounds(135, 40, 70, 23);
		getContentPane().add(cboCodigo);
	
		txtPrecio = new JTextField(Proyecto.precio0 + "");
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(135, 70, 70, 23);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
	
		layeredPane = new JLayeredPane();
		layeredPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		layeredPane.setBounds(225, 10, 220, 90);
		getContentPane().add(layeredPane);

		lblApagar = new JLabel("Importe a pagar (S/)");
		lblApagar.setForeground(Color.WHITE);
		lblApagar.setBounds(10, 10, 120, 23);
		layeredPane.add(lblApagar);

		btnEfectivo = new JButton("Efectivo (S/)");
		btnEfectivo.addActionListener(this);
		btnEfectivo.setEnabled(false);
		btnEfectivo.setBounds(10, 35, 110, 23);
		layeredPane.add(btnEfectivo);
		
		lblVuelto = new JLabel("Vuelto (S/)");
		lblVuelto.setForeground(Color.WHITE);
		lblVuelto.setBounds(35, 60, 110, 23);
		layeredPane.add(lblVuelto);
	
		txtApagar = new JTextField();
		txtApagar.setFont(new Font("Monospaced", Font.PLAIN, 11));
		txtApagar.setBounds(130, 10, 80, 23);
		txtApagar.setEditable(false);
		layeredPane.add(txtApagar);
		txtApagar.setColumns(10);

		txtEfectivo = new JTextField();
		txtEfectivo.addActionListener(this);
		txtEfectivo.setFont(new Font("Monospaced", Font.PLAIN, 11));
		txtEfectivo.setEditable(false);
		txtEfectivo.setBounds(130, 35, 80, 23);
		layeredPane.add(txtEfectivo);
		txtEfectivo.setColumns(10);
		
		txtVuelto = new JTextField();
		txtVuelto.setFont(new Font("Monospaced", Font.PLAIN, 11));
		txtVuelto.setBounds(130, 60, 80, 23);
		txtVuelto.setEditable(false);
		layeredPane.add(txtVuelto);
		txtVuelto.setColumns(10);
		
		btnVender = new JButton("Vender");
		btnVender.addActionListener(this);
		btnVender.setBounds(460, 10, 90, 23);
		getContentPane().add(btnVender);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(460, 35, 90, 23);
		getContentPane().add(btnCerrar);

		lblFechaHora = new JLabel();
		lblFechaHora.setForeground(Color.WHITE);
		lblFechaHora.setBounds(430, 105, 120, 23);
		getContentPane().add(lblFechaHora);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 130, 540, 280);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
		
		lblImgDialogo = new JLabel();
		lblImgDialogo.setIcon(new ImageIcon("imagenes/dialogo.png"));
		lblImgDialogo.setBounds(0, 0, 561, 416);
		getContentPane().add(lblImgDialogo);

		hilo = new Thread(this);
	 	hilo.start();	
	}	
	public void run() {
	 	while (hilo != null)
	 		try {
	 			Thread.sleep(1);
	 			FechayHora();	 			
	 		}
	 		catch (Exception e) {
	 		}
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
		if (arg0.getSource() == txtEfectivo  ||  arg0.getSource() == btnEfectivo) {
			actionPerformedTxtEfectivo(arg0);
		}
		if (arg0.getSource() == cboCodigo) {
			actionPerformedCboCodigo(arg0);
		}
		if (arg0.getSource() == txtCantidad  ||  arg0.getSource() == btnVender) {
			actionPerformedBtnVender(arg0);
		}
	}
	protected void actionPerformedBtnVender(ActionEvent arg0) {
		try {
			int cantidad = Integer.parseInt(txtCantidad.getText());
			double precio = Double.parseDouble(txtPrecio.getText()),
				   importeCompra, descuento;
			String codigo, modelo, obsequio, premio;

			numeroCliente ++;
			
			switch (cboCodigo.getSelectedIndex()) {
				case 0:
					codigo = Proyecto.codigo0;
					modelo = Proyecto.modelo0;
					break;
				case 1:
					codigo = Proyecto.codigo1;
					modelo = Proyecto.modelo1;
					break;
				case 2:
					codigo = Proyecto.codigo2;
					modelo = Proyecto.modelo2;
					break;
				case 3:
					codigo = Proyecto.codigo3;
					modelo = Proyecto.modelo3;
					break;
				default: 
					codigo = Proyecto.codigo4;
					modelo = Proyecto.modelo4;
			}
			
			importeCompra = precio * cantidad;
				
			if (cantidad <= 3)
				descuento = Proyecto.porcentaje1/100 * importeCompra;
			else
				if (cantidad <= 5)
					descuento = Proyecto.porcentaje2/100 * importeCompra;
				else
					if (cantidad <= 8)
						descuento = Proyecto.porcentaje3/100 * importeCompra;
					else
						descuento = Proyecto.porcentaje4/100 * importeCompra;
				
			aPagar = importeCompra - descuento;
				
			if (cantidad >= Proyecto.cantidadMinima)
				obsequio = Proyecto.obsequio;	
			else
				obsequio = "No tiene";
				
			if (numeroCliente == Proyecto.numeroClientePremiado)
				premio = Proyecto.premioSorpresa;
			else
				premio = "No tiene";
						
			txtS.setText("");	
			imprimir("BOLETA DE VENTA - " + fecha() + " " + hora());
			imprimir("Número de cliente del día --> " + numeroCliente);
			imprimir("");
			imprimir("Código del producto  :  " + codigo);
			imprimir("Modelo del producto  :  " + modelo);
			imprimir("Cantidad de maletas  :  " + cantidad);
			imprimir("Precio unitario      :  S/" + decimalFormat(precio));
			imprimir("Importe de la compra :  S/" + decimalFormat(importeCompra));
			imprimir("Descuento            :  S/" + decimalFormat(descuento));		
			imprimir("Importe a Pagar      :  S/" + decimalFormat(aPagar));
			imprimir("Obsequio             :  " + obsequio);
			imprimir("Premio sorpresa      :  " + premio);
			
			switch (cboCodigo.getSelectedIndex()) {
				case 0:
					cantidadVentasMT0 ++;
					maletasVendidasMT0 += cantidad;
					impAcumuladoMT0 += aPagar;
					break;
				case 1:
					cantidadVentasMT1 ++;
					maletasVendidasMT1 += cantidad;
					impAcumuladoMT1 += aPagar;
					break;
				case 2:
					cantidadVentasMT2 ++;
					maletasVendidasMT2 += cantidad;
					impAcumuladoMT2 += aPagar;
					break;
				case 3:
					cantidadVentasMT3 ++;
					maletasVendidasMT3 += cantidad;
					impAcumuladoMT3 += aPagar;
					break;
				default:
					cantidadVentasMT4 ++;
					maletasVendidasMT4 += cantidad;
			        impAcumuladoMT4 += aPagar;
			}
			
			txtApagar.setText(decimalFormat(aPagar));
			btnEfectivo.setEnabled(true);
			txtEfectivo.setEditable(true);
			txtEfectivo.setText("");
			txtEfectivo.requestFocus();
			txtVuelto.setText("");
		}
		catch (Exception x) {
			mensaje("Ingrese CANTIDAD correcta", "Error");
			txtCantidad.requestFocus();
		}
	}
	protected void actionPerformedCboCodigo(ActionEvent arg0) {
	
		int pos = cboCodigo.getSelectedIndex();
		switch (pos) {
			case 0:
				txtPrecio.setText(Proyecto.precio0 + "");
				break;
			case 1:
				txtPrecio.setText(Proyecto.precio1 + "");
				break;
			case 2:
				txtPrecio.setText(Proyecto.precio2 + "");
				break;
			case 3:
				txtPrecio.setText(Proyecto.precio3 + "");
				break;
			default:
				txtPrecio.setText(Proyecto.precio4 + "");
		}
		
		txtCantidad.requestFocus();
	}
	protected void actionPerformedTxtEfectivo(ActionEvent e) {
		try {
			double efectivo = Double.parseDouble(txtEfectivo.getText());
			if (efectivo < aPagar) {
				mensaje("Falta EFECTIVO", "Observación");
				txtEfectivo.setText("");
				txtEfectivo.requestFocus();
			}
			else {
				double vuelto = efectivo - aPagar;
				txtApagar.setText(decimalFormat(aPagar));
				txtEfectivo.setText(decimalFormat(efectivo));
				txtVuelto.setText(decimalFormat(vuelto));
				btnEfectivo.setEnabled(false);
				txtCantidad.requestFocus();
			}
		}
		catch (Exception x) {
			mensaje("Ingrese EFECTIVO correcto", "Error");
			txtEfectivo.setText("");
			txtEfectivo.requestFocus();
		}
	}	
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		dispose();
	}
	//  M�todos tipo void (sin par�metros)
	void FechayHora() {
		lblFechaHora.setText(fecha() + "   " + hora());
	}
	//  M�todos tipo void (con par�metros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	void mensaje(String s1, String s2) {
		JOptionPane.showMessageDialog(this, s1, s2, 2);
	}
	//  M�todos que retornan valor (sin par�metros)	
	String fecha() {
		Calendar calendario = new GregorianCalendar();
		return String.format("%02d/",calendario.get(Calendar.DAY_OF_MONTH)) +
			   String.format("%02d/",calendario.get(Calendar.MONTH) + 1) +
			   calendario.get(Calendar.YEAR);
	}
	String hora() {
		Calendar calendario = new GregorianCalendar();
		return String.format("%02d:",calendario.get(Calendar.HOUR_OF_DAY)) +
			   String.format("%02d:",calendario.get(Calendar.MINUTE)) +
			   String.format("%02d",calendario.get(Calendar.SECOND));
	}
	
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtCantidad) {
			keyTypedTxtCantidad(e);
		}
	}
	protected void keyTypedTxtCantidad(KeyEvent e) {
		Character c = e.getKeyChar();
		if (!Character.isDigit(c)) {
			e.consume();
		}
	}
	String decimalFormat(double p){
		return String.format("%.2f",p).replace(",", ".");
	}
}