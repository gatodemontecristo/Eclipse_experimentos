package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class DlgModificarMaleta extends JDialog implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;

	private JLabel lblCodigo;
	private JLabel lblModelo;
	private JLabel lblPrecio;
	private JLabel lblAncho;
	private JLabel lblAlto;
	private JLabel lblFondo;
	private JLabel lblImgDialogo;
	private JComboBox<String> cboCodigo;
	private JTextField txtModelo;
	private JTextField txtPrecio;
	private JTextField txtAncho;
	private JTextField txtAlto;
	private JTextField txtFondo;
	private JButton btnGrabar;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgModificarMaleta dialog = new DlgModificarMaleta();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DlgModificarMaleta() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgModificarMaleta.class.getResource("/img/pen-solid.png")));
		setResizable(false);
		setTitle("Modificar maleta");
		setBounds(100, 100, 450, 240);
		getContentPane().setLayout(null);

		lblCodigo = new JLabel("C\u00F3digo");
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

		cboCodigo = new JComboBox<String>();
		cboCodigo.addActionListener(this);
		cboCodigo.setModel(new DefaultComboBoxModel<String>(new String[] { "MT0", "MT1", "MT2", "MT3", "MT4" }));
		cboCodigo.setBounds(100, 20, 180, 23);
		getContentPane().add(cboCodigo);

		txtModelo = new JTextField(Proyecto.modelo0);
		txtModelo.addKeyListener(this);
		txtModelo.setBounds(100, 50, 180, 23);
		getContentPane().add(txtModelo);
		txtModelo.setColumns(10);

		txtPrecio = new JTextField(Proyecto.precio0 + "");
		txtPrecio.addKeyListener(this);
		txtPrecio.setBounds(100, 80, 180, 23);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);

		txtAncho = new JTextField(Proyecto.ancho0 + "");
		txtAncho.addKeyListener(this);
		txtAncho.setBounds(100, 110, 180, 23);
		getContentPane().add(txtAncho);
		txtAncho.setColumns(10);

		txtAlto = new JTextField(Proyecto.alto0 + "");
		txtAlto.addKeyListener(this);
		txtAlto.setBounds(100, 140, 180, 23);
		getContentPane().add(txtAlto);
		txtAlto.setColumns(10);

		txtFondo = new JTextField(Proyecto.fondo0 + "");
		txtFondo.addKeyListener(this);
		txtFondo.setBounds(100, 170, 180, 23);
		getContentPane().add(txtFondo);
		txtFondo.setColumns(10);

		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(330, 20, 100, 23);
		getContentPane().add(btnGrabar);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(330, 50, 100, 23);
		getContentPane().add(btnCerrar);

		lblImgDialogo = new JLabel();
		lblImgDialogo.setIcon(new ImageIcon("imagenes/dialogo.png"));
		lblImgDialogo.setBounds(0, 0, 450, 240);
		getContentPane().add(lblImgDialogo);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
		if (arg0.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(arg0);
		}
		if (arg0.getSource() == cboCodigo) {
			actionPerformedCboCodigo(arg0);
		}
	}

	protected void actionPerformedCboCodigo(ActionEvent arg0) {
		switch (cboCodigo.getSelectedIndex()) {
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

	protected void actionPerformedBtnGrabar(ActionEvent arg0) {
		String modelo = leerCadena(txtModelo);
		double precio = leerReal(txtPrecio);
		double ancho = leerReal(txtAncho);
		double alto = leerReal(txtAlto);
		double fondo = leerReal(txtFondo);
		
		switch (cboCodigo.getSelectedIndex()) {
		case 0:
			Proyecto.modelo0 = modelo;
			Proyecto.precio0 = precio;
			Proyecto.ancho0 = ancho;
			Proyecto.alto0 = alto;
			Proyecto.fondo0 = fondo;
			break;
		case 1:
			Proyecto.modelo1 = modelo;
			Proyecto.precio1 = precio;
			Proyecto.ancho1 = ancho;
			Proyecto.alto1 = alto;
			Proyecto.fondo1 = fondo;
			break;
		case 2:
			Proyecto.modelo2 = modelo;
			Proyecto.precio2 = precio;
			Proyecto.ancho2 = ancho;
			Proyecto.alto2 = alto;
			Proyecto.fondo2 = fondo;
			break;
		case 3:
			Proyecto.modelo3 = modelo;
			Proyecto.precio3 = precio;
			Proyecto.ancho3 = ancho;
			Proyecto.alto3 = alto;
			Proyecto.fondo3 = fondo;
			break;
		default:
			Proyecto.modelo4 = modelo;
			Proyecto.precio4 = precio;
			Proyecto.ancho4 = ancho;
			Proyecto.alto4 = alto;
			Proyecto.fondo4 = fondo;
		}
		mensaje("Datos guardados con éxito", "Datos modificados", 1);

	}

	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		dispose();
	}

	// M�todos tipo void (con par�metros)
	void validacion(String s, JTextField txt) {
		mensaje("Ingrese " + s + " correcto", "Error", 0);
		txt.setText("");
		txt.requestFocus();
	}

	void mensaje(String s1, String s2, int i) {
		JOptionPane.showMessageDialog(this, s1, s2, i);
	}

	// M�todos que retornan valor (con par�metros)
	String leerCadena(JTextField txt) {
		return txt.getText();
	}

	double leerReal(JTextField txt) {
		return Double.parseDouble(txt.getText());
	}

	public void keyPressed(KeyEvent e) {
		
	}

	public void keyReleased(KeyEvent e) {
		validarCampos();
	}	

	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtPrecio) {
			keyTypedTextFieldDecimal(e);
		} else if (e.getSource() == txtModelo) {
			keyTypedTextFieldTexto(e);
		} else if (e.getSource() == txtAncho) {
			keyTypedTextFieldDecimal(e);
		} else if (e.getSource() == txtAlto) {
			keyTypedTextFieldDecimal(e);
		} else if (e.getSource() == txtFondo) {
			keyTypedTextFieldDecimal(e);
		}
	}

	
	public void validarCampos() {

		JTextField  elementos[] = {txtPrecio,txtModelo,txtAncho,txtAlto,txtFondo};
		String valor;
		for(int i=0; i<elementos.length;i++) {
			valor = elementos[i].getText().trim();
			if(valor.length()==0) {
				btnGrabar.setEnabled(false);
				return;
			}
		} 
		btnGrabar.setEnabled(true);
	}
	protected void keyTypedTextFieldTexto(KeyEvent e) {
		char c = e.getKeyChar();
		if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
			e.consume();
		}
	}

	protected void keyTypedTextFieldEnteros(KeyEvent e) {
		Character c = e.getKeyChar();
		if (!Character.isDigit(c)) {
			e.consume();
		}
	}

	protected void keyTypedTextFieldDecimal(KeyEvent e) {
		Character c = e.getKeyChar();

		if (!Character.isDigit(c) && !c.equals('.')) {
			e.consume();
		}
	}
}
