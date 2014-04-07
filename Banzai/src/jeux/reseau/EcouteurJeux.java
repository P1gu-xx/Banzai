package jeux.reseau;

import reseau.EcouteurReseau;

public class EcouteurJeux implements EcouteurReseau {
	private String[] lesDonnees;

	@Override
	public synchronized void messageRecu(String msg) {
		lesDonnees = msg.split(":");
		switch (new Integer(lesDonnees[0])) {
		case 0:

			break;
		case 1:

			break;
		case 2:

			break;
		case 3:

			break;

		case 4:

			break;
		case 5:

			break;
		case 6:

			break;
		case 7:

			break;
		case 8:

			break;

		case 9:

			break;

		default:
			break;
		}

	}

	@Override
	public synchronized void coupureReseau() {
		// TODO Auto-generated method stub

	}

}
