package com.youwin.spaceshooter.entities;

import java.util.ArrayList;
import java.util.List;

import com.artemis.Entity;
import com.artemis.World;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.youwin.spaceshooter.components.EnemyControllerComponent;
import com.youwin.spaceshooter.components.HitboxComponent;
import com.youwin.spaceshooter.components.NameComponent;
import com.youwin.spaceshooter.components.PositionComponent;
import com.youwin.spaceshooter.components.SpriteComponent;
import com.youwin.spaceshooter.utils.CollisionLayerEnum.Layer;

public class EnemyBuilder {
    public EnemyBuilder() {

    }

    public static Entity createEnemy(World world, Vector2 position, String name) {
        Entity enemy = world.createEntity();

        List<Layer> listenLayers = new ArrayList<Layer>();
        listenLayers.add(Layer.ENEMY);

        List<Layer> searchLayers = new ArrayList<Layer>();
        searchLayers.add(Layer.PLAYER);

        return enemy.edit() //
                .add(new PositionComponent(position)) //
                .add(new SpriteComponent(new Texture("red-square.png"))) //
                .add(new EnemyControllerComponent()) //
                .add(new HitboxComponent(enemy.getId(), position, 32f, 32f, listenLayers, searchLayers)) //
                .add(new NameComponent(name)) //
                .getEntity();
    }
}