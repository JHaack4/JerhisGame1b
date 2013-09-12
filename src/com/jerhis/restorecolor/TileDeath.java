package com.jerhis.restorecolor;

import org.andengine.entity.scene.Scene;
import org.andengine.opengl.texture.region.ITiledTextureRegion;

public class TileDeath extends Tile {
	
	public TileDeath(Coord coord, char charID) {
		super(coord, 'd', charID, getImage(charID), new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59}, 4, -1);
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
		animate(deltaTime);
		
	}

	public static ITiledTextureRegion getImage(char charID) {
		switch (charID) {
		case '*': return A.fireTile;
		}
		return A.fireTile;
	}


}
