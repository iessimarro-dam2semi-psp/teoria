package Act1_03_TestProcess;
import java.io.IOException;
import java.util.Arrays;

public class Act1_03_TestProcess {

	public static void main(String[] args) {
		//act 3
		//llistat dels comandaments a executar com a matriu
		String[][] commandIargs = new String[][] {new String[] {"df", "-h" , "/"}
		,new String[] {"df", "-argument" , "/"}
		,new String[] {"comandInexistent"}};

		try {
			for(String [] command : commandIargs) {//iteracio per a cada comandament

				ProcessBuilder pb = new ProcessBuilder(command);	//obtenció del PB

				pb.inheritIO();	//Redirecció del proces als mateixos fluxos que procés pare

				System.out.println("--------------\n Execució de " + Arrays.toString(command));

				Process  procesFill = pb.start();//llançament del procés per al comandament

				int codiRet = procesFill.waitFor();//espera finalització comandament per obtindre codi error

				System.out.println("\nL'execució de " + Arrays.toString(command) 
				+ " ha retornat " + codiRet);    //Mostra codi retornat

				System.out.println(codiRet==0 ? "Execució CORRECTA" : "Execució ERRONEA");
			}
		} catch (IOException e) {
			System.err.println("Error a l'execució del procés");
			e.printStackTrace();

		} catch (InterruptedException e) {
			System.err.println("Procés interromput");
			e.printStackTrace();
		}
	}//main
}//class
