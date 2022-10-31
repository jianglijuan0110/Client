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
		
		///*    TOUJOURS AJOUTER LA POLITIQUE SE SECURITE AVANT LE GESTIONNAIRE DE SECURITE    *///
		
/*		//POLITIQUE DE SECURITE
		System.setProperty("java.security.Policy", "C:\\Users\\mague\\eclipse-workspace\\Client\\src\\client.policy");
				
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
			
			
			///*    PREMIERE VERSION DU CABINET AVEC LE SERVEUR QUI DISTRIBUE DES ANIMAUX    *///
			
			/*on crée un proxy pour se connecter � l'annuaire
			 * On utilise la méthode "lookup" qui envoie une requête vers l'annuaire*/
/*			IAnimal stub = (IAnimal) registry.lookup("Interface Animal");
			
			String response1 = stub.getNomComplet();
			System.out.println("Le nom de l'animal est: " +  response1);
			
			String response2 = stub.getDossier();
			System.out.println("Le dossier de suivi de l'animal est: " +  response2);
			
			stub.setDossier("Je mets � jour mon dossier de suivi.");
			String response3 = stub.getDossier();
			System.out.println("Vous de modifier le dossier de suivi de l'animal. Voivi les modifications: " +  response3);
			
			String response4 = stub.getEspece();
			System.out.println("Server response 1: " +  response4);
			
			String response5 = stub.nomEspece();
			System.out.println("Server response 2: " +  response5);
			
			int response6 = stub.dureeVieEspece();
			System.out.println("Server response 3: " +  response6);           
*/			
			
			
			///*    DEUXIEME VERSION DU CABINET AVEC LE SERVEUR QUI DISTRIBUE DES CABINETS VETERINAIRES    *///
			
			/*on cr�e un proxy pour se connecter � l'annuaire
			 * On utilise la m�thode "lookup" qui envoie une requ�te vers l'annuaire*/
			ICabinet stub = (ICabinet) registry.lookup("Interface Cabinet");
			
			//En voulant rajouter un animal déjà présent dans le cabinet, on a la réponse suivante:
			stub.ajouterAnimal("Ayden", "Max", 2, "Chat", 12);
			
			
			stub.ajouterAnimal("Minou", "Hady", 1, "Lapin", 7);
			stub.ajouterAnimal("Narbor", "Li", 3, "Chien", 10);
			
			
			//POUR CREER UN ANIMAL AVEC LA SOUS CLASSE "Dog"
//			stub.ajouterAnimal("Berger", "Hady", 1, new Dog("Pitbul", 3));
			
			
			//pour afficher le cabinet
			stub.getCabinet();
			
			
			//on supprimme Ayden du cabinet
			stub.removeAnimal("Ayden", "Max", 2, "Chat", 12);
			stub.getCabinet();
			
			
			//si on recherche un animal presésent dans le cabinet
			stub.rechercherAnimal("Narbor");
			
			//si on recherche un animal qui n'est pas dans le cabinet 
			stub.rechercherAnimal("Mamon");
		}
		/*NotBoundException --> si on sp�cifie le nom d'un objet qui n'existe pas
		 *RemoteException --> si on a un probl�me d'acc�s*/
		catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}

}
