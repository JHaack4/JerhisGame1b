package com.jerhis.restorecolor;

import org.andengine.entity.sprite.TiledSprite;
import org.andengine.opengl.texture.region.ITiledTextureRegion;

public class Orb extends TiledSprite {
	
	public Coord coord;
    public final char color;
    public boolean trackable = true;
    public int pointerID = -1;

    public Orb(Coord start, char color)
    {
    	super((int)start.x - C.blocksSize/2, (int)start.y - C.blocksSize/2, getImage(color), A.vbom);
    	
        this.color = color;
        this.coord = start;
    }
    
    public static ITiledTextureRegion getImage(char color) {
    	switch(color)
        {
            case 'a': 
            case 'b':
            case 'c': 
            case 'd': 
            case 'e': 
            case 'f':
        }
    	return A.orb;
    }

    public void update(float deltaTime) {
    	//TODO anim
    }

}
