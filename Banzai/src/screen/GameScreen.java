package screen;

import jeux.Monde;
import jeux.MondeReseau;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GLCommon;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * 
 * @author Michael
 */
public class GameScreen implements Screen {
	private final int height = 640, weight = 960;

	private MondeReseau monde;

	private TouchPad touchpad;

	private OrthographicCamera guiCam;
	private SpriteBatch batch;

	private Stage stage;

	public GameScreen() {
		touchpad = new TouchPad(20, 20, 200);
		monde = new MondeReseau();
		stage = new Stage(weight, height, true, batch);
		stage.addActor(touchpad.getTouchpad());
		Gdx.input.setInputProcessor(stage);
		batch = new SpriteBatch();
	}

	public void update(float delta) {
		monde.update(delta);
		guiCam.position.set(monde.getTank().body.x, monde.getTank().body.y, 0);
		guiCam.update();
		
		stage.act(Gdx.graphics.getDeltaTime());
	}

	public void draw() {
		GLCommon gl = Gdx.gl;
		gl.glClearColor(0, 0, 0, 1);
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(guiCam.combined);
		monde.draw(batch, guiCam);
		stage.draw();
	}

	@Override
	public void render(float delta) {
		update(delta);
		draw();
	}

	@Override
	public void resize(int i, int i1) {
	}

	@Override
	public void show() {
		guiCam = new OrthographicCamera(weight, height);
		guiCam.position.set(weight / 2, height / 2, 0);
		batch.enableBlending();
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}
}
