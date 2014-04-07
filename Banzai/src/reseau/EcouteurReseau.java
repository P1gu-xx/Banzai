package reseau;

public interface EcouteurReseau {
	void messageRecu(String msg);
	void coupureReseau();
}
