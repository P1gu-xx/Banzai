package entite;

import jeux.Monde;

import ch.p1gu.banzai.Assets;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Tir extends Entite {
	private boolean collision = false;
	private boolean exploser = false;
	private float dureeExplosion;

	public Tir(Entite e, Vector2 acceleration) {
		mort = false;
		dureeExplosion = 0;

		body = new Rectangle(e.body.x + e.body.width / 2 - 2, e.body.y
				+ e.body.height / 2 - 2, 4, 4);
		this.acceleration = acceleration;
	}

	@Override
	public void update(float delta) {
		if (collision != true) {
			body.x += acceleration.x;
			body.y += acceleration.y;
			if (Monde.moteurPhisique.isCellBlocked(body.x, body.y)) {
				exploser = true;
				collision = true;
			}
		} else {
			dureeExplosion += delta;
			if(dureeExplosion>Assets.explosion.animationDuration){
				mort=true;
			}
		}

	}

	@Override
	public void draw(SpriteBatch batch) {
		// TODO Auto-generated method stub
		if (exploser) {
			batch.draw(Assets.explosion.getKeyFrame(dureeExplosion),  body.x-16, body.y-16);
		} else {
			batch.draw(Assets.tir, body.x, body.y);
		}
	}

	@Override
	public void hit(Entite entite) {
		// TODO Auto-generated method stub

	}

}
