package com.youwin.spaceshooter.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.RenderingEntitySystem;
import com.artemis.annotations.Wire;

import org.mini2Dx.core.engine.geom.CollisionPoint;
import org.mini2Dx.core.graphics.Graphics;

import com.youwin.spaceshooter.components.PositionComponent;
import com.youwin.spaceshooter.components.SpriteComponent;

@Wire
public class RenderEntitySystem extends RenderingEntitySystem {
    private ComponentMapper<SpriteComponent> spriteMapper;
    private ComponentMapper<PositionComponent> positionMapper;

    public RenderEntitySystem() {
        super(Aspect.all(SpriteComponent.class, PositionComponent.class));
    }

    @Override
    protected void render(int entityId, Graphics g) {
        SpriteComponent sprite = spriteMapper.get(entityId);
        CollisionPoint position = positionMapper.get(entityId).getPoint();
        g.drawSprite(sprite.getSprite(), position.x, position.y);
    }

}