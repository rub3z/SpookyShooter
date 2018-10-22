package com.mygdx.game.utilities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.components.Scripts.Behavior;
import com.mygdx.game.components.SteeringComponent;
import com.mygdx.game.entities.Factory;


public class BehaviorBuilder {
   private static BehaviorBuilder instance;

   public static BehaviorBuilder getInstance(){
      if(instance==null){
         instance=new BehaviorBuilder();
      }
      return instance;
   }
   private BehaviorBuilder(){

   }

   public Array<Behavior> load(String path){
      Array<Behavior> behaviors=new Array<Behavior>();
      FileHandle fileHandle= Gdx.files.internal(path);
      String file = fileHandle.readString();
      String [] commands=file.split("\\n");
      for (int i =0; i< commands.length;i++){
         String[] command=file.split("\\s+");
         if(command[0].equals("move")){
            behaviors.add(move(Float.valueOf(command[1]),Float.valueOf(command[2])));
         }else if (command[0].equals("shot")){
            behaviors.add(shoot());
         }else if(command[0].equals("sleep")){

         }else if (command[0].equals("wander")){

         }
      }
      return behaviors;
   }

   private Behavior move(final float posX, final float posY){
      return new Behavior() {
         private float accumulator=0;
         @Override
         public void setBehavior(Entity entity) {
            entity.getComponent(SteeringComponent.class).steeringBehavior=
                    SteeringPresets.getArrive(entity.getComponent(SteeringComponent.class),posX,posY);
         }

         @Override
         public boolean isDone(Entity entity, float deltaTime) {
            if(entity.getComponent(SteeringComponent.class).body.getLinearVelocity().isZero(0.01f)){
               accumulator+=deltaTime;
            }else{
               accumulator=0;
            }
            return accumulator>1;
         }
      };
   }
   private Behavior shoot(){
      return new Behavior() {
         @Override
         public void setBehavior(Entity entity) {

         }

         @Override
         public boolean isDone(Entity entity, float deltaTime) {
            return true;
         }
      };
   }
   private Behavior sleep(){
      return new Behavior() {
         @Override
         public void setBehavior(Entity entity) {

         }

         @Override
         public boolean isDone(Entity entity, float deltaTime) {
            return false;
         }
      };
   }
   private Behavior wander(){
      return new Behavior() {
         @Override
         public void setBehavior(Entity entity) {

         }

         @Override
         public boolean isDone(Entity entity, float deltaTime) {
            return false;
         }
      };
   }
}
