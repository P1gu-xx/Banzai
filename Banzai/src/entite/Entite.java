package entite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Entite {
	
	public boolean mort;

	public enum entiteType {
		hero, ennemi, piece, tir, bonus
	};
	public Rectangle body;
	public Rectangle oldBody;
	public Vector2 acceleration;
	
	public abstract void update(float delta);
	
	public abstract void draw(SpriteBatch batch);
	
	public abstract void hit(Entite entite);
	
	
}
