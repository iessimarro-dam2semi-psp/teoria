package Act2_03_ThreadComptador;

import Exemple2_02_createThreads2.Exemple2_02_createThreads2;

public class Act2_03_ThreadComptador implements Runnable{

	//Propietats --------------------------------
	private int comptador;

	//Constructor --------------------------------
	public Act2_03_ThreadComptador() {
		this.comptador = 0;
	}//constructor

	//mètode Run -----------------------------------
	public void run(){
		while(comptador < 5) {
			String nomActual = Thread.currentThread().getName();
			System.out.println ("["+ nomActual + "] Comptador = "+ comptador);
			comptador++;
		}//while
	}//run

	//Métode main -------------------------------
	public static void main(String[] args) {
		System.out.println("[Fil ppal] -> Comptador amb fils implementant Runnable \n");
		//declaració d'un vector de 3 objectes Runnable
		Act2_03_ThreadComptador[] objectes = new Act2_03_ThreadComptador[3];
		//declaració d'un vector de 3 Threads
		Thread[] fils = new Thread[3];
		
		for(int i=0; i<3; i++) {
			String nomFil = "Fil"+ (i+1);
			
			System.out.println("[Fil ppal] Creant nou fil "+nomFil);
			objectes[i] = new Act2_03_ThreadComptador();
			fils[i] = new Thread(objectes[i],nomFil);
			
			System.out.println("[Fil ppal] Executant nou fil "+nomFil);
			fils[i].start();
		}//for
		
		System.out.println("[Fil ppal] 3 fils creats...");

		try {
			for(int i=0; i<3; i++) {
				fils[i].join();	//fil ppal espera finalització del fil i			
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("[Fil ppal] els 3 fils han finalitzat");
	} //main
}//class