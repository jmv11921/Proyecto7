package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.Jugador;

import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Perfil extends JFrame {

	private static final long serialVersionUID = -5552271164772740559L;
	private JPanel contentPane;

	private JTextField txtNombre;
	private JTextField txterApellido;
	private JTextField txtAlias;
	private JTextField txtEdad;
	private JTextField txtObservaciones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Perfil frame = new Perfil();
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
	public Perfil() {
		setTitle("Perfil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel imagenPerfil = new JLabel("Imagen");
		imagenPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		imagenPerfil.setBounds(0, 11, 139, 114);
		contentPane.add(imagenPerfil);
		//getContentPane().add(imagenPerfil);
		ImageIcon imagenperfil =new ImageIcon(getClass().getResource("/img/perfil.png"));			
		imagenPerfil.setEnabled(true);
		imagenPerfil.setIcon(imagenperfil);
		
		
		txtNombre = new JTextField();
		txtNombre.setText("nombre");
		txtNombre.setBounds(160, 29, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(160, 11, 46, 14);
		contentPane.add(lblNombre);
		
		txterApellido = new JTextField();
		txterApellido.setText("1er apellido");
		txterApellido.setBounds(160, 75, 86, 20);
		contentPane.add(txterApellido);
		txterApellido.setColumns(10);
		
		JLabel lblerApellido = new JLabel("1er Apellido");
		lblerApellido.setBounds(160, 61, 63, 14);
		contentPane.add(lblerApellido);
		
		txtAlias = new JTextField();
		txtAlias.setText("alias");
		txtAlias.setBounds(160, 127, 86, 20);
		contentPane.add(txtAlias);
		txtAlias.setColumns(10);
		
		JLabel lblAlias = new JLabel("Alias");
		lblAlias.setBounds(160, 111, 46, 14);
		contentPane.add(lblAlias);
		
		txtEdad = new JTextField();
		txtEdad.setText("edad");
		txtEdad.setBounds(160, 175, 86, 20);
		contentPane.add(txtEdad);
		txtEdad.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(160, 158, 46, 14);
		contentPane.add(lblEdad);
		
		JButton btnActualizarDatos = new JButton("Actualizar datos");
		btnActualizarDatos.setBounds(24, 227, 115, 23);
		contentPane.add(btnActualizarDatos);
		
		txtObservaciones = new JTextField();
		txtObservaciones.setHorizontalAlignment(SwingConstants.CENTER);
		txtObservaciones.setText("observaciones");
		txtObservaciones.setBounds(287, 35, 125, 166);
		contentPane.add(txtObservaciones);
		txtObservaciones.setColumns(10);
		
		JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setBounds(287, 11, 79, 14);
		contentPane.add(lblObservaciones);
		
	}

	//private void setTitle(String string) {
		// TODO Apéndice de método generado automáticamente
		
	//}

	//private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Apéndice de método generado automáticamente
		
	//}

	private void setContentPane(JPanel contentPane2) {
		// TODO Apéndice de método generado automáticamente
		
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setJugador(Jugador player1) {
		// TODO Apéndice de método generado automáticamente
		
	}

	public boolean jugadorActualizado() {
		// TODO Apéndice de método generado automáticamente
		return false;
	}

	public Jugador getJugador() {
		// TODO Apéndice de método generado automáticamente
		return null;
	}
}
