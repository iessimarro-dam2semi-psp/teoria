package Act1_05_processBuilderPipes;
import java.io.IOException;
import java.lang.ProcessBuilder;
import java.util.Arrays;
import java.util.List;

public class Act1_05_ProcessBuilderPipes {

	public static void main(String[] args) {
		//act 5
		try {

			ProcessBuilder pb1 = new ProcessBuilder("ip", "a"); //creació del 1r ProcessBuilder a enllaçar 
			ProcessBuilder pb2 = new ProcessBuilder("grep", "lo:"); //creació del 2n ProcessBuilder a enllaçar 

			pb2.redirectOutput(ProcessBuilder.Redirect.INHERIT);	//redirecció de l'eixida de l'últim ProcessBuilder


			ProcessBuilder[] builders = {pb1, pb2};	//execució dels ProcessBuilder enllaçats
			List<Process> processos = ProcessBuilder.startPipeline(
					Arrays.asList(builders));	//execucio i enllaçament entre processos

			Process ultimProcesFill = processos.get(processos.size()-1);	//obtenció de l'últim procés
			ultimProcesFill.waitFor(); //esperem finalització de l'últim procés

		} catch (IOException e) {
			System.err.println("Error a l'execució del procés");
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//main
}//class
