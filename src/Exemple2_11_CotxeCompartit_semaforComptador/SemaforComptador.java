package Exemple2_11_CotxeCompartit_semaforComptador;

public class SemaforComptador {
//attr
	private int numRecursosDisponibles;
	//Constructor
	public SemaforComptador(int numAccessos) {
		this.numRecursosDisponibles = numAccessos;
		System.out.println("["+Thread.currentThread().getName()
				+"] Creat el SEMAFOR COMPTADOR amb "+ numAccessos + " permesos");
	}

	//------------------------------
	public synchronized void metodeWait() {
		while(numRecursosDisponibles == 0) {	//mentre NO condicio, bloquejat fil executor
			try {
				System.out.println("["+Thread.currentThread().getName()
						+"] SEMAFOR bloqueja execució -> Espera zZzZz...");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//while
		numRecursosDisponibles--;	//canvia condicio, bloquejat fil executor	
	}//metodeWait()
	
	//------------------------------
	public synchronized void metodeWakeup() {
		numRecursosDisponibles++;	//canvia condicio, desbloquejat fil executor
		System.out.println("["+Thread.currentThread().getName()
				+"] SEMAFOR desperta execució -> Desperta fils...");
		notify(); // o notifyAll()
	}//metodeWakeup()
}//class
