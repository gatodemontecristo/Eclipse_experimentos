package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;

public class DlgConsultarMaleta extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel lblCodigo;
	private JLabel lblModelo;
	private JLabel lblPrecio;
	private JLabel lblAncho;
	private JLabel lblAlto;
	private JLabel lblFondo;
	private JLabel lblImgDialogo;
	private JComboBox <String> cboCodigo;
	private JTextField txtModelo;
	private JTextField txtPrecio;
	private JTextField txtAncho;
	private JTextField txtAlto;
	private JTextField txtFondo;
	private JButton btnCerrar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgConsultarMaleta dialog = new DlgConsultarMaleta();
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
	public DlgConsultarMaleta() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgConsultarMaleta.class.getResource("/img/magnifying-glass-solid.png")));
		setResizable(false);
		setTitle("Consultar maleta");
		setBounds(100, 100, 450, 240);
		getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBackground(Color.WHITE);
		lblCodigo.setForeground(Color.WHITE);
		lblCodigo.setBounds(20, 20, 80, 23);
		getContentPane().add(lblCodigo);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setForeground(Color.WHITE);
		lblModelo.setBounds(20, 50, 80, 23);
		getContentPane().add(lblModelo);
		
		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setBounds(20, 80, 80, 23);
		getContentPane().add(lblPrecio);
		
		lblAncho = new JLabel("Ancho (cm)");
		lblAncho.setForeground(Color.WHITE);
		lblAncho.setBounds(20, 110, 80, 23);
		getContentPane().add(lblAncho);
		
		lblAlto = new JLabel("Alto (cm)");
		lblAlto.setForeground(Color.WHITE);
		lblAlto.setBounds(20, 140, 80, 23);
		getContentPane().add(lblAlto);
		
		lblFondo = new JLabel("Fondo (cm)");
		lblFondo.setForeground(Color.WHITE);
		lblFondo.setBounds(20, 170, 80, 23);
		getContentPane().add(lblFondo);
		
		cboCodigo = new JComboBox <String> ();
		cboCodigo.addActionListener(this);
		cboCodigo.setModel(new DefaultComboBoxModel <String>
		                  (new String[] {"MT0", "MT1", "MT2", "MT3", "MT4"}));
		cboCodigo.setBounds(100, 20, 180, 23);
		getContentPane().add(cboCodigo);
		
		txtModelo = new JTextField(Proyecto.modelo0);
		txtModelo.setEditable(false);
		txtModelo.setBounds(100, 50, 180, 23);
		getContentPane().add(txtModelo);
		txtModelo.setColumns(10);

		txtPrecio = new JTextField(Proyecto.precio0 + "");
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(100, 80, 180, 23);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtAncho = new JTextField(Proyecto.ancho0 + "");
		txtAncho.setEditable(false);
		txtAncho.setBounds(100, 110, 180, 23);
		getContentPane().add(txtAncho);
		txtAncho.setColumns(10);
		
		txtAlto = new JTextField(Proyecto.alto0 + "");
		txtAlto.setEditable(false);
		txtAlto.setBounds(100, 140, 180, 23);
		getContentPane().add(txtAlto);
		txtAlto.setColumns(10);
		
		txtFondo = new JTextField(Proyecto.fondo0 + "");
		txtFondo.setEditable(false);
		txtFondo.setBounds(100, 170, 180, 23);
		getContentPane().add(txtFondo);
		txtFondo.setColumns(10);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(330, 20, 100, 23);
		getContentPane().add(btnCerrar);
		
		lblImgDialogo = new JLabel();
		lblImgDialogo.setIcon(new ImageIcon("imagenes/dialogo.png"));
		lblImgDialogo.setBounds(0, 0, 450, 240);
		getContentPane().add(lblImgDialogo);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == cboCodigo) {
			actionPerformedCboCodigo(e);
		}
	}
	protected void actionPerformedCboCodigo(ActionEvent e) {
		int posCodigo = cboCodigo.getSelectedIndex();
		switch (posCodigo) {
			case 0:
				txtModelo.setText(Proyecto.modelo0);
				txtPrecio.setText(Proyecto.precio0 + "");
				txtAncho.setText(Proyecto.ancho0 + "");
				txtAlto.setText(Proyecto.alto0 + "");
				txtFondo.setText(Proyecto.fondo0 + "");
				break;
			case 1:
				txtModelo.setText(Proyecto.modelo1);
				txtPrecio.setText(Proyecto.precio1 + "");
				txtAncho.setText(Proyecto.ancho1 + "");
				txtAlto.setText(Proyecto.alto1 + "");
				txtFondo.setText(Proyecto.fondo1 + "");
				break;
			case 2:
				txtModelo.setText(Proyecto.modelo2);
				txtPrecio.setText(Proyecto.precio2 + "");
				txtAncho.setText(Proyecto.ancho2 + "");
				txtAlto.setText(Proyecto.alto2 + "");
				txtFondo.setText(Proyecto.fondo2 + "");
				break;
			case 3:
				txtModelo.setText(Proyecto.modelo3);
				txtPrecio.setText(Proyecto.precio3 + "");
				txtAncho.setText(Proyecto.ancho3 + "");
				txtAlto.setText(Proyecto.alto3 + "");
				txtFondo.setText(Proyecto.fondo3 + "");
				break;
			default:
				txtModelo.setText(Proyecto.modelo4);
				txtPrecio.setText(Proyecto.precio4 + "");
				txtAncho.setText(Proyecto.ancho4 + "");
				txtAlto.setText(Proyecto.alto4 + "");
				txtFondo.setText(Proyecto.fondo4 + "");
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
}
