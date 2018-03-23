package Ventanas;


import Juego.Jugador;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class FinestraP extends JFrame {

	private JPanel contentPane;
	
	private CardLayout cardLayout;
	
	//Clase que almacena Jugador
	private Jugador player;
	
	//Clase que almacena la ventana Jugar (JPanel que se añadirá a este JFrame)
	private Jugar ventanaJugar=new Jugar();
	
	//Clase que almacena la ventana Perfil (JPanel que se añadirá a este JFrame)
	private Perfil ventanaPerfil=new Perfil();
	
	//Identificadores
	final static String VentanaJ="Ventana Jugar";
	final static String VentanaP="Ventana Perfil";
	
	// Create the frame
	//public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			//public void run() {
				//try {
					//FinestreP frame = new FinestreP();
					//frame.setVisible(true);
				//} catch (Exception e) {
					//e.printStackTrace();
				//}
			//}
		//});
	//}

	
	//Create the frame.

	public FinestraP(Jugador player1) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		cardLayout = new CardLayout(0, 0);
		contentPane.setLayout(cardLayout);
		
		
		
		//Añado las ventanas al contenedor
		contentPane.add(ventanaJugar.getContentPane(), VentanaJ);
		contentPane.add(ventanaPerfil.getContentPane(), VentanaP);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnVentanas = new JMenu("Ventanas");
		menuBar.add(mnVentanas);
						
		JMenuItem mntmJuego = new JMenuItem("Juego");
		mnVentanas.add(mntmJuego);
		mntmJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            cardLayout.show(contentPane, VentanaJ);
			
			//ventanaJugar.setJugador(player);
		}
		});
				
		JSeparator separator = new JSeparator();
		mnVentanas.add(separator);
				
		JMenuItem mntmPerfil = new JMenuItem("Perfil");
		mnVentanas.add(mntmPerfil);
		mntmPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				cardLayout.show(contentPane, VentanaP);
				
//				ventanaPerfil.setPerfil(player);
				
			}
		});
				

	}

	//Texto de BIENVENIDA JUGADOR	
		//Setter
			public void setJugador(Jugador p)
			{
				player = p;
				
			}
				
	
	public void habilitarJuego () {
	
		cardLayout.show(contentPane, VentanaJ);
	}
}
