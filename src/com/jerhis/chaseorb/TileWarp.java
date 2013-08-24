package com.jerhis.chaseorb;

import java.util.ArrayList;

import org.andengine.entity.scene.Scene;
import org.andengine.opengl.texture.region.ITiledTextureRegion;

public class TileWarp extends Tile {
	
	public static int currentID;
    public static ArrayList<TileWarp> otherWarps;
    public int myID;
    public int targetID;

    public TileWarp(Coord coord, char id, int myID, char targetID) {
        super(coord, 'w', id, getImage(), new int []{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29}, 4,-1);
        this.targetID = targetID - '0';
        this.myID = myID;
    }

	private static ITiledTextureRegion getImage() {
		return A.warp;
	}

	@Override
    public void collision(Chaser chaser, CollisionType type) {
        if (type == CollisionType.IN && chaser.readyToWarp[myID])
        {
            chaser.coord.x = otherWarps.get(targetID).coord.x;
            chaser.coord.y = otherWarps.get(targetID).coord.y;
            chaser.readyToWarp[targetID] = false;
        }
        else if (type == CollisionType.NONE)
        {
            chaser.readyToWarp[myID] = true;
        }
    }

	@Override
	public void update(Scene s, float deltaTime) {
		animate(deltaTime);
	}

}
