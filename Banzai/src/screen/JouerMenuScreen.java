package screen;

import ch.p1gu.banzai.Assets;
import ch.p1gu.banzai.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GLCommon;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;


public class JouerMenuScreen implements Screen {
	private Game game;
	
	private OrthographicCamera guiCam;
	private SpriteBatch batcher;
	private Rectangle soloBounds,multiBounds,retourBounds;
	private Vector3 touchPoint;
	
	public JouerMenuScreen(Game game) {
		this.game=game;
		touchPoint = new Vector3();
		batcher=new SpriteBatch();
		soloBounds=new Rectangle(Game.weight/2-75, 350, 150, 70);
		multiBounds = new Rectangle(Game.weight/2-80, 270, 160, 70);
		retourBounds = new Rectangle(Game.weight/2-75, 190, 150, 70);

		guiCam = new OrthographicCamera(Game.weight, Game.height);
		guiCam.position.set(Game.weight / 2, Game.height / 2, 0);
	}
	
	public void update(){
		
		if (Gdx.input.justTouched()) {
			guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(),0));

			if (soloBounds.contains(touchPoint.x, touchPoint.y)) {
				game.setScreen(new GameScreen());
				return;
			}
			if (multiBounds.contains(touchPoint.x, touchPoint.y)) {
				game.setScreen(new MultiMenuScreen(game));
				return;
			}
			if (retourBounds.contains(touchPoint.x, touchPoint.y)) {
				game.setScreen(new MainMenuScreen(game));
				return;
			}
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
		batcher.begin();
		
		batcher.draw(Assets.titre, Game.weight/2-150, Game.height-150, 300, 150);
		
		batcher.draw(Assets.solo, soloBounds.x, soloBounds.y, soloBounds.width, soloBounds.height);
		batcher.draw(Assets.multi, multiBounds.x, multiBounds.y, multiBounds.width, multiBounds.height);
		batcher.draw(Assets.retour, retourBounds.x, retourBounds.y, retourBounds.width, retourBounds.height);
			
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
