package Act2_10_espaguettisCarbonara_Semafor;

public class FilCuinaSalsa implements Runnable{
	//attr
	private Semafor semafor;

	//Constructor
	public FilCuinaSalsa( Semafor semafor) {
		this.semafor = semafor;
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
			//************Controlant acces a zona compromesa*********
			semafor.metodeWait();				
			
			System.out.println("["+Thread.currentThread().getName()
					+"] Servint la salsa de la paella al plat...");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("["+Thread.currentThread().getName()
				+"] Fil "+Thread.currentThread().getName()+" acabat");
	}//run
}//class
