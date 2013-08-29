package com.jerhis.chaseorb;

import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;

public class SceneEditorSelect extends SceneBase {
	
	public SceneEditorSelect() {
		super();
		loadScene();
	}
	
	@Override
	public void update(float deltaTime) {
		
	}

	@Override
	public void touch(int action, int pointerID, float x, float y) {
        if (action == TouchEvent.ACTION_DOWN && x > C.width - C.pauseArea && y < C.pauseArea) {
            onBackKeyPressed();
            return;
        }
        switch (A.helpB.touch(action,pointerID,x,y)) {
            case 0: switchScene(new SceneHelp());
        }
        if (action == TouchEvent.ACTION_DOWN)
        {
            double mx = (double)(x - C.initX)/(C.sizeX + C.gapX);
            double my = (double)(y - C.initY)/(C.sizeY + C.gapY);
            if (mx >= 0 && mx < 5 && my >=0 && my < 5 && mx-(int)mx <= (double)C.sizeX/(C.gapX + C.sizeX) && my-(int)my <= (double)C.sizeY/(C.gapY + C.sizeY))
                switchScene(new SceneLevelEditor((int)mx + 5*(int)my + 1));
        }
	}

	@Override
	public void loadScene() {
        A.mt("alleditor", 0);
        Sprite s = new Sprite(320,200,A.menu,A.vbom);
        s.setScale(2);
		attachChild(s);
        attachChild(new Sprite(C.width- C.pauseArea,0,A.returnIcon,A.vbom));
        A.helpB.attachButtons(this);
	}

	@Override
	public void disposeScene() {
		A.helpB.detachButtons(this);
	}

	@Override
	public void onBackKeyPressed() {
		switchScene(new SceneMainMenu());
	}

	@Override
	public void onPause() {
		
	}

	@Override
	public void onResume() {
		
	}


}
