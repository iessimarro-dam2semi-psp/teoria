package Exemple2_12_espaguettisCarbonara;

public class FilCuinaPasta implements Runnable{

	//Constructor
	public FilCuinaPasta() {
	}
	//-------------------
	public void run() {
		try {
			System.out.println("["+Thread.currentThread().getName()+"] Ficant a calfar una cassola amb aigua per bollir al foguer...");
			Thread.sleep(2000);	  						//temps de l'accio anterior
			System.out.println("["+Thread.currentThread().getName()+"] Afegint a la cassola els espaguettis...");
			Thread.sleep(3000);	  						//temps de l'accio anterior
			System.out.println("["+Thread.currentThread().getName()+"] Servint els espaguettis al plat...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("["+Thread.currentThread().getName()+"] Fil "+Thread.currentThread().getName()+" acabat");
	}//run
}//class
