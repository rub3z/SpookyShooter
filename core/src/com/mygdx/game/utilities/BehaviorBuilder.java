package com.mygdx.game.utilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.components.Scripts.Behavior;



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

   private Behavior move(float posX, float posY){
      return null;
   }
   private Behavior shoot(){
      return null;
   }
   private Behavior sleep(){
      return null;
   }
   private Behavior wander(){
      return null;
   }
}
