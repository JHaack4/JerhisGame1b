package com.jerhis.restorecolor;

import org.andengine.entity.scene.Scene;
import org.andengine.opengl.texture.region.ITiledTextureRegion;

public class TileSwitchBlock extends Tile {

    public TileSwitchBlock(Coord coord, char charID) {
        super(coord, 's', charID, getImage(charID));
        setCurrentTileIndex(1);
    }

    @Override
    public void collision(Chaser chaser, CollisionType type) {

        switch (charID) {
            case 'o':
                if (TileSwitch.orange) {

                    return;
                } break;
            case 'g':
                if (TileSwitch.green) {

                    return;
                } break;
            case 'p':
                if (TileSwitch.purple) {

                    return;
                } break;
        }

        switch (type) {
            case TOP: basicTopCollision(chaser);
                break;
            case LEFT: basicLeftCollision(chaser);
                break;
            case RIGHT: basicRightCollision(chaser);
                break;
            case BOTTOM: basicBottomCollision(chaser);
                break;
            case IN:
                break;
            case NONE:
                break;
        }
    }

    @Override
    public void update(Scene s, float deltaTime) {

        setCurrentTileIndex(1);
        switch (charID) {
            case 'o':
                if (TileSwitch.orange) {
                    setCurrentTileIndex(0);

                } break;
            case 'g':
                if (TileSwitch.green) {
                    setCurrentTileIndex(0);

                } break;
            case 'p':
                if (TileSwitch.purple) {
                    setCurrentTileIndex(0);

                } break;
        }
    }

    public static ITiledTextureRegion getImage(char charID) {
        switch (charID) {
            case 'o': return A.switchBlockOrange;
            case 'g': return A.switchBlockGreen;
            case 'p': return A.switchBlockPurple;
        }
        return A.switchBlockOrange;
    }

}
