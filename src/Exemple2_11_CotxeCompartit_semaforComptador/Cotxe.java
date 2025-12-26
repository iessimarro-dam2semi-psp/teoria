package Exemple2_11_CotxeCompartit_semaforComptador;

public class Cotxe {
	//atrr
	private String nom;
	private boolean disponible;
	private final SemaforComptador semafor;
	//Constructor
	public Cotxe(String nomCotxe, SemaforComptador semafor) {
		nom = nomCotxe;	
		disponible = true;
		this.semafor = semafor;
	}
	
	public boolean cercaCotxe() {
		semafor.metodeWait();		//Entrant SECCIO CRITICA amb proteccio
		//************* SECCIO CRITICA *****************************
		return disponible;
	}
	//---------------------------------------
	public void agafaCotxe() {
		//Fent temps per modificar variable booleana
		for (int i=0; i<10000;i++) {
			//No fer res
		}
		setDisponible(false);		//Canviant estat de disponible
		System.out.println("["+Thread.currentThread().getName()	
				+"] Agafant cotxe "+ this.nom+ "...*****");
	}//agafaCotxe
	//---------------------------------------
	public void usarCotxe(int tempsUsCotxe,String llocUsCotxe) {
		try {
			System.out.println("["+Thread.currentThread().getName()
					+"] Usant el cotxe "+ getNom()+ " per anar a "
					+llocUsCotxe+ " durant "+ tempsUsCotxe /1000 +"secs ...");

			Thread.sleep(tempsUsCotxe);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}//usarCotxe
	//---------------------------------------
	public void deixaCotxe() {
		System.out.println("["+Thread.currentThread().getName()	
				+"] Deixant cotxe "+ this.nom+ "...");
		setDisponible(true);
		//************* SECCIO CRITICA *****************************
		semafor.metodeWakeup();	//Alliberament CONDICIO
	}//deixaCotxe
	//---------------------------------------
	public String getNom() {
		return nom;
	}
	//---------------------------------------
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
}//class

