package com.jerhis.chaseorb;

import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.input.touch.TouchEvent;
import org.andengine.util.HorizontalAlign;

import java.util.Scanner;

public class SceneLevelEditor extends SceneBase {
	
	public SceneLevelEditor(int num) {
		super();
        state = EditorType.Select;
        A.m("editor");
        levelNum = num;
        currentTile = 5;

        levelName = C.defaultLevelName;
        backgroundString = "";
        starString = "(200,50)$(640,50)$(1080,50)";
        medalString = "7.0$15.0$25.0";
        levelString =   "                                " +
                "                                " +
                "                                " +
                "                                " +
                "                                " +
                "                                " +
                "                                " +
                "        Oa                      " +
                "  f!                        Ca  " +
                "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";

        String k = A.readFromMemory(C.fileName + levelNum + ".txt");
        if (!k.equals("")) {
            A.p(k);
            Scanner sc = new Scanner(k);
            sc.useDelimiter("#");
            levelName = sc.next();
            backgroundString = sc.next();
            starString = sc.next();
            medalString = sc.next();
            levelString = sc.next();
        }

        level.load();

        GameDrawer.draw(level, this);
        overlay = new Sprite(0,0,A.menu,A.vbom);
        returnIcon = new Sprite(1230,0,A.returnIcon,A.vbom);
        attachChild(overlay);
	}

    public static String levelName = C.defaultLevelName;
    public static String backgroundString = "";
    public static String starString = "(200,50)$(640,50)$(1080,50)";
    public static String medalString = "7.0$15.0$25.0";
    public static String levelString =
            "                                " +
                    "                                " +
                    "                                " +
                    "                                " +
                    "                                " +
                    "                                " +
                    "                                " +
                    "        Oa                      " +
                    "  f!                        Ca  " +
                    "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
    public static int levelNum;
    public Level level = new Level(0,-1);
    //public Image selectedImage = Assets.iBasicTile;
    public int currentTile = 5;
    public int currentBackground = 0;
    public float levelTime = 0;
    public boolean selected = false;
    public int warpCharLocation;

    public Sprite overlay, returnIcon;

    public enum EditorType {
        Block, Placement, Warps, Select, Test, TooManyWarps, Save, Medal, Star, Leave
    }
    EditorType state;
	
	@Override
	public void update(float deltaTime) {
        switch (state) { //update
            case Block:
                break;
            case Placement:
                break;
            case Warps:
                break;
            case Select:
                break;
            case Test:
                break;
            case TooManyWarps:
                break;
            case Save:
                break;
            case Medal:
                break;
            case Star:
                break;
        }
	}

    public Text textG, textS, textB;
    public float gold, silver, bronze;
	@Override
	public void touch(int action, int pointerID, float x, float y) {
        switch (state) { //Touch
            case Block:
                break;
            case Placement:
                break;
            case Warps:
                break;
            case Select:
                if (action == TouchEvent.ACTION_DOWN && x < C.editorSelectWidth) {
                    int numOptions = 8;
                    if (y > 0 && y < C.height/numOptions) state = EditorType.Placement;
                    if (y > C.height/numOptions && y < 2*C.height/numOptions) switchTo(EditorType.Block);
                    if (y > 2*C.height/numOptions && y < 3*C.height/numOptions) switchTo(EditorType.Star);
                    if (y > 3*C.height/numOptions && y < 4*C.height/numOptions) switchTo(EditorType.Medal);
                    if (y > 4*C.height/numOptions && y < 5*C.height/numOptions) switchTo(EditorType.Warps);
                    if (y > 5*C.height/numOptions && y < 6*C.height/numOptions) switchTo(EditorType.Test);
                    if (y > 6*C.height/numOptions && y < 7*C.height/numOptions) {
                        currentBackground = (currentBackground+1) % A.backgrounds.size();
                        backgroundString = A.backgrounds.get(currentBackground);
                        detachChild(overlay);
                        reload();
                        attachChild(overlay);
                    }
                    if (y > 7*C.height/numOptions && y < 8*C.height/numOptions) {
                        switchTo(EditorType.Save);
                    }
                }
                break;
            case Test:
                break;
            case TooManyWarps:
                break;
            case Save:
                switch (A.saveB.touch(action,pointerID,x,y)) {
                    case 0:
                        String j = ("\"" + levelName +"#"+ backgroundString + "#" + starString + "#" + medalString + "#\" +\n\""+ levelString.substring(0,32) + "\" +\n\"" + levelString.substring(32,64) + "\" +\n\"" + levelString.substring(64,96) + "\" +\n\"" + levelString.substring(96,128) + "\" +\n\"" + levelString.substring(128,160) + "\" +\n\"" + levelString.substring(160,192) + "\" +\n\"" + levelString.substring(192,224) + "\" +\n\"" + levelString.substring(224,256) + "\" +\n\"" + levelString.substring(256,288) + "\" +\n\"" + levelString.substring(288,320) + "\";");
                        if (C.cheats) {
                            A.p(j);
                        }
                        A.writeToMemory(C.fileName + levelNum + ".txt", levelName + "#" + backgroundString + "#" + starString + "#" + medalString + "#" + levelString);
                        leave();
                        break;
                    case 1:
                        String jj = ("\"" + levelName +"#"+ backgroundString + "#" + starString + "#" + medalString + "#\" +\n\""+ levelString.substring(0,32) + "\" +\n\"" + levelString.substring(32,64) + "\" +\n\"" + levelString.substring(64,96) + "\" +\n\"" + levelString.substring(96,128) + "\" +\n\"" + levelString.substring(128,160) + "\" +\n\"" + levelString.substring(160,192) + "\" +\n\"" + levelString.substring(192,224) + "\" +\n\"" + levelString.substring(224,256) + "\" +\n\"" + levelString.substring(256,288) + "\" +\n\"" + levelString.substring(288,320) + "\";");
                        if (C.cheats) {
                            A.p(jj);
                        }
                        leave();
                        break;
                    case 2:
                        onBackKeyPressed();
                        break;
                }
                break;
            case Medal:
                if (action == TouchEvent.ACTION_DOWN && x > C.width - C.pauseArea && y < C.pauseArea) {
                    onBackKeyPressed();
                    return;
                }
                try {
                    textG.detachSelf();
                    textS.detachSelf();
                    textB.detachSelf();
                } catch (Exception e) {}
                textG = new Text(C.medalLocs[18][1],C.medalLocs[18][0],A.mFont,gold + "",new TextOptions(HorizontalAlign.CENTER), A.vbom);
                textG.setPosition(C.medalLocs[18][1] - textG.getWidth()/2,C.medalLocs[18][0]);
                attachChild(textG);
                textS = new Text(C.medalLocs[19][1],C.medalLocs[19][0],A.mFont,silver + "",new TextOptions(HorizontalAlign.CENTER), A.vbom);
                textS.setPosition(C.medalLocs[19][1] - textS.getWidth()/2,C.medalLocs[19][0]);
                attachChild(textS);
                textB = new Text(C.medalLocs[20][1],C.medalLocs[20][0],A.mFont,bronze + "",new TextOptions(HorizontalAlign.CENTER), A.vbom);
                textB.setPosition(C.medalLocs[20][1] - textB.getWidth()/2,C.medalLocs[20][0]);
                attachChild(textB);
                    if (action == TouchEvent.ACTION_DOWN)
                        for(int k = 0; k < 18; k++)
                            if (x > C.medalLocs[k][1] - C.medalWidth/2 && x < C.medalLocs[k][1] + C.medalWidth/2 && y > C.medalLocs[k][0] - C.medalWidth/2 && y < C.medalLocs[k][0] + C.medalWidth/2) {
                                if (k/6 == 0) {
                                    switch (k%6) {
                                        case 0: gold += 10; break;
                                        case 1: gold += 1; break;
                                        case 2: gold += 0.1f; break;
                                        case 5: gold -= 0.1f; break;
                                        case 4: gold -= 1; break;
                                        case 3: gold -= 10; break;
                                    }
                                }
                                else if (k/6 == 1) {
                                    switch (k%6) {
                                        case 0: silver += 10; break;
                                        case 1: silver += 1; break;
                                        case 2: silver += 0.1f; break;
                                        case 5: silver -= 0.1f; break;
                                        case 4: silver -= 1; break;
                                        case 3: silver -= 10; break;
                                    }
                                }
                                else if (k/6 == 2) {
                                    switch (k%6) {
                                        case 0: bronze += 10; break;
                                        case 1: bronze += 1; break;
                                        case 2: bronze += 0.1f; break;
                                        case 5: bronze -= 0.1f; break;
                                        case 4: bronze -= 1; break;
                                        case 3: bronze -= 10; break;
                                    }
                                }
                            }
                if (gold <= 1) gold = 1.0f;
                if (gold > 99.7) gold = 99.7f;
                if (silver > 99.8) silver = 99.8f;
                if (bronze > 99.9) bronze = 99.9f;
                if (gold >= silver) silver = gold + 0.1f;
                if (silver >= bronze) bronze = silver + 0.1f;
                gold = Math.round(100*gold) / 100.0f;
                silver = Math.round(100*silver) / 100.0f;
                bronze = Math.round(100*bronze) / 100.0f;
                medalString = gold + "$" + silver + "$" + bronze;
                break;
            case Star:
                if (action == TouchEvent.ACTION_DOWN && x > C.width - C.pauseArea && y < C.pauseArea) {
                    onBackKeyPressed();
                    return;
                }

                    switch(action)
                    {
                        case TouchEvent.ACTION_DOWN:
                            double distance = 60;
                            Star closest = null;
                            for (Star s: level.stars)
                            {
                                double starDistance = A.distance(s.coord, new Coord(x, y));
                                if (starDistance < distance)
                                {
                                    distance = starDistance;
                                    closest = s;
                                }
                            }
                            if (closest != null)
                            {
                                closest.pointerID = pointerID;
                                closest.coord = new Coord(x, y);
                            }
                            break;
                        case TouchEvent.ACTION_MOVE:
                            for (Star s: level.stars)
                                if (pointerID == s.pointerID) {
                                    s.coord = new Coord(x, y);
                                }
                            break;
                        case TouchEvent.ACTION_CANCEL:
                        case TouchEvent.ACTION_UP:
                            for (Star s: level.stars)
                                if (pointerID == s.pointerID)
                                {
                                    s.coord = new Coord(x, y);
                                    s.pointerID = -1;
                                }
                    }
                for (Star s: level.stars)
                {
                    s.coord.x = (int)s.coord.x + 0;
                    s.coord.y = (int)s.coord.y + 0;
                    if (s.coord.x < C.blocksSize/2) s.coord.x = C.blocksSize/2;
                    if (s.coord.x > C.width - C.blocksSize/2) s.coord.x = C.width - C.blocksSize/2;
                    if (s.coord.y > C.height - C.blocksSize/2) s.coord.y = C.height - C.blocksSize/2;
                    if (s.coord.y < C.blocksSize/2) s.coord.y = C.blocksSize/2;
                    s.setPosition((int)s.coord.x - 20, (int)s.coord.y - 20);
                }
                starString = level.stars.get(0).coord.toString(true) + "$" + level.stars.get(1).coord.toString(true) + "$" + level.stars.get(2).coord.toString(true);
                break;
        }
	}

	@Override
	public void loadScene() {

	}

	@Override
	public void disposeScene() {
		
	}

	@Override
	public void onBackKeyPressed() {
        if (state == EditorType.Select) {

        }
        else {
            reload();
            switchTo(EditorType.Select);
            selected = false;
        }
	}

	@Override
	public void onPause() {
		
	}

	@Override
	public void onResume() {
		
	}

    public void switchTo(EditorType s) {

        switch (state) { //DELOAD
            case Block:
                detachChild(overlay);
                break;
            case Placement:
                break;
            case Warps:
                break;
            case Select:
                detachChild(overlay);
                break;
            case Test:
                break;
            case TooManyWarps:
                detachChild(overlay);
                break;
            case Save:
                A.saveB.detachButtons(this);
                break;
            case Medal:
                textG.detachSelf();
                textB.detachSelf();
                textS.detachSelf();
                reload();
                detachChild(overlay);
                detachChild(returnIcon);
                break;
            case Star:
                detachChild(returnIcon);
                reload();
                break;
        }

        switch (s) { //LOAD
            case Block:
                A.m("block");
                overlay = new Sprite(0,0,A.menu,A.vbom);
                attachChild(overlay);
                break;
            case Placement:
                break;
            case Warps:
                break;
            case Select:
                A.m("editor");
                overlay = new Sprite(0,0,A.menu,A.vbom);
                attachChild(overlay);
                break;
            case Test:
                break;
            case TooManyWarps:
                A.m("toomanywarps");
                overlay = new Sprite(0,0,A.menu,A.vbom);
                attachChild(overlay);
                break;
            case Save:
                A.saveB.attachButtons(this);
                break;
            case Medal:
                A.m("medal");
                overlay = new Sprite(0,0,A.menu,A.vbom);
                attachChild(overlay);
                attachChild(returnIcon);
                Scanner sc = new Scanner(medalString);
                sc.useDelimiter("[$]+");
                gold = Float.parseFloat(sc.next());
                silver = Float.parseFloat(sc.next());
                bronze = Float.parseFloat(sc.next());
                textG = new Text(C.medalLocs[18][1],C.medalLocs[18][0],A.mFont,gold + "",new TextOptions(HorizontalAlign.CENTER), A.vbom);
                textG.setPosition(C.medalLocs[18][1] - textG.getWidth()/2,C.medalLocs[18][0]);
                attachChild(textG);
                textS = new Text(C.medalLocs[19][1],C.medalLocs[19][0],A.mFont,silver + "",new TextOptions(HorizontalAlign.CENTER), A.vbom);
                textS.setPosition(C.medalLocs[19][1] - textS.getWidth()/2,C.medalLocs[19][0]);
                attachChild(textS);
                textB = new Text(C.medalLocs[20][1],C.medalLocs[20][0],A.mFont,bronze + "",new TextOptions(HorizontalAlign.CENTER), A.vbom);
                textB.setPosition(C.medalLocs[20][1] - textB.getWidth()/2,C.medalLocs[20][0]);
                attachChild(textB);
                break;
            case Star:
                attachChild(returnIcon);
                break;
        }

        state = s;

    }

    public void reload() {
        GameDrawer.unDraw(level,this);
        level.load();
        GameDrawer.draw(level, this);
    }

    public void leave() {
        switchTo(EditorType.Leave);
        GameDrawer.unDraw(level,this);
        switchScene(new SceneEditorSelect());
    }

}
