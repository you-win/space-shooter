package com.youwin.spaceshooter.entities;

import com.artemis.Entity;
import com.artemis.MdxWorld;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.youwin.spaceshooter.components.HitboxComponent;
import com.youwin.spaceshooter.components.NameComponent;
import com.youwin.spaceshooter.components.PlayerControllerComponent;
import com.youwin.spaceshooter.components.PositionComponent;
import com.youwin.spaceshooter.components.SpriteComponent;

public class PlayerBuilder {
    public PlayerBuilder() throws Exception {
        throw new Error();
    }

    public static Entity createPlayer(MdxWorld world) {
        Entity player = world.createEntity();
        return player.edit() //
                .add(new PositionComponent(0f, 0f)) //
                .add(new SpriteComponent(new Texture("blue-square.png"))) //
                .getEntity();
    }

    public static Entity createPlayer(MdxWorld world, Vector2 position) {
        Entity player = world.createEntity();
        return player.edit() //
                .add(new PlayerControllerComponent()) //
                .add(new PositionComponent(position)) //
                .add(new SpriteComponent(new Texture("blue-square.png"))) //
                .add(new HitboxComponent(player.getId(), position, 32f, 32f)) //
                .add(new NameComponent("Player")) //
                .getEntity();
    }
}