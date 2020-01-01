package com.youwin.spaceshooter.entities;

import com.artemis.Entity;
import com.artemis.MdxWorld;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.youwin.spaceshooter.components.HitboxComponent;
import com.youwin.spaceshooter.components.PositionComponent;
import com.youwin.spaceshooter.components.SpriteComponent;

public class BulletBuilder {
    public BulletBuilder() {

    }

    public Entity createBullet(MdxWorld world, Vector2 position, float speed) {
        Entity bullet = world.createEntity();
        return bullet.edit() //
                .add(new PositionComponent(0f, 0f)) //
                .add(new SpriteComponent(new Texture("red-square.png"))) //
                .add(new HitboxComponent(bullet.getId(), position, 32f, 32f)) //
                .getEntity();
    }
}