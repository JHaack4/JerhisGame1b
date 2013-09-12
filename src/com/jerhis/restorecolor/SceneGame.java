package com.jerhis.restorecolor;

import android.widget.Toast;

import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.sprite.TiledSprite;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.input.touch.TouchEvent;
import org.andengine.util.HorizontalAlign;

public class SceneGame extends SceneBase {
	
	public SceneGame(int packID, int levelNum) {
		super();
		state = GameState.Ready;
		levelPack = new LevelPack(packID);
        levelPack.startOn(levelNum);
		loadScene();
	}
	
	private GameState state;
	private LevelPack levelPack;
    private Level level;
    private float time = 0;
    private int ticks = 0;
    private int medal = -1, star = -1;
	
	@Override
	public void update(float deltaTime) {
		if (C.cheats && ticks%100 == 1 || deltaTime == 3.15) A.p("dt:" + deltaTime);
		ticks++;
		switch(state) { //UPDATE STUFF HERE
		case Fail:
			break;
		case Finish:
			break;
		case Paused:
			break;
		case Ready:
			break;
		case Running:
			time += deltaTime;
			if (time > 99990) time = 99990f;
			detachChild(gameText);
			gameText = new Text(10,3,A.mFont,((int)time/10)/10.0 + "",new TextOptions(HorizontalAlign.CENTER), A.vbom);
			attachChild(gameText);
			GameState gs = GameRunner.update(this, deltaTime, level);
			if (gs != GameState.Running) 
				switchTo(gs);	
			break;
		default:
			break;
		}
	}

	@Override
	public void touch(int action, int pointerID, float x, float y) {
		switch(state) { //HANDLE TOUCH STUFF HERE
		case Fail:
			switch (A.failB.touch(action, pointerID, x, y)) {
			case 0: retry(); break;
			case 1: levelSelect(); break;
			}
			break;
		case Finish:
			switch (A.finishB.touch(action, pointerID, x, y)) {
			case 0: if (level.packID == -1) levelSelect(); else nextLevel(); break;
			case 1: retry(); break;
			case 2: levelSelect(); break;
			}
			break;
		case Paused:
			switch (A.pauseB.touch(action, pointerID, x, y)) {
			case 0: switchTo(GameState.Running); break;
			case 1: retry(); break;
			case 2: levelSelect(); break;
			}
			break;
		case Ready:
			if (action == TouchEvent.ACTION_DOWN) switchTo(GameState.Running);

			break;
		case Running:
			if (x > 1230 && y < 50 && action == TouchEvent.ACTION_DOWN) {
				switchTo(GameState.Paused);
			}
			else GameRunner.orbsByTouch(action, pointerID, x, y, level.orbs, level.tiles);
			break;
		default:
			break;
		}
	}

	public Sprite overlay, pauseIcon;
	public TiledSprite finishStar, finishMedal;
	public Text gameText, finishText;
	@Override
	public void loadScene() {
		level = levelPack.nextLevel();
		A.mt("allgame",1);
		overlay = new Sprite(320,200,A.menu,A.vbom);
        overlay.setScale(2);
		pauseIcon = new Sprite(1230,0,A.pauseIcon,A.vbom);
		finishStar = new TiledSprite(200,200,A.finishStar,A.vbom);
		finishMedal = new TiledSprite(880,200,A.finishMedal,A.vbom);
		gameText = new Text(10,3,A.mFont,"0.0",new TextOptions(HorizontalAlign.CENTER), A.vbom);
		GameDrawer.draw(level, this); 
		attachChild(overlay);
	}

	@Override
	public void disposeScene() {
	
	}

	@Override
	public void onBackKeyPressed() {
		
	}

	@Override
	public void onPause() {
		if (state == GameState.Running) {
			switchTo(GameState.Paused);
		}
	}

	@Override
	public void onResume() {
		
	}

	enum GameState {
		Ready, Running, Paused, Fail, Finish, Leave
	}
	
	private void switchTo(GameState s) {
		switch(state) { //UNLOAD STUFF HERE
		case Fail:
			detachChild(overlay);
			A.failB.detachButtons(this);
			break;
		case Finish:
			detachChild(overlay);
			detachChild(finishStar);
			detachChild(finishMedal);
			detachChild(finishText);
			A.finishB.detachButtons(this);
			break;
		case Paused:
			detachChild(overlay);
			A.pauseB.detachButtons(this);
			break;
		case Ready:
			detachChild(overlay);
            final String toastText = C.getLevelText(level.packID,level.levelNum);
            if (!toastText.equals("")) {
                A.activity.runOnUiThread(new Runnable() {
                    public void run() {
                        Toast.makeText(A.activity, toastText, Toast.LENGTH_LONG).show();
                    }
                });
            }
			break;
		case Running:
			detachChild(pauseIcon);
			detachChild(gameText);
			break;
		default:
			break;
		}
		
		switch(s) { //LOAD STUFF HERE
		case Fail:
			A.mt("allgame",3);
			overlay = new Sprite(320,200,A.menu,A.vbom);
			attachChild(overlay);
            overlay.setScale(2);
			A.failB.attachButtons(this);
			break;
		case Finish:
			A.mt("allgame",0);
			overlay = new Sprite(320,200,A.menu,A.vbom);
            overlay.setScale(2);
			star = level.getStars();
            medal = level.getMedal((int)time/100.0);
            levelPack.setSave(level.levelNum + 1, 0, 'u');
            if (star > levelPack.saved.charAt(3*level.levelNum + 1) - '0')
                levelPack.setSave(level.levelNum, 1, (char)('0' + star));
            if (medal > levelPack.saved.charAt(3*level.levelNum + 2) - '0')
                levelPack.setSave(level.levelNum, 2, (char)('0' + medal));
			attachChild(overlay);
			attachChild(finishStar);
			attachChild(finishMedal);
			finishStar.setCurrentTileIndex(star);
			finishMedal.setCurrentTileIndex(medal);
			finishText = new Text(640,225,A.bigFont,"" + ((int)time/10)/10.0,new TextOptions(HorizontalAlign.CENTER), A.vbom);
			attachChild(finishText);
			finishText.setPosition(640 - finishText.getWidth()/2, 225);
			A.finishB.attachButtons(this);
			break;
		case Paused:
			A.mt("allgame",2);
			overlay = new Sprite(320,200,A.menu,A.vbom);
            overlay.setScale(2);
			attachChild(overlay);
			A.pauseB.attachButtons(this);
			break;
		case Ready:
			A.mt("allgame",1);
			overlay = new Sprite(320,200,A.menu,A.vbom);
            overlay.setScale(2);
			GameDrawer.draw(level, this);
			attachChild(overlay);
			break;
		case Running:
            GameRunner.X = -1;
            GameRunner.Y = -1;
            GameRunner.pointerID = -1;
			attachChild(pauseIcon);
			attachChild(gameText);
			break;
		default:
			break;
		}
		
		state = s;
	}
	
	private void levelSelect() {
		switchTo(GameState.Leave);
		switchScene(new SceneLevelSelect(levelPack.packID));
	}
	
	private void retry() {
        time = 0;
        ticks = 0;
        star = -1;
        medal = -1;
        GameDrawer.unDraw(level, this);
        level = levelPack.thisLevel();
        switchTo(GameState.Ready);
    }
	
	private void nextLevel() {
		time = 0;
	    ticks = 0;
	    star = -1;
	    medal = -1;
	    GameDrawer.unDraw(level, this);
	    level = levelPack.nextLevel();
	    if (level == null) levelSelect();
	    switchTo(GameState.Ready);
	}
	
}
