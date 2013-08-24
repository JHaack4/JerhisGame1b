package com.jerhis.chaseorb;

import org.andengine.entity.scene.Scene;
import org.andengine.opengl.texture.region.ITiledTextureRegion;

public class TileDeath extends Tile {
	
	public TileDeath(Coord coord, char charID) {
		super(coord, 'd', charID, getImage(charID), new int[]{0,1,2,3,4,5,6,7,8,9}, 10, -1);
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
        case BOTTOM: basicBottomCollision(chaser);
            break;
        case IN: chaser.dead = true;
            break;
        case NONE:
            break;
		}	
	}

	@Override
	public void update(Scene s, float deltaTime) {
		animateRandom(deltaTime);
		
	}

	public static ITiledTextureRegion getImage(char charID) {
		switch (charID) {
		case '*': return A.fireTile;
		}
		return A.fireTile;
	}


}
