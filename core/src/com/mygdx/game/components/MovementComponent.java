package com.mygdx.game.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Pool;

public class MovementComponent implements Component, Pool.Poolable {
   public boolean moveLeft, moveRight, moveUp, moveDown, shot;

    /**
     * Resets the object for reuse. Object references should be nulled and fields may be set to default values.
     */
    @Override
    public void reset() {
        moveLeft=false;
        moveRight=false;
        moveUp=false;
        moveDown=false;
        shot=false;
    }
}
