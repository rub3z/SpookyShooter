package com.mygdx.game.components.Scripts;


import com.badlogic.ashley.core.Entity;

public interface Behavior {
   /**
    * Run this behavior every frame
    * @param entity entity that this behavior belong to
    */
    void setBehavior(Entity entity);
    boolean isDone(Entity entity, float deltaTime);
}
