package jeux;

import java.util.ArrayList;
import java.util.Hashtable;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

import entite.Tank;
import entite.Tir;

public class Monde{
	
	private Map map;
	public Tank tank;
	public static MoteurPhisique moteurPhisique;
	
	public static Hashtable<Integer, Tank> lesTanks;
	public static ArrayList<Tir> lesTirsEn;
	
	public Monde() {
		lesTanks=new Hashtable<Integer, Tank>();
		lesTirsEn=new ArrayList<Tir>();
		map = new Map("001");
		tank = new Tank(35, 35,1);
		moteurPhisique=new MoteurPhisique((TiledMapTileLayer) map.getMap().getLayers().get("map"));
		
		}
	
	public void update(float delta){
		tank.update(delta);
		moteurPhisique.deplaceEntite(tank);
	}
	
	public void draw(SpriteBatch batch,OrthographicCamera guiCam){	
		map.render(guiCam);
		batch.begin();
		
		tank.draw(batch);
		for (Tank t : lesTanks.values()) {
			t.draw(batch);
		}
		batch.end();
	}

	public Tank getTank() {
		return tank;
	}
	
}
