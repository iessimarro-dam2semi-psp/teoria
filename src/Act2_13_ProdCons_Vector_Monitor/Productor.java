package Act2_13_ProdCons_Vector_Monitor;

public class Productor implements Runnable{
	//Monitor, gestiona la comunicació i la sincronització entre fils
	private Monitor buffer;
	private int numElementsGenerats;
	
	//Cnstructor
	public Productor( Monitor s, int nElements ) {
		this.buffer = s;
		this.numElementsGenerats = nElements;
		System.out.println("["+Thread.currentThread().getName()+"] Creació d'un PRODUCTOR que produirà "
		+ nElements +" elements");
	}
	//variable del número a passar al consumidor
	private int numero = 0;

	public void run() {
		// Posa numElementsGenerats números aleatoris a disposició del consumidor
		for( int i=0; i < numElementsGenerats; i++ ) {
			numero = (int)(10*Math.random());
			buffer.produir(numero); //deixa el número al MONITOR
			System.out.println("[" +Thread.currentThread().getName() 
					+ "] Produït el número "+numero );
		}//for
	}
}//class
