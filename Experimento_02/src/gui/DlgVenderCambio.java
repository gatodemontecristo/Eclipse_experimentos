package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyEvent;

public class DlgVenderCambio extends JDialog implements ActionListener, KeyListener {
	private JLabel lblNewLabel;
	private JTextField txtEfectivo;
	private JTextField txtImporte;
	private JLabel lblNewLabel_1;
	private JTextField txtVuelto;
	private JButton btnNewButton_3;
	private JComboBox cboMedioPago;
	private JButton btnNewButton;
	private int realizar=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgVenderCambio dialog = new DlgVenderCambio(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgVenderCambio(DlgVender parentDialog) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgVenderCambio.class.getResource("/img/coins-solid.png")));
		setTitle("Efectuar cambio");
		setBounds(100, 100, 386, 170);
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
            	if(realizar == 1) {
            	DlgVender.formaDePago = cboMedioPago.getSelectedIndex();
            	DlgVender.efectivoDePago = Double.parseDouble(txtEfectivo.getText());
            	DlgVender.vueltoADar = Double.parseDouble(txtVuelto.getText());
            	parentDialog.imprimirBoleta();
            	}
            }
        });
		
			
		getContentPane().setLayout(null);
		
		
		lblNewLabel = new JLabel("Importe a pagar (S/)");
		lblNewLabel.setBounds(21, 33, 116, 13);
		getContentPane().add(lblNewLabel);
		
		txtEfectivo = new JTextField();
		txtEfectivo.setText("0.0");
		txtEfectivo.addKeyListener(this);
		txtEfectivo.setBounds(154, 55, 103, 19);
		getContentPane().add(txtEfectivo);
		txtEfectivo.setColumns(10);
		
		txtImporte = new JTextField();
		txtImporte.setText(decimalFormat(DlgVender.importeAPagar) + "");
		txtImporte.setEditable(false);
		txtImporte.setColumns(10);
		txtImporte.setBounds(154, 30, 103, 19);
		getContentPane().add(txtImporte);
		
		lblNewLabel_1 = new JLabel("Vuelto (S/)");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 84, 103, 13);
		getContentPane().add(lblNewLabel_1);
		
		txtVuelto = new JTextField();
		txtVuelto.setEditable(false);
		txtVuelto.setColumns(10);
		txtVuelto.setBounds(154, 81, 103, 19);
		getContentPane().add(txtVuelto);
		
		btnNewButton_3 = new JButton("Pagar");
		btnNewButton_3.setEnabled(false);
		btnNewButton_3.addActionListener(this);
		btnNewButton_3.setBounds(267, 29, 85, 21);
		getContentPane().add(btnNewButton_3);
		
		cboMedioPago = new JComboBox();
		cboMedioPago.addActionListener(this);
		cboMedioPago.setModel(new DefaultComboBoxModel(new String[] {"Efectivo", "Débito", "Crédito"}));
		cboMedioPago.setBounds(21, 56, 116, 21);
		getContentPane().add(cboMedioPago);
		
		btnNewButton = new JButton("Cerrar");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(267, 54, 85, 21);
		getContentPane().add(btnNewButton);
		obtenerVuelto();
	}
	
	public static ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
		Image image = icon.getImage();
		Image newImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(newImage);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton_3) {
			actionPerformedBtnNewButton_3(e);
		}
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
		if (e.getSource() == cboMedioPago) {
			actionPerformedComboBox(e);
		}
	}
	protected void actionPerformedComboBox(ActionEvent e) {
		int medio = cboMedioPago.getSelectedIndex();
		switch (medio) {
		case 0:
			txtEfectivo.setText("0.0");
			txtEfectivo.setEditable(true);
			txtEfectivo.requestFocus();
			obtenerVuelto();
			break;
		case 1:
			txtEfectivo.setText("0.0");
			txtEfectivo.setEditable(false);
			txtVuelto.setText("0.0");
			break;
		default:
			txtEfectivo.setText("0.0");
			txtEfectivo.setEditable(false);
			txtVuelto.setText("0.0");
	}
		validarCampos();
	}
	public void obtenerVuelto() {
		
		double efectivo = Double.parseDouble(txtEfectivo.getText());
		double importe = Double.parseDouble(txtImporte.getText());
		double calculo = efectivo - importe;
		
		txtVuelto.setText(decimalFormat(calculo)+"");
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtEfectivo) {
			keyReleasedTxtEfectivo(e);
		}
	}
	public void keyTyped(KeyEvent e) {
		Character c = e.getKeyChar();
		if (!Character.isDigit(c) && !c.equals('.')) {
			e.consume();
		}
	}
	protected void keyReleasedTxtEfectivo(KeyEvent e) {
		int medio = cboMedioPago.getSelectedIndex();
		String efectivo = txtEfectivo.getText();
		if(medio == 0 && efectivo.length() != 0 ) {
			obtenerVuelto();
			validarCampos();
		}
		
	}
	String decimalFormat(double p){
		return String.format("%.2f",p).replace(",", ".");
	}
	public void validarCampos() {
		int medio = cboMedioPago.getSelectedIndex();
		if(medio == 0) {
		JTextField  elementos[] = {txtEfectivo,txtVuelto};
		String valor;
		for(int i=0; i<elementos.length;i++) {
			valor = elementos[i].getText().trim();
			if(valor.length()==0) {
				btnNewButton_3.setEnabled(false);
				return;
			}else if(Double.parseDouble(valor)<=0) {
				btnNewButton_3.setEnabled(false);
				return;
			}
		} 
		btnNewButton_3.setEnabled(true);
		}else {
			btnNewButton_3.setEnabled(true);
		}
	}	
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		dispose();
	}
	protected void actionPerformedBtnNewButton_3(ActionEvent e) {
		realizar = 1;
		dispose();
	}
}
