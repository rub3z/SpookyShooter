package com.mygdx.game.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.entities.Factory;
import com.mygdx.game.utilities.Utilities;

/**
 * A system responsible for spawning enemies.
 */
public class EnemiesSpawnSystem extends IteratingSystem {


   Array<EnemySpawnData> enemySpawnData;
   public EnemiesSpawnSystem(){
      super(Family.all().get());
      enemySpawnData=new Array<EnemySpawnData>();
      enemySpawnData.add(new EnemySpawnData(1) {
         @Override
         public void spawn() {
            Factory.getFactory().spawnEnemy1(Utilities.FRUSTUM_WIDTH/2,Utilities.FRUSTUM_HEIGHT+10, "GameScreen/Behaviors/Behavior1.txt");
            Factory.getFactory().spawnEnemy1(Utilities.FRUSTUM_WIDTH/2,Utilities.FRUSTUM_HEIGHT+10, "GameScreen/Behaviors/Behavior2.txt");
         }
      });
      enemySpawnData.add(new EnemySpawnData(0.3f) {
         @Override
         public void spawn() {
            Factory.getFactory().spawnEnemy2(Utilities.FRUSTUM_WIDTH/2-100,Utilities.FRUSTUM_HEIGHT+10, "GameScreen/Behaviors/Behavior3.txt");
            Factory.getFactory().spawnEnemy2(Utilities.FRUSTUM_WIDTH/2+100,Utilities.FRUSTUM_HEIGHT+10, "GameScreen/Behaviors/Behavior4.txt");
         }
      });
      enemySpawnData.add(new EnemySpawnData(0.1f) {
         @Override
         public void spawn() {
            if (Factory.getFactory().boss.size() == 0) {
               Factory.getFactory().spawnBoss(Utilities.FRUSTUM_WIDTH / 2, Utilities.FRUSTUM_HEIGHT +25, "GameScreen/Behaviors/Behavior5.txt");

            }else{
               this.accumulator=0;
            }
         }
      });
   }

   @Override
   public void update(float deltaTime){
      int numPlayer=Factory.getFactory().players.size();
      int scale =1;
      if(numPlayer>=1){
         scale=numPlayer;
      }
      for(EnemySpawnData data: enemySpawnData){
         data.accumulator+=deltaTime;
         if(data.accumulator>=data.spawnRate/scale){
            data.spawn();
            data.accumulator-=data.spawnRate/scale;
         }
      }

   }
   /**
    * This method is called on every entity on every update call of the EntitySystem. Override this to implement your system's
    * specific processing.
    *
    * @param entity    The current Entity being processed
    * @param deltaTime The delta time between the last and current frame
    */
   @Override
   protected void processEntity(Entity entity, float deltaTime) {

   }

   abstract class EnemySpawnData{
      public float spawnRate; //How many enemies per second.
      public float accumulator;
      public EnemySpawnData(float spawnRate){
         this.spawnRate=1/spawnRate;
         accumulator=0;
      }
      public abstract void spawn();
   }
}
