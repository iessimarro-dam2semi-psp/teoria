package Act2_13_ProdCons_Vector_Monitor;

public class Monitor {
	//atributs PROTEGITS
	private int dades[] = null; //buffer
	private int numElements;
	private int segNum; //posicio a agafar o deixar del buffer

	//atributs PROTEGITS CONDICIO
	//control de l’estat de la cua, condició per executar
	private boolean cuaPlena;
	private boolean cuaBuida;

	//CONSTRUCTOR
	public Monitor(int numElements) {
		this.numElements = numElements;
		dades = new int[numElements];
		segNum = 0;

		cuaPlena = false;	//Inicialment NO es plena
		cuaBuida = true;	//Inicialment es buida
		System.out.println("["+Thread.currentThread().getName()+"] Creació d'un MONITOR amb un buffer de "
				+ numElements +" elements");		
	}
	//--------------------------------------
	public synchronized int consumir() {
		int valorRetornar = -1;
		// Si la cua es troba buida envia el fil a la cua d'espera
		while(cuaBuida) { //ix quan cuaBuida és false
			try {
				System.out.println("[" +Thread.currentThread().getName() 
						+ "] Buffer BUIT! "+Thread.currentThread().getName()+ " Dorm zZz...");
				wait(); 
			} catch( InterruptedException e ) {}
		}//while
		// Disminueix segNum perquè agafa un número i hi haurà un número menys a la cua
		segNum--;
		// Si no queden números
		if(segNum == 0) 
			cuaBuida = true; // La cua es troba buida

		// La cua no està plena perquè s'ha consumit un número
		cuaPlena = false;
		valorRetornar = dades[segNum];

		for(int i=0; i<1000000000; i++) {}

		//Si cua era plena i s'ha consumit un element, desperta fils Productors bloquejats
		if(segNum == dades.length - 1) {
			System.out.println("[" +Thread.currentThread().getName() 
					+ "] <Buffer NO PLE: Desperta PRODUCTOR per produir elements>");
			notifyAll();
		}//if
		// Retorna el número al fil consumidor
		return(valorRetornar);
	}//consumir

	//--------------------------------------
	public synchronized void produir(int num) {
		// Si la cua està plena, no hi entren més números, enviem el fil a la cua d'espera
		while(cuaPlena) {
			//Si cuaPlena és false, podrà continuar produint
			try {
				System.out.println("[" +Thread.currentThread().getName() 
						+ "] Buffer PLE! " +Thread.currentThread().getName()+ " Dorm zZz...");
				wait(); 
			} catch( InterruptedException e ) {}
		}//while
		// afegit el nou número a la cua al primer lloc disponible
		dades[segNum] = num;
		// augmentem els números a la cua
		segNum++;
		// Mirem si la cua està plena
		if(segNum == numElements)
			cuaPlena = true;
		//cuaBuida és false perquè acaben de produir un número
		cuaBuida = false;

		for(int i=0; i<1; i++) {}
		//Si s'ha produit un primer element, desperta fils Consumidors bloquejats
		if(segNum == 1) {
			System.out.println("[" +Thread.currentThread().getName() 
					+ "] <Buffer NO BUIT: Desperta CONSUMIDOR per consumir elements>");
			notifyAll();
		}//if
	}//produir
}//class
