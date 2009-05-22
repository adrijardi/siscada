package com.umbrella.mail.message;




/* 
 * tiene el nombre de todos los mensajes que se pueden usar
 */
public enum OntologiaMSG {
	ACTUALIZARCONTEXTO("ActualizarContexto",0),
	ACTUALIZARCONTEXTOROBOT("ActualizarContextoRobot",0),//se pasa el nuevo contexto en el objeto
	ACTUALIZARCONFIGURACION("ActualizarConfiguracion",0),//se pasa el nuevo configuracion en el objeto
	AVISARUNFALLO("AvisarUnFallo",1),//nombre de la maquina q causa el fallo, sacado del enumerado
	INTERFERENCIA("Interferencia",2), //primer parametro es el robot que la causa y el 2 parametro es la cinta en la que la causa, se saca del enumerado de Maquinas
	FININTERFERENCIA("FinInterferencia",2),//parametro 1 el robot y el 2 la conta
	PASTELLISTO("PastelListo",0),
	BLISTERLISTO("BlisterListo",4),
	BLISTERCOMPLETO("BlisterCompleto",4),
	BLISTERALMACENADO("BlisterAlmacenado",1), // el parametro dice si es valido o no lo es
	BLISTERVALIDO("BlisterValido",0),
	BLISTERNOVALIDO("BlisterNoValido",0),
	ARRANCAR("Arrancar",3),
	PARADA("Parada",2),
	PARADAFALLO("ParadaFallo",2),
	PARADAEMERGENCIA("ParadaEmergencia",2),
	ARRANCARDESDEEMERGENCIA("ArrancarDesdeEmergencia",4),
	RESET("Reset",2),
	PRODUCTORECOGIDO("ProductoRecogido",2), //primer parametro el robot y segundo parametro el tipo de producto
	FINCINTALIBRE("FinCintaLibre",3),
	PRODUCTOCOLOCADO("ProductoColocado",2), //primer parametro es el robot y el 2� es el producto
	RELLENARMAQUINA("RellanarMaquina",3), // en el vector 0 el nombre de la maquina sacado del Numerado y el sig parametro un int contertido a String que es la cantidad
	MODIFICARCAMPO("ModificarCampo",4),
	//MOVERDESDEMESA("MoverDesdeMesa",2), 
	AUTOM_STATE("AutomState",0),//parametro 1 String["AU1", "AU2", "AU3", "RB1", "RB2"], Boolean(true, false)
	CAKE_DEPOT("CakeDepot",0),
	AU1_CAKES_POS("Au1CakesPos",0),
	ROBOT_SET_CONTENT("RobotSetContent",0)
	; 
	
	
	private final String nombre;
	private int numParametros;
	//private String[] parametros;
	
	private OntologiaMSG(String nombreClase, int numParametros){
		this.nombre=nombreClase;
		this.numParametros=numParametros;
		// this.parametros=parametros;
	}

	public String getNombre() {
		return nombre;
	}

	public int getNumParametros() {
		return numParametros;
	}
	
}
