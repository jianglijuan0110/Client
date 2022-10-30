package client;

import common.Espece;

public class Dog extends Espece {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Dog() {
		super();
	}

	public Dog(String nomEspece, int dureeVie) {
		super(nomEspece, dureeVie);
	}

	@Override
	public String getEspece() {
		return super.getEspece();
	}

	@Override
	public String getNomEspece() {
		return super.getNomEspece();
	}

	@Override
	public void setNomEspece(String nomEspece) {
		super.setNomEspece(nomEspece);
	}

	@Override
	public int getDureeVieEspece() {
		return super.getDureeVieEspece();
	}

	@Override
	public void setDureeVie(int dureeVie) {
		super.setDureeVie(dureeVie);
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	
}
