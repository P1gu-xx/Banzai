package jeux;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class Map {

	private TiledMap map;
	
	private OrthogonalTiledMapRenderer renderer;
	
	public Map(String numero) {
		chargerMap(numero);
		renderer = new OrthogonalTiledMapRenderer(map);
	}
	
	public void render(OrthographicCamera camera){
		
	    renderer.setView(camera);
	    renderer.render();
	}
	
	public void chargerMap(String numero){
		TmxMapLoader loader = new TmxMapLoader();
	    map = loader.load("data/maps/maps"+numero+".tmx");
	}

	public TiledMap getMap() {
		return map;
	}

	public void setMap(TiledMap map) {
		this.map = map;
	}
	
}
