package Exemple2_13_espaguettisCarbonara_WaitNotify;

public class SemaforSincron {
	//attr
	private boolean platBuit;

	//Constructor
	public SemaforSincron() {
		platBuit = true;
	}
	//-----------------------------------------
	public synchronized void metodeWait(){
		while(isPlatBuit()){ 			//Avalua l’estat de la condicio
			try{ //si plat està buit, suspen el fil alliberant el bloqueig de l'objecte Plat
				System.out.println("["+Thread.currentThread().getName()
						+"] Wait() -> Fil SALSA espera a que estiga servida la PASTA zZzZz...");
				wait();	 //si la condició és falsa, continua esperant		
			}catch(InterruptedException e) {
				// codi d’excepció
			}//catch
		}//while
	}//metodeWait
	//-----------------------------------------	
	public synchronized void metodeWakeup(){
		setPlatBuit(false); //la condició permet ara continuar un o més fils
		System.out.println("["+Thread.currentThread().getName()
				+"] Notify() -> Despertant fil SALSA...");
		notify();
	}//metodeCanviCondicio
	//-----------------------------------------
	public boolean isPlatBuit() {
		return platBuit;
	}
	//-----------------------------------------
	public void setPlatBuit(boolean platBuit) {
		this.platBuit = platBuit;
	}
	//-----------------------------------------
}//class
