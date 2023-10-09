package gui;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class DlgConfigurarPremioSorpresa extends JDialog implements ActionListener, KeyListener {
	
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPremioSorpresa;
	private JTextField txtNumeroCliente;
	private JButton btnCancelar;
	private JButton btnAleatorio;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConfigurarPremioSorpresa dialog = new DlgConfigurarPremioSorpresa();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConfigurarPremioSorpresa() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgConfigurarPremioSorpresa.class.getResource("/img/robot-solid.png")));
		setResizable(false);
		setTitle("Configurar premio sorpresa");
		setBounds(100, 100, 450, 115);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNumeroCliente_ConfigurarPremioSorpresa = new JLabel("N\u00FAmero de cliente");
			lblNumeroCliente_ConfigurarPremioSorpresa.setForeground(Color.WHITE);
			lblNumeroCliente_ConfigurarPremioSorpresa.setBounds(22, 18, 108, 14);
			contentPanel.add(lblNumeroCliente_ConfigurarPremioSorpresa);
		}
		{
			JLabel lblPremioSorpresa_ConfigurarPremioSorpresa = new JLabel("Premio sorpresa");
			lblPremioSorpresa_ConfigurarPremioSorpresa.setForeground(Color.WHITE);
			lblPremioSorpresa_ConfigurarPremioSorpresa.setBounds(22, 49, 108, 14);
			contentPanel.add(lblPremioSorpresa_ConfigurarPremioSorpresa);
		}
		{
			txtPremioSorpresa = new JTextField(""+Proyecto.premioSorpresa);
			txtPremioSorpresa.addKeyListener(this);
			txtPremioSorpresa.setBounds(151, 46, 148, 20);
			contentPanel.add(txtPremioSorpresa);
			txtPremioSorpresa.setColumns(10);
		}
		{
			txtNumeroCliente = new JTextField(""+Proyecto.numeroClientePremiado);
			txtNumeroCliente.addKeyListener(this);
			txtNumeroCliente.setBounds(151, 15, 81, 20);
			contentPanel.add(txtNumeroCliente);
			txtNumeroCliente.setColumns(10);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(335, 11, 89, 23);
			contentPanel.add(btnAceptar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(335, 45, 89, 23);
			contentPanel.add(btnCancelar);
		}
		
		btnAleatorio = new JButton();
		btnAleatorio.setIcon(
				resizeIcon(new ImageIcon(DlgConfigurarPremioSorpresa.class.getResource("/img/dice-solid.png")), 20, 20));
		btnAleatorio.addActionListener(this);
		btnAleatorio.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAleatorio.setBounds(242, 12, 57, 26);
		contentPanel.add(btnAleatorio);
	}
	public static ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
		Image image = icon.getImage();
		Image newImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(newImage);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == btnAleatorio) {
			actionPerformedBtnAleatorio(e);
		}
	}
	protected void actionPerformedBtnAleatorio(ActionEvent e) {
		aleatorio();
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		try {
			leerDatos();
			mensaje("Datos guardados con �xito", "Guardar configuraci�n", 1);
			dispose();
		}
		catch (Exception x) {
			mensaje("Ingrese un valor correcto", "Error", 0);
			txtNumeroCliente.setText("");
			txtNumeroCliente.requestFocus();
		}
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
	//  M�todos tipo void (sin par�metros)	
	void aleatorio() {
		int valor = aleatorio(1, 50);
		txtNumeroCliente.setText(valor + "");
		validarCampos();
	}
	void leerDatos() {
		int numClientePremiado;
		String premio;
		numClientePremiado=leerNumeroCliente(txtNumeroCliente);
		Proyecto.numeroClientePremiado=numClientePremiado;
		premio = leerPremio(txtPremioSorpresa);
		Proyecto.premioSorpresa = premio;
	}
	//  M�todos tipo void (con par�metros)	
	void mensaje(String s1, String s2, int i) {
		JOptionPane.showMessageDialog(this, s1, s2, i);
	}
	//  M�todos que retornan valor (con par�metros)	
	int aleatorio(int min, int max) {
	    return (int)((max - min + 1) * Math.random()) + min;
	}
	int leerNumeroCliente(JTextField txt) {
		return Integer.parseInt(txt.getText());
    }
	String leerPremio(JTextField txt) {
		return txt.getText();
	}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		validarCampos();
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtPremioSorpresa) {
			keyTypedTxtPremioSorpresa(e);
		}
		if (e.getSource() == txtNumeroCliente) {
			keyTypedTxtNumeroCliente(e);
		}
	}
	protected void keyTypedTxtNumeroCliente(KeyEvent e) {
		Character c = e.getKeyChar();
		if(!Character.isDigit(c)){
			e.consume();
		}
	}
	protected void keyTypedTxtPremioSorpresa(KeyEvent e) {
		Character c = e.getKeyChar();
		if(!Character.isLetter(c) && !Character.isWhitespace(c)){
			e.consume();
		}
	}
	public void validarCampos() {

		JTextField  elementos[] = {txtPremioSorpresa,txtNumeroCliente};
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
