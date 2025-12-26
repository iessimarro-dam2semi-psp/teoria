package Exemple2_14_CotxeCompartit_Semaphore;

public class Main {

	public static void main(String[] args) {

		//creem un objecte compartit
		Cotxe focus = new Cotxe("Ford FOCUS");
		
		//Objectes Runnable
		MembreFamiliar pare = new MembreFamiliar("Treballar", 10000, focus);	
		MembreFamiliar mare = new MembreFamiliar("Botiga", 5000, focus);	
		MembreFamiliar filla = new MembreFamiliar("Universitat", 6000, focus);
		//creacio Fils
		Thread filPare = new Thread(pare,"pare");
		Thread filMare = new Thread(mare,"mare");
		Thread filFilla = new Thread(filla,"filla");
		//llançament fils
		filPare.start();
		filMare.start();
		filFilla.start();
		
		//espera fils
		try {
			filPare.join();
			filMare.join();
			filFilla.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("["+Thread.currentThread().getName()
				+"] Finalització fil ppal");
	}//main
}//class
