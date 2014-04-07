package screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad.TouchpadStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class TouchPad {
	
	private static Touchpad touchpad;
	private TouchpadStyle touchpadStyle;
	private Skin touchpadSkin;
	private Drawable touchBackground;
	private Drawable touchKnob;
	
	public TouchPad(int positionX,int positionY,int taille) {
		// Create a touchpad skin
		touchpadSkin = new Skin();
		// Set background image
		touchpadSkin.add("touchBackground", new Texture(
				"data/img/touchBackground.png"));
		// Set knob image
		touchpadSkin.add("touchKnob", new Texture("data/img/touchKnob.png"));
		// Create TouchPad Style
		touchpadStyle = new TouchpadStyle();
		// Create Drawable's from TouchPad skin
		touchBackground = touchpadSkin.getDrawable("touchBackground");
		touchKnob = touchpadSkin.getDrawable("touchKnob");
		// Apply the Drawables to the TouchPad Style
		touchpadStyle.background = touchBackground;
		touchpadStyle.knob = touchKnob;
		// Create new TouchPad with the created style
		touchpad = new Touchpad(10, touchpadStyle);
		// setBounds(x,y,width,height)
		touchpad.setBounds(positionX, positionY, taille, taille);
	}

	public Touchpad getTouchpad() {
		return touchpad;
	}
	
	public static float getKnobPercentX(){
		return touchpad.getKnobPercentX();
	}
	public static float getKnobPercentY(){
		return touchpad.getKnobPercentY();
	}
}
