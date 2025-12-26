package Exemple2_04_Banc_Synchronized1;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		CompteBancari compte = new CompteBancari(0);
		System.out.println("[Programa ppal] Inici amb saldo " + compte.getSaldo());
		
		CaixerBanc obj1 = new CaixerBanc(compte, 1);
		CaixerBanc obj2 = new CaixerBanc(compte, 2);
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
				
		System.out.println("[Programa ppal] Finalitzacio del programa ppal amb saldo " + compte.getSaldo() +"€");
	}

}
