package Act2_08_Pont1carril_waitNotify;

public class Vehicle  implements Runnable{
	//attrib
	String nomVehicle;
	String sentitMarxa;
	Pont pont;

	//Constructor
	public Vehicle(String nomVehicle,String sentitMarxa, Pont pont) {
		this.nomVehicle = nomVehicle;
		this.sentitMarxa = sentitMarxa;
		this.pont = pont;

		System.out.println("["+Thread.currentThread().getName()
				+"] Vehicle "+ nomVehicle +" arriba al Pont");
	}

	//---------------------------------------
	public void run() {
		System.out.println("["+Thread.currentThread().getName()
				+"] Vehicle vol travessar Pont per anar cap a la " + sentitMarxa);
		pont.entraPont();		//Entrant SECCIO CRITICA amb proteccio
		//************* SECCIO CRITICA *****************************
		pont.travesaPont(sentitMarxa);
		//************* SECCIO CRITICA *****************************
		pont.ixPont();	//Alliberament CONDICIO
	}//run
}//class
