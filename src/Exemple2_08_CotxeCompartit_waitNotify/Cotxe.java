package Exemple2_08_CotxeCompartit_waitNotify;

public class Cotxe {
	//atrr
	private String nom;
	private boolean clau;

	//Constructor
	public Cotxe(String nomCotxe) {
		nom = nomCotxe;	
		clau = true;
		System.out.println("["+Thread.currentThread().getName()	+"] Creat el cotxe "+nomCotxe);
	}

	//---------------------------------------
	public boolean isCotxeDisponible() {
		if (clau)  return true;
		else		return false;
	}//isCotxeDisponible

	//---------------------------------------
	public void usarCotxe(int tempsUsCotxe,String llocUsCotxe) {
		try {
			System.out.println("["+Thread.currentThread().getName()
					+"] Usant el cotxe "+ getNom()+ " per anar a "+llocUsCotxe+ " durant "+ tempsUsCotxe /1000 +"secs ...");

			Thread.sleep(tempsUsCotxe);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//usarCotxe

	//---------------------------------------
	public synchronized void metodeWait() {
		try {
			while(!isCotxeDisponible()) {
				System.out.println("["+Thread.currentThread().getName()
						+"] metodeWait() -> El cotxe NO està disponible, espera zZzZz...");
				wait();
			}//while

			//****************SECCIO CRITICA***************************************
			//Cod de la funcio agafaCotxe()
			this.clau = false;		//Canviant estat de clau
			//Fent temps per modificar variable booleana
			for (int i=0; i<10000;i++) {
				//No fer res
			}
			System.out.println("["+Thread.currentThread().getName()	+"] Agafant cotxe "+ this.nom+ "...*****");
			//agafaCotxe

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//metodeWait

	//---------------------------------------
	public synchronized void metodeCanviaEstatClau() {

		//codi de la funcio deixaCotxe()
		System.out.println("["+Thread.currentThread().getName()	+"] Deixant cotxe "+ this.nom+ "...");
		this.clau = true;
		//deixaCotxe
		System.out.println("["+Thread.currentThread().getName()
				+"] metodeCanviaEstatClau() -> El cotxe ja està disponible, desperta fils...");
		//****************SECCIO CRITICA***************************************
		notifyAll();
	}//metodeCanviaEstatClau

	//---------------------------------------
	public String getNom() {
		return nom;
	}
}//class
