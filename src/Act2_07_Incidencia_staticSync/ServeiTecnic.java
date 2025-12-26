package Act2_07_Incidencia_staticSync;
import java.io.*;

public class ServeiTecnic {
	//attr
	static int numIncidencia;		//num incidencies resoltes
	static int maxIncidencies;		//max incidencies resoltes per dia
	static int idNovaIncidencia;	//id de la nova incidencia a atendre


	//CONSTRUCTOR 1
	public ServeiTecnic(int maxIncidencies) throws IOException {
		maxIncidencies = maxIncidencies;
		numIncidencia = 0;
		idNovaIncidencia = 0;
	}

	//--------------------------------
	static int getIdNovaIncidencia() {
		synchronized(ServeiTecnic.class) {
			idNovaIncidencia++;		//retorna identificador de nova incidència incrementada
		}
		return idNovaIncidencia;
	}//getNumIncidencia
	//--------------------------------	
	public boolean isMaxIncidenciesReached() {
		if ((getNumIncidencia() + 1) == maxIncidencies)
			return true;	//Si shan atés totes les incidencies del dia, retorna true
		else {
			return false;
		}//else
	}//isMaxIncidenciesReached


//	public boolean incrementaIncidencia(String nomTecnic) {
	static void incrementaIncidencia(String nomTecnic) {
		try {
			//******************************************
				synchronized(ServeiTecnic.class) {
					int nIncidencia = getNumIncidencia();
					System.out.println("["+ nomTecnic +"]"+ " Demana incrementar incidències resoltes (quantitat actual:"+ nIncidencia +")");
					Thread.sleep(50);
					setNumIncidencia(nIncidencia + 1);		//incrementa num incidències
					System.out.println("["+ nomTecnic +"]"+ " Num incidències resoltes: "+ getNumIncidencia());
				}//synchronized
				//******************************************
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//incrementaIncidencia
	
	//--------------------------------
	static int getNumIncidencia() {
		return numIncidencia;
	}//getNumIncidencia

	//--------------------------------
	static void setNumIncidencia(int nouNumIncidencia) {
		numIncidencia = nouNumIncidencia;
	}//setNumIncidencia
	//--------------------------------
}//class
