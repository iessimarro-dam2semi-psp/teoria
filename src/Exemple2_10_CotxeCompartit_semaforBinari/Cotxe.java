package Exemple2_10_CotxeCompartit_semaforBinari;

public class Cotxe {
	//atrr
	private String nom;
	private final SemaforBinari semafor;

	//Constructor
	public Cotxe(String nomCotxe, SemaforBinari semafor) {
		nom = nomCotxe;
		System.out.println("["+Thread.currentThread().getName()	+"] Creat el cotxe "+nomCotxe);
		this.semafor = semafor;
		}

	//---------------------------------------
	public void agafaCotxe() {
		semafor.metodeWait();		//Entrant SECCIO CRITICA amb proteccio
		//************* SECCIO CRITICA *****************************
		System.out.println("["+Thread.currentThread().getName()	
				+"] Agafant cotxe "+ this.nom+ "...*****");
		//Fent temps per modificar variable booleana
		for (int i=0; i<10000;i++) {
			//No fer res
		}
	}//agafaCotxe
	//---------------------------------------
	public void usarCotxe(int tempsUsCotxe,String llocUsCotxe) {
		try {
			System.out.println("["+Thread.currentThread().getName()
					+"] Usant el cotxe "+ getNom()+ " per anar a "
					+llocUsCotxe+ " durant "+ tempsUsCotxe /1000 +"secs ...");

			Thread.sleep(tempsUsCotxe);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//usarCotxe
	//---------------------------------------
	public void deixaCotxe() {
		System.out.println("["+Thread.currentThread().getName()	
				+"] Deixant cotxe "+ this.nom+ "...");
		//************* SECCIO CRITICA *****************************
		semafor.metodeWakeup();	//Alliberament CONDICIO
	}//deixaCotxe
	//---------------------------------------
	public String getNom() {
		return nom;
	}
}//class
