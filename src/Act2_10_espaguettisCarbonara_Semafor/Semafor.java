package Act2_10_espaguettisCarbonara_Semafor;

public class Semafor {
//attr
	private boolean condicio;
	//Constructor
	public Semafor() {
		condicio = true;
	}
	
	public synchronized void metodeWait() {
		while(condicio) {
			try {
				System.err.println("["+Thread.currentThread().getName()+"]" 
			+" **SEMAFOR bloqueja execució a metodeWait()**");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//while
//		condicio = false;
	}//metodeWait()
	


	public synchronized void metodeWakeup() {
		condicio = false;
		System.err.println("["+Thread.currentThread().getName()+"]" 
				+" **SEMAFOR desperta execució a metodeWakeup()**");
		notify(); // o notifyAll()
	}//metodeWakeup()
	
}//class
