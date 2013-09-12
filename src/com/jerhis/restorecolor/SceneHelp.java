package com.jerhis.restorecolor;

import org.andengine.entity.sprite.Sprite;

public class SceneHelp extends SceneBase {
	
	public SceneHelp() {
		super();
		loadScene();
	}
	
	@Override
	public void update(float deltaTime) {
		
	}

	@Override
	public void touch(int action, int pointerID, float x, float y) {
		switch (A.returnB.touch(action,pointerID,x,y)) {
            case 0: onBackKeyPressed();
        }
	}

	@Override
	public void loadScene() {
		A.mt("alleditor", 1);
        Sprite s = new Sprite(320,200,A.menu,A.vbom);
        s.setScale(2);
        attachChild(s);
        A.returnB.attachButtons(this);
	}

	@Override
	public void disposeScene() {
		A.returnB.detachButtons(this);
	}

	@Override
	public void onBackKeyPressed() {
		switchScene(new SceneEditorSelect());
	}

	@Override
	public void onPause() {
		
	}

	@Override
	public void onResume() {
		
	}


}
