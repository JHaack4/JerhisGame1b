package com.jerhis.chaseorb;

import org.andengine.entity.scene.background.Background;

public class SceneSplashLoading extends SceneBase {

	public SceneSplashLoading() {
		super();
		loadScene();
	}
	
	@Override
	public void update(float deltaTime) {
		if (time > 10)
			switchScene(new SceneLoading());
	}

	@Override
	public void touch(int action, int pointerID, float x, float y) {
		
	}

	@Override
	public void loadScene() {
		setBackground(new Background(0,0,0));
		A.loadSplash();
	}

	@Override
	public void disposeScene() {
		
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
