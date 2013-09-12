package com.jerhis.restorecolor;

import org.andengine.entity.scene.Scene;
import org.andengine.opengl.texture.region.ITiledTextureRegion;

public class TileFinish extends Tile {
	
	public TileFinish(Coord coord, char charID) {
		super(coord, 'f', charID, getImage(charID), new int[] {0,1,2,3,4,5,6,7,8,9,8,7,6,5,4,3,2,1}, 5, -1);
	}

    @Override
    public void collision(Chaser chaser, CollisionType type) {
        if (type == CollisionType.IN)
        {
            chaser.finished = true;
            chaser.coord = coord.clone();
        }
    }

    @Override
    public void update(Scene s, float deltaTime) {
    	animate(deltaTime);
    }

    public static ITiledTextureRegion getImage(char charID) {
		return A.finishTile;
	}

}
