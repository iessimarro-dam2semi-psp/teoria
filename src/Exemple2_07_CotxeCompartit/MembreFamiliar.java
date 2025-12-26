package Exemple2_07_CotxeCompartit;

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
				+"] Necesita el cotxe "+ cotxe.getNom()+ " per anar a "+llocUsCotxe+ " durant "+ tempsUsCotxe/1000 +"secs");
		
		if(cotxe.isCotxeDisponible()) {
			cotxe.agafaCotxe();
			cotxe.usarCotxe(tempsUsCotxe, llocUsCotxe);
			cotxe.deixaCotxe();
		}else{
			System.out.println("["+Thread.currentThread().getName()
					+"] El cotxe NO està disponible, espera");
		}//if

	}//run
}//class
