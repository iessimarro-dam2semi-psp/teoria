package Exemple2_05_Banc_Synchronized2;
import java.io.*;

public class CompteBancari {
	//attr
	private float saldo;

	//CONSTRUCTOR 1
	public CompteBancari( float saldoInicial) throws IOException {
		this.setSaldo(saldoInicial);
	}

	public void ingressarCB(float diners, String nomFil) throws IOException, InterruptedException {
		float aux;
		System.out.println("["+ nomFil +"]"+ " Ingressant "+ diners + "€ ...");
		aux=getSaldo();
		System.out.println("["+ nomFil + "] " + aux + "=getSaldo() + " + diners + " €");
		aux=aux+diners;
		System.out.println("["+ nomFil + "] setSaldo(" + aux + ")");
		setSaldo(aux);//setSaldo(aux);
	}//treureCB

	
	public void treureCB(float diners, String nomFil) throws IOException, InterruptedException {
		float aux;
		System.out.println("["+ nomFil +"]"+ " Traguent "+ diners + "€ ...");
		aux=getSaldo();
		System.out.println("["+ nomFil + "] " + aux + "=getSaldo() - " + diners + " €");
		aux=aux-diners;
		System.out.println("["+ nomFil + "] setSaldo(" + aux + ")");
		setSaldo(aux);
	}//treureCB
	
	
	public float getSaldo() {
		return saldo;
	}//getSaldo

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}//setSaldo
}
