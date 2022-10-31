package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

//import common.IAnimal;
import common.ICabinet;

public class Client {
	
	//CONSTRUCTEUR PAR DEFAUT
	private Client() {
		
	}

	public static void main(String[] args) {
		
		//POLITIQUE DE SECURITE
/*		System.setProperty("java.security.Policy", "file:C:\\Users\\mague\\eclipse-workspace\\Client\\src\\client.policy");
				
		//GESTIONNAIRE DE SECURITE
		try {
			if (System.getSecurityManager() == null) {
			    System.setSecurityManager(new SecurityManager());
			}
		} catch (Exception a) {
			a.printStackTrace();
		}
*/		
		
		
		String host = (args.length < 1)? null : args[0];
		
		try {
			
			Registry registry = LocateRegistry.getRegistry(host);
			
			/*on cr�e un proxy pour se connecter � l'annuaire
			 * On utilise la m�thode "lookup" qui envoie une requ�te vers l'annuaire*/
			ICabinet stub = (ICabinet) registry.lookup("Interface Cabinet");
			
			stub.ajouterAnimal("Ayden", "Max", 2, "Chat", 12);
			stub.ajouterAnimal("Minou", "Hady", 1, "Lapin", 7);
			//stub.ajouterAnimal("Berger", "Hady", 1, new Dog("Pitbul", 3));
			
/*			IAnimal stub = (IAnimal) registry.lookup("Interface Animal");
		
			String response1 = stub.getNomComplet();
			System.out.println("Server response 1: " +  response1);
			
			String response2 = stub.getDossier();
			System.out.println("Server response 2: " +  response2);
			
			stub.setDossier("Je mets � jour mon dossier de suivi.");
			String response3 = stub.getDossier();
			System.out.println("Server response 3: " +  response3);
			
			String response4 = stub.getEspece();
			System.out.println("Server response 4: " +  response4);
			
			String response5 = stub.nomEspece();
			System.out.println("Server response 5: " +  response5);
			
			int response6 = stub.dureeVieEspece();
			System.out.println("Server response 6: " +  response6);           */
			
			
			stub.getCabinet();
			
			/*stub.removeAnimal("Ayden", "Max", 2, "Chat", 12);
			
			stub.getCabinet();
			
			/*stub.rechercherAnimal("Ayden");
			stub.rechercherAnimal("Minou");*/
		}
		/*NotBoundException --> si on sp�cifie le nom d'un objet qui n'existe pas
		 *RemoteException --> si on a un probl�me d'acc�s*/
		catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}

}
