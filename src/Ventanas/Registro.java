package Ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Juego.Jugador;
import Ventanas.Jugar;


//CLASE Ventana Inicial
public class Registro extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 2815939040592627306L;
	//ATRIBUTOS
	public JPanel contentPane;
	public JTextField textFieldNOMBRE;
	public JTextField textFieldAPELLIDO1;
	public JTextField textFieldALIAS;
	public JTextField textFieldEDAD;
	private final JLabel lblJuegoMathDice = new JLabel("Juego MATH  DICE");
	public JTextField textFieldCUADROTextoInferior;
	

	//Creo una etiqueta de referencia a un objeto tipo Inicio
    private Registro referencia;
    //Permite acceso desde la ventana Inicio a la ventana Juego, pasándola como referencia
    private FinestraP ventanaJugar;
    //Generamos un nuevo jugador
    private Jugador player1=new Jugador();

    

    //Constructor Ventana de INICIO
    public Registro(FinestraP fp) {
    	
    	
    	// Asocio referencia al objeto creado que es tipo Registro
        referencia=this;
        //La etiqueta ventanaJgar se asocia al input de Registro. Se hace visible a toda la clase
        ventanaJugar=fp;
        //Este truquillo garantiza que al pulsar el botón "A JUGAR" pueda manipular todas las ventanas
        
    	
        //VENTANA
		setBackground(Color.YELLOW);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 326);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
    	
  
		//Etiquetas (JLabel)
		lblJuegoMathDice.setBounds(155, 11, 152, 19);
		lblJuegoMathDice.setForeground(Color.BLUE);
		lblJuegoMathDice.setFont(new Font("Verdana", Font.BOLD, 14));
		contentPane.add(lblJuegoMathDice);
		
		JLabel lblDatosDelJugador = new JLabel("Datos del Jugador (pulsar INTRO en cada campo)");
		lblDatosDelJugador.setBounds(61, 30, 342, 20);
		lblDatosDelJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDelJugador.setBackground(Color.WHITE);
		lblDatosDelJugador.setForeground(Color.RED);
		lblDatosDelJugador.setFont(new Font("Arial", Font.BOLD, 14));
		contentPane.add(lblDatosDelJugador);
			
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 57, 60, 20);
		lblNombre.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(lblNombre);
		
		JLabel lblApellido1 = new JLabel("1er Apellido:");
		lblApellido1.setBounds(10, 88, 71, 14);
		lblApellido1.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(lblApellido1);
		
		JLabel lblAlias = new JLabel("Alias:");
		lblAlias.setBounds(10, 116, 52, 14);
		lblAlias.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(lblAlias);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(224, 116, 46, 14);
		lblEdad.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(lblEdad);

		
		//Entradas (JTextFile)
		textFieldNOMBRE = new JTextField();
		textFieldNOMBRE.setBounds(61, 57, 187, 20);
		contentPane.add(textFieldNOMBRE);
		textFieldNOMBRE.setColumns(10);
		//Listener esperando INTRO
		textFieldNOMBRE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Si pulso Intro se muestra dato del Jugador
				player1.setNombre(textFieldNOMBRE.getText());
			}
		});
		
		textFieldAPELLIDO1 = new JTextField();
		textFieldAPELLIDO1.setBounds(87, 85, 208, 20);
		contentPane.add(textFieldAPELLIDO1);
		textFieldAPELLIDO1.setColumns(10);
		//Listener esperando INTRO
				textFieldAPELLIDO1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					//Si pulso Intro se muestra dato del Jugador
						player1.setApellido1(textFieldAPELLIDO1.getText());
					}
				});
		
		textFieldALIAS = new JTextField();
		textFieldALIAS.setBounds(45, 113, 145, 20);
		contentPane.add(textFieldALIAS);
		textFieldALIAS.setColumns(10);
		//Listener esperando INTRO
			textFieldALIAS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//Si pulso Intro se muestra dato del Jugador
				player1.setAlias(textFieldALIAS.getText());
					}
				});
		
		textFieldEDAD = new JTextField();
		textFieldEDAD.setBounds(261, 113, 46, 20);
		contentPane.add(textFieldEDAD);
		textFieldEDAD.setColumns(10);	
		//Listener esperando INTRO
		textFieldEDAD.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		//Si pulso Intro se muestra dato del Jugador
			player1.setEdad(textFieldEDAD.getText());
				}
			});
			
		//Botón A JUGAR
		JButton btnBotonJUGAR = new JButton("A  JUGAR");
		btnBotonJUGAR.setBounds(121, 172, 221, 31);
		btnBotonJUGAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0 ) {
				//Cuando pulso el botón "A JUGAR" escribe mensaje en la caja de texto inferior de la ventana
				if (player1.espaciosBlanco(player1.getNombre())) {
					textFieldCUADROTextoInferior.setText("Falta NOMBRE o pulsar Intro");
				} else if (player1.espaciosBlanco(player1.getApellido1())) {
					textFieldCUADROTextoInferior.setText("Falta 1er APELLIDO o pulsar Intro");
				} else if (player1.espaciosBlanco(player1.getAlias())) {
					textFieldCUADROTextoInferior.setText("Falta ALIAS o pulsar Intro");
				} //else if (player1.espaciosBlanco(player1.getEdad())) {
					//textFieldCUADROTextoInferior.setText("Falta EDAD o pulsar Intro");	
				 else if (player1.esNumero(textFieldEDAD.getText())) {
					textFieldCUADROTextoInferior.setText("EDAD no es un número");
				} 					else {
					textFieldCUADROTextoInferior.setText("Nuevo JUGADOR: "+player1.getNombre()+" "+player1.getApellido1()+"  "+"(alias: "+player1.getAlias()+"- "+player1.getEdad()+" años)");

					//Paso datos de jugador
					ventanaJugar.setJugador(player1);
					// Habilitar menu juego
					ventanaJugar.habilitarJuego();					
					//Abro Jugar
					ventanaJugar.setVisible(true);
					//Cierro Registro
					referencia.setVisible(false);
				}
			}
		});
	
	btnBotonJUGAR.setForeground(new Color(199, 21, 133));
	btnBotonJUGAR.setFont(new Font("Arial", Font.BOLD, 16));
	contentPane.add(btnBotonJUGAR);
	
	textFieldCUADROTextoInferior = new JTextField();
	textFieldCUADROTextoInferior.setBounds(10, 201, 428, 75);
	contentPane.add(textFieldCUADROTextoInferior);
	textFieldCUADROTextoInferior.setColumns(10);

}

}
