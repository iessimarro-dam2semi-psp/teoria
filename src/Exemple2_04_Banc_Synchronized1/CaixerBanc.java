package Exemple2_04_Banc_Synchronized1;

import java.io.IOException;

public class CaixerBanc implements Runnable{
	//ATRIBUTS
	private CompteBancari compte; //atribut compartit pels fils
	private int operacioAfer;

	//CONSTRUCTOR
	public CaixerBanc(CompteBancari compte, int operacio) {
		this.compte = compte;
		this.operacioAfer = operacio;
	}

	//METODES 
	public void ingressar(float diners) throws IOException, InterruptedException{
		//sobre l'objecte compartit, realitza un ingres
		this.compte.ingressarCB(diners, Thread.currentThread().getName());
	}//ingressar

	public void treure(float diners) throws IOException, InterruptedException {
		//sobre l'objecte compartit, realitza un extracte
		this.compte.treureCB(diners, Thread.currentThread().getName());
	}//treure

	public void run() {
		try {
			//en funció del valor passat al constructor, realitza unes operacions1 o atres
			switch(operacioAfer) {
			case 1: 		
				//System.out.println("\t[" + Thread.currentThread().getName() +"] Resum d'accions: +400 i -200");
				//ingres de 400€
				System.out.println("["+Thread.currentThread().getName()+"] (1/2) Ingressant 400...");
				ingressar(400);
				//extracte de 200€
				//System.out.println("["+Thread.currentThread().getName()+"] (2/2) Traguent 200...");
				//treure(200);
				break;
			default: 		
				//System.out.println("\t[" + Thread.currentThread().getName() +"] Resum d'accions: -600 i +200");
				//extracte de 200€
				System.out.println("["+Thread.currentThread().getName()+"] (1/2)  Traguent 600...");
				treure(600);
				//ingres de 200€
				//System.out.println("["+Thread.currentThread().getName()+"] (2/2) Ingressant 200...");
				//ingressar(200);
				break;
			}//switch
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//run
}//class
