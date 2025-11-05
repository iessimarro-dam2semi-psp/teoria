package Exemple1_03_ProcessInterromput;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Exemple1_03_ProcessInterromput {

	public static void main(String[] args) {
		//exemple 3
		String[] commandIargs = new String[] {"find", "/", "-name", "\"*\""  };
		//temps espera
		int timeout = 500;
		//obtenció del PB
		ProcessBuilder pb = new ProcessBuilder(commandIargs);
		//Redirecció del procés als mateixos fluxos que procés pare
		pb.inheritIO();

		try {
			//llançament del procés
			Process  procesFill = pb.start();
			
			//espera fins un temps timeout
			if (!procesFill.waitFor(timeout, TimeUnit.MILLISECONDS)) {
				//finalització del procés
				procesFill.destroy();
				System.out.println("\nWARNING: L'execució de " + Arrays.toString(commandIargs) 
			    + " NO ha finalitzat, INTERROMPUT");
			}
			
		} catch (IOException e) {
			System.err.println("Error a l'execució del procés");
			e.printStackTrace();

		} catch (InterruptedException e) {
			System.err.println("Procés interromput");
			e.printStackTrace();
		}
	}//main
}
