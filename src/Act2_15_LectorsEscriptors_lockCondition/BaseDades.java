package Act2_15_LectorsEscriptors_lockCondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BaseDades {
	// attr
	private int numLectors;
	private int numEscriptors;
	private boolean escrivint;
	private int numero;

	// <------------- Variables per al bloqueig amb Lock
	final Lock bloqueig;
	final Condition escriure;
	final Condition llegir;

	// Constructor
	public BaseDades() {
		numLectors = 0;
		numEscriptors = 0;
		escrivint = false;
		numero = 0;
		// TODO Auto-generated constructor stub
		bloqueig = new ReentrantLock();
		this.escriure = bloqueig.newCondition();
		this.llegir = bloqueig.newCondition();
	}

	public void llegir(){
		comencaLector();
		llegit();
		finalitzaLector();
	}

	public synchronized void escriure(int valor){
		comencaEscriptor();
		escrit(valor);
		finalitzaEscriptor();
	}


	public void llegit(){
		String accio = " Continua procés lectura (2 de 3)->";
		System.out.println("[" +Thread.currentThread().getName()+"]"+ accio +" *Llegit :["+ numero +"]*");
	}

	//-----------------------------------------
	public synchronized void escrit(int valor){
		numero = valor;
		String accio = " Continua procés escriptura (2 de 3)->";
		System.out.println("[" +Thread.currentThread().getName()+"] "+ accio +" *Escrit :["+ numero +"]*");
	}

	//-----------------------------------------
	public void comencaLector(){
		bloqueig.lock();
		try {
			String accio = " Comença procés lectura (1 de 3)->";
			while (escrivint || numEscriptors>0){
				System.out.println("[" +Thread.currentThread().getName()+"] "+ accio +"Lector BLOQUEJAT! zZz...");
				llegir.await();
			}
			numLectors++;
			//Per si algun lector vol llegir
			System.out.println("[" +Thread.currentThread().getName()+"] "+ accio +"Desperta possibles Lectors BLOQUEJATS");
			llegir.signalAll();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("NumLectors:" +numLectors + "; numEscriptors:" + numEscriptors + " escrivint:" + escrivint);
		bloqueig.unlock();
	}//comencaLector

	//-----------------------------------------
	public void finalitzaLector(){
		bloqueig.lock();
		String accio = " Finalitza procés lectura (3 de 3)->";
		numLectors--;
		if(numLectors == 0){					//Si no queden lectors, es desperta als escriptors
			System.out.println("[" +Thread.currentThread().getName()+"]"+ accio + "Desperta possibles Escriptors BLOQUEJATS");
			escriure.signalAll();
		} 
//		System.out.println("NumLectors:" +numLectors + "; numEscriptors:" + numEscriptors + " escrivint:" + escrivint);
		bloqueig.unlock();
	}//finalitzaLector

	//-----------------------------------------
	public void comencaEscriptor(){
		bloqueig.lock();
		try {
			String accio = " Comença procés escriptura (1 de 3)->";
			numEscriptors++;
			while (escrivint || numLectors>0){
				System.out.println("[" +Thread.currentThread().getName()+"]"+ accio + " Escriptor BLOQUEJAT! zZz...");
				escriure.await();

			}
			escrivint = true;
			//Per si algun lector vol llegir
			System.out.println("[" +Thread.currentThread().getName()+"]"+ accio + " Escriptor pot escriure");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("NumLectors:" +numLectors + "; numEscriptors:" + numEscriptors + " escrivint:" + escrivint);
		bloqueig.unlock();
	}//comencaEscriptor

	//-----------------------------------------
	public synchronized void finalitzaEscriptor(){
		bloqueig.lock();
		String accio = " Finalitza procés escriptura (3 de 3)->";
		numEscriptors--;
		escrivint = false;
		if(numEscriptors > 0) {
			System.out.println("[" +Thread.currentThread().getName()+"]"+ accio + " Desperta possibles Escriptors BLOQUEJATS");
			escriure.signalAll();
		}else {
			System.out.println("[" +Thread.currentThread().getName()+"]"+ accio + " Desperta Lectors BLOQUEJAT");
			llegir.signalAll();
		}
		//Per si algun lector vol llegir
//		System.out.println("NumLectors:" +numLectors + "; numEscriptors:" + numEscriptors + " escrivint:" + escrivint);
		bloqueig.unlock();
	}//finalitzaLector
}
