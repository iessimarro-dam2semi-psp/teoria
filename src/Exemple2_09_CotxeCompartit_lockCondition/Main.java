package Exemple2_09_CotxeCompartit_lockCondition;

public class Main {

	public static void main(String[] args) {

		//creem un objecte compartit
		Cotxe focus = new Cotxe("Ford FOCUS");
		//creacio Fils amb Objectes Runnable
		Thread filPare = new Thread(new MembreFamiliar("Treballar", 10000, focus),"pare");
		Thread filMare = new Thread(new MembreFamiliar("Botiga", 5000, focus),"mare");
		Thread filFilla = new Thread(new MembreFamiliar("Universitat", 6000, focus),"filla");

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
