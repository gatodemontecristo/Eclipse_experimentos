package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

public class DlgConfigurarCantidadOptimaMaletas extends JDialog implements ActionListener, KeyListener {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel lblCantidadOptima;
	private JLabel lblImgDialogo;
	private JTextField txtCantidad;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgConfigurarCantidadOptimaMaletas dialog = new DlgConfigurarCantidadOptimaMaletas();
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
	public DlgConfigurarCantidadOptimaMaletas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgConfigurarCantidadOptimaMaletas.class.getResource("/img/scale-balanced-solid.png")));
		setResizable(false);
		setTitle("Configurar cantidad óptima de maletas vendidas");
		setBounds(100, 100, 500, 120);
		getContentPane().setLayout(null);
		
		lblCantidadOptima = new JLabel("Cantidad \u00D3ptima de maletas vendidas");
		lblCantidadOptima.setForeground(Color.WHITE);
		lblCantidadOptima.setBounds(20, 20, 250, 23);
		getContentPane().add(lblCantidadOptima);
		
		txtCantidad = new JTextField(Proyecto.cantidadOptima + "");
		txtCantidad.addKeyListener(this);
		txtCantidad.setBounds(250, 20, 89, 23);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(390, 20, 90, 23);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(390, 50, 90, 23);
		getContentPane().add(btnCancelar);
		
		lblImgDialogo = new JLabel();
		lblImgDialogo.setBounds(0, 0, 500, 120);
		lblImgDialogo.setIcon(new ImageIcon("imagenes/dialogo.png"));
		getContentPane().add(lblImgDialogo);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		try {
			Proyecto.cantidadOptima = leerEntero(txtCantidad);
			mensaje("Configuraci�n guardada con �xito", "Guardar configuraci�n", 1);
			dispose();
		}
		catch (Exception x) {
			mensaje("Ingrese una CANTIDAD correcta", "Error", 0);
		}
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
	//  M�todos tipo void (con par�metros)
	void mensaje(String s1, String s2, int i) {
		JOptionPane.showMessageDialog(this, s1, s2, i);
	}
	//  M�todos que retornan valor (con par�metros)	
	int leerEntero(JTextField txt) {
		return Integer.parseInt(txt.getText());
	}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		validarCampos();
	}
	public void keyTyped(KeyEvent e) {
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
	public void validarCampos() {

		JTextField  elementos[] = {txtCantidad};
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
}
