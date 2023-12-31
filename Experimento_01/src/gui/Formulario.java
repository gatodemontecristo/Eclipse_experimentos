package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Formulario extends JFrame implements KeyListener, ActionListener  {

	private JPanel contentPane;
	private JLabel lblNombre;
	private JTextField textFieldNom;
	private JLabel lblApellido;
	private JTextField textFieldApellido;
	private JLabel lblEdad;
	private JTextField textFieldEdad;
	private JLabel lblSueldo;
	private JTextField textFieldSueldo;
	private JButton btnProcesar;
	private JScrollPane scrollPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario frame = new Formulario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Formulario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Formulario.class.getResource("/imagen/mario.png")));
		setResizable(false);
		setTitle("Empleado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 10, 45, 13);
		contentPane.add(lblNombre);
		
		textFieldNom = new JTextField();
		textFieldNom.addKeyListener(this);
		textFieldNom.setBounds(65, 7, 96, 19);
		contentPane.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(171, 10, 77, 13);
		contentPane.add(lblApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.addKeyListener(this);
		textFieldApellido.setBounds(226, 7, 96, 19);
		contentPane.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 33, 45, 13);
		contentPane.add(lblEdad);
		
		textFieldEdad = new JTextField();
		textFieldEdad.addKeyListener(this);
		textFieldEdad.setBounds(65, 30, 96, 19);
		contentPane.add(textFieldEdad);
		textFieldEdad.setColumns(10);
		
		lblSueldo = new JLabel("Sueldo");
		lblSueldo.setBounds(171, 33, 45, 13);
		contentPane.add(lblSueldo);
		
		textFieldSueldo = new JTextField();
		textFieldSueldo.addKeyListener(this);
		textFieldSueldo.setBounds(226, 30, 96, 19);
		contentPane.add(textFieldSueldo);
		textFieldSueldo.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.setEnabled(false);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(332, 6, 85, 21);
		contentPane.add(btnProcesar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 56, 416, 197);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		validarCampos();
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == textFieldSueldo) {
			keyTypedTextFieldSueldo(e);
		}
		if (e.getSource() == textFieldEdad) {
			keyTypedTextFieldEdad(e);
		}
		if (e.getSource() == textFieldApellido) {
			keyTypedTextFieldApellido(e);
		}
		if (e.getSource() == textFieldNom) {
			keyTypedTextFieldNom(e);
		}
	}
	protected void keyTypedTextFieldNom(KeyEvent e) {
		char c = e.getKeyChar();
		if(!Character.isLetter(c) && !Character.isWhitespace(c)){
			e.consume();
		}
	}
	protected void keyTypedTextFieldApellido(KeyEvent e) {
		Character c = e.getKeyChar();
		if(!Character.isLetter(c) && !Character.isWhitespace(c)){
			e.consume();
		}
	}
	protected void keyTypedTextFieldEdad(KeyEvent e) {
		Character c = e.getKeyChar();
		if(!Character.isDigit(c)){
			e.consume();
		}
	}
	protected void keyTypedTextFieldSueldo(KeyEvent e) {
		Character c = e.getKeyChar();
		
		if(!Character.isDigit(c) && !c.equals('.')){
			e.consume();
		}
	}
	public void validarCampos() {

		JTextField  elementos[] = {textFieldNom,textFieldApellido,textFieldEdad,textFieldSueldo};
		String valor;
		for(int i=0; i<elementos.length;i++) {
			valor = elementos[i].getText().trim();
			if(valor.length()==0) {
				btnProcesar.setEnabled(false);
				return;
			}
		} 
		btnProcesar.setEnabled(true);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		
		String nombre = textFieldNom.getText();
		String apellido = textFieldApellido.getText();
		int edad = Integer.parseInt(textFieldEdad.getText());
		double sueldo = Double.parseDouble(textFieldSueldo.getText());
		
		imprimir("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
		imprimir("░░░░░░░░░" + " Reporte de usuario " +"░░░░░░░░░");
		imprimir("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
		imprimir("");
		imprimir("Nombre\t:  " + nombre);
		imprimir("Apellido\t:  " + apellido);
		imprimir("Edad\t:  " + edad);
		imprimir("Sueldo\t:  " + decimalFormat(sueldo));
		imprimir("");
		imprimir("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	
	}
	String decimalFormat(double p){
		return String.format("%.2f",p).replace(",", ".");
	}
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
}
