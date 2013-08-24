package com.jerhis.chaseorb;

import org.andengine.entity.scene.Scene;
import org.andengine.opengl.texture.region.ITiledTextureRegion;

public class TileKey extends Tile {
	
	public TileKey(Coord coord, char charID) {
		super(coord, 'K', charID, getImage(charID));
	}

	public boolean caught = false;
	
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
            if (!caught) {
                switch(charID)
                {
                    case 'r': chaser.keyRed = true; break;
                    case 'b': chaser.keyBlue = true; break;
                    case 'y': chaser.keyYellow = true; break;
                }
                caught = true;
                setVisible(false);
            }
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
		case 'r': return A.keyRed;
		case 'y': return A.keyYellow;
		case 'b': return A.keyBlue;
		}
		return A.keyRed;
	}


}
