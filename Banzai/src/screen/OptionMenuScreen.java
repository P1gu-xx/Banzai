package screen;

import ch.p1gu.banzai.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GLCommon;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class OptionMenuScreen implements Screen {
	Game game;
	
	private OrthographicCamera guiCam;
	
	public OptionMenuScreen(Game game) {
		this.game=game;
		
		guiCam=new OrthographicCamera(Game.weight,Game.height);
		guiCam.position.set(Game.weight/2,Game.height/2,0);
	}

	@Override
	public void render(float delta) {
		GLCommon gl = Gdx.gl;
		gl.glClearColor(0, 1, 0, 1);
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		guiCam.update();

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
