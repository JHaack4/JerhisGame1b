package com.jerhis.chaseorb;

import org.andengine.entity.scene.Scene;
import org.andengine.opengl.texture.region.ITiledTextureRegion;

public class TileBasic extends Tile {

	public TileBasic(Coord coord, char charID) {
		super(coord, 'b', charID, getImage(charID),new int[]{0},30,0);
	}

	@Override
	public void collision(Chaser chaser, CollisionType type) {
        if (charID == '+' && type != CollisionType.NONE){
            switch (chaser.color) {
                case 'a': setFrames(new int[]{1,2,3,4,5,6,7,8,9,0}, 0); break;
                case 'b': setFrames(new int[]{11,12,13,14,15,16,17,18,19,0}, 0); break;
                case 'c': setFrames(new int[]{21,22,23,24,25,26,27,28,29,0}, 0); break;
                case 'd': setFrames(new int[]{31,32,33,34,35,36,37,38,39,0}, 0); break;
                case 'e': setFrames(new int[]{41,42,43,44,45,46,47,48,49,0}, 0); break;
                case 'f': setFrames(new int[]{51,52,53,54,55,56,57,58,59,0}, 0); break;
            }
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
		if (charID == '+') {
            animate(deltaTime);
            if (currentFrame == 10)
                setFrames(new int[]{0}, 0);
        }
		
	}

	public static ITiledTextureRegion getImage(char charID) {
		switch (charID) {
		case '+': return A.basicTile;
		case '<': return A.dirtTile;
		case '&': return A.metalTile;
		case '^': return A.snowTile;
		case '~': return A.grassTile;
		case '_': return A.iceTile;
        case ']': return A.fireBaseTile;
		}
		return A.basicTile;
	}

}
