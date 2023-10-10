package proyecto;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class DialogoConsultar extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblTitulo;
	private JLabel lblLargo;
	private JTextField txtLargo;
	private JLabel lblAutor;
	private JTextField txtAutor;
	private JButton btnCerrar;
	private JLabel lblCodigo;
	private JComboBox<String> cboCodigo;
	private JTextField txtTitulo;
	private JButton btnActualizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DialogoConsultar dialog = new DialogoConsultar(null);
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
	public DialogoConsultar(Tienda parentDialog) {
		setTitle("Consultar libro");
		setBounds(100, 100, 460, 204);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
            	parentDialog.MensajedeSalida();
            }
        });

		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(10, 11, 46, 14);
		contentPanel.add(lblCodigo);

		lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(10, 36, 46, 14);
		contentPanel.add(lblTitulo);

		lblAutor = new JLabel("Autor");
		lblAutor.setBounds(10, 61, 46, 14);
		contentPanel.add(lblAutor);

		lblLargo = new JLabel("Largo");
		lblLargo.setBounds(10, 86, 46, 14);
		contentPanel.add(lblLargo);

		
		cboCodigo = new JComboBox<String>();
		cboCodigo.addActionListener(this);
		cboCodigo.setModel(new DefaultComboBoxModel<String>(new String[] {"c001", "c002", "c003"}));
		cboCodigo.setBounds(66, 8, 89, 20);
		contentPanel.add(cboCodigo);
		
		txtTitulo = new JTextField();
		txtTitulo.setEditable(false);
		txtTitulo.setBounds(66, 33, 219, 20);
		contentPanel.add(txtTitulo);
		txtTitulo.setColumns(10);

		txtAutor = new JTextField();
		txtAutor.setEditable(false);
		txtAutor.setBounds(66, 58, 219, 20);
		contentPanel.add(txtAutor);
		txtAutor.setColumns(10);
		
		txtLargo = new JTextField();
		txtLargo.setText(Tienda.largo+"");
		txtLargo.setBounds(66, 83, 89, 20);
		contentPanel.add(txtLargo);
		txtLargo.setColumns(10);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(345, 7, 89, 23);
		contentPanel.add(btnCerrar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					Tienda.largo = Double.parseDouble(txtLargo.getText());
					JOptionPane.showMessageDialog(null, "Se realiz� con exito la actualizaci�n");
				}catch(Exception evt){
					JOptionPane.showMessageDialog(null, "Se gener� un error");
				}
				
				
				
			}
		});
		btnActualizar.setBounds(345, 32, 89, 23);
		contentPanel.add(btnActualizar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboCodigo) {
			actionPerformedCboCodigo(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	protected void actionPerformedCboCodigo(ActionEvent e) {
		
	}
}
