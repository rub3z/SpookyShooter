package com.mygdx.game.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.entities.Factory;

public class EnemiesSpawnSystem extends IteratingSystem {


   Array<EnemySpawnData> enemySpawnData;
   public EnemiesSpawnSystem(){
      super(Family.all().get());
      enemySpawnData=new Array<EnemySpawnData>();
      enemySpawnData.add(new EnemySpawnData(2) {
         @Override
         public void spawn() {
            if(count<2)
               Factory.getFactory().spawnEnemy(0,0);
            count++;
         }
      });

   }

   @Override
   public void update(float deltaTime){
      for(EnemySpawnData data: enemySpawnData){
         data.accumulator+=deltaTime;
         if(data.accumulator>=data.spawnRate){
            data.spawn();
            data.accumulator-=data.spawnRate;
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
      public float count=0;
      public EnemySpawnData(float spawnRate){
         this.spawnRate=1/spawnRate;
         accumulator=0;
      }
      public abstract void spawn();
   }
}
