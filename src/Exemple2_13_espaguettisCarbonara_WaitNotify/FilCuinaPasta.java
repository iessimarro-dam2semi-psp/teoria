package Exemple2_13_espaguettisCarbonara_WaitNotify;

public class FilCuinaPasta implements Runnable{
	//attr
		private SemaforSincron semaforSincron;
		
	//Constructor
	public FilCuinaPasta(SemaforSincron semaforSincron) {
		this.semaforSincron = semaforSincron;
	}
	
	public void run() {
		try {
			System.out.println("["+Thread.currentThread().getName()
					+"] Ficant a calfar una cassola amb aigua per bollir al foguer...");
			Thread.sleep(3000);	  						//temps de l'accio anterior
			System.out.println("["+Thread.currentThread().getName()
					+"] Afegint a la cassola els espaguettis...");
			Thread.sleep(4000);	  						//temps de l'accio anterior
			System.out.println("["+Thread.currentThread().getName()
					+"] Servint els espaguettis al plat...");
			//********Canviant estat condició per executar el 2n fil********
			semaforSincron.metodeWakeup();	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("["+Thread.currentThread().getName()
				+"] Fil "+Thread.currentThread().getName()+" acabat");
	}//run
}//class
