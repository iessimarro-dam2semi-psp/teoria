package Exemple2_07_CotxeCompartit;

public class Cotxe {
	//atrr
	private String nom;
	private boolean clau;

	//Constructor
	public Cotxe(String nomCotxe) {
		nom = nomCotxe;	
		clau = true;	//condicio amb valor inicial a true
		System.out.println("["+Thread.currentThread().getName()
				+"] Creat el cotxe "+nomCotxe);
	}

	//---------------------------------------
	public boolean isCotxeDisponible() {
		if (clau) {	return true;
		}else{		return false;
		}
	}//isCotxeDisponible

	//---------------------------------------
	public void agafaCotxe() {
			//Fent temps per modificar variable booleana
			for (int i=0; i<10000;i++) {
				System.out.print("["+Thread.currentThread().getName()	+"] brum");//No fer res
			}
			
			this.clau = false;		//Canviant estat de clau
			System.out.println("["+Thread.currentThread().getName()	+"] Agafant cotxe "+ this.nom+ "...*****");
	}//agafaCotxe

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
	public void deixaCotxe() {
		System.out.println("["+Thread.currentThread().getName()	+"] Deixant cotxe "+ this.nom+ "...");
		this.clau = true;
	}//deixaCotxe

	//---------------------------------------
	public String getNom() {
		return nom;
	}
	//---------------------------------------
	public void setClau(boolean clau) {
		this.clau = clau;
	}
}//class

