package Exemple2_12_espaguettisCarbonara;

public class FilCuinaSalsa implements Runnable{

	//Constructor
	public FilCuinaSalsa() {
	}

	public void run() {
		try {
			System.out.println("["+Thread.currentThread().getName()+"] Ficant a calfar una paella amb oli al foguer...");
			Thread.sleep(1000);	  						//temps de l'accio anterior
			System.out.println("["+Thread.currentThread().getName()+"] Afegint a la paella la ceba i el magre...");
			Thread.sleep(1000);	  						//temps de l'accio anterior
			System.out.println("["+Thread.currentThread().getName()+"] Cuinant ceba i el magre...");
			Thread.sleep(2000);	  						//temps de l'accio anterior
			System.out.println("["+Thread.currentThread().getName()+"] Afegint a la paella la nata...");
			Thread.sleep(1000);	  						//temps de l'accio anterior
			System.out.println("["+Thread.currentThread().getName()+"] Cuinant la nata...");
			Thread.sleep(1000);	  						//temps de l'accio anterior
			System.out.println("["+Thread.currentThread().getName()+"] Servint la salsa de la paella al plat...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("["+Thread.currentThread().getName()+"] Fil "+Thread.currentThread().getName()+" acabat");
	}//run
}//class