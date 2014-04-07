package ch.p1gu.banzai.serveur;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client implements Runnable{
	
	private DataOutputStream dos;
	private DataInputStream dis;
	private Socket s;
	private ServeurTcp serv;
	public int id;
	
	public Client(Socket s,ServeurTcp serv,int id) {
		this.serv=serv;
		this.id=id;
		try {
			dos=new DataOutputStream(s.getOutputStream());
			dis=new DataInputStream(s.getInputStream());
			dos.writeInt(id);
			dos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {

		while (true) {
			try {
				serv.envoyerMessageAuxClients(id, dis.readUTF());
			} catch (IOException e) {
				serv.supprimerClient(this);
			}
			
		}
		
	}

	public void envoyerMessage(String msg) {
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			serv.supprimerClient(this);
		}
	
	}

	

}
