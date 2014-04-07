package ch.p1gu.banzai.serveur;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import java.util.Vector;

public class ServeurTcp implements Runnable {
	private Vector<Client> lesClients;
	private Hashtable<Integer, Vector<Integer>> lesClientUdp;
	private ServerSocket ss;

	public ServeurTcp(int port) {
		lesClients = new Vector<Client>();
		try {
			ss = new ServerSocket(port);
		} catch (IOException e) {
			System.out.println("port deja ecoute");
		}
	}

	public synchronized void envoyerMessageAuxClients(int idClient, String msg) {
		for (Client client : lesClients) {
			if (client.id != idClient) {
				client.envoyerMessage(msg);
			}
		}
	}

	public synchronized void supprimerClient(Client c) {
		lesClients.remove(c);
	}

	@Override
	public void run() {
		int id;
		while (true) {
			Socket socketClient = null;
			try {
				socketClient = ss.accept();
			} catch (IOException e) {

			}
			Client client = null;
			if(lesClients.size()>0){
			client=lesClients.get(lesClients.size()-1);
			}
			if (client != null) {
				id = client.id + 1;
			} else {
				id = lesClients.size();
			}
			Client c = new Client(socketClient, this, id);
			lesClients.add(c);
			new Thread(c).start();
		}
	}

}
