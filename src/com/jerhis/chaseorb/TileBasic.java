package com.jerhis.chaseorb;

import org.andengine.entity.scene.Scene;
import org.andengine.opengl.texture.region.ITiledTextureRegion;

public class TileBasic extends Tile {

	public TileBasic(Coord coord, char charID) {
		super(coord, 'b', charID, getImage(charID));
	}

	@Override
	public void collision(Chaser chaser, CollisionType type) {
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
		//no anim
		
	}

	public static ITiledTextureRegion getImage(char charID) {
		switch (charID) {
		case '+': return A.basicTile;
		case '<': return A.dirtTile;
		case '&': return A.metalTile;
		case '^': return A.snowTile;
		case '~': return A.grassTile;
		case '_': return A.iceTile;
		}
		return A.basicTile;
	}

}
