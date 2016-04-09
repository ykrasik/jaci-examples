package com.github.ykrasik.jaci.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.github.ykrasik.jaci.JaciLibGdxExample;

public class DesktopLauncher {
	public static void main (String[] arg) {
		final LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Jaci";
		config.setFromDisplayMode(LwjglApplicationConfiguration.getDesktopDisplayMode());
		config.fullscreen = false;
		config.height -= 150;
		config.width -= 100;
		config.resizable = true;
		config.x = 50;
		config.y = 50;

		new LwjglApplication(new JaciLibGdxExample(), config);
	}
}
