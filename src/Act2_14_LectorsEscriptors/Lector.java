package Act2_14_LectorsEscriptors;

public class Lector implements Runnable{
	//attrib
	int numLectures;
	BaseDades bd;

	//Constructor
	public Lector (int numLectures, BaseDades bd, String nomFil){
		this.numLectures = numLectures;
		this.bd = bd;
		System.out.println("Creació d'un Lector "+ nomFil +" amb "+numLectures+" lectures");
	}

	public void run() {
		for (int i=0; i<numLectures; i++){		//per cada lectura
			System.out.println("[" +Thread.currentThread().getName()+"] Solicita lectura ");
			bd.llegir();						//accio de llegir
		}//for
	}//run
}//class
