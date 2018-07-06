package me.ryrybread5.idlegame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import me.ryrybread5.idlegame.CookieClicker;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.foregroundFPS =60;

		//System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");
		config.width = LwjglApplicationConfiguration.getDesktopDisplayMode().width;
		config.height = LwjglApplicationConfiguration.getDesktopDisplayMode().height;
		config.fullscreen = false;
		config.resizable=false;
		config.vSyncEnabled = true;
		new LwjglApplication(new CookieClicker(), config);
	}
}
