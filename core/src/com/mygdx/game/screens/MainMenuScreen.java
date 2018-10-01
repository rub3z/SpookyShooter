package com.mygdx.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Shooter;
import com.mygdx.game.SpookyShooter;

/**
 * This is the main menu. It will show all options available to players.
 */
public class MainMenuScreen extends ScreenAdapter {
   SpriteBatch batch;
   Texture img;
   /**
    * This is the reference to the game object.
    */
   private Game myGame;


   /**
    * Constructor for this screen
    *
    * @param myGame
    */
   public MainMenuScreen(Game myGame) {
      this.myGame = myGame;
      batch = new SpriteBatch();
      img = new Texture("GameScreen/Gfx/secondScreen.jpg");
   }

   /**
    * This the main loop of this screen.
    *
    * @param delta time between current frame and last frame
    */
   @Override
   public void render(float delta) {
      Gdx.gl.glClearColor(0, 0, 0, 0);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
      batch.begin();
      batch.draw(img, Gdx.graphics.getWidth() / 2 - img.getWidth() / 2, Gdx.graphics.getHeight() / 2 - img.getHeight() / 2);
      batch.end();
      if (Gdx.input.isKeyJustPressed(Input.Keys.X) ||
          Gdx.input.isKeyJustPressed(Input.Keys.BUTTON_X)) {
         System.out.println("Key press captured");
         ((Shooter) myGame).changeScreen(3, 1);
      }
      if (Gdx.input.isKeyJustPressed(Input.Keys.B) ||
          Gdx.input.isKeyJustPressed(Input.Keys.BUTTON_B)) {
         System.out.println("Key press captured");
         ((Shooter) myGame).changeScreen(3, 2);
      }
   }
}
