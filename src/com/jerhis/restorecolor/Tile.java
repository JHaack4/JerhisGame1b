package com.jerhis.restorecolor;

import java.util.ArrayList;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.TiledSprite;
import org.andengine.opengl.texture.region.ITiledTextureRegion;

public abstract class Tile extends TiledSprite {

    public Coord coord;
    public char typeID, charID;
    public static Tile[][] tiles;
    public int[] frames;
    public int frameLength, currentFrame;
    public float frameDT = 0;

    public Tile(Coord coord, char typeID, char charID, ITiledTextureRegion image)
    {
    	super((int)coord.x, (int)coord.y, image, A.vbom);
        this.coord = coord;
        this.charID = charID;
        this.typeID = typeID;
        frameLength = 100;
        frames = new int[] {0};
        currentFrame = 0;
    }
    
    public Tile(Coord coord, char typeID, char charID, ITiledTextureRegion image, int[] frames, int frameLength, int startFrame) {
    	this(coord, typeID, charID, image);
    	this.frames = frames;
    	this.frameLength = frameLength;
    	currentFrame = startFrame==-1 ? (int)(Math.random()*frames.length) : startFrame;
    	setCurrentTileIndex(frames[currentFrame]);
    }
    
    public abstract void collision(Chaser chaser, CollisionType type);
    public abstract void update(Scene s, float deltaTime);
    
    public void touch() {
    	//does nothing, unless overridden
    }
    
    public void animate(float deltaTime) {
    	//only called for animated tiles 
    	//which use alternate constructor
    	frameDT += deltaTime;

        if (frameDT > frameLength)
        {
            frameDT -= frameLength;
            currentFrame++;
            if (currentFrame >= frames.length) currentFrame = 0;
            setCurrentTileIndex(frames[currentFrame]);
        }
    }
    
    public void animateRandom(float deltaTime) {
    	frameDT += deltaTime;

        if (frameDT > frameLength)
        {
            frameDT -= frameLength;
            currentFrame = (int)(Math.random() * frames.length);
            setCurrentTileIndex(frames[currentFrame]);
        }
    }
    
    public void set(int newFrame) {
    	frameDT = 0;
        currentFrame = newFrame;
        setCurrentTileIndex(frames[currentFrame]);
    }
    
    public void setDirect(int newFrame) {
    	frameDT = 0;
        setCurrentTileIndex(newFrame);
    }
    
    public void setFrames(int[] newFrames, int startTile) {
    	frameDT = 0;
        currentFrame = startTile;
        frames = newFrames;
        setCurrentTileIndex(frames[currentFrame]);
    }

    public void basicTopCollision(Chaser chaser)
    {
        if (chaser.upwardVelocity < 0) {
            chaser.upwardVelocity = 0;
            chaser.coord.y = coord.y - C.blocksSize + 1;
            chaser.jumping = false;
        }
    }

    public void basicLeftCollision(Chaser chaser)
    {
        if (chaser.sideVelocity > 0) {
            chaser.sideVelocity = 0;
            chaser.coord.x = coord.x - C.blocksSize;
        }
    }

    public void basicRightCollision(Chaser chaser)
    {
        if (chaser.sideVelocity < 0) {
            chaser.sideVelocity = 0;
            chaser.coord.x = coord.x + C.blocksSize;
        }
    }

    public void basicBottomCollision(Chaser chaser)
    {
        if (chaser.upwardVelocity > 0) {
            chaser.upwardVelocity = -chaser.upwardVelocity/2;
            chaser.coord.y = coord.y + C.blocksSize - 1;
        }
    }

    public static ArrayList<Tile> getAdjacentTiles(Tile[][] tiles, Coord c)
    {
        ArrayList<Tile> closeTiles = new ArrayList<Tile>();
        int x = (int)c.x / C.blocksSize;
        int y = (int)c.y / C.blocksSize;

        int adjArea = 2;

        for (int offX = 0-adjArea; offX < adjArea+1; offX++)
            for (int offY = 0-adjArea; offY < adjArea+1; offY++)
                if (x+offX >= 0 && y+offY >= 0 && x+offX < C.xBlocks && y+offY < C.yBlocks)
                    if (!(tiles[x+offX][y+offY] instanceof TileEmpty))
                        closeTiles.add(tiles[x+offX][y+offY]);

        return closeTiles;
    }

    public CollisionType checkForCollision(Chaser chaser)
    {
        int x = (int) chaser.coord.x - (int) coord.x;
        int y = (int) coord.y - (int) chaser.coord.y;

        if (Math.abs(y) < C.blockInsideRatio*C.blocksSize && Math.abs(x) < C.blockInsideRatio*C.blocksSize)
            return CollisionType.IN;
        if (Math.abs(y) < C.blocksSize && Math.abs(x) < C.blocksSize)
        {
            if (Math.abs(x) > Math.abs(y))
            {
                if (x>0) return CollisionType.RIGHT;
                else return CollisionType.LEFT;
            }
            else
            {
                if (y>0) return CollisionType.TOP;
                else return CollisionType.BOTTOM;
            }
        }

        return CollisionType.NONE;
    }

    public enum CollisionType {
        TOP, LEFT, RIGHT, BOTTOM, IN, NONE
    }
}
