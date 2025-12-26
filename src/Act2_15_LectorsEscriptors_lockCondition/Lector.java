package Act2_15_LectorsEscriptors_lockCondition;

public class Lector implements Runnable{
	int numLectures;
	BaseDades bd;

	public Lector (int numLectures, BaseDades bd, String nomFil){
		this.numLectures = numLectures;
		this.bd = bd;
		System.out.println("Creació d'un Lector "+ nomFil +" amb "+numLectures+" lectures");
	}

	public void run() {
		for (int i=0; i<numLectures; i++){		//per cada lectura
			System.out.println("[" +Thread.currentThread().getName()+"] Solicita lectura");
			bd.llegir();						//accio de llegir
		}//for
	}//run
}
