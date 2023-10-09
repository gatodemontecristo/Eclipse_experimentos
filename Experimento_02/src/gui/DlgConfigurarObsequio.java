package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class DlgConfigurarObsequio extends JDialog implements ActionListener, KeyListener {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel lblCantidad;
	private JLabel lblObsequio;
	private JLabel lblImgDialogo;
	private JTextField txtCantidad;
	private JTextField txtObsequio;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgConfigurarObsequio dialog = new DlgConfigurarObsequio();
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
	public DlgConfigurarObsequio() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgConfigurarObsequio.class.getResource("/img/gift-solid.png")));
		setResizable(false);
		setTitle("Configurar obsequio");
		setBounds(100, 100, 450, 120);
		getContentPane().setLayout(null);
		
		lblCantidad = new JLabel("Cantidad m\u00EDnima de maletas adquiridas");
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setBounds(10, 20, 230, 23);
		getContentPane().add(lblCantidad);
		
		lblObsequio = new JLabel("Obsequio");
		lblObsequio.setForeground(Color.WHITE);
		lblObsequio.setBounds(10, 50, 69, 23);
		getContentPane().add(lblObsequio);
		
		txtCantidad = new JTextField(Proyecto.cantidadMinima + "");
		txtCantidad.addKeyListener(this);
		txtCantidad.setBounds(240, 20, 86, 23);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		
		txtObsequio = new JTextField(Proyecto.obsequio + "");
		txtObsequio.addKeyListener(this);
		txtObsequio.setBounds(239, 50, 86, 23);
		getContentPane().add(txtObsequio);
		txtObsequio.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(340, 20, 90, 23);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(340, 50, 90, 23);
		getContentPane().add(btnCancelar);
		
		lblImgDialogo = new JLabel();
		lblImgDialogo.setIcon(new ImageIcon("imagenes/dialogo.png"));
		lblImgDialogo.setBounds(0, 0, 450, 120);
		getContentPane().add(lblImgDialogo);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
	}
	
	void mensaje(String s1, String s2, int i) {
		JOptionPane.showMessageDialog(this, s1, s2, i);
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}	
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		try {
			Proyecto.cantidadMinima = leerEntero(txtCantidad);
			Proyecto.obsequio = leerCadena(txtObsequio);
			mensaje("Configuración guardada con éxito", "¿ Guardar configuración ?", 1);
			dispose();
		}
		catch (Exception x) {
			mensaje("Ingrese un valor correcto", "Error", 0);
			txtCantidad.setText("");
			txtCantidad.requestFocus();
		}
	}
	//  M�todos que retornan valor (con par�metros)	
	int leerEntero(JTextField txt) {
		return Integer.parseInt(txt.getText());
	}
	String leerCadena(JTextField txt) {
		return txt.getText();
	}
	public void validarCampos() {

		JTextField  elementos[] = {txtObsequio,txtCantidad};
		String valor;
		for(int i=0; i<elementos.length;i++) {
			valor = elementos[i].getText().trim();
			if(valor.length()==0) {
				btnAceptar.setEnabled(false);
				return;
			}
		} 
		btnAceptar.setEnabled(true);
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		validarCampos();
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtObsequio) {
			keyTypedTxtObsequio(e);
		}
		if (e.getSource() == txtCantidad) {
			keyTypedTxtCantidad(e);
		}
	}
	protected void keyTypedTxtCantidad(KeyEvent e) {
		Character c = e.getKeyChar();
		if(!Character.isDigit(c)){
			e.consume();
		}
	}
	protected void keyTypedTxtObsequio(KeyEvent e) {
		Character c = e.getKeyChar();
		if(!Character.isLetter(c) && !Character.isWhitespace(c)){
			e.consume();
		}
	}
}
