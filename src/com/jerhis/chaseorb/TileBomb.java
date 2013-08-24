package com.jerhis.chaseorb;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.TiledSprite;
import org.andengine.opengl.texture.region.ITiledTextureRegion;

public class TileBomb extends Tile {
	
	public TileBomb(Coord coord, char charID) {
		super(coord, 'x', charID, getImage(charID));
	}
	
	public boolean exploded = false;
	public float timeSinceExploded = 0;

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
        	if (!exploded) {
                exploded = true;
                for (int x = (int)coord.x/C.blocksSize - 2; x <= coord.x/C.blocksSize + 2; x++)
                    for (int y = (int)coord.y/C.blocksSize - 2; y <= coord.y/C.blocksSize + 2; y++)
                        if (x >= 0 && y >=0 && x < C.xBlocks && y < C.yBlocks && tiles[x][y] instanceof TileCracked) {
                        	((TileCracked)tiles[x][y]).intact = false;
                        	((TileCracked)tiles[x][y]).setVisible(false);
                        }
                setVisible(false);     
            }
            break;
        case NONE:
            break;
		}	
	}

	
	public TiledSprite smoke;
	@Override
	public void update(Scene s, float deltaTime) {
		//no anim (until smoking)
		if (exploded) {
			if (timeSinceExploded == 0) {
				smoke = new TiledSprite((int)coord.x - 160, (int)coord.y - 160, A.smoke, A.vbom);
				s.attachChild(smoke);
			}
			timeSinceExploded += deltaTime;
			if (timeSinceExploded < 10) smoke.setCurrentTileIndex(0); //move the smoke anim here
			else if (timeSinceExploded < 20) smoke.setCurrentTileIndex(1); 
			else if (timeSinceExploded < 30) smoke.setCurrentTileIndex(2);
			else if (timeSinceExploded < 40) smoke.setCurrentTileIndex(3); 
			else smoke.detachSelf();
		}
		
	}

	public static ITiledTextureRegion getImage(char charID) {
		return A.bomb;
	}

}
