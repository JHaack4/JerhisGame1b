package com.jerhis.restorecolor;

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
				smoke = new TiledSprite((int)coord.x, (int)coord.y, A.smoke, A.vbom);
                smoke.setScale(10.0f);
				s.attachChild(smoke);
			}
			timeSinceExploded += deltaTime;
            for (int k = 0; k < 30; k++)
                if (timeSinceExploded > k*4 && timeSinceExploded <= 4 + 4*k) {
                    smoke.setCurrentTileIndex((k+26)%30);
                    if (k == 8) {
                        for (int x = (int)coord.x/C.blocksSize - 2; x <= coord.x/C.blocksSize + 2; x++)
                            for (int y = (int)coord.y/C.blocksSize - 2; y <= coord.y/C.blocksSize + 2; y++)
                                if (x >= 0 && y >=0 && x < C.xBlocks && y < C.yBlocks && tiles[x][y] instanceof TileCracked) {
                                    ((TileCracked)tiles[x][y]).intact = false;
                                    (tiles[x][y]).setVisible(false);
                                }
                    }
                    return;
                }

			smoke.detachSelf();
		}
		
	}

	public static ITiledTextureRegion getImage(char charID) {
		return A.bomb;
	}

}
