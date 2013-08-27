package com.jerhis.chaseorb;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.opengl.font.FontFactory;
import org.andengine.ui.activity.BaseGameActivity;
import org.andengine.util.color.Color;

import android.graphics.Typeface;
import android.view.KeyEvent;

public class GameActivity extends BaseGameActivity {

	public Camera camera;
	
	@Override
	public EngineOptions onCreateEngineOptions() {
		camera = new Camera(0,0,1280,800);
		EngineOptions eo = new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED, new FillResolutionPolicy(), camera);
		eo.getAudioOptions().setNeedsSound(true);
        eo.getTouchOptions().setNeedsMultiTouch(true);
		return eo;
	}

	@Override
	public void onBackPressed() {
		//super.onBackPressed();
	    try {
	    	SceneBase bs = (SceneBase) mEngine.getScene();
	    	bs.onBackKeyPressed();
	    } catch (Exception e) {

	    }
	}
	
	@Override
	public void onPause() {
		super.onPause();
		try {
			SceneBase bs = (SceneBase) mEngine.getScene();
			bs.onPause();
		} catch (Exception e) {
			
		}
	}

	@Override
	public void onResume() {
		super.onResume();
		try {
			SceneBase bs = (SceneBase) mEngine.getScene();
			bs.onResume();
		} catch (Exception e) {
			
		}
	}


	@Override
	public void onCreateResources(
			OnCreateResourcesCallback pOnCreateResourcesCallback)
			throws Exception {

		A.mFont = FontFactory.create(this.getFontManager(), this.getTextureManager(), 
				256, 256, Typeface.create(Typeface.DEFAULT, Typeface.BOLD), 64);
		A.mFont.load();
		A.bigFont = FontFactory.create(this.getFontManager(), this.getTextureManager(), 
				512, 512, Typeface.create(Typeface.DEFAULT, Typeface.BOLD), 128, Color.WHITE.hashCode());
		A.bigFont.load();
		A.fileLocation = getFilesDir();
		A.prepare(mEngine, this, camera, getVertexBufferObjectManager());
		pOnCreateResourcesCallback.onCreateResourcesFinished();
		
	}

	@Override
	public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback) throws Exception {
		SceneBase scene = new SceneSplashLoading();
		pOnCreateSceneCallback.onCreateSceneFinished(scene);
	}

	@Override
	public void onPopulateScene(Scene pScene,
			OnPopulateSceneCallback pOnPopulateSceneCallback) throws Exception {
		pOnPopulateSceneCallback.onPopulateSceneFinished();
	}

}
