package com.jerhis.restorecolor;

import org.andengine.entity.scene.Scene;
import org.andengine.opengl.texture.region.ITiledTextureRegion;

public class TileSwitch extends Tile {

    public static boolean orange = false, green = false, purple = false, once = false;
    public static boolean orangeB = false, greenB = false, purpleB = false;

    public boolean want;

    public TileSwitch(Coord coord, char charID) {
        super(coord, 'S', charID, getImage(charID));
    }

    @Override
    public void collision(Chaser chaser, CollisionType type) {

        switch (type) {
            case TOP: //basicTopCollision(chaser);
                break;
            case LEFT: //basicLeftCollision(chaser);
                break;
            case RIGHT: //basicRightCollision(chaser);
                break;
            case BOTTOM: //basicBottomCollision(chaser);
                break;
            case IN:
                switch (charID) {
                    case 'o': orangeB = true; break;
                    case 'g': greenB = true; break;
                    case 'p': purpleB = true; break;
                }
                want = true;
                break;
            case NONE:
                break;
        }
    }

    @Override
    public void update(Scene s, float deltaTime) {
        if (!once) {
            orange = orangeB;
            green = greenB;
            purple = purpleB;
            orangeB=false;
            greenB = false;
            purpleB = false;
            once = true;
        }
        if (want) setCurrentTileIndex(1);
        else setCurrentTileIndex(0);
        want = false;
    }

    public static ITiledTextureRegion getImage(char charID) {
        switch (charID) {
            case 'o': return A.switchOrange;
            case 'g': return A.switchGreen;
            case 'p': return A.switchPurple;
        }
        return A.switchOrange;
    }

}
