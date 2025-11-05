package Act1_06_ProcessInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Act1_06_ProcessInputStream {

	public static void main(String[] args) {
		//act 6
		String[] commandIargs = new String[] {"df", "-h" , "/"};	 //declaració del comandament a executar
		ProcessBuilder pb = new ProcessBuilder(commandIargs);	//obtenció del PB

		try {
			Process  procesFill = pb.start();	//llançament del procés

			InputStreamReader inputProces = new InputStreamReader(procesFill.getInputStream());	//enllaça el flux eixida del proces al Buffer
			BufferedReader br = new BufferedReader (inputProces);

			int codiRet = procesFill.waitFor();				//espera finalització per obtindre codi error

			//Visualització del codi error
			System.out.println("L'execució de " + Arrays.toString(commandIargs) 
			+ " ha retornat " + codiRet);
			System.out.println(codiRet==0 ? "Execució CORRECTA" : "Execució ERRONEA");

			//Eixida del proces a pantalla
			System.out.println("\nEIXIDA del PROCÉS amb BufferedReader: ");
			String linea = null;
			//mostra l'eixida del proces linea a linea usant BufferedReader
			while((linea = br.readLine()) != null) {
				System.out.println(linea);
			}//while	
		} catch (IOException e) {
			System.err.println("Error a l'execució del procés");
			e.printStackTrace();

		} catch (InterruptedException e) {
			System.err.println("Procés interromput");
			e.printStackTrace();
		}
	}//main
}//class
