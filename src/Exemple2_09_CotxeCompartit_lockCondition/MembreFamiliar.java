package Exemple2_09_CotxeCompartit_lockCondition;

public class MembreFamiliar  implements Runnable{
	int tempsUsCotxe;
	String llocUsCotxe;
	Cotxe cotxe;

	//Constructor
	public MembreFamiliar(String llocNecessitatCotxe, int tempsNecessitatCotxe, Cotxe cotxe) {
		llocUsCotxe = llocNecessitatCotxe;
		tempsUsCotxe = tempsNecessitatCotxe;
		this.cotxe = cotxe;

		System.out.println("["+Thread.currentThread().getName()
				+"] Creat el membre familiar");
	}

	//---------------------------------------
	public void run() {
		System.out.println("["+Thread.currentThread().getName()
				+"] Necesita el cotxe "+ cotxe.getNom()+ " per anar a "+llocUsCotxe
				+ " durant "+ tempsUsCotxe/1000 +"secs");
		try {
			cotxe.metodeWait();

			//Entrant SECCIO CRITICA amb proteccio
			//************* SECCIO CRITICA *****************************
			cotxe.usarCotxe(tempsUsCotxe, llocUsCotxe);
			//************* SECCIO CRITICA *****************************
			cotxe.metodeCanviaEstatClau();	//Alliberament CONDICIO
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//run
}//class
