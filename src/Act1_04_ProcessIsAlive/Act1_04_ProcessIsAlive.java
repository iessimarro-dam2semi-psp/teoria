package Act1_04_ProcessIsAlive;
import java.io.IOException;
import java.util.Arrays;

public class Act1_04_ProcessIsAlive {

	public static void main(String[] args) {
		//act 4
		String[] commandIargs = new String[] {"sleep", "10"};	//comandament a executar

		ProcessBuilder pb = new ProcessBuilder(commandIargs);	//obtenció del PB
		pb.inheritIO();	//Redirecció del procés als mateixos fluxos que procés pare

		try {
			Process  procesFill = pb.start();//llançament del procés

			while (procesFill.isAlive()) {//Comprovacio si el procés és viu
				System.out.println("\nL'execució de " + Arrays.toString(commandIargs) 
				+ " continua...");	//Indicació de proces en marxa

				Thread.sleep(3000);//espera pasiva de 3segs
			}
			System.out.println("\nL'execució de " + Arrays.toString(commandIargs) 
			+ " ha acabat");	//Indicació de proces acabat
		} catch (IOException e) {
			System.err.println("Error a l'execució del procés");
			e.printStackTrace();

		} catch (InterruptedException e) {
			System.err.println("Procés interromput");
			e.printStackTrace();
		}
	}//main
}//class
