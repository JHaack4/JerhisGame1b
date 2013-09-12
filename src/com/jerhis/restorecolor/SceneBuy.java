package com.jerhis.restorecolor;

import org.andengine.entity.sprite.Sprite;

public class SceneBuy extends SceneBase {
	
	public SceneBuy() {
		super();
		loadScene();
	}
	
	@Override
	public void update(float deltaTime) {
		
	}

	@Override
	public void touch(int action, int pointerID, float x, float y) {
		
	}

	@Override
	public void loadScene() {
        A.mt("allmain", 3);
        Sprite s = new Sprite(0,0,A.menu,A.vbom);
        s.setScale(2);
		attachChild(s);
	}

	@Override
	public void disposeScene() {
		
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
