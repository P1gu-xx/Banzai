package ch.p1gu.banzai.serveur;

import java.util.ArrayList;
import java.io.*;
import java.net.*;

public class ServeurUdp implements Runnable {

	final static int port = 4567;
	final static int taille = 1024;
	static byte buffer[] = new byte[taille];
	private ArrayList<ClientUdp> lesClients;

	public ServeurUdp() {
		lesClients = new ArrayList<ClientUdp>();
	}

	@Override
	public void run() {
		System.out.println("Start thread udp");
		DatagramSocket socket;
		try {
			socket = new DatagramSocket(port);
			boolean portDejaConnue = false, ipDejaConnue = false;
			String donnees = "";
			String message = "";
			int taille = 0;
			while (true) {
				portDejaConnue = ipDejaConnue = false;

				DatagramPacket paquet = new DatagramPacket(buffer,
						buffer.length);
				socket.receive(paquet);
				taille = paquet.getLength();
				donnees = new String(paquet.getData(), 0, taille);

				// envoyer donnnees
				message = donnees;
				DatagramPacket envoi = null;
				for (ClientUdp client : lesClients) {
					if (client.inetAdress.getHostAddress() != paquet
							.getAddress().getHostAddress()) {
						if (client.port != paquet.getPort()) {

							envoi = new DatagramPacket(message.getBytes(),
									message.length(), client.inetAdress,
									client.port);
							socket.send(envoi);
							System.out.println("Message envoye");
						} else {
							portDejaConnue = true;
						}
					} else {
						ipDejaConnue = true;
					}

				}
				if (!portDejaConnue) {
					if (!ipDejaConnue) {

						System.out.println("nouveau client");
						lesClients.add(new ClientUdp(paquet.getAddress(),
								paquet.getPort()));
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
