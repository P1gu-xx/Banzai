/*

 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.p1gu.banzai;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * 
 * @author Michael
 */
public class Assets {

	public static final String FONT_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";
	
	public static Texture texture;
	public static Texture textureTir;

	public static TextureRegion backgroundRegion;
	public static TextureRegion titre;
	public static TextureRegion tankVert,tankRouge;
	public static TextureRegion tir;
	public static Animation explosion;
	// text
	public static TextureRegion jouer;
	public static TextureRegion option;
	public static TextureRegion score;
	public static TextureRegion solo;
	public static TextureRegion multi;
	public static TextureRegion retour;
	
	// font
	public static BitmapFont font1;

	public static Texture loadTexture(String file) {
		return new Texture(Gdx.files.internal(file));
	}

	public static void load() {
		texture = loadTexture("data/img/banzai.png");
		textureTir = loadTexture("data/img/tir.png");
		tir = new TextureRegion(textureTir, 4, 4);
		tankVert = new TextureRegion(texture, 0, 0, 21, 24);
		tankRouge = new TextureRegion(texture, 22, 0, 21, 24);
		backgroundRegion = new TextureRegion(texture, 511, 0, 1, 512);
		titre = new TextureRegion(texture, 0, 384, 255, 512 - 384);
		// text
		jouer = new TextureRegion(texture, 0, 43, 78, 38);
		option = new TextureRegion(texture, 0, 83, 87, 38);
		score = new TextureRegion(texture, 0, 121, 76, 38);
		solo = new TextureRegion(texture, 0, 161, 68, 38);
		multi = new TextureRegion(texture, 0, 201, 78, 37);
		retour = new TextureRegion(texture, 0, 237, 87, 38);
		// animation
		explosion = new Animation(0.1f, new TextureRegion(texture, 45, 0, 32,
				32), new TextureRegion(texture, 77, 0, 32, 32),
				new TextureRegion(texture, 109, 0, 32, 32), new TextureRegion(
						texture, 141, 0, 32, 32));
		
		//font
		font1=new BitmapFont(Gdx.files.internal("data/font/font2.fnt"),
		         Gdx.files.internal("data/font/font2_0.png"), false);

	}

	public static void dispose() {
		texture.dispose();
	}
}
