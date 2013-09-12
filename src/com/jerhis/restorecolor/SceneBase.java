package com.jerhis.restorecolor;

import org.andengine.entity.scene.Scene;
import org.andengine.input.touch.TouchEvent;

public abstract class SceneBase extends Scene {

	public SceneBase()
    {
    }
    
	public float time = 0;
    @Override
    public void onManagedUpdate(final float pSecondsElapsed) {
    	super.onManagedUpdate(pSecondsElapsed);
    	float k = pSecondsElapsed < 0.0315 ? 100 * pSecondsElapsed : 3.15f;
    	time += k;
    	update(k);
    }

    @Override
    public boolean onSceneTouchEvent(final TouchEvent pSceneTouchEvent) {
        A.activity.runOnUpdateThread(new Runnable() {
            @Override
            public void run() {
                int action = pSceneTouchEvent.getAction();
                int pointerID = pSceneTouchEvent.getPointerID();
                float x = pSceneTouchEvent.getX();
                float y = pSceneTouchEvent.getY();
                touch(action, pointerID, x, y);
            }
        });


    	return super.onSceneTouchEvent(pSceneTouchEvent);
    }
    
    public void switchScene(final SceneBase b) {
    	
    	A.engine.setScene(b);
    	disposeScene();
    }
    
    public abstract void update(float deltaTime);
    public abstract void touch(int action, int pointerID, float x, float y);
    public abstract void loadScene();
    public abstract void disposeScene();
    public abstract void onBackKeyPressed();
    public abstract void onPause();
    public abstract void onResume();
    
}
