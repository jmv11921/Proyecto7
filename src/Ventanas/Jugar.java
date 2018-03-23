package Ventanas;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
//import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

//import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Juego.Jugador;

public class Jugar extends JFrame {

	private static final long serialVersionUID = 8792777489928696903L;
	//Atributos
	private JPanel contentPane;

	private Jugador player1; //recoge el paso por referencia desde la ventana Registro
	private Random aleatorio = new Random();	

	//atributos JLabel
	private JLabel JLabel_Saludo;
	private JLabel dado1,dado2,dado3,dado4,dado5,dado6;
	private JLabel labelSuma;
	private JLabel labelResta;
	
	//atributos JTextField
	private JTextField txtPuntuacion;
	private JTextField txtOperacion;
	private JTextField txtComentarios;		
	
	//atributos Jbutton
	private JButton botonVerificar;
	private JButton botonRepite;
				
	//Variable "semáforo" para saber si toca número o operacion
	private boolean tocaNumero=true;		//true = toca numero
	private boolean tocaOperacion=false;	//true = toca operacion
		
		//Otra variable de tipo "semáforo" para saber si toca suma o resta
		private boolean tocaSumar = false;		//true = toca sumar
		private boolean tocaRestar = false;		//true = toca restar
		
		//Variable para almacenar las operaciones que realizaremos
		private int resultadoOperaciones=0;
		
		//Variable para la puntuación del jugador
		private int puntuacion=0;
		
		//Variable para almacenar el valor del dado de 12 caras
		private int valorDado_12=0;
	
	//Variables necesarias para asignar las imágenes de los dados necesarios aleatoriamente

	
	//Array que almacena las imágenes de los dados
	private ImageIcon[] dados3 = new ImageIcon[3];
	private ImageIcon[] dados6 = new ImageIcon[6];
	private ImageIcon[] dado12 = new ImageIcon[12];

	private ImageIcon dadogris = new ImageIcon(getClass().getResource("/img/dadogris.png"));
	
	//Array que almacena los números aleatorios
	private int[] numAleatorio = new int [6]; 

	//CONSTRUCTOR
	public Jugar() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel_Saludo = new JLabel("Saludo Jugador");
		JLabel_Saludo.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_Saludo.setBounds(92, 16, 240, 32);
		contentPane.add(JLabel_Saludo);		

		//Cuadrados para las imagenes de los dados
		dado1= new JLabel("dado1");
		dado1.setBounds(10, 59, 70, 68);
		contentPane.add(dado1);
		
		dado2= new JLabel("dado2");
		dado2.setBounds(92, 59, 72, 72);
		contentPane.add(dado2);
		
		dado3= new JLabel("dado3");
		dado3.setBounds(174, 59, 72, 72);
		contentPane.add(dado3);
		
		dado4= new JLabel("dado4");
		dado4.setBounds(10, 142, 72, 72);
		contentPane.add(dado4);
		
		dado5= new JLabel("dado5");
		dado5.setBounds(92, 142, 72, 72);
		contentPane.add(dado5);
		
		dado6= new JLabel("dado6");
		dado6.setBounds(55, 246, 89, 85);
		contentPane.add(dado6);
		
		//Etiqueta para poner la imagen de la suma
				labelSuma = new JLabel("+");
				labelSuma.setBounds(239, 142, 72, 67);
				getContentPane().add(labelSuma);
				ImageIcon suma = new ImageIcon(getClass().getResource("/img/suma.png"));		//Creamos un objeto imageicon con la ruta de la imagen que queremos
				labelSuma.setIcon(suma);
				labelSuma.setName("Suma");
				labelSuma.addMouseListener(new ListenerOperaciones());
				
		//Etiqueta para poner la imagen de la resta
				labelResta = new JLabel("-");
				labelResta.setBounds(321, 142, 72, 67);
				getContentPane().add(labelResta);
				ImageIcon resta = new ImageIcon(getClass().getResource("/img/resta.png"));		//Ponemos la imagen
				labelResta.setIcon(resta);
				labelResta.setName("Resta");
				labelResta.addMouseListener(new ListenerOperaciones());
		
		//Campo texto OPERACION
		txtOperacion = new JTextField();
		txtOperacion.setHorizontalAlignment(SwingConstants.CENTER);
		txtOperacion.setBounds(220, 219, 204, 32);
		contentPane.add(txtOperacion);
		txtOperacion.setColumns(10);
		
		//Campo texto PUNTUACION
		txtPuntuacion = new JTextField();
		txtPuntuacion.setHorizontalAlignment(SwingConstants.CENTER);
		txtPuntuacion.setText("Puntuacion");
		txtPuntuacion.setBounds(326, 79, 98, 32);
		contentPane.add(txtPuntuacion);
		txtPuntuacion.setColumns(10);
		
		//Botón MATHDICE
		JButton botonVerificar = new JButton("MATHDICE");
		botonVerificar.setBounds(256, 262, 138, 32);
		botonVerificar.addActionListener(new ListenerBotonVerificar());
		contentPane.add(botonVerificar);		
		
		//Botón REPITE JUGADA
		JButton botonRepite = new JButton("REPITE JUGADA");
		botonRepite.setEnabled(false);
		botonRepite.addActionListener(new ListenerBotonRepite());
		botonRepite.setBounds(256, 302, 138, 32);
		contentPane.add(botonRepite);
		
		//Campo texto COMENTARIOS
		txtComentarios = new JTextField();
		txtComentarios.setHorizontalAlignment(SwingConstants.CENTER);
		txtComentarios.setBounds(220, 345, 204, 32);
		contentPane.add(txtComentarios);
		txtComentarios.setColumns(10);
		
		inicializarDados();
	}
		
	//Método para inicializar DADOS
	private void inicializarDados() {
		
        for(int i=0;i<dados3.length;i++){	
		dados3[i]=new ImageIcon(getClass().getResource("/img/dado"+String.valueOf(i+1)+"_3.png"));
		//Solución para redimensionar las imágenes al tamaño de las cajas JLabel (no me funciona en el for):
		//Icon icono= new ImageIcon(dados3[i].getImage().getScaledInstance(dado[i].getIconWidth(), dado[i].getIconHeight(), Image.SCALE_DEFAULT));
		//dado[i].setIcon(icono);
		}
        
        for(int i=0;i<dados6.length;i++){
        dados6[i]=new ImageIcon(getClass().getResource("/img/dado"+String.valueOf(i+1)+"_6.png"));
		}
        
		for(int i=0;i<dado12.length;i++){
		dado12[i]=new ImageIcon(getClass().getResource("/img/dado"+String.valueOf(i+1)+"_12.png"));
		}
		
		dadogris = new ImageIcon(getClass().getResource("/img/dadogris.png"));
	
	
		//Rellenamos el array numAleatorio
				for(int i=0; i<3; i++){
					numAleatorio[i] = aleatorio.nextInt(3);	  //Numero aleatorio entre 0 y 2
				}
				for(int i=3; i<5; i++){
					numAleatorio[i] = aleatorio.nextInt(6);	  //Numero aleatorio entre 0 y 5
				}
				numAleatorio[5] = aleatorio.nextInt(12);	  //Numero aleatorio entre 0 y 11
				
				//Creamos los dados con las imágenes aleatorias de dados
				dado1.setIcon(dados3[numAleatorio[0]]);
				dado2.setIcon(dados3[numAleatorio[1]]);
				dado3.setIcon(dados3[numAleatorio[2]]);
				dado4.setIcon(dados6[numAleatorio[3]]);
				dado5.setIcon(dados6[numAleatorio[4]]);
				dado6.setIcon(dado12[numAleatorio[5]]);
				
				//Nombramos los JLabels para identificarlos
				dado1.setName("1");
				dado2.setName("2");
				dado3.setName("3");
				dado4.setName("4");
				dado5.setName("5");
				dado6.setName("6");
	
				//Añadimos los MouseListeners a cada uno de los 5 dados con los que operamos para cuando se pulse sobre estos
				dado1.addMouseListener(new ListenerDados());
				dado2.addMouseListener(new ListenerDados());
				dado3.addMouseListener(new ListenerDados());
				dado4.addMouseListener(new ListenerDados());
				dado5.addMouseListener(new ListenerDados());
				
				//Añadimos los MouseListeners a los iconos de suma y resta para cuando se pulse sobre estos
				labelSuma.addMouseListener(new ListenerOperaciones());
				labelResta.addMouseListener(new ListenerOperaciones());
				
				//Ponemos el semáforo en true ya que al empezar tocará seleccionar número
				tocaNumero = true;
				
				//Inicializamos contador operaciones
				resultadoOperaciones=0; 
				
				//Almacenamos el valor del dado de 12 en una variable int
				int dado_12=Integer.valueOf(dado6.getName());
				int valorDado12 = numAleatorio[dado_12-1] + 1;	//Obtenemos el valor del dado de 12 caras
				valorDado_12 = valorDado12;						//Lo asignamos a esta variable para poder utilizarla fuera de este método

				sePuedeJugar(); 								//Llamamos al método para comprobar que sea jugable

				}

		
	//Texto de BIENVENIDA JUGADOR	
	//Setter
		public void setJugador(Jugador player1)
		{
			this.setPlayer1(player1);
			JLabel_Saludo.setText("Bienvenido "+player1.getNombre()+" al juego");
		}
		
		
//Método para realizar las operaciones
public void operacion(int num){
if(tocaSumar){							//Si toca sumar sumaremos el parámetro a la variable del resultado
	resultadoOperaciones = resultadoOperaciones + num;
	}
else if(tocaRestar){					//Si no toca restar restaremos el parámetro a la variable del resultado
	resultadoOperaciones = resultadoOperaciones - num;}
	else{resultadoOperaciones=num;} // Si no toca ni sumar ni restar, cogemos el número
}

//MÉTODO PARA COMPROBAR QUE LA SUMA DE TODOS SEA MAYOR O IGUAL QUE EL DADO DE 12 CARAS, SI NO NO SE PUEDE JUGAR Y DEBEREMOS VOLVER A LANZAR LOS DADOS
//De esta manera nunca ocurrirá que por ejemplo salga en todos los dados el 1, y en el dado de 12 un 10, por ejemplo.
public void sePuedeJugar(){

int dado1_3=Integer.valueOf(dado1.getName());
int valorDado1_3= numAleatorio[dado1_3 - 1]+1;
int dado2_3=Integer.valueOf(dado2.getName());
int valorDado2_3= numAleatorio[dado2_3 - 1]+1;
int dado3_3=Integer.valueOf(dado3.getName());
int valorDado3_3= numAleatorio[dado3_3 - 1]+1;
int dado1_6=Integer.valueOf(dado4.getName());
int valorDado1_6= numAleatorio[dado1_6 - 1]+1;
int dado2_6=Integer.valueOf(dado5.getName());
int valorDado2_6= numAleatorio[dado2_6 - 1]+1;

//Cada vez que se lancen los dados, comprobará que la suma de todos sea al menos igual que el valor del de 12, si no, volverá a lanzarlos.
while((valorDado1_3+valorDado2_3+valorDado3_3+valorDado1_6+valorDado2_6)<valorDado_12){
	inicializarDados();
	}
}

public Jugador getPlayer1() {
	return player1;
}


public void setPlayer1(Jugador player1) {
	this.player1 = player1;
}


public JPanel getContentPane() {
	return contentPane;
}

public void setContentPane(JPanel contentPane) {
	this.contentPane = contentPane;
}

//Creamos la 'Inner class' ListenerDados
class ListenerDados implements MouseListener{
	
@Override
public void mouseClicked(MouseEvent e) {
// Acción a realizar al hacer click
JLabel dado = (JLabel) e.getSource(); 				//Esto comprueba sobre que dado se ha presionado
int numeroDado = Integer.valueOf(dado.getName());
int valorDado = numAleatorio[numeroDado-1] + 1;		//Esta variable almacenará el valor del dado que hemos presionado
if(tocaNumero){
	operacion(valorDado);							//Llamamos al método para realizar la operación necesaria
	dado.setIcon(dadogris); 						//Ponemos el dado gris
	tocaNumero=false;													
	tocaOperacion=true;
	txtOperacion.setText(txtOperacion.getText() + String.valueOf(valorDado));
	dado.removeMouseListener(this);
	}	
}

@Override
//Indica al compilador que estamos “sobreescribiendo” un método ya existente
public void mouseEntered(MouseEvent arg0) {
}
public void mouseExited(MouseEvent arg0) {
}
public void mousePressed(MouseEvent arg0) {
}
public void mouseReleased(MouseEvent arg0) {
}
}
	
//Creamos la 'Inner class' ListenerOperaciones
class ListenerOperaciones implements MouseListener{

public void mouseClicked(MouseEvent e) {
	// Acción a realizar al hacer click
		JLabel operacion = (JLabel) e.getSource(); //Esto comprueba sobre que operacion se ha dado el evento
		if(tocaOperacion){
			if(operacion.getName()=="Resta"){							
				tocaSumar=false;
				tocaRestar=true;
				txtOperacion.setText(txtOperacion.getText() + "-"); 	//Añadimos el símbolo de la resta a la caja de texto
			}
			else if(operacion.getName()=="Suma"){
				tocaSumar=true;
				tocaRestar=false;
				txtOperacion.setText(txtOperacion.getText() + "+"); 	//Añadimos el símbolo de la suma a la caja de texto
			}
			tocaNumero=true;		//Una vez presionada una operación, volverá a tocar un número
			tocaOperacion=false;	
			}
		}

@Override
//Indica al compilador que estamos “sobreescribiendo” un método ya existentes
public void mouseEntered(MouseEvent arg0) {
	}
public void mouseExited(MouseEvent arg0) {
	}
public void mousePressed(MouseEvent arg0) {
	}
public void mouseReleased(MouseEvent arg0) {
	}
}

//Creamos la 'Inner class' ListenerBotonRepite
class ListenerBotonRepite implements ActionListener{

public void actionPerformed(ActionEvent arg0) {
	//Accion a realizar al presionar el boton
	inicializarDados();
	botonRepite.setEnabled(false);
	tocaNumero=true;											//Al volver a jugar, tocará número y no operación
	tocaSumar=true;												//Al volver a jugar, tocará que el primer número se sume a la variable
	tocaOperacion=false;
	botonVerificar.setEnabled(true); 							//Volveremos a activar el botón de comprobar
	if(botonRepite.getText()=="REPITE JUGADA"){
		resultadoOperaciones=0;									//Reiniciamos la variable del resultado
		//txtPuntuacion.setText("Puntuacion: 0"); 					//Reiniciamos la etiqueta que muestra el resultado
		puntuacion=0;											//Reiniciamos la variable de la puntuación
		txtComentarios.setText("");
	}
	else if(botonRepite.getText()=="Continuar"){
		resultadoOperaciones=0;									//También se reinicia la variable en este caso
		txtComentarios.setText("");
	}
	botonRepite.setText("REPITE JUGADA");
	botonRepite.setEnabled(false);
}
}

//Creamos la 'Inner class' ListenerBotonVerificar
class ListenerBotonVerificar implements ActionListener{

public void actionPerformed(ActionEvent e) {
	//Accion a realizar al presionar el boton
	JButton botonVerificar = (JButton)e.getSource();
	botonVerificar.setEnabled(false); 		//Para que no se pueda presionar más veces y aumente la puntuación
	
	JPanel panel = (JPanel) botonVerificar.getParent();
	JButton botonRepite = (JButton) panel.getComponent(11);
	
	if(resultadoOperaciones==valorDado_12){
		puntuacion=puntuacion+5;
		//txtPuntuacion.setText("Puntuacion: " + String.valueOf(puntuacion));	//Aumentamos la puntuación del jugador		
		botonRepite.setText("Continuar");										//Cambiamos el texto del boton
		txtComentarios.setText("Correcto!");
	}
	else{
		botonRepite.setText("Reintentar");										//Cambiamos el texto del boton
		txtComentarios.setText("Incorrecto. Vuelve a comenzar");
	}
	botonRepite.setEnabled(true); 		
	
}


//Indica al compilador que estamos “sobreescribiendo” un método ya existentes
public void mouseEntered(MouseEvent arg0) {
}
public void mouseExited(MouseEvent arg0) {
}
public void mousePressed(MouseEvent arg0) {
}
public void mouseReleased(MouseEvent arg0) {
}

}
}