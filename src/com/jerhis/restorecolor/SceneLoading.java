package com.jerhis.restorecolor;

import org.andengine.entity.sprite.Sprite;

public class SceneLoading extends SceneBase {
	
	public SceneLoading() {
		super();
		loadScene();
	}
	
	@Override
	public void update(float deltaTime) {
		if (time > 200)
			switchScene(new SceneMainMenu());
	}

	@Override
	public void touch(int action, int pointerID, float x, float y) {
		
	}

	Sprite s;
	@Override
	public void loadScene() {
		s = new Sprite(320,200,A.menu,A.vbom);
        s.setScale(2);
		attachChild(s);
		A.load();
	}

	@Override
	public void disposeScene() {
		detachChild(s);
	}

	@Override
	public void onBackKeyPressed() {
		
	}

	@Override
	public void onPause() {
		
	}

	@Override
	public void onResume() {
		
	}


}
