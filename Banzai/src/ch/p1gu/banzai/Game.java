package ch.p1gu.banzai;

import screen.MainMenuScreen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.FPSLogger;

public class Game extends com.badlogic.gdx.Game {
	public static final int height=640,weight=960;
	
	private FPSLogger fps;

	@Override
	public void create () {
		Assets.load();
		MainMenuScreen mms=new MainMenuScreen(this);
		this.setScreen(mms);
		fps = new FPSLogger();
	}

	@Override
	public void render() {
		super.render();
		fps.log();
	}

	/** {@link Game#dispose()} only calls {@link Screen#hide()} so you need to override {@link Game#dispose()} in order to call
	 * {@link Screen#dispose()} on each of your screens which still need to dispose of their resources. SuperJumper doesn't
	 * actually have such resources so this is only to complete the example. */
	@Override
	public void dispose () {
		super.dispose();

		getScreen().dispose();
	}
}
