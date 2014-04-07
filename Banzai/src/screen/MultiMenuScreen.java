package screen;

import ch.p1gu.banzai.Assets;
import ch.p1gu.banzai.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GLCommon;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class MultiMenuScreen implements Screen{
	private Game game;
	private OrthographicCamera guiCam;
	private SpriteBatch batcher;
	
	private Vector3 touchPoint;
	protected String message;
	
	public MultiMenuScreen(Game game) {
		this.game=game;
		message="";
		touchPoint = new Vector3();
		batcher=new SpriteBatch();

		guiCam = new OrthographicCamera(Game.weight, Game.height);
		guiCam.position.set(Game.weight / 2, Game.height / 2, 0);
	}
	
	public void update(){
		
		if (Gdx.input.justTouched()) {
			guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(),0));


		}
		
	}

	public void draw(){

		GLCommon gl = Gdx.gl;
		gl.glClearColor(1, 0, 0, 1);
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		guiCam.update();
		
		batcher.setProjectionMatrix(guiCam.combined);

		batcher.disableBlending();
		batcher.begin();
		
		batcher.draw(Assets.backgroundRegion, 0, 0, Game.weight, Game.height);
		
		batcher.end();

		batcher.enableBlending();
		if (Gdx.input.justTouched()) {
			Gdx.input.getTextInput(new TextInputListener() {
				@Override
				public void input (String text) {
					message = "message: " + text + ", touch screen for new dialog";
				}

				@Override
				public void canceled () {
					message = "cancled by user";
				}
			}, "enter something funny", "funny");
		}
		batcher.begin();
		Assets.font1.setColor(0.0f, 0.0f, 0.0f, 1.0f);
		Assets.font1.draw(batcher, message, 50, 50);
		batcher.draw(Assets.titre, Game.weight/2-150, Game.height-150, 300, 150);

			
		batcher.end();
	}
	
	@Override
	public void render(float delta) {
		update();
		draw();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}


}
