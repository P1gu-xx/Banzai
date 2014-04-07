package ch.p1gu.banzai;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Banzai";
		cfg.useGL20 = false;
		cfg.width = 960;
		cfg.height = 640;
		cfg.vSyncEnabled = true;
		cfg.foregroundFPS=30;
		
		new LwjglApplication(new Game(), cfg);
	}
}
