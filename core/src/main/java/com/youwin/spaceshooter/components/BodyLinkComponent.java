package com.youwin.spaceshooter.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.artemis.Component;
import com.artemis.World;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.youwin.spaceshooter.utils.CollisionLayerEnum.Layer;

public class BodyLinkComponent extends Component {
    public class BodyLink {
        private int id;
        private Vector2 previousTargetPoint;

        public BodyLink() {
        }

        public BodyLink(World world, Vector2 position) {
            previousTargetPoint = position.cpy();

            List<Layer> listenLayers = new ArrayList<Layer>(Arrays.asList(Layer.PLAYER_LINK));

            List<Layer> searchLayers = new ArrayList<Layer>(Arrays.asList(Layer.PLAYER, Layer.ENEMY));

            int bodyLinkId = world.create();
            id = bodyLinkId;
            world.getEntity(bodyLinkId).edit() //
                    .add(new PositionComponent(position)) //
                    .add(new HitboxComponent(bodyLinkId, position, 32f, 32f, listenLayers, searchLayers)) //
                    .add(new SpriteComponent(new Texture("blue-square.png"))) //
                    .add(new SimpleControllerComponent(5f)) //
                    .getEntity();
        }

        public int getId() {
            return id;
        }

        public Vector2 getPreviousTargetPoint() {
            return previousTargetPoint;
        }

        public void setPreviousTargetPoint(Vector2 previousTargetPoint) {
            this.previousTargetPoint = previousTargetPoint;
        }
    }

    private int parentId;
    private List<BodyLink> bodyLinks;

    public BodyLinkComponent() {
    }

    public BodyLinkComponent(int parentId) {
        this.parentId = parentId;
        bodyLinks = new ArrayList<BodyLink>();
    }

    public void addBodyLink(World world, Vector2 position) {
        bodyLinks.add(new BodyLink(world, position));
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public List<BodyLink> getBodyLinks() {
        return bodyLinks;
    }

    public void setBodyLinks(List<BodyLink> bodyLinks) {
        this.bodyLinks = bodyLinks;
    }
}