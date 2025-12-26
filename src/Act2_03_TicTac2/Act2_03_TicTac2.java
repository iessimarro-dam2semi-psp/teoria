package Act2_03_TicTac2;

public class Act2_03_TicTac2 implements Runnable{

	//Propietats --------------------------------
	private String nomFil;

	//Constructor --------------------------------
	public Act2_03_TicTac2(String nomFil) {
		this.nomFil = nomFil;
	}//constructor

	//mètode Run -----------------------------------
	public void run(){
		for(int i=0; i<5; i++) {
			System.out.print (" "+Thread.currentThread().getName()+"");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}//for
	}//run




	public static void main(String[] args) {

		//creacio nou obj Runnable TIC
		Act2_03_TicTac2 objRnb1 = new Act2_03_TicTac2("TIC"); 
		//creacio nou obj Runnable TAC
		Act2_03_TicTac2 objRnb2 = new Act2_03_TicTac2("TAC"); 

		//creacio nou fil TIC
		Thread objFil1 = new Thread(objRnb1, objRnb1.nomFil);
		//creacio nou fil TAC
		Thread objFil2 = new Thread(objRnb2, objRnb2.nomFil);

		System.out.println("[Fil ppal] Iniciant rellotge...");
		objFil1.start();	//iniciant fil1
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		objFil2.start();	//iniciant fil2

		try {
			objFil1.join();	//fil ppal espera finalització del fil1
			objFil2.join();	//fil ppal espera finalització del fil2
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n[Fil ppal] Finalitzat rellotge \n");
	} //main
}//class
