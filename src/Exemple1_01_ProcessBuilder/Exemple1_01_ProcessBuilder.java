package Exemple1_01_ProcessBuilder;
import java.io.IOException;

public class Exemple1_01_ProcessBuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//exemple 1
			ProcessBuilder pb1 = new ProcessBuilder("df", "-h" , "/");
			pb1.inheritIO();
			//llançament del procés
			pb1.start();

			//exemple2
			String[] commandIargs = new String[] {"df", "-h" , "/"};
			ProcessBuilder pb = new ProcessBuilder(commandIargs);
			pb.inheritIO();

			//llançament del procés
			Process  procesFill = pb.start();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//main
}
