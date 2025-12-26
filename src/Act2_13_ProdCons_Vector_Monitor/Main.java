package Act2_13_ProdCons_Vector_Monitor;

public class Main {

	public static void main(String[] args) {
		System.out.println("["+Thread.currentThread().getName()+"] Versió Productor-Consumidor amb VECTOR i un Monitor");
		//creacío d'un monitor
		//per comunicar i sincronitzar productor / consumidor
		Monitor monitor = new Monitor(3);
		int numElementsAprocessar = 5;

		//crea els fils per al productor i consumidor
		// on s'els assigna un nou objecte amb els arguments: 
		//Monitor i la quantitat items a processar
		Thread productor = new Thread(new Productor(monitor, numElementsAprocessar), "PRODUCTOR");
		Thread consumidor = new Thread(new Consumidor(monitor, numElementsAprocessar), "CONSUMIDOR");

		//Executem els fils
		System.out.println("["+Thread.currentThread().getName()+"] Inici fils.....");
		consumidor.start();
		productor.start();	
		try {
			consumidor.join();
			productor.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("["+Thread.currentThread().getName()+"] Finalització programa Productor-Consumidor amb VECTOR i un Monitor");
	}//main
}//class
