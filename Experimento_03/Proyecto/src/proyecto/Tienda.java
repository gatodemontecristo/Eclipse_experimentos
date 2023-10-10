package proyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Tienda extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnuArchivo;
	private JMenuItem mnuSalir;
	private JMenu mnMantenimiento;
	private JMenuItem mntmConsultar;
	private JMenu mnAyuda;
	private JMenuItem mntmAcercaDeTienda;
	private JMenuItem mntmListar;
	private JMenu mnAlumnos;
	private JMenuItem mntmRegistrar;
	public static double largo = 60;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		/*AQUI SE HACE REFERENCIA A flatlaf PARA EL UI DESIGN*/
		try {
			UIManager.setLookAndFeel(new FlatDarkLaf());
			/*AQUI LA LISTA DE ESTILOS QUE PUEDES USAR*/
			/**
			 * UIManager.setLookAndFeel(new FlatLightLaf());
			 * UIManager.setLookAndFeel(new FlatDarkLaf());
			 * UIManager.setLookAndFeel(new FlatIntelliJLaf());
			 * UIManager.setLookAndFeel(new FlatDarculaLaf());
			 * UIManager.setLookAndFeel(new FlatMacLightLaf());
			 * UIManager.setLookAndFeel(new FlatMacDarkLaf());
			 */
			
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tienda frame = new Tienda();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tienda() {
		setResizable(false);
		setTitle("Tienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 401);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnuArchivo = new JMenu("Archivo");
		menuBar.add(mnuArchivo);

		mnuSalir = new JMenuItem("Salir");
		mnuSalir.addActionListener(this);
		mnuArchivo.add(mnuSalir);

		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);

		mntmConsultar = new JMenuItem("Consultar");
		mntmConsultar.addActionListener(this);
		mnMantenimiento.add(mntmConsultar);

		mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(this);
		mnMantenimiento.add(mntmListar);

		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);

		mntmAcercaDeTienda = new JMenuItem("Acerca de Tienda");
		mntmAcercaDeTienda.addActionListener(this);
		mnAyuda.add(mntmAcercaDeTienda);
		
		mnAlumnos = new JMenu("Alumnos");
		menuBar.add(mnAlumnos);
		
		mntmRegistrar = new JMenuItem("Registrar");
		mntmRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Valor de largo : " + largo);
			}
		});
		mnAlumnos.add(mntmRegistrar);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmListar) {
			actionPerformedMntmListar(arg0);
		}
		if (arg0.getSource() == mntmAcercaDeTienda) {
			actionPerformedMntmAcercaDeTienda(arg0);
		}
		if (arg0.getSource() == mntmConsultar) {
			actionPerformedMntmConsultar(arg0);
		}
		if (arg0.getSource() == mnuSalir) {
			actionPerformedMnuSalir(arg0);
		}
	}
	
	public void MensajedeSalida() {
		JOptionPane.showMessageDialog(null, "Se cerro el dialog recientemente.");
	}
	
	protected void actionPerformedMnuSalir(ActionEvent arg0) {
		System.exit(0);
	}

	protected void actionPerformedMntmConsultar(ActionEvent arg0) {
		DialogoConsultar d = new DialogoConsultar(this);
		d.setLocationRelativeTo(this);
		d.setModal(true);
		d.setVisible(true);
	}

	protected void actionPerformedMntmAcercaDeTienda(ActionEvent arg0) {
		DialogoAcercaDeTienda d = new DialogoAcercaDeTienda(this);
		d.setLocationRelativeTo(this);
		d.setModal(true);
		d.setVisible(true);
	}

	protected void actionPerformedMntmListar(ActionEvent arg0) {
		DialogoListar d = new DialogoListar(this);
		d.setLocationRelativeTo(this);
		d.setModal(true);
		d.setVisible(true);
	}
}