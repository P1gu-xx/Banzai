package jeux.reseau;

import entite.Tank;
import entite.Tir;
import reseau.Reseau;

public class ReseauJeux extends Reseau {

	public ReseauJeux() {
		super(new EcouteurJeux());

		connecterServeur("127.0.0.1", 5060);
	}

	public void envoyerPositionTank(Tank tank) {
		reseauUdp.envoyerDonnee(id + ":" + tank.body.x + ":" + tank.body.y
				+ ":" + tank.angle);
	}

	public void enoyerTir(Tir t) {
		reseauTcp.envoyerDonnee(id + ":" + t.body.x + ":" + t.body.y);
	}

}
