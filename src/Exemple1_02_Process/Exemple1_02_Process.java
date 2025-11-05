package Exemple1_02_Process;
import java.io.IOException;
import java.util.Arrays;

public class Exemple1_02_Process {

	public static void main(String[] args) {
		//exemple 2
		String[] commandIargs = new String[] {"df", "-h" , "/"};
		ProcessBuilder pb = new ProcessBuilder(commandIargs);
		pb.inheritIO();

		try {
			//llançament del procés
			Process  procesFill = pb.start();
			
			//espera finalització per obtindre codi error
			int codiRet = procesFill.waitFor();
			
			System.out.println("\nL'execució de " + Arrays.toString(commandIargs) 
			    + " ha retornat " + codiRet);
			System.out.println(codiRet==0 ? "Execució CORRECTA" : "Execució ERRONEA");
		} catch (IOException e) {
			System.err.println("Error a l'execució del procés");
			e.printStackTrace();

		} catch (InterruptedException e) {
			System.err.println("Procés interromput");
			e.printStackTrace();
		}
	}//main
}
