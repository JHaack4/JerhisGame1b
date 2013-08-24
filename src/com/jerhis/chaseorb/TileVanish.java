package com.jerhis.chaseorb;

import org.andengine.entity.scene.Scene;
import org.andengine.opengl.texture.region.ITiledTextureRegion;

public class TileVanish extends Tile {

	public TileVanish(Coord coord, char charID) {
		super(coord, 'v', charID, getImage(),new int[]{0,1,2,3,4,5,6,7,8,9},10,0);
		// TODO Auto-generated constructor stub
	}

	private static ITiledTextureRegion getImage() {
		return A.cloudTile;
	}
	
	public final int maxVanish = 50, maxReappear = 200, numFrames = 10;
    public boolean guyOn = false, walkable = true;
    public float timeUntilVanish = maxVanish, timeUntilReappear = maxReappear;

	@Override
	public void collision(Chaser chaser, CollisionType type) {
		switch (type) {
        case TOP:
            if (walkable) {
                guyOn = true;
                basicTopCollision(chaser);
            }
            break;
        case LEFT: if (walkable) basicLeftCollision(chaser);
            break;
        case RIGHT: if (walkable) basicRightCollision(chaser);
            break;
        case BOTTOM: if (walkable) basicBottomCollision(chaser);
            break;
        case IN:
            break;
        case NONE:
            break;
		}
	}

	@Override
	public void update(Scene s, float deltaTime) {

        if (guyOn && walkable) {
            timeUntilVanish -= deltaTime;
        }
        else if (walkable) {
            timeUntilVanish += deltaTime;
            if (timeUntilVanish > maxVanish) {
                timeUntilVanish = maxVanish;
            }
        }
        else if (!walkable) {
            timeUntilReappear -= deltaTime;
        }

        if (timeUntilVanish < 0) {
            walkable = false;
            timeUntilVanish = 0;
            timeUntilReappear = maxReappear;
        }
        if (timeUntilReappear < 0) {
            walkable = true;
            timeUntilReappear = 0;
            timeUntilVanish = 0.1f;
        }
  
        guyOn = false;
        
        if (timeUntilVanish >= maxVanish) animate(deltaTime);
        else setDirect((int)((maxVanish - timeUntilVanish)*(numFrames-1))/maxVanish + 10);	
	}

}
