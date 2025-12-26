package Exemple2_13_espaguettisCarbonara_WaitNotify;

public class FilCuinaSalsa implements Runnable{
	//attr
	private SemaforSincron semaforSincron;

	//Constructor
	public FilCuinaSalsa(SemaforSincron semaforSincron) {
		this.semaforSincron = semaforSincron;
	}

	public void run() {
		try {
			System.out.println("["+Thread.currentThread().getName()
					+"] Ficant a calfar una paella amb oli al foguer...");
			Thread.sleep(1000);	  						//temps de l'accio anterior
			System.out.println("["+Thread.currentThread().getName()
					+"] Afegint a la paella la ceba i el magre...");
			Thread.sleep(1000);	  						//temps de l'accio anterior
			System.out.println("["+Thread.currentThread().getName()
					+"] Cuinant ceba i el magre...");
			Thread.sleep(2000);	  						//temps de l'accio anterior
			System.out.println("["+Thread.currentThread().getName()
					+"] Afegint a la paella la nata...");
			Thread.sleep(1000);	  						//temps de l'accio anterior
			System.out.println("["+Thread.currentThread().getName()
					+"] Cuinant la nata...");
			Thread.sleep(1000);	  						//temps de l'accio anterior
			//************Esperant condició per reprendre execució fil*********
			semaforSincron.metodeWait();				
			
			System.out.println("["+Thread.currentThread().getName()
					+"] Servint la salsa de la paella al plat...");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("["+Thread.currentThread().getName()
				+"] Fil "+Thread.currentThread().getName()+" acabat");
	}//run
}//class
