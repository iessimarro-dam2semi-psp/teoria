package Act2_11_Pont2carrils_semafor;

public class SemaforComptador {
//attr
	private int numRecursosDisponibles;
	//Constructor
	public SemaforComptador(int num) {
		numRecursosDisponibles = num;
	}
	//----------------------------------------
	public synchronized void metodeWait() {

		while(numRecursosDisponibles == 0) {
			try {
				System.out.println("["+Thread.currentThread().getName()
						+"] <SEMAFOR bloqueja execució>");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//while
		numRecursosDisponibles--;
	}//metodeWait()
	//----------------------------------------	
	public synchronized void metodeWakeup() {
		numRecursosDisponibles++;
		System.out.println("["+Thread.currentThread().getName()
				+"] <SEMAFOR desperta execució>");
		notify(); // o notifyAll()
	}//metodeWakeup()
}//class
