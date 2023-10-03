package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Proyecto_IA_2023_01 extends JFrame implements MouseListener, ActionListener {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnMantenimiento;
	private JButton btnVentas;
	private JButton btnConfiguracin;
	private JButton btnAyuda;
	private JButton btnConsultarMaleta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proyecto_IA_2023_01 frame = new Proyecto_IA_2023_01();
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
	public Proyecto_IA_2023_01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 939, 557);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 92, 184));
		panel.setBounds(0, 0, 366, 520);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnMantenimiento = new JButton(" Mantenimiento");
		btnMantenimiento.setIcon(resizeIcon(new ImageIcon(Proyecto_IA_2023_01.class.getResource("/img/cube-solid.png")),30,30));
		btnMantenimiento.addMouseListener(this);
		btnMantenimiento.setBorderPainted(false);
		btnMantenimiento.setHorizontalAlignment(SwingConstants.RIGHT);
		btnMantenimiento.setForeground(Color.WHITE);
		btnMantenimiento.setBackground(new Color(0, 92, 184));
		btnMantenimiento.setFont(new Font("Arial", Font.BOLD, 16));
		btnMantenimiento.setBounds(0, 70, 366, 87);
		panel.add(btnMantenimiento);
		
		btnVentas = new JButton( "Ventas");
		btnVentas.setIcon(resizeIcon(new ImageIcon(Proyecto_IA_2023_01.class.getResource("/img/briefcase-solid.png")),30,30));
		btnVentas.addMouseListener(this);
		btnVentas.setHorizontalAlignment(SwingConstants.RIGHT);
		btnVentas.setForeground(Color.WHITE);
		btnVentas.setFont(new Font("Arial", Font.BOLD, 16));
		btnVentas.setBorderPainted(false);
		btnVentas.setBackground(new Color(0, 92, 184));
		btnVentas.setBounds(0, 160, 366, 87);
		panel.add(btnVentas);
		
		btnConfiguracin = new JButton(" Configuración");
		btnConfiguracin.setIcon(resizeIcon(new ImageIcon(Proyecto_IA_2023_01.class.getResource("/img/gears-solid.png")),40,30));
		btnConfiguracin.addMouseListener(this);
		btnConfiguracin.addActionListener(this);
		btnConfiguracin.setHorizontalAlignment(SwingConstants.RIGHT);
		btnConfiguracin.setForeground(Color.WHITE);
		btnConfiguracin.setFont(new Font("Arial", Font.BOLD, 16));
		btnConfiguracin.setBorderPainted(false);
		btnConfiguracin.setBackground(new Color(0, 92, 184));
		btnConfiguracin.setBounds(0, 257, 366, 87);
		panel.add(btnConfiguracin);
		
		btnAyuda = new JButton(" Ayuda");
		btnAyuda.setIcon(resizeIcon(new ImageIcon(Proyecto_IA_2023_01.class.getResource("/img/users-solid.png")),30,30));
		btnAyuda.addMouseListener(this);
		btnAyuda.addActionListener(this);
		btnAyuda.setHorizontalAlignment(SwingConstants.RIGHT);
		btnAyuda.setForeground(Color.WHITE);
		btnAyuda.setFont(new Font("Arial", Font.BOLD, 16));
		btnAyuda.setBorderPainted(false);
		btnAyuda.setBackground(new Color(0, 92, 184));
		btnAyuda.setBounds(0, 347, 366, 87);
		panel.add(btnAyuda);
		
		btnConsultarMaleta = new JButton("Consultar maleta");
		btnConsultarMaleta.setIcon(resizeIcon(new ImageIcon(Proyecto_IA_2023_01.class.getResource("/img/magnifying-glass-solid.png")),30,30));
		btnConsultarMaleta.setLayout(new BorderLayout());
		btnConsultarMaleta.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnConsultarMaleta.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConsultarMaleta.setBounds(406, 73, 320, 225);
		contentPane.add(btnConsultarMaleta);
		
	}
	public static ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(newImage);
    }
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
		e.getComponent().setBackground(SystemColor.textHighlight); 
		
	}
	public void mouseExited(MouseEvent e) {
		e.getComponent().setBackground(new Color(0, 92, 184));
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
		e.getComponent().setBackground(new Color(0, 92, 184));
	}
	
	public void actionPerformed(ActionEvent e) {
	
	}
}
