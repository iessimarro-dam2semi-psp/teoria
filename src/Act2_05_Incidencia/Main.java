package Act2_05_Incidencia;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Programa del SERVEI TECNIC\n=========================");
		ServeiTecnic servei = new ServeiTecnic(5);
		System.out.println("[Programa ppal] Inici amb " + servei.getNumIncidencia()+" incidències resoltes");

		//Creació de 2 tecnics
		Tecnic  tecnic1 = new Tecnic(servei);
		Tecnic tecnic2 = new Tecnic(servei);

		//Convertint tecnics en fils
		Thread filTecnicA = new Thread(tecnic1, "TecnicA");
		Thread filTecnicB = new Thread(tecnic2, "TecnicB");
		//Llançant els fils
		filTecnicA.start();
		filTecnicB.start();
		//Esperant finalitzacio dels fils
		filTecnicA.join();
		filTecnicB.join();

		System.out.println("[Programa ppal] Finalitzacio del programa ppal amb " + servei.getNumIncidencia() +" incidències resoltes");
	}//main
}//class
