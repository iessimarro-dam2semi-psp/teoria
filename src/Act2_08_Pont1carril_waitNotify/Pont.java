package Act2_08_Pont1carril_waitNotify;

public class Pont {
	//atrr
	private boolean lliure;

	//Constructor
	public Pont() {
		lliure = true;
	}

	//---------------------------------------
	public void travesaPont(String sentit) {
		for (int i=0; i<5000;i++) {
			//No fer res, passar temps sense alliberar processador
		}//for
		System.out.println("["+Thread.currentThread().getName()
				+"] ** Travessant el Pont per anar cap a "+ sentit +"**");
		//Fent temps per modificar variable booleana
		for (int i=0; i<5000;i++) {
			//No fer res, passar temps sense alliberar processador
		}//for
	}//travesaPont

	//---------------------------------------
	public synchronized void entraPont() {
		try {
			while(!lliure) {
				System.out.println("["+Thread.currentThread().getName()
						+"] entraPont() -> El Pont NO està disponible, espera zZzZz...");
				wait();
			}//while

			//*****accions en exclusió mútua*********
			this.lliure = false;		//Canviant estat de clau
			System.out.println("["+Thread.currentThread().getName()	+"] ** Entrant al Pont... **");	
			//***************************************

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//entraPont

	//---------------------------------------
	public synchronized void ixPont() {
		System.out.println("["+Thread.currentThread().getName()	+"] ** Eixint del Pont... **");
		this.lliure = true;	//canvia condicio
		
		System.out.println("["+Thread.currentThread().getName()
				+"] ixPont() -> El Pont ja està disponible, desperta vehicles...");
		notifyAll();
	}//ixPont
}//class
