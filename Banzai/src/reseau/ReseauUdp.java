package reseau;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ReseauUdp implements Runnable {

	private DatagramSocket socket;
	private EcouteurReseau ecouteur;
	private int port;
	private DatagramPacket donneesRecues;
	private InetAddress serveur;

	public ReseauUdp(EcouteurReseau ecouteur) {
		this.ecouteur = ecouteur;
		donneesRecues = new DatagramPacket(new byte[1024], 1024);
	}

	public void connexionServeur(String addrsse, int port) {
		try {
			serveur = InetAddress.getByName(addrsse);
			socket = new DatagramSocket();
			socket.setSoTimeout(0);
			this.port = port;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	public void envoyerDonnee(String msg) {
		DatagramPacket donneesEmises = new DatagramPacket(msg.getBytes(),
				msg.length(), serveur, port);
		try {
			socket.send(donneesEmises);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {

			while (true) {
				socket.receive(donneesRecues);
				ecouteur.messageRecu(new String(donneesRecues.getData(), 0,
						donneesRecues.getLength()));
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
