package Act1_02_Runtime;
import java.io.IOException;

public class Act1_02_Runtime {

	public static void main(String[] args) {
		//act 2
		String[] commandIargs = new String[] {"ls", "-l"};  //declaració del comandament a executar

		Runtime rt = Runtime.getRuntime();	//obtenció d'un objecte de la classe Runtime
		try {

			Process procesFill = rt.exec(commandIargs);	//creació i execució d'un nou procés fill
			System.out.println("Execució EXITOSA del comandament: " + commandIargs[0]);


			commandIargs = new String[] {"als", "-l"};  //declaració d'un comandament inexistent -> Error
			procesFill = rt.exec(commandIargs);	//creació i execució d'un nou procés fill

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("ERROR: Excepció generada a l'executar el comandament: " + commandIargs[0]);
			e.printStackTrace();
		}
	}//main
}//class
