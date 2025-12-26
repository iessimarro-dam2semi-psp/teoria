package Act2_14_LectorsEscriptors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseDades bd = new BaseDades();				//monitor
		Lector[]   lectors = new Lector[3];		//3 lectors
		Escriptor[] escriptors = new Escriptor[2];	//2 escriptors
		Thread[] fils = new Thread[5];			//vector dels 5 fils (escriptors + lectors)

		System.out.println("[" +Thread.currentThread().getName()
				+"] Programa LECTORS/ESCRIPTORS amb "+lectors.length 
				+ " lectors i "+escriptors.length+ " escriptors");
		System.out.println("-----------------------------------------------------------");

		//creacio ojectes Runnable
		for(int i = 0; i < lectors.length; i++)
			lectors[i] = new Lector(2,bd,"L"+(i+1));//(int numLectures, BaseDades bd,  String nomFil)
		for(int i = 0; i < escriptors.length; i++)
			escriptors[i] = new Escriptor(2,bd,"E"+(i+1)); //(int numEscriptures, BaseDades bd, String nomFil)

		//creacio fils i llançament
		for (int i = 0; i < escriptors.length; i++) {
			fils[i] = new Thread(escriptors[i],"E"+(i+1));
			fils[i].start();
		}//for
		
		for (int i = 0; i < lectors.length; i++) {
			fils[i+escriptors.length] = new Thread(lectors[i],"L"+(i+1));
			fils[i+escriptors.length].start();
		}

		for (int i = 0; i < fils.length; i++) {
			try {
				fils[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//for

		System.out.println("[" +Thread.currentThread().getName()
				+"] Programa LECTORS/ESCRIPTORS finalitzat");
	}//main
}//class
