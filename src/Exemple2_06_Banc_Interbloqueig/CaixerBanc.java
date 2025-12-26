package Exemple2_06_Banc_Interbloqueig;
import java.io.IOException;

public class CaixerBanc implements Runnable{
	//ATRIBUTS
	private CompteBancari compteDefecte; //atribut compartit pels fils
	private CompteBancari compteOpcional;
	private int operacioAfer;

	//CONSTRUCTOR1
	public CaixerBanc(CompteBancari compte, int operacio) {
		this.compteDefecte = compte;
		this.compteOpcional = null;	
		this.operacioAfer = operacio;
	}
	//CONSTRUCTOR2
	public CaixerBanc(CompteBancari compte1, CompteBancari compte2, int operacio) {
		this.compteDefecte = compte1;
		this.compteOpcional = compte2;
		this.operacioAfer = operacio;
	}

	//METODES 
	public void ingressar(CompteBancari compte, float diners) throws IOException, InterruptedException{
		//sobre l'objecte compartit, realitza un ingres
		compte.ingressarCB(diners, Thread.currentThread().getName());
	}//ingressar

	public void treure(CompteBancari compte, float diners) throws IOException, InterruptedException {
		//sobre l'objecte compartit, realitza un extracte
		compte.treureCB(diners, Thread.currentThread().getName());
	}//treure
	
	public void transferirDiners( CompteBancari cOrigen, CompteBancari cDesti, float quantitat) 
			throws IOException, InterruptedException{
		CompteBancari compteA = null;
		CompteBancari compteB = null;
		if(cOrigen.getIdCompte() < cDesti.getIdCompte()){ 		//si id cOrigen és menor que cDesti
			compteA = cOrigen;								//compteA és el compte amb id més baix
			compteB = cDesti;								//compteB és el compte amb id més alt
		} else  if(cOrigen.getIdCompte() > cDesti.getIdCompte()){	//si id cOrigen és major que cDesti
			compteA = cDesti;								//compteA és el compte amb id més baix
			compteB = cOrigen;								//compteB és el compte amb id més alt
		} else  if(cOrigen.getIdCompte() == cDesti.getIdCompte()) //si comptes son iguals, no fer res
			return;			
		//***********SINCRONITZACIO ORDENADA
		synchronized (compteA){								//sincronitza compte amb id més baix
			synchronized (compteB){							//sincronitza compte amb id més alt
				//Codi sincronitzat
				if(cOrigen.getSaldo() >= quantitat){ 
					cOrigen.treureCB(quantitat, Thread.currentThread().getName());  //extrau compteA
					cDesti.ingressarCB(quantitat, Thread.currentThread().getName());  //ingresa compteB
				}//if
			 }//synchronized 
		 }//synchronized
		//********************************
	} //transferirDiners

	public void run() {
		try {
			//en funció del valor passat al constructor, realitza unes operacions1 o atres
			switch(operacioAfer) {
			case 1: 		
				
					//ingres de 400€
					System.out.println("["+Thread.currentThread().getName()+"] (1/2) Ingressant 400...");
					ingressar(compteDefecte, 400);
					//extracte de 200€
					System.out.println("["+Thread.currentThread().getName()+"] (2/2) Traguent 200...");
					treure(compteDefecte, 200);
				
				break;
			case 2: 		
				//System.out.println("\t[" + Thread.currentThread().getName() +"] Resum d'accions: -600 i +200");
//				synchronized(compteDefecte) { //  *****sincronització sobre l'objecte compartit compte ******
					//extracte de 200€
					System.out.println("["+Thread.currentThread().getName()+"] (1/2)  Traguent 600...");
					treure(compteDefecte, 600);
					//ingres de 200€
					System.out.println("["+Thread.currentThread().getName()+"] (2/2) Ingressant 200...");
					ingressar(compteDefecte, 200);
//				}//synchronized
				break;
			default:
				//System.out.println("\t[" + Thread.currentThread().getName() +"] Resum d'accions: Transferir 200");
				if(compteOpcional == null) {
					System.err.println("No hi ha compte destí, ANULADA transferencia");
					return;
				}
					//extracte de 200€
					System.out.println("["+Thread.currentThread().getName()+"] (1/2)  Transferència de 200€ del compte Origen "+ compteDefecte.getIdCompte() +" al compte Desti "+ compteOpcional.getIdCompte() +" ...");
					transferirDiners(compteDefecte, compteOpcional, 200);
					//ingres de 200€
				break;
			}//switch
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//run
}//class
