package com.youwin.spaceshooter.entities;

import com.artemis.Entity;
import com.artemis.MdxWorld;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.youwin.spaceshooter.components.PlayerControllerComponent;
import com.youwin.spaceshooter.components.PositionComponent;
import com.youwin.spaceshooter.components.SpriteComponent;

public class PlayerBuilder {
    public PlayerBuilder() {

    }

    public static Entity createPlayer(MdxWorld world) {
        return world.createEntity().edit() //
                .add(new PlayerControllerComponent()) //
                .add(new PositionComponent(0f, 0f)) //
                .add(new SpriteComponent(new Texture("blue-square.png"))) //
                .getEntity();
    }

    public static Entity createPlayer(MdxWorld world, Vector2 position) {
        return world.createEntity().edit() //
                .add(new PlayerControllerComponent()) //
                .add(new PositionComponent(position)) //
                .add(new SpriteComponent(new Texture("blue-square.png"))) //
                .getEntity();
    }
}