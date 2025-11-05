package Exemple2_01_createThreads1;
public class Exemple2_01_createThreads1  extends Thread{

	//Constructor --------------------------------
	public Exemple2_01_createThreads1 (String NomFil){
		this.setName(NomFil);
	}//constructor

	//mètode Run -----------------------------------
	public void run(){
		System.out.println ("Fil["+ this.getName() + "] -> Hola, soc el fil: "+ this.getName());
		System.out.println ("Fil["+ this.getName() + "] -> Fil "+ this.getName() + " ha acabat");
	}//run

	//Métode main -------------------------------
	public static void main(String[] args){
		System.out.println("[Fil ppal] -> Comença el fil ppal \n");
		//creacio nou fil1
		Exemple2_01_createThreads1 objFil1 = new Exemple2_01_createThreads1("nomFil1"); 
		//creacio nou fil2
		Exemple2_01_createThreads1 objFil2 = new Exemple2_01_createThreads1("nomFil2"); 

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

