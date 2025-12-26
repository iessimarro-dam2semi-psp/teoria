package Act2_10_espaguettisCarbonara_Semafor;

public class FilCuinaPasta implements Runnable{
	//attr
		private Semafor semafor;
		
	//Constructor
	public FilCuinaPasta(Semafor semafor) {
		this.semafor = semafor;
	}
	
	public void run() {
		try {
			System.out.println("["+Thread.currentThread().getName()
					+"] Ficant a calfar una cassola amb aigua per bollir al foguer...");
			Thread.sleep(4000);	  						//temps de l'accio anterior
			System.out.println("["+Thread.currentThread().getName()
					+"] Afegint a la cassola els espaguettis...");
			Thread.sleep(3000);	  						//temps de l'accio anterior
			System.out.println("["+Thread.currentThread().getName()
					+"] Servint els espaguettis al plat...");
			
			//************Controlant acces a zona compromesa*********
			semafor.metodeWakeup();	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("["+Thread.currentThread().getName()
				+"] Fil "+Thread.currentThread().getName()+" acabat");
	}//run
}//class
