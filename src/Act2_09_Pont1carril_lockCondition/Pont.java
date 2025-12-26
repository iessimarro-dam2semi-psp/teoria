package Act2_09_Pont1carril_lockCondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Pont {
	//atrr
	private boolean lliure;
	private Lock cadenat;
	private Condition passar;

	//Constructor
	public Pont() {
		lliure = true;
		cadenat = new ReentrantLock();		//creat un objecte bloqueig
		passar = cadenat.newCondition();	//associada una condicio al bloqueig
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
	public  void entraPont() {
		try {
			cadenat.lock();	//Aconsegueix el bloqueig

			while(!lliure) {
				System.out.println("["+Thread.currentThread().getName()
						+"] entraPont() -> El Pont NO està disponible, espera zZzZz...");
				passar.await();		//Bloqueja el fil associant-lo a la Condition
			}//while
			//*****accions en exclusió mútua*********
			this.lliure = false;		//Canviant estat de clau
			System.out.println("["+Thread.currentThread().getName()	+"] ** Entrant al Pont... **");	
			//***************************************
			cadenat.unlock();	//Allibera el bloqueig
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}//entraPont

	//---------------------------------------
	public  void ixPont() {
		cadenat.lock();		//Aconsegueix el bloqueig

		System.out.println("["+Thread.currentThread().getName()	+"] ** Eixint del Pont... **");
		this.lliure = true;	//canvia condicio

		System.out.println("["+Thread.currentThread().getName()
				+"] ixPont() -> El Pont ja està disponible, desperta vehicles...");
		passar.signalAll();		//Allibera el fils associats a la Condition
		cadenat.unlock();		//Allibera el bloqueig

	}//ixPont
}//class
