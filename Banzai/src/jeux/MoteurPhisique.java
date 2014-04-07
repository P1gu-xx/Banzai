package jeux;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;

import entite.Entite;

public class MoteurPhisique {

	public MoteurPhisique(TiledMapTileLayer collisionLayer) {
		this.collisionLayer = collisionLayer;
	}

	private TiledMapTileLayer collisionLayer;

	public boolean isCellBlocked(float x, float y) {
		Cell cell = collisionLayer.getCell(
				(int) (x / collisionLayer.getTileWidth()),
				(int) (y / collisionLayer.getTileHeight()));
		return cell != null && cell.getTile() != null
				&& cell.getTile().getProperties().containsKey("collision");
	}

	public boolean collisionGauche(Entite e) {
		for (float step = 0; step < e.body.height; step += collisionLayer
				.getTileHeight() / 2)
			if (isCellBlocked(e.body.x + e.body.width, e.oldBody.y + step))
				return true;
		return false;
	}

	public boolean collisionDroite(Entite e) {
		for (float step = 0; step < e.body.height; step += collisionLayer
				.getTileHeight() / 2)
			if (isCellBlocked(e.body.x, e.oldBody.y + step))
				return true;
		return false;
	}

	public boolean collisionHaut(Entite e) {
		for (float step = 0; step < e.body.width; step += collisionLayer
				.getTileWidth() / 2)
			if (isCellBlocked(e.oldBody.x + step, e.body.y + e.body.height))
				return true;
		return false;

	}

	public boolean collisionBas(Entite e) {
		for (float step = 0; step < e.body.width; step += collisionLayer
				.getTileWidth() / 2)
			if (isCellBlocked(e.oldBody.x + step, e.body.y))
				return true;
		return false;
	}

	public void deplaceEntite(Entite e) {
		boolean collisionX = false, collisionY = false;
		if (e.acceleration.x < 0)
			collisionX = collisionDroite(e);
		else if (e.acceleration.x > 0)
			collisionX = collisionGauche(e);

		if (collisionX) {
			e.body.x = e.oldBody.x;
		}

		if (e.acceleration.y < 0) // going down
			collisionY = collisionBas(e);
		else if (e.acceleration.y > 0) // going up
			collisionY = collisionHaut(e);

		// react to y collision
		if (collisionY) {
			e.body.y = e.oldBody.y;
		}

	}
}
