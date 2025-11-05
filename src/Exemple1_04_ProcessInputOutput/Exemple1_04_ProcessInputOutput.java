package Exemple1_04_ProcessInputOutput;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Exemple1_04_ProcessInputOutput {
	//exemple4
	public static void main(String[] args) {
		//exemple 4
		//indica comandament a executar
		ProcessBuilder pb = new ProcessBuilder("nslookup");
		//redireccio eixida
		pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
		
		try {
			//definicio buffer de teclat
			InputStreamReader isr = new InputStreamReader(System.in,"UTF-8");
			BufferedReader br = new BufferedReader (isr);
			String command = "nslookup";
			String cadena = null;

			//captura una cadena de teclat
			System.out.println("Introdueix una cadena:");
			while((cadena = br.readLine())!=null && cadena.length()!=0){

				Process  procesFill = pb.start();	//llançament del procés

				OutputStream os = procesFill.getOutputStream();//flux connecta entrada proces
				OutputStreamWriter osr = new OutputStreamWriter(os,"UTF-8");
				osr.write(cadena); //escriu la cadena a entrada proces
				osr.flush();
				os.close();		//tanca el flux

				//espera finalització per obtindre codi error
				int codiRet = procesFill.waitFor();
				System.out.println("\nL'execució de " + command 
						+ " ha retornat " + codiRet);
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
}