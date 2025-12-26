package Exemple2_13_espaguettisCarbonara_WaitNotify;

public class MainCuiner {

	public static void main(String[] args) {
		//creació objecte plat
		SemaforSincron semaforSincron = new SemaforSincron();
		//creacio fils
		Thread filT1 = new Thread(new FilCuinaPasta(semaforSincron),"filPasta");
		Thread filT2 = new Thread(new FilCuinaSalsa(semaforSincron),"filSalsa");
		System.out.println("[Fil ppal] Comença tasques el cuiner...");
		//llançament fils
		filT1.start();
		filT2.start();

		try {//espera finalitzacio fils
			filT1.join();
			filT2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}//catch

		System.out.println("[Fil ppal] Plat acabat!");
		System.out.println("[Fil ppal] Acaba tasques el cuiner");

	}//main
}//class
