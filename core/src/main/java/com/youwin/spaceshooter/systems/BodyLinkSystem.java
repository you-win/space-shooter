package com.youwin.spaceshooter.systems;

import java.util.List;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.annotations.Wire;
import com.artemis.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Logger;
import com.youwin.spaceshooter.components.BodyLinkComponent;
import com.youwin.spaceshooter.components.PositionComponent;
import com.youwin.spaceshooter.components.SimpleControllerComponent;

import org.mini2Dx.core.engine.geom.CollisionPoint;

@Wire
public class BodyLinkSystem extends IteratingSystem {
    private static final Logger LOG = new Logger("[BodyLinkSystem]", Logger.INFO);

    private ComponentMapper<BodyLinkComponent> bodyLinkMapper;
    private ComponentMapper<SimpleControllerComponent> simpleControllerMapper;
    private ComponentMapper<PositionComponent> positionMapper;

    private Vector2 previousRepositionPosition = Vector2.Zero;

    public BodyLinkSystem() {
        super(Aspect.all(BodyLinkComponent.class));
    }

    @Override
    protected void process(int entityId) {
        BodyLinkComponent bodyLinkComponent = bodyLinkMapper.get(entityId);
        List<BodyLinkComponent.BodyLink> bodyLinks = bodyLinkComponent.getBodyLinks();

        for (int i = 0; i < bodyLinks.size(); i++) {
            BodyLinkComponent.BodyLink link = bodyLinks.get(i);
            SimpleControllerComponent controller = simpleControllerMapper.get(link.getId());
            Vector2 position = positionMapper.get(link.getId()).getPoint().cpy();
            Vector2 parentPosition;
            Vector2 repositionPoint;
            Vector2 targetDirection = Vector2.Zero;

            if (i == 0) {
                PositionComponent parent = positionMapper.get(bodyLinkComponent.getParentId());
                parentPosition = parent.getPoint().cpy();
                repositionPoint = parentPosition.cpy().sub(parent.getPreviousPoint());
            } else {
                PositionComponent parent = positionMapper.get(bodyLinks.get(i - 1).getId());
                parentPosition = parent.getPoint().cpy();
                repositionPoint = parentPosition.cpy().sub(parent.getPreviousPoint());
            }

            // Use or store the previous position
            if (repositionPoint.isZero()) {
                repositionPoint = link.getPreviousTargetPoint();
            } else {
                link.getPreviousTargetPoint().set(repositionPoint.cpy());
            }
            // Custom clamp for individual parts of the vector
            repositionPoint.x = -Math.max(-1, Math.min(1, repositionPoint.x));
            repositionPoint.y = -Math.max(-1, Math.min(1, repositionPoint.y));

            if (repositionPoint.x > 0) {
                parentPosition.x += 32;
            } else if (repositionPoint.x < 0) {
                parentPosition.x -= 32;
            }

            if (repositionPoint.y > 0) {
                parentPosition.y += 32;
            } else if (repositionPoint.y < 0) {
                parentPosition.y -= 32;
            }

            targetDirection = position.sub(parentPosition);
            targetDirection.x = -Math.max(-1, Math.min(1, targetDirection.x));
            targetDirection.y = -Math.max(-1, Math.min(1, targetDirection.y));
            controller.setTargetDirection(targetDirection);
        }
    }
}