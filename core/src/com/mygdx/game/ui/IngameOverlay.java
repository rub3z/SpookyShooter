package com.mygdx.game.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class IngameOverlay extends Stage {
   public IngameOverlay(){
      //Create table that fill the screen
      Table table= new Table();
      table.setFillParent(true);
      table.setDebug(true);
      this.addActor(table);

      //Load skin in
      Skin skin = new Skin(Gdx.files.internal("Skins/shade/skin/uiskin.json"));

      //Create buttons
      TextButton singleplayer=new TextButton("Singleplayer", skin);
      singleplayer.setScale(5,5);
      TextButton multiplayer = new TextButton("Multiplayer", skin);
      TextButton exit = new TextButton("Quit", skin);
      Slider slider=new Slider(0f,100f,1f,false,skin);
      //Add buttons to table
      table.add(singleplayer).fillX().uniformX().width(100);
      table.row();
      table.add(multiplayer).fillX().uniformX();
      table.row();
      table.add(exit).fillX().uniformX();
      table.row();
      table.add(slider);
   }
}
