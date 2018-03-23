package Principal;

import Ventanas.Jugar;
import Ventanas.Registro;
import Ventanas.FinestraP;

//Lanzo ventanas
public class Principal {

	public static void main(String[] args) {
		
	//Ventanas usadas
				
		
		//**Ventana FinestraP
		FinestraP fp = new FinestraP(null);
		
		//Creacion ventana Registro y enlace con ventana Jugar
		Registro REG= new Registro(fp);
		
		//Hacer visible la ventana Registro
		REG.setVisible(true);

	}

}
