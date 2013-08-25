package com.jerhis.chaseorb;

import org.andengine.entity.sprite.Sprite;

public class SceneAbout extends SceneBase {
	
	public SceneAbout() {
		super();
		loadScene();
	}
	
	@Override
	public void update(float deltaTime) {
		
	}

	@Override
	public void touch(int action, int pointerID, float x, float y) {
		switch(A.returnB.touch(action,pointerID,x,y))
        {
            case 0: onBackKeyPressed();
        }
	}

	@Override
	public void loadScene() {
		A.m("about");
		attachChild(new Sprite(0,0,A.menu,A.vbom));
        A.returnB.attachButtons(this);
	}

	@Override
	public void disposeScene() {
        A.returnB.detachButtons(this);
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
