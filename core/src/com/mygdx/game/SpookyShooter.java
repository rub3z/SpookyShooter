package com.mygdx.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.mygdx.game.screens.GameOverScreen;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.screens.MainMenuScreen;
import com.mygdx.game.screens.TitleScreen;

/**
 * This is the entry point to the game.
 * @author Agile Whisperers
 * @version 0.0.1
 */
public class SpookyShooter extends Game {

   /**
    * Called when the {@link Application} is first created.
    */
   @Override
   public void create() {
      setScreen(new TitleScreen(this));
   }

   /**
    * This function allows screen to control which screen it will be translate to.
    * @param choice
    */
   public void changeScreen(int choice, int playerCount) {
      switch (choice) {
         case 1:
            setScreen(new TitleScreen(this));
            break;
         case 2:
            setScreen(new MainMenuScreen(this));
            break;
         case 3:
            setScreen(new GameScreen(this, playerCount));
            break;
         case 4:
            setScreen(new GameOverScreen(this));
            break;
      }
   }
}
