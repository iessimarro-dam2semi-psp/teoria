package Act2_10_espaguettisCarbonara_Semafor;

public class MainCuiner {

	public static void main(String[] args) {
		//creació objecte plat
		Plat plat = new Plat();
		//creació objecte Semafor de sincronització
		Semafor semafor = new Semafor();
		//creacio fils
		Thread filT1 = new Thread(new FilCuinaPasta(semafor),"filPasta");
		Thread filT2 = new Thread(new FilCuinaSalsa(semafor),"filSalsa");
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

		if(plat.isPlatAcabat())
			System.out.println("[Fil ppal] Plat acabat!");
		System.out.println("[Fil ppal] Acaba tasques el cuiner");

	}//main
}//class
