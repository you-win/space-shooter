package com.youwin.spaceshooter.entities;

import java.util.ArrayList;
import java.util.List;

import com.artemis.Entity;
import com.artemis.World;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.youwin.spaceshooter.components.HitboxComponent;
import com.youwin.spaceshooter.components.NameComponent;
import com.youwin.spaceshooter.components.PlayerControllerComponent;
import com.youwin.spaceshooter.components.PositionComponent;
import com.youwin.spaceshooter.components.ShootingComponent;
import com.youwin.spaceshooter.components.SpriteComponent;
import com.youwin.spaceshooter.components.TimerComponent;
import com.youwin.spaceshooter.utils.CollisionLayerEnum.Layer;

public class PlayerBuilder {
    public PlayerBuilder() throws Exception {
        throw new Error();
    }

    public static Entity createPlayer(World world, Vector2 position, float speed) {
        Entity player = world.createEntity();

        List<Layer> listenLayers = new ArrayList<Layer>();
        listenLayers.add(Layer.PLAYER);

        List<Layer> searchLayers = new ArrayList<Layer>();
        searchLayers.add(Layer.ENEMY);

        TimerComponent timerComponent = new TimerComponent();
        timerComponent.addTimer("ShootingComponent", 0.25f);
        timerComponent.addTimer("Test", 1f);

        return player.edit() //
                .add(new PlayerControllerComponent(speed)) //
                .add(new PositionComponent(position)) //
                .add(new SpriteComponent(new Texture("blue-square.png"))) //
                .add(new HitboxComponent(player.getId(), position, 32f, 32f, listenLayers, searchLayers)) //
                .add(new NameComponent("Player")) //
                .add(new ShootingComponent(new Vector2(10, 0))) //
                .add(timerComponent) //
                .getEntity();
    }
}