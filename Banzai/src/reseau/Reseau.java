package reseau;

public class Reseau {
	protected int id;
	protected ReseauUdp reseauUdp;
	protected ReseauTcp reseauTcp;
	private Thread threadTcp,threadUdp;

	public Reseau(EcouteurReseau ecouteur) {
		reseauTcp = new ReseauTcp(ecouteur);
		reseauUdp = new ReseauUdp(ecouteur);
	}

	public boolean connecterServeur(String ip, int port) {
		id = reseauTcp.connexionServeur(ip, port);
		reseauUdp.connexionServeur(ip, port);
		if (id != -1) {
			threadTcp=new Thread(reseauTcp,"tcp");
			threadUdp=new Thread(reseauUdp,"udp");
			threadTcp.start();
			threadUdp.start();
			return true;
		} else {
			return false;
		}
	}
	
	

}
