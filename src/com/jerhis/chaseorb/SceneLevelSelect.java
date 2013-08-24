package com.jerhis.chaseorb;

import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.sprite.TiledSprite;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.input.touch.TouchEvent;
import org.andengine.util.HorizontalAlign;

public class SceneLevelSelect extends  SceneBase {
	
	public SceneLevelSelect(int packID) {
		super();
		this.packID = packID;
		loadScene();
	}
	
	public int packID;
	public String saved = "";
	
	@Override
	public void update(float deltaTime) {
		
	}

	@Override
	public void touch(int action, int pointerID, float x, float y) {
		if (action == TouchEvent.ACTION_DOWN && x > C.width - C.pauseArea && y < C.pauseArea) {
            onBackKeyPressed();
            return;
        }
        if (action == TouchEvent.ACTION_DOWN) {
            double mx = (double)(x - C.initX)/(C.sizeX + C.gapX);
            double my = (double)(y - C.initY)/(C.sizeY + C.gapY);
            int j = (int)mx + 5*(int)my + 1;
            if ((packID != -1 || !A.readFromMemory(C.fileName + j + ".txt").equals("")) && (C.cheats || saved.charAt(3*( j )) == 'u' || packID == -1 || score(A.readFromMemory(C.packFileName + packID)) > 4*j) && mx >= 0 && mx < 5 && my >=0 && my < 5 && mx-(int)mx <= (double)C.sizeX/(C.gapX + C.sizeX) && my-(int)my <= (double)C.sizeY/(C.gapY + C.sizeY))
                switchScene(new SceneGame(packID, j));
        }
	}
	
	public int score(String h)
    {
        if (h.equals("")) return -1;
        int t = 0;
        for (int k = 1; k<26; k++)
            t += h.charAt(3*k + 1) + h.charAt(3*k + 2) - '0' - '0';
        return t;
    }

	@Override
	public void loadScene() {
		A.m("level");
		attachChild(new Sprite(0,0,A.menu,A.vbom));
		attachChild(new Sprite(C.width- C.pauseArea,0,A.returnIcon,A.vbom));
		saved = LevelPack.read(packID);
		for (int k = 0; k < 25; k++) {
            if (packID == -1) {
                int kk = k+1;
                if (A.readFromMemory(C.fileName + kk + ".txt").equals("")) {
                	//g.drawImage(A.locked,(k%5)*(C.sizeX+C.gapX) + C.initX, (k/5)*(C.sizeY + C.gapY) + C.initY);
                	attachChild(new Sprite((k%5)*(C.sizeX+C.gapX) + C.initX,(k/5)*(C.sizeY + C.gapY) + C.initY,A.locked,A.vbom));
                }
            }
            else {
                int star = saved.equals("") ? 0 : saved.charAt(3*(k+1)+1) - '0';
                int medal = saved.equals("") ? 0 : saved.charAt(3*(k+1)+2) - '0';
            	char un = saved.charAt(3*(k+1));
                if (un == 'l' && score(A.readFromMemory(C.packFileName + packID)) <= 4*k + 4) {
                    //g.drawImage(Assets.locked,(k%5)*(C.sizeX+C.gapX) + C.initX, (k/5)*(C.sizeY + C.gapY) + C.initY);
                	attachChild(new Sprite((k%5)*(C.sizeX+C.gapX) + C.initX,(k/5)*(C.sizeY + C.gapY) + C.initY,A.locked,A.vbom));
                }
                else {
                    //g.drawImage(Assets.levelstar,(k%5)*(C.sizeX+C.gapX) + C.initX, (k/5)*(C.sizeY + C.gapY) + C.initY + C.sizeY - A.levelStar.getHeight()/4*3,(star-1)*A.levelStar.getWidth()/3,0,Assets.levelStar.getWidth()/3,Assets.levelstar.getHeight());
                    if (star != 0) {
                    	TiledSprite ts1 = new TiledSprite((k%5)*(C.sizeX+C.gapX) + C.initX,(k/5)*(C.sizeY + C.gapY) + C.initY + C.sizeY - A.levelStar.getHeight()/4*3,A.levelStar,A.vbom);
                    	ts1.setCurrentTileIndex(star - 1);
                    	attachChild(ts1);
                    }
                	//g.drawImage(Assets.levelmedal,(k%5)*(C.sizeX+C.gapX) + C.initX + C.sizeX/2, (k/5)*(C.sizeY + C.gapY) + C.initY + C.sizeY - A.levelMedal.getHeight()/4*3,(medal-1)*A.levelMedal.getWidth()/3,0,Assets.levelMedal.getWidth()/3,Assets.levelmedal.getHeight());
                    if (medal != 0) {
                    	TiledSprite ts2 = new TiledSprite((k%5)*(C.sizeX+C.gapX) + C.initX  + C.sizeX/2,(k/5)*(C.sizeY + C.gapY) + C.initY + C.sizeY - A.levelMedal.getHeight()/4*3,A.levelMedal,A.vbom);
                    	ts2.setCurrentTileIndex(medal - 1);
                    	attachChild(ts2);
                    }
                }
            }
        }
		String h = A.readFromMemory(C.packFileName + packID);
        if (h.equals("") || packID == -1) return;
        int t = score(h);
        attachChild(new Text(700, 125, A.mFont, "Score: " + t + "/150", new TextOptions(HorizontalAlign.LEFT), A.vbom));
	}

	@Override
	public void disposeScene() {
		
	}

	@Override
	public void onBackKeyPressed() {
		switchScene(new ScenePackSelect());
	}

	@Override
	public void onPause() {
		
	}

	@Override
	public void onResume() {
		
	}


}
