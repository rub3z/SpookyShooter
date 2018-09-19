package com.mygdx.game.systems;

import com.badlogic.ashley.core.*;
import com.badlogic.ashley.systems.SortedIteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.components.BodyComponent;
import com.mygdx.game.components.TextureComponent;
import com.mygdx.game.components.TransformComponent;
import com.mygdx.game.entities.Factory;
import com.mygdx.game.utilities.Utilities;

import java.util.Comparator;

public class RenderingSystem extends SortedIteratingSystem {

    /**
     * Mappers uses to quickly access the component of an entity.
     */
    private ComponentMapper<TransformComponent> transformMapper;
    private ComponentMapper<TextureComponent> textureMapper;
    private OrthographicCamera camera;

    /**
     * SpriteBatch uses to draw.
     */
    private SpriteBatch spriteBatch;

    /**
     * Constructor
     */
    public RenderingSystem(SpriteBatch spriteBatch, OrthographicCamera camera){
        super(Family.all(BodyComponent.class,TextureComponent.class).get(), new LayerComparator());

        transformMapper=ComponentMapper.getFor(TransformComponent.class);
        textureMapper=ComponentMapper.getFor(TextureComponent.class);

         this.spriteBatch=spriteBatch;
         this.camera=camera;
    }

    @Override
    public void update(float deltaTime){

       Gdx.gl.glClearColor(1, 0, 0, 1);
       Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
       camera.update();
       spriteBatch.setProjectionMatrix(camera.combined);
       spriteBatch.enableBlending();
       super.update(deltaTime);
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
        spriteBatch.begin();
        TextureComponent textureComponent= textureMapper.get(entity);
        TransformComponent transformComponent=transformMapper.get(entity);
        if(textureComponent!=null&&!transformComponent.isHidden){
            float width= textureComponent.textureRegion.getRegionWidth();
            float height=textureComponent.textureRegion.getRegionHeight();
            float originX= width/2f;
            float originY= height/2f;
            spriteBatch.draw(textureComponent.textureRegion,
                    transformComponent.position.x-originX,
                    transformComponent.position.y-originY,
                    originX,
                    originY,
                    width,
                    height,
                    Utilities.PixelsToMeters(transformComponent.scale.x),
                    Utilities.PixelsToMeters(transformComponent.scale.y),
                    transformComponent.rotation);
        }

        spriteBatch.end();
    }

    /**
     * A comparator used to compare which texture to render first....Layering .
     */
    private static class LayerComparator implements Comparator<Entity> {
        private ComponentMapper<TransformComponent> tm= ComponentMapper.getFor(TransformComponent.class);
        @Override
        public int compare(Entity e1, Entity e2){
            return (int)Math.signum(tm.get(e1).position.z-tm.get(e2).position.z);
        }
    }
}

