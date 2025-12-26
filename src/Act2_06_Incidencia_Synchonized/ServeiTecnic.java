package Act2_06_Incidencia_Synchonized;
import java.io.*;

public class ServeiTecnic {
	//attr
	private int numIncidencia;		//num incidencies resoltes
	private int maxIncidencies;		//max incidencies resoltes per dia
	private int idNovaIncidencia;	//id de la nova incidencia a atendre


	//CONSTRUCTOR 1
	public ServeiTecnic(int maxIncidencies) throws IOException {
		this.maxIncidencies = maxIncidencies;
		this.numIncidencia = 0;
		this.idNovaIncidencia = 0;
	}

	//--------------------------------
	public int getIdNovaIncidencia() {
		synchronized(this) {
		return ++idNovaIncidencia;		//retorna identificador de nova incidència incrementada
		}
	}//getNumIncidencia
	//--------------------------------	
	public boolean isMaxIncidenciesReached() {
		if ((getNumIncidencia() + 1) == maxIncidencies)
			return true;	//Si shan atés totes les incidencies del dia, retorna true
		else {
			return false;
		}//else
	}//isMaxIncidenciesReached
	//--------------------------------
	public int getNumIncidencia() {
		return numIncidencia;
	}//getNumIncidencia

	//--------------------------------
	public void setNumIncidencia(int numIncidencia) {
		this.numIncidencia = numIncidencia;
	}//setNumIncidencia
	//--------------------------------

//	public boolean incrementaIncidencia(String nomTecnic) {
	public void incrementaIncidencia(String nomTecnic) {
		try {
			//******************************************
				synchronized(this) {
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
}//class
