package Act2_06_Incidencia_Synchonized;


public class Tecnic implements Runnable{
	//ATRIBUTS
	private ServeiTecnic servei; //atribut compartit pels fils

	//CONSTRUCTOR
	public Tecnic(ServeiTecnic servei) {
		this.servei = servei;
	}

	//run
	public void run() {

		int novaIncidencia;
		try {
			for (int i=1; i<=3; i++) {//fins a 3 incidències
				if (servei.isMaxIncidenciesReached()) {		//Si shan atés totes les incidencies del dia, acaba jornada
					System.out.println("["+Thread.currentThread().getName()+ "] Aconseguit màxim incidències. Finalitza servei atenció");
					return;
				}//if				
				novaIncidencia = servei.getIdNovaIncidencia();
				System.out.println("["+Thread.currentThread().getName()+"] Atenent incidència "+ novaIncidencia +" ...");
				Thread.sleep(50);
				System.out.println("["+Thread.currentThread().getName()+"] Solucionant incidència "+ novaIncidencia +" ...");
				//incrementa les incidències
				servei.incrementaIncidencia(Thread.currentThread().getName());
			}//for
			System.out.println("["+Thread.currentThread().getName()+"] Tecnic ha finalitzat seua jornada");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//run
}//class
