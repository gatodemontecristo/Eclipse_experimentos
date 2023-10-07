package gui;

import java.awt.BorderLayout;

import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

public class DlgListarMaletas extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnCerrar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgListarMaletas dialog = new DlgListarMaletas();
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
	public DlgListarMaletas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgListarMaletas.class.getResource("/img/list-check-solid.png")));
		setResizable(false);
		setTitle("Listar maletas");
		setBounds(100, 100, 592, 322);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(2, 2, 566, 243);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 15));
		scrollPane.setViewportView(txtS);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(233, 255, 100, 23);
		contentPanel.add(btnCerrar);
		
		listar();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
	}
	protected void actionPerformedBtnListar(ActionEvent arg0) {
		txtS.setText("");
		listar();	
	}
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		dispose();
	}
	//  M�todos tipo void (sin par�metros)	
	void listar() {
		
		
		
		
		
		


		

		
		  
		

 
	    imprimir("───────────▄▀▄─────────▄▀▄");
	    imprimir("─────────▄█░░▀▀▀▀▀░░█▄");
	    imprimir("──▄▄───█░░░░░░░░░░░█───▄▄");
	    imprimir("█▄▄█──█░░▀░░▄░░▀░░█─█▄▄█");
	    imprimir("██████ LISTADO DE MALETAS █████");
	    imprimir("");
		imprimir("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
		imprimir("Código      :  " + Proyecto.codigo0);
		imprimir("Descripción :  " + Proyecto.modelo0);
		imprimir("Precio (S/) :  " + decimalFormat(Proyecto.precio0));
		imprimir("Ancho (cm)  :  " + decimalFormat(Proyecto.ancho0));
		imprimir("Alto (cm)   :  " + decimalFormat(Proyecto.alto0));
		imprimir("Fondo (cm)  :  " + decimalFormat(Proyecto.fondo0));
		imprimir("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
		imprimir("Código      :  " + Proyecto.codigo1);
		imprimir("Descripción :  " + Proyecto.modelo1);
		imprimir("Precio (S/) :  " + decimalFormat(Proyecto.precio1));
		imprimir("Ancho (cm)  :  " + decimalFormat(Proyecto.ancho1));
		imprimir("Alto (cm)   :  " + decimalFormat(Proyecto.alto1));
		imprimir("Fondo (cm)  :  " + decimalFormat(Proyecto.fondo1));
		imprimir("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
		imprimir("Código      :  " + Proyecto.codigo2);
		imprimir("Descripción :  " + Proyecto.modelo2);
		imprimir("Precio (S/) :  " + decimalFormat(Proyecto.precio2));
		imprimir("Ancho (cm)  :  " + decimalFormat(Proyecto.ancho2));
		imprimir("Alto (cm)   :  " + decimalFormat(Proyecto.alto2));
		imprimir("Fondo (cm)  :  " + decimalFormat(Proyecto.fondo2));
		imprimir("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
		imprimir("Código      :  " + Proyecto.codigo3);
		imprimir("Descripción :  " + Proyecto.modelo3);
		imprimir("Precio (S/) :  " + decimalFormat(Proyecto.precio3));
		imprimir("Ancho (cm)  :  " + decimalFormat(Proyecto.ancho3));
		imprimir("Alto (cm)   :  " + decimalFormat(Proyecto.alto3));
		imprimir("Fondo (cm)  :  " + decimalFormat(Proyecto.fondo3));
		imprimir("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
		imprimir("Código      :  " + Proyecto.codigo4);
		imprimir("Descripción :  " + Proyecto.modelo4);
		imprimir("Precio (S/) :  " + decimalFormat(Proyecto.precio4));
		imprimir("Ancho (cm)  :  " + decimalFormat(Proyecto.ancho4));
		imprimir("Alto (cm)   :  " + decimalFormat(Proyecto.alto4));
		imprimir("Fondo (cm)  :  " + decimalFormat(Proyecto.fondo4));
		imprimir("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
	}
	//  M�todos tipo void (con par�metros)	
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	//  M�todos que retornan valor (con par�metros)
	String decimalFormat(double p){
		return String.format("%.2f",p).replace(",", ".");
	}
}
