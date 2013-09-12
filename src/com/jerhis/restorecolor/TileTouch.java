package com.jerhis.restorecolor;

import org.andengine.entity.scene.Scene;
import org.andengine.opengl.texture.region.ITiledTextureRegion;

public class TileTouch extends Tile {

	public TileTouch(Coord coord, char charID) {
		super(coord, 't', charID, getImage());
		isFull = charID == 'f';
		
		if (isFull) setFrames(new int[] {1}, 0);
        else  setFrames(new int[] {0}, 0);
	}

	private static ITiledTextureRegion getImage() {
		// TODO Auto-generated method stub
		return A.touchTile;
	}

	public boolean isFull;
	
	@Override
	public void collision(Chaser chaser, CollisionType type) {
		if (!isFull) return;

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
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void touch() {
		isFull = !isFull;

        if (isFull) setFrames(new int[] {1}, 0);
        else  setFrames(new int[] {0}, 0);
	}

}
