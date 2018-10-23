package com.mygdx.game.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.utilities.Utilities;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class IngameOverlay extends Stage {

   private int playerCount;
   private Table table;
   private Skin skin;
   private Array<Label> labels;
   public IngameOverlay(int playerCount){
      this.playerCount=playerCount;
      labels=new Array<Label>();
      //Load skin in
      skin = new Skin(Gdx.files.internal("Skins/shade/skin/uiskin.json"));



      if( playerCount>=1){
          createUI(0, Utilities.FRUSTUM_HEIGHT-4,true);
      }
      if(playerCount>=2){
          createUI(Utilities.FRUSTUM_WIDTH-23,Utilities.FRUSTUM_HEIGHT-4,false);
      }
      if(playerCount>=3){
          createUI(0,0,true);
      }
      if(playerCount>=4){
          createUI(Utilities.FRUSTUM_WIDTH-23,0,true);
      }

     /* if(playerCount>3){
         createUI(Utilities.FRUSTUM_WIDTH-15,0,true);
      }
      if(playerCount>2){
         createUI(0,0,true);
      }
      if(playerCount>1){
         createUI(Utilities.FRUSTUM_WIDTH-15,Utilities.FRUSTUM_HEIGHT-4,false);
      }
      if(playerCount>0){
         createUI(0, Utilities.FRUSTUM_HEIGHT-4,true);
      }*/
   }

   private void createUI(float posX, float posY, boolean leftAlign){
      Label label =new Label("LOL U HAVE NO POINTS NOW",skin,"title");
      label.setPosition(Utilities.MetersToPixels(posX),Utilities.MetersToPixels(posY));
      this.addActor(label);
      labels.add(label);
   }
   public void updateScore(int player, int score){
      if(player >=0 && player<labels.size){
         labels.get(player).setText(Integer.toString(score));
      }
   }
}
