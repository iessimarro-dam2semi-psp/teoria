package Act2_12_Pont2carrils_Semaphore;

import java.util.concurrent.Semaphore;

public class Pont {
	//atrr
	private boolean carrilDret_lliure;
	private boolean carrilEsq_lliure;
	private final Semaphore semafor;

	//Constructor
	public Pont(Semaphore semafor) {
		carrilDret_lliure = true;
		carrilEsq_lliure = true;
		this.semafor = semafor;
	}

	//---------------------------------------
	public boolean isSentitDisponible(String sentit) {
		if(sentit == "esquerra")
			return carrilEsq_lliure;
		else
			return carrilDret_lliure;
	}//isSentitDisponible
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
	public void entraPont(String sentit) {

		while(!isSentitDisponible(sentit)) {
			
			System.out.println("["+Thread.currentThread().getName()
					+"] El carril "+ sentit +" del Pont NO està disponible, espera zZzZz...");
			try {
				semafor.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//while

		//*****accions en exclusió mútua*********
		if(sentit == "esquerra")				//Canviant estat de carril
			carrilEsq_lliure = false;
		else
			carrilDret_lliure = false;

		System.out.println("["+Thread.currentThread().getName()	+"] ** Entrant al Pont pel carril "+ sentit+" ... **");	
		//***************************************
	}//entraPont

	//---------------------------------------
	public void ixPont(String sentit) {
		System.out.println("["+Thread.currentThread().getName()	+"] ** Eixint del  Pont pel carril "+ sentit+" ... **");	
		if(sentit == "esquerra")				//Canviant estat de carril
			carrilEsq_lliure = true;
		else
			carrilDret_lliure = true;

		System.out.println("["+Thread.currentThread().getName()
				+"] El carril "+ sentit+" del Pont ja està disponible, desperta vehicles...");
		semafor.release();
	}//ixPont
}//class
