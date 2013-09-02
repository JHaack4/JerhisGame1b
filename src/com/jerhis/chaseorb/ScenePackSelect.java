package com.jerhis.chaseorb;

import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.sprite.TiledSprite;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.input.touch.TouchEvent;
import org.andengine.util.HorizontalAlign;

public class ScenePackSelect extends SceneBase {

	public ScenePackSelect() {
		super();
		loadScene();
	}
	
	public static int packID = 0;
	
	@Override
	public void update(float deltaTime) {
		
	}

	@Override
	public void touch(int action, int pointerID, float x, float y) {
		boolean b = false;
        try {
            b = A.readFromMemory(C.packFileName + (packID-1)).charAt(78) == 'u' || score() >= packID*100;
        } catch (Exception e) {}
        if (action == TouchEvent.ACTION_DOWN && x > C.width-C.pauseArea && y < C.pauseArea) {
            onBackKeyPressed();
            return;
        }
        else if (action == TouchEvent.ACTION_DOWN && x > C.width/2 - 800/2 && x < C.width/2 + 800/2 && y > C.height/2 - 500/2 && y < C.height/2 + 500/2 && (packID == 0 || packID == -1 || b || C.cheats)) {
            if (C.full || packID == 0)
                switchScene(new SceneLevelSelect(packID));
            else switchScene(new SceneBuy());
        }
        else if (action == TouchEvent.ACTION_DOWN && x > C.packX1 && x < C.packX2 && y > C.packY1 && y < C.packY2) {
            if (locked()) detachChild(lockedS);
        	packID--;
            if (packID < -1) packID = C.numPacks - 1;
            int h = packID == -1 ? 7 : packID;
            packS.setCurrentTileIndex(h);
            if (locked()) attachChild(lockedS);
        }
        else if (action == TouchEvent.ACTION_DOWN && x < C.width - C.packX1 && x > C.width - C.packX2 && y > C.packY1 && y < C.packY2) {
        	if (locked()) detachChild(lockedS);
        	packID++;
            if (packID >= C.numPacks) packID = -1;
            int h = packID == -1 ? 7 : packID;
            packS.setCurrentTileIndex(h);
            if (locked()) attachChild(lockedS);
        }
	}

	public int score() {
        int t = 0;
        for (int l = 0; l < 6; l++){
            String h = A.readFromMemory(C.packFileName + l);
            if (h.equals("")) continue;
            for (int k = 1; k<26; k++)
                t += h.charAt(3*k + 1) + h.charAt(3*k + 2) - '0' - '0';
        }
        return t;
    }
	public boolean locked() {
		int j = packID - 1;
		try {
			if (packID != 0 && packID != -1 && score() < packID*100 && A.readFromMemory(C.packFileName + j).charAt(78) != 'u')
				return true;
		} catch (Exception e) {return true;}
		return false;
	}
	
	public Sprite lockedS;
    public TiledSprite packS;
	@Override
	public void loadScene() {
        A.mt("allmain", 1);
        Sprite sp = new Sprite(320,200,A.menu,A.vbom);
        sp.setScale(2);
		attachChild(sp);
		attachChild(new Sprite(C.width - C.pauseArea,0,A.returnIcon,A.vbom));
		packS = new TiledSprite(C.width/2 - 200,C.height/2 - 125,A.packs,A.vbom);
        packS.setScale(2);
        int h = packID == -1 ? 7 : packID;
        packS.setCurrentTileIndex(h);
		attachChild(packS);
		lockedS = new Sprite(C.width/2 - A.locked.getWidth()/2,C.height/2 - A.locked.getHeight()/2,A.locked,A.vbom);
		if (locked())
			attachChild(lockedS);
		
		int t = score();
		attachChild(new Text(540, 700, A.mFont, "Overall Score: " + t + "/900", new TextOptions(HorizontalAlign.CENTER), A.vbom));
	}

	@Override
	public void disposeScene() {
		
	}

	@Override
	public void onBackKeyPressed() {
		//A.p("back tried");
		//A.engine.runOnUpdateThread(new Runnable() {
		    //@Override
		    //public void run() {
		switchScene(new SceneMainMenu());
		    //}
		//});
		
	}

	@Override
	public void onPause() {
		
	}

	@Override
	public void onResume() {
		
	}

}
