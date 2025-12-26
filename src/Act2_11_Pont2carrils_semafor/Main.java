package Act2_11_Pont2carrils_semafor;

public class Main {

	public static void main(String[] args) {

		System.out.println("Programa Pont amb un sol carril amb Semafor comptador");
		System.out.println("=====================================================");
		//creem un objecte compartit
		Pont pont = new Pont(new SemaforComptador(2));
		//Objectes Runnable
		Vehicle cotxe1 = new Vehicle("cotxe1", "esquerra", pont);	
		Vehicle cotxe2 = new Vehicle("cotxe2", "dreta", pont);	
		Vehicle furgoneta1 = new Vehicle("furgoneta1","esquerra", pont);
		Vehicle furgoneta2 = new Vehicle("furgoneta2","dreta", pont);
		//creacio Fils
		Thread filC1 = new Thread(cotxe1, cotxe1.nomVehicle);
		Thread filC2 = new Thread(cotxe2,cotxe2.nomVehicle);
		Thread filF1 = new Thread(furgoneta1,furgoneta1.nomVehicle);
		Thread filF2 = new Thread(furgoneta2,furgoneta2.nomVehicle);
		//llançament fils
		filC1.start();
		filC2.start();
		filF1.start();
		filF2.start();
		
		//espera fils
		try {
			filC1.join();
			filC2.join();
			filF1.join();
			filF2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("["+Thread.currentThread().getName()
				+"] Finalització fil ppal");
	}//main
}//class
