package com.jerhis.restorecolor;

import org.andengine.entity.scene.Scene;
import org.andengine.opengl.texture.region.ITiledTextureRegion;

public class TileKeyhole extends Tile {
	
	public TileKeyhole(Coord coord, char charID) {
		super(coord, 'k', charID, getImage(charID));
	}

	public boolean opened = false;
	
	@Override
	public void collision(Chaser chaser, CollisionType type) {
		if (!opened && type != CollisionType.NONE) {
            switch(charID)
            {
                case 'r': if (chaser.keyRed) opened = true; break;
                case 'b': if (chaser.keyBlue) opened = true; break;
                case 'y': if (chaser.keyRed) opened = true; break;
            }
            if (opened) setVisible(false);
        }

        switch (type) {
            case TOP:
                if (!opened) basicTopCollision(chaser);
                break;
            case LEFT:
                if (!opened) basicLeftCollision(chaser);
                break;
            case RIGHT:
                if (!opened) basicRightCollision(chaser);
                break;
            case BOTTOM:
                if (!opened) basicBottomCollision(chaser);
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
		case 'r': return A.keyHoleRed;
		case 'y': return A.keyHoleYellow;
		case 'b': return A.keyHoleBlue;
		}
		return A.keyHoleRed;
	}

}
