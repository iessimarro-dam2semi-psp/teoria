package Act2_15_LectorsEscriptors_lockCondition;

public class Escriptor implements Runnable{
	int numEscriptures;
	BaseDades bd;

	public Escriptor (int numEscriptures, BaseDades bd, String nomFil){
		this.numEscriptures = numEscriptures;
		this.bd = bd;
		System.out.println("Creació d'un Escriptor "+ nomFil +" amb "+numEscriptures+" escriptures");
	}

	public void run() {
		int decenes = Integer.parseInt(Thread.currentThread().getName().substring(1)) * 10;
		for (int i=0; i<numEscriptures; i++){		//per cada escriptura
			System.out.println("[" +Thread.currentThread().getName()+"] Solicita escriptura ");
			bd.escriure(decenes+ i + 1);					//accio d'escriure
		}//for
	}//run
}//class
