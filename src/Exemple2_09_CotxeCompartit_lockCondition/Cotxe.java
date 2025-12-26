package Exemple2_09_CotxeCompartit_lockCondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cotxe {
	//atrr
	private String nom;
	private boolean clau;
	private Lock cadenat;
	private Condition disponible;

	//Constructor
	public Cotxe(String nomCotxe) {
		nom = nomCotxe;	
		clau = true;
		System.out.println("["+Thread.currentThread().getName()	+"] Creat el cotxe "+nomCotxe);
		cadenat = new ReentrantLock();
		disponible = cadenat.newCondition();
	}

	//---------------------------------------
	public boolean isCotxeDisponible() {
		if (clau)  return true;
		else		return false;
	}//isCotxeDisponible

	//---------------------------------------
	public void agafaCotxe() {
		//Fent temps per modificar variable booleana
		for (int i=0; i<10000;i++) {
			//No fer res
		}

		this.clau = false;		//Canviant estat de clau
		System.out.println("["+Thread.currentThread().getName()	+"] Agafant cotxe "
				+ this.nom+ "...*****");
	}//agafaCotxe

	//---------------------------------------
	public void usarCotxe(int tempsUsCotxe,String llocUsCotxe) {
		try {
			System.out.println("["+Thread.currentThread().getName()
					+"] Usant el cotxe "+ getNom()+ " per anar a "+llocUsCotxe+ " durant "
					+ tempsUsCotxe /1000 +"secs ...");

			Thread.sleep(tempsUsCotxe);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//usarCotxe

	//---------------------------------------
	public void deixaCotxe() {
		System.out.println("["+Thread.currentThread().getName()	+"] Deixant cotxe "
				+ this.nom+ "...");
		this.clau = true;
	}//deixaCotxe

	//---------------------------------------
	public void metodeWait() throws InterruptedException {
		try {
			cadenat.lock();
			while(!isCotxeDisponible()) {
				System.out.println("["+Thread.currentThread().getName()
						+"] metodeWait() -> El cotxe NO està disponible, espera zZzZz...");
				disponible.await();
			}//while

			agafaCotxe();
			cadenat.unlock();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//metodeWait

	//---------------------------------------
	public void metodeCanviaEstatClau() throws InterruptedException {

		cadenat.lock();
		deixaCotxe();
		System.out.println("["+Thread.currentThread().getName()
				+"] metodeCanviaEstatClau() -> El cotxe ja està disponible, desperta fils...");
		disponible.signalAll();
		cadenat.unlock();

	}//metodeCanviaEstatClau

	//---------------------------------------
	public String getNom() {
		return nom;
	}
	//---------------------------------------
	public void setClau(boolean clau) {
		this.clau = clau;
	}
}//class
