package entite;

import java.util.ArrayList;

import screen.TouchPad;
import ch.p1gu.banzai.Assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Tank extends Entite {
	public static float vitessemax = 200;
	public float angle;
	public ArrayList<Tir> lesTirs;
	private float dernierTir, vitesseDeTir;
	private int couleur;

	public Tank(float x, float y,int couleur) {
		this.couleur=couleur;
		lesTirs = new ArrayList<Tir>();
		body = new Rectangle(x, y, 24, 24);
		oldBody=new Rectangle(x,y,24,24);
		acceleration = new Vector2(50, 100);
		angle = -90;
		dernierTir = 0;
		vitesseDeTir = 0.1f;
	}

	@Override
	public void update(float delta) {
		clear();
		
		calculerAcceleration(delta);
		
		gererTirs(delta);

		calculeDeplacement(delta);
		
		calculerAngleTank();

		updateTir(delta);
	}
	
	private void updateTir(float delta){
		for (Tir tir : lesTirs) {
			tir.update(delta);
		}
	}
	
	private void calculerAngleTank(){
		if (acceleration.x != 0 || acceleration.y != 0) {
			angle = acceleration.angle() - 90;
		}
	}
	
	private void calculeDeplacement(float delta){
		oldBody.x=body.x;
		oldBody.y=body.y;
		body.x += acceleration.x;
		body.y += acceleration.y;
		
	}
	
	private void gererTirs(float delta){
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE)||
				((Gdx.input.isTouched()&&Gdx.input.getX()>Gdx.graphics.getWidth()/2)||
						(Gdx.input.isTouched(1)&&Gdx.input.getX(1)>Gdx.graphics.getWidth()/2))) {
			if (vitesseDeTir < dernierTir) {
				Vector2 accTir = new Vector2();
				accTir.x = (float) Math
						.cos(Math.toRadians((double) angle + 90)) *10;
				accTir.y = (float) Math
						.sin(Math.toRadians((double) angle + 90)) *10;
				Tir t =new Tir(this, accTir);
				lesTirs.add(t);
				dernierTir = 0;
			} else {
				dernierTir += delta;
			}
		}
	}
	
	private void calculerAcceleration(float delta){	
		acceleration.x = TouchPad.getKnobPercentX() * delta * vitessemax;
		acceleration.y = TouchPad.getKnobPercentY() * delta * vitessemax;

		if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			acceleration.y = vitessemax * delta;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.S)) {
			acceleration.y = -vitessemax * delta;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			acceleration.x = -vitessemax * delta;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.D)) {
			acceleration.x = vitessemax * delta;
		}
	}
	
	public void clear(){
		Tir t;
		for (int i = 0; i < lesTirs.size(); i++) {
			t = lesTirs.get(i);
			if (t.mort) {
				lesTirs.remove(i);
				i--;
			}

		}
	}

	@Override
	public void draw(SpriteBatch batch) {

		for (Tir tir : lesTirs) {
			tir.draw(batch);
		}
		switch (couleur) {
		case 1:
			batch.draw(Assets.tankVert ,body.x, body.y, body.width /2, body.height / 2, body.width, body.height,1f,1f, angle);
			
			break;
		case 2:
			batch.draw(Assets.tankRouge ,body.x, body.y, body.width /2, body.height / 2, body.width, body.height,1f,1f, angle);
			
			break;
		default:
			break;
		}
		//batch.draw(Assets.tankRouge ,body.x, body.y, body.width /2, body.height / 2, body.width, body.height,1f,1f, angle);
		

	}

	@Override
	public void hit(Entite entite) {
		// TODO Auto-generated method stub

	}

}
