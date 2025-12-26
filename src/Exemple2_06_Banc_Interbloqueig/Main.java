package Exemple2_06_Banc_Interbloqueig;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		CompteBancari compteA = new CompteBancari(2145 ,1000);
		CompteBancari compteB = new CompteBancari(7459 ,2000);
		System.out.println("[Programa ppal] Inici al compteA ("+ compteA.getIdCompte() +") amb saldo de " + compteA.getSaldo() +"€");
		System.out.println("[Programa ppal] Inici al compteB ("+ compteB.getIdCompte() +") amb saldo de " + compteB.getSaldo() +"€");
		
		CaixerBanc obj1 = new CaixerBanc(compteA, compteB, 3);
		CaixerBanc obj2 = new CaixerBanc(compteB, compteA, 3);
		//CaixerBanc obj3 = new CaixerBanc(compte,3);
		
		Thread fil1 = new Thread(obj1, "home");
		Thread fil2 = new Thread(obj2, "dona");
		//Thread fil3 = new Thread(obj2,"BBVA");
		
		fil1.start();
		fil2.start();
		//fil3.start();
		
		fil1.join();
		fil2.join();
		//fil3.join();
				
		System.out.println("[Programa ppal] Finalitzacio del programa ppal al compteA ("+ compteA.getIdCompte() + ") amb saldo " + compteA.getSaldo() +"€");
		System.out.println("[Programa ppal] Finalitzacio del programa ppal al compteB ("+ compteB.getIdCompte() + ") amb saldo " + compteB.getSaldo() +"€");
	}

}
