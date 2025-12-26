package Exemple2_11_CotxeCompartit_semaforComptador;

public class MembreFamiliar  implements Runnable{
	int tempsUsCotxe;
	String llocUsCotxe;
	Cotxe cotxe1;
	Cotxe cotxe2;

	//Constructor
	public MembreFamiliar(String llocNecessitatCotxe, int tempsNecessitatCotxe
			, Cotxe cotxe1, Cotxe cotxe2) {
		llocUsCotxe = llocNecessitatCotxe;
		tempsUsCotxe = tempsNecessitatCotxe;
		this.cotxe1 = cotxe1;
		this.cotxe2 = cotxe2;

		System.out.println("["+Thread.currentThread().getName()
				+"] Creat el membre familiar");
	}
	//---------------------------------------
	public void run() {
		System.out.println("["+Thread.currentThread().getName()
				+"] Necesita un cotxe per anar a "+llocUsCotxe
				+ " durant "+ tempsUsCotxe/1000 +"secs");
		
		Cotxe cotxe;
		if(cotxe1.cercaCotxe())	//si 1r cotxe no està ocupat, s'afafa eixe
			cotxe = cotxe1;
		else 						//si 2n cotxe no està ocupat, s'afafa eixe
			cotxe = cotxe2;
		
		cotxe.agafaCotxe();
		cotxe.usarCotxe(tempsUsCotxe, llocUsCotxe);
		cotxe.deixaCotxe();
		
	}//run
}//class
