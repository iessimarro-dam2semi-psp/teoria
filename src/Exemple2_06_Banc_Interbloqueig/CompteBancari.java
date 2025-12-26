package Exemple2_06_Banc_Interbloqueig;
import java.io.*;

public class CompteBancari {
	//attr
	private int idCompte;
	private float saldo;

	//CONSTRUCTOR 1
	public CompteBancari(int idCompte) throws IOException {
		this.idCompte = idCompte;
	}

	public CompteBancari(int idCompte, float saldoInicial) throws IOException {
		this.setIdCompte(idCompte);
		this.setSaldo(saldoInicial);
	}

	public void ingressarCB(float diners, String nomFil) throws IOException, InterruptedException {
		float aux;
		synchronized(this) { //  *****sincronització sobre l'objecte compartit compte ******
			System.out.println("["+ nomFil +"]"+ " Ingressant "+ diners + "€ al compte "+ this.getIdCompte() +"...");
			aux=getSaldo();
			System.out.println("["+ nomFil + "] " + aux + "=getSaldo() + " + diners + " €");
			aux=aux+diners;
			System.out.println("["+ nomFil + "] setSaldo(" + aux + ")");
			setSaldo(aux);//setSaldo(aux);
		}//synchronized
	}//treureCB


	public void treureCB(float diners, String nomFil) throws IOException, InterruptedException {
		float aux;
		synchronized(this) { //  *****sincronització sobre l'objecte compartit compte ******
			System.out.println("["+ nomFil +"]"+ " Traguent "+ diners + "€ del compte "+ this.getIdCompte() +"...");
			aux=getSaldo();
			System.out.println("["+ nomFil + "] " + aux + "=getSaldo() - " + diners + " €");
			aux=aux-diners;
			System.out.println("["+ nomFil + "] setSaldo(" + aux + ")");
			setSaldo(aux);
		}//synchronized
	}//treureCB

	public int getIdCompte() {
		return idCompte;
	}//getSaldo

	
	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	public float getSaldo() {
		return saldo;
	}//getSaldo

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}//setSaldo
}
