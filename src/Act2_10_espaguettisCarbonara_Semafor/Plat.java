package Act2_10_espaguettisCarbonara_Semafor;

public class Plat {
	//attr
	private boolean platBuit;
	private boolean platAcabat;
	
	//Constructor
	public Plat() {
		platBuit = true;
		platAcabat = false;
	}
/*	//-----------------------------------------
	public synchronized void metodeWait(){
		while(isPlatBuit()){ 			//Avalua l’estat de la condicio
			try{ //si plat està buit, suspen el fil alliberant el bloqueig de l'objecte Plat
				System.out.println("["+Thread.currentThread().getName()
						+"] WAIT() -> FIL ESPERA A QUE ESTIGA SERVIDA LA PASTA zZzZz...");
				wait();	 //si la condició és falsa, continua esperant		
			}catch(InterruptedException e) {
				// codi d’excepció
			}//catch

			// CODI  EN EXCLUSIÓ MUTUA, sols quan la condició és certa.
		}
	}//metodeWait
	//-----------------------------------------	
	public synchronized void metodeCanviCondicio(boolean valor){
		setPlatBuit(valor); //la condició permet ara continuar un o més fils
		System.out.println("["+Thread.currentThread().getName()
				+"] NOTIFY() -> DESPERTANT FIL DE LA SALSA...");
		notify();
	}//metodeCanviCondicio
*/	//-----------------------------------------
	public boolean isPlatBuit() {
		return platBuit;
	}
	//-----------------------------------------
	public void setPlatBuit(boolean platBuit) {
		this.platBuit = platBuit;
	}
	//-----------------------------------------
	public boolean isPlatAcabat() {
		return platAcabat;
	}
	//-----------------------------------------
	public void setPlatAcabat(boolean platPreparat) {
		this.platAcabat = platPreparat;
	}
	//-----------------------------------------
}//class
