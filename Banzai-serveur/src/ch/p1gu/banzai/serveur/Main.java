package ch.p1gu.banzai.serveur;

public class Main{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Start Serveur");
		//Serveur serv=new Serveur(new Integer(args[0]));
		ServeurTcp serv=new ServeurTcp(4567);
		new Thread(serv).start();
		new Thread(new ServeurUdp()).start();
	}

}
