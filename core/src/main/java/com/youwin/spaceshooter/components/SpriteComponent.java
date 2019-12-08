package com.youwin.spaceshooter.components;

import com.artemis.Component;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import org.mini2Dx.core.graphics.Sprite;

public class SpriteComponent extends Component {
    private Sprite sprite;

    public SpriteComponent() {
        sprite = new Sprite();
    }

    public SpriteComponent(Texture texture) {
        sprite = new Sprite(texture);
    }

    public Sprite getSprite() {
        return sprite;
    }
}