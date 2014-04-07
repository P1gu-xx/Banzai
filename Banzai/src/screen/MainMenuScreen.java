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
import com.badlogic.gdx.utils.TimeUtils;

public class MainMenuScreen implements Screen {

	Game game;
	OrthographicCamera guiCam;
	SpriteBatch batcher;

	Rectangle soundBounds;
	Rectangle jouerBounds;
	Rectangle optionBounds;
	Rectangle scoreBounds;
	Vector3 touchPoint;
	
	String message;

	long last = TimeUtils.nanoTime();

	public MainMenuScreen(Game game) {
		this.game = game;
		guiCam = new OrthographicCamera(Game.weight, Game.height);
		guiCam.position.set(Game.weight/2, Game.height/2, 0);
		batcher = new SpriteBatch();

		soundBounds = new Rectangle(0, 0, 64, 64);
		jouerBounds = new Rectangle(Game.weight/2-75, 350, 150, 70);
		optionBounds = new Rectangle(Game.weight/2-80, 270, 160, 70);
		scoreBounds = new Rectangle(Game.weight/2-75, 190, 150, 70);

		touchPoint = new Vector3();
	}

	public void update() {
		if (Gdx.input.justTouched()) {
			guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(),
					0));

			if (jouerBounds.contains(touchPoint.x, touchPoint.y)) {
				game.setScreen(new JouerMenuScreen(game));
				return;
			}
			if (optionBounds.contains(touchPoint.x, touchPoint.y)) {
				game.setScreen(new OptionMenuScreen(game));
				return;
			}
			if (scoreBounds.contains(touchPoint.x, touchPoint.y)) {

				return;
			}
			if (soundBounds.contains(touchPoint.x, touchPoint.y)) {

				return;
			}
		}
	}

	public void draw() {
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
		
		batcher.draw(Assets.jouer, Game.weight/2-75, 350, 150, 70);
		batcher.draw(Assets.option, Game.weight/2-80, 270, 160, 70);
		batcher.draw(Assets.score, Game.weight/2-75, 190, 150, 70);
		
		batcher.end();

		if (TimeUtils.nanoTime() - last > 2000000000) {
			Gdx.app.log(
					"Banzai",
					"version: " + Gdx.app.getVersion() + ", memory: "
							+ Gdx.app.getJavaHeap() + ", "
							+ Gdx.app.getNativeHeap() + ", native orientation:"
							+ Gdx.input.getNativeOrientation()
							+ ", orientation: " + Gdx.input.getRotation()
							+ ", accel: " + (int) Gdx.input.getAccelerometerX()
							+ ", " + (int) Gdx.input.getAccelerometerY() + ", "
							+ (int) Gdx.input.getAccelerometerZ() + ", apr: "
							+ (int) Gdx.input.getAzimuth() + ", "
							+ (int) Gdx.input.getPitch() + ", "
							+ (int) Gdx.input.getRoll());
			last = TimeUtils.nanoTime();
		}
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
