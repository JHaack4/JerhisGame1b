package com.jerhis.chaseorb;

import org.andengine.entity.sprite.Sprite;

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
		
	}

	@Override
	public void loadScene() {
		A.m("editorselect");
		attachChild(new Sprite(0,0,A.menu,A.vbom));
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
