package Exemple2_02_createThreads2;
public class Exemple2_02_createThreads2 implements Runnable{

	//Propietats --------------------------------
	private String nomFil;
		
	//Constructor --------------------------------
	public Exemple2_02_createThreads2 (String NomFil){
		this.nomFil = NomFil;
	}//constructor

	//mètode Run -----------------------------------
	public void run(){
		String nomActual = Thread.currentThread().getName();
		System.out.println ("Fil["+ nomActual + "] -> Hola, soc el fil: "+ nomActual);
		System.out.println ("Fil["+ nomActual + "] -> Fil "+ nomActual + " ha acabat");
	}//run

	//Métode main -------------------------------
	public static void main(String[] args){
		System.out.println("[Fil ppal] -> Comença el fil ppal \n");
		//creacio obj1 Runnable
		Exemple2_02_createThreads2 objRnb1 = new Exemple2_02_createThreads2("nomFil1"); 
		//creacio obj2 Runnable		
		Exemple2_02_createThreads2 objRnb2 = new Exemple2_02_createThreads2("nomFil2"); 
		//creacio nou fil1
		Thread objFil1 = new Thread(objRnb1, objRnb1.nomFil);
		//creacio nou fil2
		Thread objFil2 = new Thread(objRnb2, objRnb2.nomFil);
		
		System.out.println("[Fil ppal] -> Executant nous fils..");
		objFil1.start();	//iniciant fil1
		objFil2.start();	//iniciant fil2

		try {
			objFil1.join();	//fil ppal espera finalització del fil1
			objFil2.join();	//fil ppal espera finalització del fil2
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("[Fil ppal] -> Acabat");
	} //main
}//class

