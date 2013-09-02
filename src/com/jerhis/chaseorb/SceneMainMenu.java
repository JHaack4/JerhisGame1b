package com.jerhis.chaseorb;

import org.andengine.entity.sprite.Sprite;

public class SceneMainMenu extends SceneBase {
	
	public SceneMainMenu() {
		super();
		loadScene();
	}
	
	@Override
	public void update(float deltaTime) {
		
	}

	@Override
	public void touch(int action, int pointerID, float x, float y) {
		switch (A.mainB.touch(action, pointerID, x ,y))
        {
            case 0: switchScene(new ScenePackSelect()); break;
            case 1:
                if (C.full) switchScene(new SceneEditorSelect());
                else switchScene(new SceneBuy());
                break;
            case 2: switchScene(new SceneAbout()); break;
        }
	}

	@Override
	public void loadScene() {
        A.mt("allmain", 0);
		Sprite bgS = new Sprite(320,200,A.menu,A.vbom);
        bgS.setScale(2);
		attachChild(bgS);
		A.mainB.attachButtons(this);
	}

	@Override
	public void disposeScene() {
		A.mainB.detachButtons(this);
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
