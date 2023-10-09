package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
 
import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class Proyecto extends JFrame implements MouseListener, ActionListener {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnMantenimiento;
	private JButton btnVentas;
	private JButton btnConfiguracin;
	private JButton btnAyuda;
	private JPanel panel_1;
	private JButton btnConsultarMaleta;
	private JButton btnListarMaleta;
	private JButton btnModificarMaleta;
	private JButton btnGenerarReportes;
	private JButton btnConfigurarDesc;
	private JButton btnConfigurarObs;
	private JButton btnVender;
	private JButton btnConfigurarCant;
	private JButton btnConfigurarSorpresa;
	
	
//  Datos del primer modelo
	public static String codigo0 = "MT0";
	public static String modelo0 = "Aviator";
	public static double precio0 = 124.9;
	public static double ancho0 = 63.5;
	public static double alto0 = 30.9;
	public static double fondo0 = 29.2;
	//  Datos del segundo modelo
	public static String codigo1 = "MT1";
	public static String modelo1 = "Century";
	public static double precio1 = 174.9;
	public static double ancho1 = 75.0;
	public static double alto1 = 28.5;
	public static double fondo1 = 30.0;
	//  Datos del tercer modelo
	public static String codigo2 = "MT2";
	public static String modelo2 = "Benneton";
	public static double precio2 = 159.9;
	public static double ancho2 = 65.2;
	public static double alto2 = 31.2;
	public static double fondo2 = 29.4;
	//  Datos del cuarto modelo
	public static String codigo3 = "MT3";
	public static String modelo3 = "Lucas";
	public static double precio3 = 99.9;
	public static double ancho3 = 45.0;
	public static double alto3 = 70.0;
	public static double fondo3 = 25.0;
	//  Datos del quinto modelo
	public static String codigo4 = "MT4";
	public static String modelo4 = "Samsonite";
	public static double precio4 = 84.9;
	public static double ancho4 = 50.2;
	public static double alto4 = 60.4;
	public static double fondo4 = 25.0;
	//  Porcentajes de descuento
	public static double porcentaje1 = 4.0;
	public static double porcentaje2 = 5.5;
	public static double porcentaje3 = 7.0;
	public static double porcentaje4 = 8.5;
	//  Cantidad �ptima de maletas vendidas
	public static int cantidadOptima = 50;
	//  Cantidad m�nima de maletas adquiridas para obtener el obsequio
	public static int cantidadMinima = 20;
	//  Obsequio
	public static String obsequio = "USB";
	//  N�mero de cliente que recibe el premio sorpresa
	public static int numeroClientePremiado = 5;
	//  Premio sorpresa
	public static String premioSorpresa = "Una Nintendo Switch";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new FlatDarkLaf());
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proyecto frame = new Proyecto();
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
	public Proyecto() {
		setResizable(false);
		setTitle("Maletinmania 2.0");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Proyecto.class.getResource("/img/githublogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 939, 547);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(60, 63, 65));
		panel.setBounds(0, 0, 366, 520);
		contentPane.add(panel);
		panel.setLayout(null);

		btnVentas = new JButton("Ventas");
		btnVentas.addActionListener(this);
		btnVentas.setIcon(
				resizeIcon(new ImageIcon(Proyecto.class.getResource("/img/briefcase-solid.png")), 30, 30));
		btnVentas.addMouseListener(this);
		btnVentas.setHorizontalAlignment(SwingConstants.RIGHT);
		btnVentas.setForeground(Color.WHITE);
		btnVentas.setFont(new Font("Arial", Font.BOLD, 16));
		btnVentas.setBorderPainted(false);
		btnVentas.setBackground(new Color(60, 63, 65));
		btnVentas.setBounds(0, 160, 366, 87);
		panel.add(btnVentas);

		btnConfiguracin = new JButton(" Configuración");
		btnConfiguracin.setIcon(
				resizeIcon(new ImageIcon(Proyecto.class.getResource("/img/gears-solid.png")), 40, 30));
		btnConfiguracin.addMouseListener(this);
		btnConfiguracin.addActionListener(this);
		btnConfiguracin.setHorizontalAlignment(SwingConstants.RIGHT);
		btnConfiguracin.setForeground(Color.WHITE);
		btnConfiguracin.setFont(new Font("Arial", Font.BOLD, 16));
		btnConfiguracin.setBorderPainted(false);
		btnConfiguracin.setBackground(new Color(60, 63, 65));
		btnConfiguracin.setBounds(0, 250, 366, 87);
		panel.add(btnConfiguracin);

		btnAyuda = new JButton(" Ayuda");
		btnAyuda.setIcon(
				resizeIcon(new ImageIcon(Proyecto.class.getResource("/img/users-solid.png")), 30, 30));
		btnAyuda.addMouseListener(this);
		btnAyuda.addActionListener(this);
		btnAyuda.setHorizontalAlignment(SwingConstants.RIGHT);
		btnAyuda.setForeground(Color.WHITE);
		btnAyuda.setFont(new Font("Arial", Font.BOLD, 16));
		btnAyuda.setBorderPainted(false);
		btnAyuda.setBackground(new Color(60, 63, 65));
		btnAyuda.setBounds(0, 343, 366, 87);
		panel.add(btnAyuda);
		
		btnMantenimiento = new JButton("Mantenimiento");
		btnMantenimiento.setForeground(Color.WHITE);
		btnMantenimiento.addActionListener(this);
		btnMantenimiento.setIcon(
				resizeIcon(new ImageIcon(Proyecto.class.getResource("/img/cube-solid.png")), 30, 30));
		btnMantenimiento.addMouseListener(this);
		btnMantenimiento.setBorderPainted(false);
		btnMantenimiento.setHorizontalAlignment(SwingConstants.RIGHT);
		btnMantenimiento.setBackground(new Color(60, 63, 65));
		btnMantenimiento.setFont(new Font("Arial", Font.BOLD, 16));
		btnMantenimiento.setBounds(0, 70, 366, 87);
		panel.add(btnMantenimiento);
		
		
		
		
 
		panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(376, 20, 539, 500);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		btnConsultarMaleta = new JButton("Consultar maleta");
		btnConsultarMaleta.addActionListener(this);
		btnConsultarMaleta.setIcon(resizeIcon(
				new ImageIcon(Proyecto.class.getResource("/img/magnifying-glass-solid.png")), 30, 30));
		btnConsultarMaleta.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnConsultarMaleta.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConsultarMaleta.setForeground(Color.WHITE);
		btnConsultarMaleta.setFont(new Font("Arial", Font.BOLD, 16));
		btnConsultarMaleta.setBorderPainted(false);
		btnConsultarMaleta.setBackground(new Color(223, 41, 53));
		btnConsultarMaleta.setBounds(48, 41, 200, 200);
		panel_1.add(btnConsultarMaleta);

		
		
		
		btnListarMaleta = new JButton("Listar maleta");
		btnListarMaleta.addActionListener(this);
		btnListarMaleta.setIcon(
				resizeIcon(new ImageIcon(Proyecto.class.getResource("/img/list-check-solid.png")), 30, 30));
		btnListarMaleta.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnListarMaleta.setHorizontalTextPosition(SwingConstants.CENTER);
		btnListarMaleta.setForeground(Color.WHITE);
		btnListarMaleta.setFont(new Font("Arial", Font.BOLD, 16));
		btnListarMaleta.setBorderPainted(false);
		btnListarMaleta.setBackground(new Color(223, 41, 53));
		btnListarMaleta.setBounds(48, 258, 200, 189);
		panel_1.add(btnListarMaleta);

		btnModificarMaleta = new JButton("Modificar maleta");
		btnModificarMaleta.addActionListener(this);
		btnModificarMaleta.setIcon(
				resizeIcon(new ImageIcon(Proyecto.class.getResource("/img/pen-solid.png")), 30, 30));
		btnModificarMaleta.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnModificarMaleta.setHorizontalTextPosition(SwingConstants.CENTER);
		btnModificarMaleta.setForeground(Color.WHITE);
		btnModificarMaleta.setFont(new Font("Arial", Font.BOLD, 16));
		btnModificarMaleta.setBorderPainted(false);
		btnModificarMaleta.setBackground(new Color(223, 41, 53));
		btnModificarMaleta.setBounds(278, 41, 200, 200);
		panel_1.add(btnModificarMaleta);

		btnGenerarReportes = new JButton("Generar reportes");
		btnGenerarReportes.addActionListener(this);
		btnGenerarReportes.setIcon(resizeIcon(
				new ImageIcon(Proyecto.class.getResource("/img/file-invoice-dollar-solid.png")), 30, 30));
		btnGenerarReportes.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnGenerarReportes.setHorizontalTextPosition(SwingConstants.CENTER);
		btnGenerarReportes.setForeground(Color.WHITE);
		btnGenerarReportes.setFont(new Font("Arial", Font.BOLD, 16));
		btnGenerarReportes.setBorderPainted(false);
		btnGenerarReportes.setBackground(new Color(223, 41, 53));
		btnGenerarReportes.setBounds(48, 41, 200, 200);
		panel_1.add(btnGenerarReportes);

		btnVender = new JButton("Vender");
		btnVender.addActionListener(this);
		btnVender.setIcon(
				resizeIcon(new ImageIcon(Proyecto.class.getResource("/img/sack-dollar-solid.png")), 30, 30));
		btnVender.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnVender.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVender.setForeground(Color.WHITE);
		btnVender.setFont(new Font("Arial", Font.BOLD, 16));
		btnVender.setBorderPainted(false);
		btnVender.setBackground(new Color(223, 41, 53));
		btnVender.setBounds(278, 41, 200, 200);
		panel_1.add(btnVender);
		
		
		btnConfigurarDesc = new JButton("Configurar Descuentos");
		btnConfigurarDesc.addActionListener(this);
		btnConfigurarDesc.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnConfigurarDesc.setIcon(
				resizeIcon(new ImageIcon(Proyecto.class.getResource("/img/percent-solid.png")), 30, 30));
		btnConfigurarDesc.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConfigurarDesc.setForeground(Color.WHITE);
		btnConfigurarDesc.setFont(new Font("Arial", Font.BOLD, 16));
		btnConfigurarDesc.setBorderPainted(false);
		btnConfigurarDesc.setBackground(new Color(223, 41, 53));
		btnConfigurarDesc.setBounds(48, 41, 200, 200);
		panel_1.add(btnConfigurarDesc);
		
		btnConfigurarObs = new JButton("Configurar Obsequio");
		btnConfigurarObs.setIcon(
				resizeIcon(new ImageIcon(Proyecto.class.getResource("/img/gift-solid.png")), 30, 30));
		btnConfigurarObs.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnConfigurarObs.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConfigurarObs.setForeground(Color.WHITE);
		btnConfigurarObs.setFont(new Font("Arial", Font.BOLD, 16));
		btnConfigurarObs.setBorderPainted(false);
		btnConfigurarObs.setBackground(new Color(223, 41, 53));
		btnConfigurarObs.setBounds(278, 41, 200, 200);
		panel_1.add(btnConfigurarObs);
		
		
		btnConfigurarCant = new JButton("Configurar Cantidad");
		btnConfigurarCant.setIcon(
				resizeIcon(new ImageIcon(Proyecto.class.getResource("/img/scale-balanced-solid.png")), 30, 30));
		btnConfigurarCant.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnConfigurarCant.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConfigurarCant.setForeground(Color.WHITE);
		btnConfigurarCant.setFont(new Font("Arial", Font.BOLD, 16));
		btnConfigurarCant.setBorderPainted(false);
		btnConfigurarCant.setBackground(new Color(223, 41, 53));
		btnConfigurarCant.setBounds(48, 256, 200, 191);
		panel_1.add(btnConfigurarCant);
		
		btnConfigurarSorpresa = new JButton("Configurar Sorpresa");
		btnConfigurarSorpresa.setIcon(
				resizeIcon(new ImageIcon(Proyecto.class.getResource("/img/robot-solid.png")), 30, 30));
		btnConfigurarSorpresa.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnConfigurarSorpresa.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConfigurarSorpresa.setForeground(Color.WHITE);
		btnConfigurarSorpresa.setFont(new Font("Arial", Font.BOLD, 16));
		btnConfigurarSorpresa.setBorderPainted(false);
		btnConfigurarSorpresa.setBackground(new Color(223, 41, 53));
		btnConfigurarSorpresa.setBounds(278, 258, 200, 191);
		panel_1.add(btnConfigurarSorpresa);
		
		
		btnConfigurarDesc.setVisible(false);
		btnConfigurarObs.setVisible(false);
		btnConfigurarCant.setVisible(false);
		btnConfigurarSorpresa.setVisible(false);
		
		btnConsultarMaleta.setVisible(false);
		btnModificarMaleta.setVisible(false);
		btnListarMaleta.setVisible(false);

		btnVender.setVisible(false);
		btnGenerarReportes.setVisible(false);

	}
	Component botonSeleccionado;
	public static ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
		Image image = icon.getImage();
		Image newImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(newImage);
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
		if(botonSeleccionado != e.getComponent()) {
			e.getComponent().setBackground(new Color(105, 105, 105));
		}
		
		
	}

	public void mouseExited(MouseEvent e) {
		
		if(botonSeleccionado != e.getComponent()) {
			e.getComponent().setBackground(new Color(60, 63, 65));
		}
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConfigurarDesc) {
			actionPerformedBtnConfigurarDesc(e);
		}
		if (e.getSource() == btnGenerarReportes) {
			actionPerformedBtnGenerarReportes(e);
		}
		if (e.getSource() == btnVender) {
			actionPerformedBtnVender(e);
		}
		if (e.getSource() == btnModificarMaleta) {
			actionPerformedBtnModificarMaleta(e);
		}
		if (e.getSource() == btnListarMaleta) {
			actionPerformedBtnListarMaleta(e);
		}
		if (e.getSource() == btnConsultarMaleta) {
			actionPerformedBtnConsultarMaleta(e);
		}
		if (e.getSource() == btnVentas) {
			botonSeleccionado = btnVentas;
			actionPerformedBtnVentas(e);
		}
		if (e.getSource() == btnMantenimiento) {
			botonSeleccionado = btnMantenimiento;
			actionPerformedBtnMantenimiento(e);
		}
		if (e.getSource() == btnConfiguracin) {
			botonSeleccionado = btnConfiguracin;
			actionPerformedBtnConfiguracin(e);
		}

	}

	protected void actionPerformedBtnMantenimiento(ActionEvent e) {

		btnConfigurarDesc.setVisible(false);
		btnConfigurarObs.setVisible(false);
		btnConfigurarCant.setVisible(false);
		btnConfigurarSorpresa.setVisible(false);
		
		btnConsultarMaleta.setVisible(true);
		btnModificarMaleta.setVisible(true);
		btnListarMaleta.setVisible(true);

		btnVender.setVisible(false);
		btnGenerarReportes.setVisible(false);

		btnMantenimiento.setBackground(new Color(223, 41, 53));
		btnVentas.setBackground(new Color(60, 63, 65));
		btnConfiguracin.setBackground(new Color(60, 63, 65));

	}

	protected void actionPerformedBtnVentas(ActionEvent e) {
		
		btnConfigurarDesc.setVisible(false);
		btnConfigurarObs.setVisible(false);
		btnConfigurarCant.setVisible(false);
		btnConfigurarSorpresa.setVisible(false);
		
		btnConsultarMaleta.setVisible(false);
		btnModificarMaleta.setVisible(false);
		btnListarMaleta.setVisible(false);

		btnVender.setVisible(true);
		btnGenerarReportes.setVisible(true);

		btnMantenimiento.setBackground(new Color(60, 63, 65));
		btnVentas.setBackground(new Color(223, 41, 53));
		btnConfiguracin.setBackground(new Color(60, 63, 65));
	}
	protected void actionPerformedBtnConfiguracin(ActionEvent e) {
		btnConfigurarDesc.setVisible(true);
		btnConfigurarObs.setVisible(true);
		btnConfigurarCant.setVisible(true);
		btnConfigurarSorpresa.setVisible(true);
		
		btnConsultarMaleta.setVisible(false);
		btnModificarMaleta.setVisible(false);
		btnListarMaleta.setVisible(false);

		btnVender.setVisible(false);
		btnGenerarReportes.setVisible(false);

		btnMantenimiento.setBackground(new Color(60, 63, 65));
		btnVentas.setBackground(new Color(60, 63, 65));
		btnConfiguracin.setBackground(new Color(223, 41, 53));
	}
	protected void actionPerformedBtnConsultarMaleta(ActionEvent e) {
		DlgConsultarMaleta dcm = new DlgConsultarMaleta();
		dcm.setLocationRelativeTo(this);
		dcm.setModal(true);
		dcm.setVisible(true);
	}
	protected void actionPerformedBtnListarMaleta(ActionEvent e) {
		DlgListarMaletas dlm = new DlgListarMaletas();
		dlm.setLocationRelativeTo(this);
		dlm.setModal(true);
		dlm.setVisible(true);
	}
	protected void actionPerformedBtnModificarMaleta(ActionEvent e) {
		DlgModificarMaleta dlm = new DlgModificarMaleta();
		dlm.setLocationRelativeTo(this);
		dlm.setModal(true);
		dlm.setVisible(true);
	}
	protected void actionPerformedBtnVender(ActionEvent e) {
		DlgVender dlv = new DlgVender();
		dlv.setLocationRelativeTo(this);
		dlv.setModal(true);
		dlv.setVisible(true);
	}
	protected void actionPerformedBtnGenerarReportes(ActionEvent e) {
		DlgGenerarReportes dlr = new DlgGenerarReportes();
		dlr.setLocationRelativeTo(this);
		dlr.setModal(true);
		dlr.setVisible(true);
	}
	protected void actionPerformedBtnConfigurarDesc(ActionEvent e) {
		DlgConfigurarDescuentos dcd = new DlgConfigurarDescuentos();
		dcd.setLocationRelativeTo(this);
		dcd.setModal(true);
		dcd.setVisible(true);
	}
}
