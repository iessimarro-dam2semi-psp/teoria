package Exemple2_14_CotxeCompartit_Semaphore;
import java.util.concurrent.Semaphore;

public class Cotxe {
	//atrr
	private String nom;
	private final Semaphore semafor;

	//Constructor
	public Cotxe(String nomCotxe) {
		nom = nomCotxe;
		System.out.println("["+Thread.currentThread().getName()	+"] Creat el cotxe "+nomCotxe);
		semafor = new Semaphore(1);
	}

	//---------------------------------------
	public synchronized void agafaCotxe() {
		try {
			//Fent temps per modificar variable booleana
			for (int i=0; i<10000;i++) {
				//No fer res
			}
			semafor.acquire();	//>>>>Agafant BLOQUEIG
			//Entrant SECCIO CRITICA amb proteccio
			//************* SECCIO CRITICA *****************************
			System.out.println("["+Thread.currentThread().getName()	
					+"] Agafant cotxe "+ this.nom+ "...*****");
		} catch (InterruptedException e) {
			e.printStackTrace();
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
	public synchronized void deixaCotxe() {
		System.out.println("["+Thread.currentThread().getName()	
				+"] Deixant cotxe "+ this.nom+ "...");
		//************* SECCIO CRITICA *****************************
		semafor.release();	//>>>>Alliberament BLOQUEIG
	}//deixaCotxe
	//---------------------------------------
	public String getNom() {
		return nom;
	}
}//class
