package com.jerhis.chaseorb;

import org.andengine.entity.scene.Scene;
import org.andengine.opengl.texture.region.ITiledTextureRegion;

public class TileHalf extends Tile {
	
	public TileHalf(Coord coord, char charID) {
		super(coord, 'h', charID, getImage(charID));
	}

	@Override
	public void collision(Chaser chaser, CollisionType type) {
		switch (type) {
        case TOP: basicTopCollision(chaser);
            break;
        case LEFT: //basicLeftCollision(chaser);
            break;
        case RIGHT: //basicRightCollision(chaser);
            break;
        case BOTTOM: //basicBottomCollision(chaser);
            break;
        case IN:
            break;
        case NONE:
            break;
		}	
	}

	@Override
	public void update(Scene s, float deltaTime) {
		//no anim
		
	}

	public static ITiledTextureRegion getImage(char charID) {
		return A.halfTile;
	}


}
