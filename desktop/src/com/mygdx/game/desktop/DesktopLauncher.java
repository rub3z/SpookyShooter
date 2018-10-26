package com.mygdx.game.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.SpookyShooter;
import org.lwjgl.util.Display;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new SpookyShooter(), config);
		config.title = "Don't Get Too Spooked!!!";
		config.useGL30 = true;
		config.width = 1920;
		config.height = 1080;
		config.allowSoftwareMode = true;
		config.x = -1;
		config.y = -1;
	}
}
