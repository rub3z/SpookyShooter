package com.mygdx.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.SpookyShooter;
import com.mygdx.game.ui.Gameover;

/**
 * This is the game over screen. It will be shown at the end of a game session.
 */
public class GameOverScreen extends ScreenAdapter {

   private static GameOverScreen gameOverScreen;
   /**
    * This is the reference to the game object.
    */
   private Game myGame;
   private Gameover gameOver;
   SpriteBatch batch;
   Texture img;
   int numberOfPlayers;

   /**
    * Constructor for this screen
    *
    * @param myGame
    */
   private GameOverScreen(Game myGame) {
      this.myGame = myGame;
     gameOver= new Gameover();
     batch = new SpriteBatch();
     img = new Texture("GameScreen/Gfx/fourthScreen.jpg");
   }

   public static GameOverScreen getScreen(Game myGame){
      if(gameOverScreen==null){
         gameOverScreen=new GameOverScreen(myGame);
      }
      return gameOverScreen;
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
      batch.draw(img, Gdx.graphics.getWidth() / 2 - img.getWidth() / 2, Gdx.graphics.getHeight() / 5);
      batch.end();
      if (Gdx.input.isKeyJustPressed(Input.Keys.X) ||
          Gdx.input.isKeyJustPressed(Input.Keys.BUTTON_X)) {
         System.out.println("Key press captured");
         ((SpookyShooter) myGame).changeScreen(3, numberOfPlayers);
      }

      if (Gdx.input.isKeyJustPressed(Input.Keys.B) ||
       Gdx.input.isKeyJustPressed(Input.Keys.BUTTON_B)) {
         System.out.println("Key press captured");
         Gdx.app.exit();
      }
      gameOver.act(delta);
      gameOver.draw();
   }

   /**
    * Call this method to add score to score board.
    * @param name of player
    * @param score score
    */
   public void addScore(String name, long score){
      gameOver.addScore(name,score);
   }


}
