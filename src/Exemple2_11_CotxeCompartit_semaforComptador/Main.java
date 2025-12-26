package Exemple2_11_CotxeCompartit_semaforComptador;

public class Main {
	public static void main(String[] args) {

		//creem el objecte SEMAFOR compartit
		SemaforComptador semaforCompt = new SemaforComptador(2);

		//creem un objecte compartit
		Cotxe focus = new Cotxe("Ford FOCUS", semaforCompt);
		Cotxe p308 = new Cotxe("Peugeot 308", semaforCompt);

		//creacio Fils amb Objectes Runnable
		Thread fils[] = new Thread [4];
		fils[0] = new Thread(new MembreFamiliar("Treballar", 10000, focus, p308),"pare");
		fils[1] = new Thread(new MembreFamiliar("Botiga", 5000, focus ,p308),"mare");
		fils[2]  = new Thread(new MembreFamiliar("Universitat", 6000, focus, p308),"filla");
		fils[3]  = new Thread(new MembreFamiliar("Institut", 6000, focus, p308),"fill");
		
		//llançament fils
		for(Thread fil : fils) {
			fil.start();
		}//for

		//espera fils
		try {
			for(Thread fil : fils) {
				fil.join();
			}//for
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("["+Thread.currentThread().getName()
				+"] Finalització fil ppal");
	}//main
}//class
