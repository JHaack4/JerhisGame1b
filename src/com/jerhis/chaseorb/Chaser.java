package com.jerhis.chaseorb;

import org.andengine.entity.sprite.TiledSprite;
import org.andengine.opengl.texture.region.ITiledTextureRegion;

public class Chaser extends TiledSprite {
	
	public Coord coord;
    public final char color;

    public double upwardVelocity = 0;
    public double gravity = C.chaserGravity;
    public double sideVelocity = 0;
    public double momentum = C.chaserMomentum;
    public double resistance = C.chaserResistance;
    public double maxVelocity = C.maxVelocity;

    public boolean readyToWarp[] = new boolean[43];
    public boolean finished = false;
    public boolean dead = false;
    public boolean jumping = false;

    public boolean keyRed = false;
    public boolean keyBlue = false;
    public boolean keyYellow = false;

    public int startX;


    public Chaser(Coord start, char color)
    {
    	super((int)start.x, (int)start.y, getImage(color), A.vbom);
    	
        this.color = color;
        this.coord = start;

        startX = (int) start.x;

        for(int k = 0; k < 43; k++)
            readyToWarp[k] = true;
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
    	return A.chaser;
    }

    public void update(float deltaTime) {
    	setRotation( (int)coord.x - startX);
        //setScale(1,1 + Math.abs((float)upwardVelocity * 0.1f));
    }

}
