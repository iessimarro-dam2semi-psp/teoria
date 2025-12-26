package Act2_02_TicTac1;

public class Act2_02_TicTac1 extends Thread{

	//Constructor --------------------------------
	public Act2_02_TicTac1(String nomFil) {
		this.setName(nomFil);
	}//constructor

	//mètode Run -----------------------------------
	public void run(){
		for(int i=0; i<5; i++) {
			System.out.print (" "+this.getName()+"");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}//for
	}//run




	public static void main(String[] args) {
		
		//creacio nou fil TIC
		Act2_02_TicTac1 objFil1 = new Act2_02_TicTac1("TIC"); 
		//creacio nou fil TAC
		Act2_02_TicTac1 objFil2 = new Act2_02_TicTac1("TAC"); 

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
