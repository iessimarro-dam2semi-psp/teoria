package Exemple2_12_espaguettisCarbonara;

public class MainCuiner {

	public static void main(String[] args) {
		//creacio fils
		Thread filT1 = new Thread(new FilCuinaPasta(),"filPasta");
		Thread filT2 = new Thread(new FilCuinaSalsa(),"filSalsa");
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

		System.out.println("[Fil ppal] Acaba tasques el cuiner");

	}//main
}//class
