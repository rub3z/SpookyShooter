package com.mygdx.game.components.Scripts;

import com.badlogic.ashley.core.Entity;
import com.mygdx.game.components.IsBulletComponent;
import com.mygdx.game.screens.GameScreen;

public class EnemyCollisionCallback  implements CollisionCallback {

   @Override
   public void run(Entity thisObject, Entity otherObject) {
      switch(thisObject.getComponent(IsBulletComponent.class).playerNum) {
         case 0: GameScreen.getGameScreen().score0 += 10f;
            GameScreen.getGameScreen().ui
             .updateScore(0, GameScreen.getGameScreen().score0);
            break;
         case 1: GameScreen.getGameScreen().score0 += 10f;
            GameScreen.getGameScreen().ui
             .updateScore(1, GameScreen.getGameScreen().score0);
            break;
         case 2: GameScreen.getGameScreen().score0 += 10f;
            GameScreen.getGameScreen().ui
             .updateScore(2, GameScreen.getGameScreen().score0);
            break;
         case 3: GameScreen.getGameScreen().score0 += 10f;
            GameScreen.getGameScreen().ui
             .updateScore(3              , GameScreen.getGameScreen().score0);
            break;

      }

   }
}