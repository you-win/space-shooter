package com.youwin.spaceshooter.entities;

import java.util.ArrayList;
import java.util.List;

import com.artemis.Entity;
import com.artemis.World;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.youwin.spaceshooter.components.HitboxComponent;
import com.youwin.spaceshooter.components.NameComponent;
import com.youwin.spaceshooter.components.PositionComponent;
import com.youwin.spaceshooter.components.SpriteComponent;
import com.youwin.spaceshooter.utils.CollisionLayerEnum.Layer;

public class BulletBuilder {
    public BulletBuilder() {

    }

    public static Entity createBullet(World world, Vector2 position, float speed) {
        Entity bullet = world.createEntity();

        List<Layer> listenLayers = new ArrayList<Layer>();
        listenLayers.add(Layer.NONE);

        List<Layer> searchLayers = new ArrayList<Layer>();
        searchLayers.add(Layer.ENEMY);

        return bullet.edit() //
                .add(new NameComponent("Bullet")) //
                .add(new PositionComponent(position)) //
                .add(new SpriteComponent(new Texture("red-square.png"))) //
                .add(new HitboxComponent(bullet.getId(), position, 32f, 32f, listenLayers, searchLayers)) //
                .getEntity();
    }
}