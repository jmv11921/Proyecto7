package Juego;

//CLASE
public class Jugador {
	
		// Declaro ATRIBUTOS y TIPOS de la Clase
		private String nombre;
		private String apellido1;
		private String alias;
		private String edad;
		
		// CONSTRUCTOR
		public Jugador() {
			init();
		}
		
		public void init() {
				this.nombre = "";
				this.apellido1 = "";
				this.alias = "";
				this.edad = "";
				
			}
		
		// METODOS (geters y seters)
		public String getNombre(){
			return nombre;}
		public void setNombre (String nombre){
			this.nombre = nombre;}
		
		public String getApellido1(){
			return apellido1;}
		public void setApellido1 (String apellido1){
			this.apellido1 = apellido1;}
		
		public String getAlias(){
			return alias;}	
		public void setAlias (String alias){
			this.alias = alias;}
		
		public String getEdad(){
			return edad;}
		public void setEdad(String edad){
			this.edad = edad;}
		

		
		//Verifica si una cadena es un valor numérico
		public boolean esNumero(String edad){
		try {
		Integer.parseInt(edad);
		return false;
		} catch (Exception e){
		return true;
		}
		}
			
		
		// Verifica si una cadena son espacios en blanco 
		 public boolean espaciosBlanco(String cad)
		 	{
		 	for(int i =0; i<cad.length(); i++)
		 		if(cad.charAt(i) != ' ')
		 		return false;
		 			return true;
		 	}
		 

			
		public String toString(){
			return this.nombre+"  "+this.apellido1+"  "+this.alias+" "+this.edad;
		}
}