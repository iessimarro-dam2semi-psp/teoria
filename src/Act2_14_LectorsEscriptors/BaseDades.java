package Act2_14_LectorsEscriptors;

public class BaseDades {
	// attr
	private int numLectors;
	private int numEscriptors;
	private boolean escrivint;
	private int numero;


	// Constructor
	public BaseDades() {
		numLectors = 0;
		numEscriptors = 0;
		escrivint = false;
		numero = 0;
		// TODO Auto-generated constructor stub
	}

	//-----------------------------------------
	public void llegir(){
		comencaLector();	//accions previes a llegir
		llegit();			//accio de llegir
		finalitzaLector();	//accions posteriors a llegir
	}//llegir

	//-----------------------------------------
	public synchronized void escriure(int valor){
		comencaEscriptor();			//accions previes a escriure
		escrit(valor);			//accio d'escriure
		finalitzaEscriptor();		//accions posteriors a escriure
	}//escriure

	//-----------------------------------------
	public void llegit(){
		String accio = " Continua procés lectura (2 de 3)->";
		System.out.println("[" +Thread.currentThread().getName()+"]"+ accio +" *Llegit :["+ numero +"]*");
	}//llegit

	//-----------------------------------------
	//-----------------------------------------
	public synchronized void escrit(int valor){
		numero = valor;
		String accio = " Continua procés escriptura (2 de 3)->";
		System.out.println("[" +Thread.currentThread().getName()+"]"+ accio +" *Escrit :["+ numero +"]*");
	}

	//-----------------------------------------
	//-----------------------------------------
	public synchronized void comencaLector(){
		try {	
			String accio = " Comença procés lectura (1 de 3)->";
			while (escrivint || numEscriptors>0){		//si hi ha escriptor treballant o pendents escriure
				System.out.println("[" +Thread.currentThread().getName()+"]"+ accio +" Lector BLOQUEJAT! zZz...");
				wait();
			}
			numLectors++;								//increment del num Lectors
			//Desperta Escriptors i Lectors bloquejats per si algun pot accedir també
			System.out.println("[" +Thread.currentThread().getName()+"]"+ accio +" Desperta fils...");
			notifyAll();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//comencaLector

	//-----------------------------------------
	public synchronized void finalitzaLector(){
		String accio = " Finalitza procés lectura (3 de 3)->";
		numLectors--;							//increment del num Lectors
		if(numLectors == 0){					//Si no hi ha més Lectors...
			//Desperta Escriptors i Lectors bloquejats
			System.out.println("[" +Thread.currentThread().getName()+"]"+ accio +" Desperta fils...");
			notifyAll();
		}
	}//finalitzaLector

	//-----------------------------------------
	public synchronized void comencaEscriptor(){
		try {
			String accio = " Comença procés escriptura (1 de 3)->";
			numEscriptors++;							//increment del num Escriptors
			while (escrivint || numLectors>0){			//si hi ha escriptor treballan o lectors llegint
				System.out.println("[" +Thread.currentThread().getName()+"]"+ accio +" Escriptor BLOQUEJAT! zZz...");
				wait();

			}
			escrivint = true;							//Marca que s'està escrivint
			System.out.println("[" +Thread.currentThread().getName()+"]"+ accio +" Escriptor pot escriure");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//comencaEscriptor

	//-----------------------------------------
	public synchronized void finalitzaEscriptor(){
		String accio = " Finalitza procés escriptura (3 de 3)->";
		numEscriptors--;								//decrement del num Escriptors
		escrivint = false;								//Marca que s'ha acabat d'escriure
		//Desperta Escriptors i Lectors bloquejats
		System.out.println("[" +Thread.currentThread().getName()+"]"+ accio +" Desperta fils...");
		notifyAll();
	}//finalitzaLector
}
