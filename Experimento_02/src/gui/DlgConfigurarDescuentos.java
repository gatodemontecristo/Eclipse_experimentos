package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DlgConfigurarDescuentos extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel lbl_1_3;
	private JLabel lbl_4_5;
	private JLabel lbl_6_8;
	private JLabel lbl_masDe8;
	private JLabel lblPorc1;
	private JLabel lblPorc2;
	private JLabel lblPorc3;
	private JLabel lblPorc4;
	private JLabel lblImgDialogo;
	private JTextField txt_1_3;
	private JTextField txt_4_5;
	private JTextField txt_6_8;
	private JTextField txtMasDe8;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgConfigurarDescuentos dialog = new DlgConfigurarDescuentos();
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
	public DlgConfigurarDescuentos() {
		setResizable(false);
		setTitle("Configuraci�n | Configurar descuentos");
		setBounds(100, 100, 450, 180);
		getContentPane().setLayout(null);
		
		lbl_1_3 = new JLabel("1 a 3 maletas");
		lbl_1_3.setForeground(Color.WHITE);
		lbl_1_3.setBounds(22, 20, 100, 23);
		getContentPane().add(lbl_1_3);
		
		lbl_4_5 = new JLabel("4 a 5 maletas");
		lbl_4_5.setForeground(Color.WHITE);
		lbl_4_5.setBounds(22, 50, 100, 23);
		getContentPane().add(lbl_4_5);
		
		lbl_6_8 = new JLabel("6 a 8 maletas");
		lbl_6_8.setForeground(Color.WHITE);
		lbl_6_8.setBounds(22, 80, 100, 23);
		getContentPane().add(lbl_6_8);
		
		lbl_masDe8 = new JLabel("M\u00E1s de 8 maletas");
		lbl_masDe8.setForeground(Color.WHITE);
		lbl_masDe8.setBounds(22, 110, 100, 23);
		getContentPane().add(lbl_masDe8);
		
		txt_1_3 = new JTextField(Proyecto.porcentaje1 + "");
		txt_1_3.setBounds(133, 20, 102, 23);
		getContentPane().add(txt_1_3);
		txt_1_3.setColumns(10);
		
		txt_4_5 = new JTextField(Proyecto.porcentaje2 + "");
		txt_4_5.setBounds(133, 50, 102, 23);
		getContentPane().add(txt_4_5);
		txt_4_5.setColumns(10);
		
		txt_6_8 = new JTextField(Proyecto.porcentaje3 + "");
		txt_6_8.setBounds(133, 80, 102, 23);
		getContentPane().add(txt_6_8);
		txt_6_8.setColumns(10);
		
		txtMasDe8 = new JTextField(Proyecto.porcentaje4 + "");
		txtMasDe8.setBounds(133, 110, 102, 23);
		getContentPane().add(txtMasDe8);
		txtMasDe8.setColumns(10);

		lblPorc1 = new JLabel("%");
		lblPorc1.setForeground(Color.WHITE);
		lblPorc1.setBounds(245, 20, 18, 23);
		getContentPane().add(lblPorc1);
		
		lblPorc2 = new JLabel("%");
		lblPorc2.setForeground(Color.WHITE);
		lblPorc2.setBounds(245, 50, 18, 23);
		getContentPane().add(lblPorc2);
		
		lblPorc3 = new JLabel("%");
		lblPorc3.setForeground(Color.WHITE);
		lblPorc3.setBounds(245, 80, 18, 23);
		getContentPane().add(lblPorc3);
		
		lblPorc4 = new JLabel("%");
		lblPorc4.setForeground(Color.WHITE);
		lblPorc4.setBounds(245, 110, 18, 23);
		getContentPane().add(lblPorc4);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(330, 20, 100, 23);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(330, 50, 100, 23);
		getContentPane().add(btnCancelar);
		
		lblImgDialogo = new JLabel();
		lblImgDialogo.setIcon(new ImageIcon("imagenes/dialogo.png"));
		lblImgDialogo.setBounds(0, 0, 450, 180);
		getContentPane().add(lblImgDialogo);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		try {
			double porc1 = leerReal(txt_1_3);
			try {
				double porc2 = leerReal(txt_4_5);
				try {
					double porc3 = leerReal(txt_6_8);
					try {
						double porc4 = leerReal(txtMasDe8);
						Proyecto.porcentaje1 = porc1;
						Proyecto.porcentaje2 = porc2;
						Proyecto.porcentaje3 = porc3;
						Proyecto.porcentaje4 = porc4;
						mensaje("Descuentos guardados con �xito", "Guardar configuraci�n", 1);
						dispose();
					}
					catch (Exception x) {
						validacion("PORCENTAJE 4", txtMasDe8);
					}
				}
				catch (Exception x) {
					validacion("PORCENTAJE 3", txt_6_8);
				}
			}
			catch (Exception x) {
				validacion("PORCENTAJE 2", txt_4_5);
			}
		}
		catch (Exception x) {
			validacion("PORCENTAJE 1", txt_1_3);
		}
	}
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		dispose();
	}
	//  M�todos tipo void (con par�metros)
	void validacion(String s, JTextField txt) {
		mensaje("Ingrese " + s + " correcto", "Error", 0);
		txt.setText("");
		txt.requestFocus();
	}
	void mensaje(String s1, String s2, int i) {
		JOptionPane.showMessageDialog(this, s1, s2, i);
	}
	//  M�todos que retornan valor (con par�metros)	
	double leerReal(JTextField txt) {
		return Double.parseDouble(txt.getText());
	}
	
}
