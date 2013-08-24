package com.jerhis.chaseorb;

import java.util.ArrayList;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.sprite.TiledSprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;

public class MyButtonGroup {

	public ArrayList<MyButton> buttons;
	public ArrayList<ITextureRegion> texts;
	public ArrayList<Sprite> sprites;
    public int[][] buttonCoords;

    public MyButtonGroup(ArrayList<ITextureRegion> ts, int[][] bcs, ITiledTextureRegion image) {
    	buttonCoords = bcs;
    	texts = ts;
    	buttons = new ArrayList<MyButton>();
    	for (int k = 0; k < bcs.length; k++) {
    		MyButton b = new MyButton(bcs[k][0],bcs[k][1],image);
    		buttons.add(b);
    	}
    }
	
	public int touch(int action, int pointerID, float x, float y) {
		switch (action) {
		case TouchEvent.ACTION_DOWN:
			for (int k = 0; k < buttons.size(); k++)
				if (!buttons.get(k).down
						&& inBounds(new Coord(x, y), new Coord(
								buttonCoords[k][0], buttonCoords[k][1]),
								new Coord(buttonCoords[k][0] + C.buttonWidth,
										buttonCoords[k][1] + C.buttonHeight))) {
					buttons.get(k).down = true;
					buttons.get(k).pointerID = pointerID;
					buttons.get(k).setCurrentTileIndex(1);
				}
			break;
		case TouchEvent.ACTION_MOVE:
			for (int k = 0; k < buttons.size(); k++)
				if (pointerID == buttons.get(k).pointerID
						&& !inBounds(new Coord(x, y), new Coord(
								buttonCoords[k][0], buttonCoords[k][1]),
								new Coord(buttonCoords[k][0] + C.buttonWidth,
										buttonCoords[k][1] + C.buttonHeight))) {
					buttons.get(k).reset();
				}
			break;
		case TouchEvent.ACTION_UP:
		case TouchEvent.ACTION_CANCEL:
			for (int k = 0; k < buttons.size(); k++)
				if (pointerID == buttons.get(k).pointerID
						&& inBounds(new Coord(x, y), new Coord(
								buttonCoords[k][0], buttonCoords[k][1]),
								new Coord(buttonCoords[k][0] + C.buttonWidth,
										buttonCoords[k][1] + C.buttonHeight))) {
					for (MyButton b : buttons)
						b.reset();
					return k;
				}
		}
		return -1;
	}
	
	public boolean inBounds(Coord a, Coord b, Coord c) {
        return a.x>b.x && a.x<c.x && a.y>b.y && a.y < c.y;
    }
	
	public void attachButtons(Scene s) {
		sprites = new ArrayList<Sprite>();
		for (int k = 0; k < buttons.size(); k++) {
			s.attachChild(buttons.get(k));
			Sprite sp = new Sprite(buttonCoords[k][0],buttonCoords[k][1],texts.get(k),A.vbom);
			sprites.add(sp);
			s.attachChild(sp);
		}
	}
	
	public void detachButtons(Scene s) {
		for (int k = 0; k < buttons.size(); k++) {
			s.detachChild(buttons.get(k));
			s.detachChild(sprites.get(k));
		}
	}
	
	public class MyButton extends TiledSprite {

		public int pointerID = -1;
	    public boolean down = false;
	    public ITextureRegion text;

	    public void reset()
	    {
	        down = false;
	        pointerID = -1;
	        setCurrentTileIndex(0);
	    }
	
		public MyButton(float pX, float pY, ITiledTextureRegion image) {
			super(pX, pY, image, A.vbom);
			
		}
		
	}
}
