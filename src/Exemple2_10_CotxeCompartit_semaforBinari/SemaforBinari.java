package Exemple2_10_CotxeCompartit_semaforBinari;

public class SemaforBinari {
//attr
	private boolean condicio;
	//Constructor
	public SemaforBinari() {
		System.out.println("["+Thread.currentThread().getName()
				+"] Creat el SEMAFOR BINARI");
		condicio = true;
	}

	//------------------------------
	public synchronized void metodeWait() {
		while(!condicio) {	//mentre NO condicio, bloquejat fil executor
			try {
				System.out.println("["+Thread.currentThread().getName()
						+"] SEMAFOR bloqueja execució -> Espera zZzZz...");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//while
		condicio = false;	//canvia condicio, bloquejat fil executor	
	}//metodeWait()
	
	//------------------------------
	public synchronized void metodeWakeup() {
		condicio = true;	//canvia condicio, desbloquejat fil executor
		System.out.println("["+Thread.currentThread().getName()
				+"] SEMAFOR desperta execució -> Desperta fils...");
		notify(); // o notifyAll()
	}//metodeWakeup()
}//class
