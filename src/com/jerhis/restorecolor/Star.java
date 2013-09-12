package com.jerhis.restorecolor;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.TiledSprite;

public class Star extends TiledSprite {
	
	public Coord coord;
    public boolean caughtYet = false;
    public int num;
    public int pointerID = -1;

    public Star(Coord coord, int num)
    {
    	super((int)coord.x - 20, (int)coord.y - 20, A.star, A.vbom);
    	
        this.coord = coord;
        this.num = num;
    }

    public void checkCollision(Chaser chaser)
    {
        if (Math.abs(coord.x - chaser.coord.x - C.blocksSize/2) < C.starRatio*C.blocksSize && Math.abs(coord.y - chaser.coord.y - C.blocksSize/2) < C.starRatio*C.blocksSize)
        {
        	caughtYet = true;
        	this.detachSelf();
        }
    }

    public void update(Scene s, float deltaTime) {
    	//TODO anim
    }

}
