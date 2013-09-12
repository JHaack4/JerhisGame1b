package com.jerhis.restorecolor;

import org.andengine.entity.scene.Scene;
import org.andengine.opengl.texture.region.ITiledTextureRegion;

public class TileEmpty extends Tile {

	public TileEmpty(Coord coord, char charID) {
		super(coord, ' ', charID, getImage(charID));
	}

	@Override
	public void collision(Chaser chaser, CollisionType type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Scene s, float deltaTime) {
		// TODO Auto-generated method stub
		
	}
	
	public static ITiledTextureRegion getImage(char charID) {
		return A.emptyTile;
	}

}
