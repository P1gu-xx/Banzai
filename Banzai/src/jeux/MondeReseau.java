package jeux;

import jeux.reseau.ReseauJeux;

public class MondeReseau extends Monde{
	
	private ReseauJeux reseau;

	public MondeReseau() {
		super();
		reseau=new ReseauJeux();
		}
	
	@Override
	public void update(float delta) {
		super.update(delta);
		reseau.envoyerPositionTank(tank);
	}
}
