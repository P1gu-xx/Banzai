package ch.p1gu.banzai.serveur;

import java.net.InetAddress;

public class ClientUdp {
	public InetAddress inetAdress;
	public int port;
	
	public ClientUdp(InetAddress inetAdress,int port) {
		this.inetAdress=inetAdress;
		this.port=port;
	}
}
