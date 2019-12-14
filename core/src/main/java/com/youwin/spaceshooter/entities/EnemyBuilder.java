package com.youwin.spaceshooter.entities;

import com.artemis.Entity;
import com.artemis.MdxWorld;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.youwin.spaceshooter.components.EnemyControllerComponent;
import com.youwin.spaceshooter.components.HitboxComponent;
import com.youwin.spaceshooter.components.NameComponent;
import com.youwin.spaceshooter.components.PositionComponent;
import com.youwin.spaceshooter.components.SpriteComponent;

public class EnemyBuilder {
    public EnemyBuilder() {

    }

    public static Entity createEnemy(MdxWorld world) {
        Entity enemy = world.createEntity();
        return enemy.edit() //
                .add(new PositionComponent(0f, 0f)) //
                .add(new SpriteComponent(new Texture("red-square.png"))) //
                .add(new EnemyControllerComponent()) //
                .getEntity();
    }

    public static Entity createEnemy(MdxWorld world, Vector2 position, float speed) {
        Entity enemy = world.createEntity();
        return enemy.edit() //
                .add(new PositionComponent(position)) //
                .add(new SpriteComponent(new Texture("red-square.png"))) //
                .add(new EnemyControllerComponent(speed)) //
                .add(new HitboxComponent(enemy.getId(), position, 32f, 32f)) //
                .getEntity();
    }

    public static Entity createEnemy(MdxWorld world, Vector2 position, String name) {
        Entity enemy = world.createEntity();
        return enemy.edit() //
                .add(new PositionComponent(position)) //
                .add(new SpriteComponent(new Texture("red-square.png"))) //
                .add(new EnemyControllerComponent()) //
                .add(new HitboxComponent(enemy.getId(), position, 32f, 32f)) //
                .add(new NameComponent(name)) //
                .getEntity();
    }
}