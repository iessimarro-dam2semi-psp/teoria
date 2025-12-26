package Act2_13_ProdCons_Vector_Monitor;

public class Consumidor implements Runnable{
	//Monitor, gestiona la comunicació i la sincronització entre fils
	private Monitor buffer;
	private int numElementsConsumits;

	//Constructor 
	public Consumidor( Monitor s, int nElements) {
		buffer = s;
		this.numElementsConsumits = nElements;
		System.out.println("["+Thread.currentThread().getName()+"] Creació d'un CONSUMIDOR que consumirà "
		+ nElements +" elements");
	}

	public void run() {
		int num; //variable del número que li passa el productor
		// Rep numElementsConsumits números des del productor al MONITOR
		for( int i=0; i < numElementsConsumits; i++ ){
			num = buffer.consumir(); //agafa el número i el mostra
			System.out.println( "[" +Thread.currentThread().getName() 
					+ "] Número agafat: "+num );
		}//for
	}
}//class
