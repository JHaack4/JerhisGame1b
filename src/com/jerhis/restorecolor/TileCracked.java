package com.jerhis.restorecolor;

import org.andengine.entity.scene.Scene;
import org.andengine.opengl.texture.region.ITiledTextureRegion;

public class TileCracked extends Tile {
	
	public TileCracked(Coord coord, char charID) {
		super(coord, 'c', charID, getImage(charID));
	}

	public boolean intact = true;
	
	@Override
	public void collision(Chaser chaser, CollisionType type) {
		if (!intact) return;
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
		//bomb class will call cracked to set visible = false
		
	}

	public static ITiledTextureRegion getImage(char charID) {
		switch (charID) {
		case '/': return A.midTile;
		case '-': return A.stoneTile;
		case '[': return A.glassTile;
		}
		return A.basicTile;
	}


}
