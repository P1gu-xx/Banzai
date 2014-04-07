package reseau;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ReseauTcp implements Runnable {

	private Socket s;
	private DataInputStream dis;
	private static DataOutputStream dos;
	private EcouteurReseau ecouteur;
	private String msg;

	public ReseauTcp(EcouteurReseau ecouteur) {
		this.ecouteur = ecouteur;
	}

	/**
	 * permet de se conneter a un serveur. va creer les objets pour communiquer
	 * avec le serveur.
	 * 
	 * @param addresse
	 *            ip ou fqdn du serveur.
	 * @param port
	 *            le port sur le quel ecoute le serveur.
	 */
	public int connexionServeur(String addresse, int port) {
		try {
			s = new Socket(addresse, port);
			dis = new DataInputStream(s.getInputStream());
			dos = new DataOutputStream(s.getOutputStream());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return recupererId();
	}

	public void envoyerDonnee(String msg) {
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * permet de recuperer l'id du client qui se trouve sur le serveur.
	 * 
	 * @return int id du client. si il y a un problème alors la reponse sera
	 *         -1;
	 */
	private int recupererId() {
		try {
			return dis.readInt();
		} catch (IOException e) {
			return -1;
		}
	}

	@Override
	public void run() {
		try {
			while ((msg = dis.readUTF()) != null) {
				ecouteur.messageRecu(msg);
			}
		} catch (IOException e) {
			ecouteur.coupureReseau();
			e.printStackTrace();
		}

	}

}
