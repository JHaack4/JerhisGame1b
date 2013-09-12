package com.jerhis.restorecolor;

import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.sprite.TiledSprite;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.util.HorizontalAlign;

import java.util.ArrayList;
import java.util.Scanner;

public class SceneLevelEditor extends SceneBase {
	
	public SceneLevelEditor(int num) {
		super();
        state = EditorType.Select;
        A.mt("alleditor", 2);
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
            //A.p(k);
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
        overlay = new Sprite(320,200,A.menu,A.vbom);
        overlay.setScale(2);
        returnIcon = new Sprite(1230,0,A.returnIcon,A.vbom);
        attachChild(overlay);
        selectedBlock = new TiledSprite(C.editorCurrentBlockX,C.editorCurrentBlockY,selectedImage,A.vbom);
        selectedBlock.setCurrentTileIndex(12);
        attachChild(selectedBlock);
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
    public ITiledTextureRegion selectedImage = A.basicTile;
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
        if (readyToLeave) {
            readyToLeave = false;
            leave();
        }
        if (switchReady) {
            switchTo2(ss);
            switchReady = false;
        }
        switch (state) { //update
            case Test:
                levelTime += deltaTime;
                SceneGame.GameState str = GameRunner.update(this,deltaTime,level);
                if (str != SceneGame.GameState.Running) {
                    reload();
                    detachChild(returnIcon);
                    attachChild(returnIcon);
                    levelTime = 0;
                }
                detachChild(levelText);
                levelText = new Text(10,3,A.mFont,((int)levelTime/10)/10.0 + "",new TextOptions(HorizontalAlign.CENTER), A.vbom);
                attachChild(levelText);
                break;
        }
	}

    public Text textG, textS, textB, levelText;
    public float gold, silver, bronze;
    public Sprite warpIcon;
    public TiledSprite selectedBlock;
    public Tile[][] tempLevelS;
    public boolean readyToLeave = false;
    public ArrayList<Orb> tempLevelO;
    public ArrayList<Chaser> tempLevelC;
    public ArrayList<Star> tempLevelST;
	@Override
	public void touch(final int action, final int pointerID, final float x, final float y) {


        switch (state) { //Touch
            case Block:
                if (action == TouchEvent.ACTION_DOWN && x > C.width - C.pauseArea && y < C.pauseArea) {
                    back();
                    return;
                }
                if (action == TouchEvent.ACTION_DOWN && x < 10*120) {
                    try {
                        int k = ((int)y)/120*10 + ((int)x)/120;
                        selectedImage = A.tilesList.get(k);
                        currentTile = k;
                        switchTo(EditorType.Placement);
                    } catch (Exception e) {}
                }
                break;
            case Placement:
                if (action == TouchEvent.ACTION_DOWN && x > C.width - C.pauseArea && y < C.pauseArea) {
                    back();
                    return;
                }
                detachChild(returnIcon);
                if (action == TouchEvent.ACTION_DOWN) {
                    if (TileWarp.otherWarps.size() == 42 && currentTile == 1)
                    {
                        switchTo(EditorType.TooManyWarps);
                    }
                    int delWarp = -1;
                    int mx = ((int)x)/C.blocksSize;
                    int my = ((int)y)/C.blocksSize;
                    if (currentTile != 0) {
                        TiledSprite sp = new TiledSprite(mx*80,my*80,selectedImage,A.vbom);
                        int cti = currentTile == 7? 1: 0;
                        cti = currentTile == 5 || currentTile == 4? 12 : cti;
                        sp.setCurrentTileIndex(cti);
                        tilesListSprite.add(sp);
                        attachChild(sp);
                    }
                    try {
                        for (Chaser chaser : tempLevelC)
                            if (((int)chaser.coord.x) / 80 == mx && ((int)chaser.coord.y) / 80 == my)
                                chaser.setVisible(false);
                        for (Orb orb:  tempLevelO)
                            if ((int)orb.coord.x / 80 == mx && (int)orb.coord.y / 80 == my)
                                orb.setVisible(false);
                        tempLevelS[mx][my].setVisible(false);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    int xy = 2 * mx + 2 * C.xBlocks * my;
                    if (levelString.charAt(xy) == 'w') delWarp = ((TileWarp)level.tiles[mx][my]).myID;
                    levelString = levelString.substring(0,xy) + A.charCodes.get(currentTile) + levelString.substring(xy+2);
                    level.load();
                    if (currentTile == 1) {
                        for (int k = 0; k < 320; k+=2)
                            if (levelString.charAt(k) == 'w')
                                if (levelString.charAt(k+1) >= ((TileWarp)(level.tiles[mx][my])).myID + '0' && xy != k)
                                    levelString = levelString.substring(0,k) + "w" + ((char)(levelString.charAt(k+1)+1)) + levelString.substring(k+2);
                    }
                    if (currentTile == 0 && delWarp != -1) {
                        for (int k = 0; k < 320; k+=2)
                            if (levelString.charAt(k) == 'w')
                                if (levelString.charAt(k+1) >= delWarp + '0' && levelString.charAt(k+1) != '0')
                                    levelString = levelString.substring(0,k) + "w" + ((char)(levelString.charAt(k+1)-1)) + levelString.substring(k+2);
                    }
                    level.load();

                }
                attachChild(returnIcon);
                break;
            case Warps:
                if (action == TouchEvent.ACTION_DOWN && x > C.width - C.pauseArea && y < C.pauseArea) {
                    back();
                    return;
                }

                    if (action == TouchEvent.ACTION_DOWN) {
                        int mx = ((int)x)/C.blocksSize;
                        int my = ((int)y)/C.blocksSize;
                        int xy = 2 * mx + 2 * C.xBlocks * my;
                        if (!(level.tiles[mx][my] instanceof TileWarp))
                            return;

                        if (selected) {
                            char c = (char)(((TileWarp)(level.tiles[mx][my])).myID + '0');
                            levelString = levelString.substring(0,warpCharLocation) + "w" + c + levelString.substring(warpCharLocation+2);
                            selected = false;
                            detachChild(warpIcon);
                        }
                        else {
                            warpCharLocation = xy;
                            selected = true;
                            warpIcon = new Sprite(mx*80, my*80, A.selectedWarp,A.vbom);
                            attachChild(warpIcon);
                        }
                        level.load();
                    }
                break;
            case Select:
                if (action == TouchEvent.ACTION_DOWN && x < C.editorSelectWidth) {
                    int numOptions = 8;
                    if (y > 0 && y < C.height/numOptions) switchTo(EditorType.Placement);
                    if (y > C.height/numOptions && y < 2*C.height/numOptions) switchTo(EditorType.Block);
                    if (y > 2*C.height/numOptions && y < 3*C.height/numOptions) switchTo(EditorType.Star);
                    if (y > 3*C.height/numOptions && y < 4*C.height/numOptions) switchTo(EditorType.Medal);
                    if (y > 4*C.height/numOptions && y < 5*C.height/numOptions) switchTo(EditorType.Warps);
                    if (y > 5*C.height/numOptions && y < 6*C.height/numOptions) switchTo(EditorType.Test);
                    if (y > 6*C.height/numOptions && y < 7*C.height/numOptions) {
                        currentBackground = (currentBackground+1) % A.backgrounds.size();
                        backgroundString = A.backgrounds.get(currentBackground);
                        detachChild(selectedBlock);
                        detachChild(overlay);
                        reload();
                        attachChild(overlay);
                        attachChild(selectedBlock);
                    }
                    if (y > 7*C.height/numOptions && y < 8*C.height/numOptions) {
                        switchTo(EditorType.Save);
                    }
                }
                break;
            case Test:
                if (action == TouchEvent.ACTION_DOWN && x > C.width - C.pauseArea && y < C.pauseArea) {
                    back();
                    return;
                }
                GameRunner.orbsByTouch(action,pointerID,x,y,level.orbs,level.tiles);
                break;
            case TooManyWarps:
                if (action == TouchEvent.ACTION_DOWN) back();
                break;
            case Save:
                switch (A.saveB.touch(action,pointerID,x,y)) {
                    case 0:
                        String j = ("\"" + levelName +"#"+ backgroundString + "#" + starString + "#" + medalString + "#\" +\n\""+ levelString.substring(0,32) + "\" +\n\"" + levelString.substring(32,64) + "\" +\n\"" + levelString.substring(64,96) + "\" +\n\"" + levelString.substring(96,128) + "\" +\n\"" + levelString.substring(128,160) + "\" +\n\"" + levelString.substring(160,192) + "\" +\n\"" + levelString.substring(192,224) + "\" +\n\"" + levelString.substring(224,256) + "\" +\n\"" + levelString.substring(256,288) + "\" +\n\"" + levelString.substring(288,320) + "\";");
                        if (C.cheats) {
                            A.p(j);
                        }
                        A.writeToMemory(C.fileName + levelNum + ".txt", levelName + "#" + backgroundString + "#" + starString + "#" + medalString + "#" + levelString);
                        readyToLeave = true;
                        break;
                    case 1:
                        String jj = ("\"" + levelName +"#"+ backgroundString + "#" + starString + "#" + medalString + "#\" +\n\""+ levelString.substring(0,32) + "\" +\n\"" + levelString.substring(32,64) + "\" +\n\"" + levelString.substring(64,96) + "\" +\n\"" + levelString.substring(96,128) + "\" +\n\"" + levelString.substring(128,160) + "\" +\n\"" + levelString.substring(160,192) + "\" +\n\"" + levelString.substring(192,224) + "\" +\n\"" + levelString.substring(224,256) + "\" +\n\"" + levelString.substring(256,288) + "\" +\n\"" + levelString.substring(288,320) + "\";");
                        if (C.cheats) {
                            A.p(jj);
                        }
                        readyToLeave = true;
                        break;
                    case 2:
                        back();
                        break;
                }
                break;
            case Medal:
                if (action == TouchEvent.ACTION_DOWN && x > C.width - C.pauseArea && y < C.pauseArea) {
                    back();
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
                    back();
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
                                closest.coord = new Coord(x - 20, y - 20);
                            }
                            break;
                        case TouchEvent.ACTION_MOVE:
                            for (Star s: level.stars)
                                if (pointerID == s.pointerID) {
                                    s.coord = new Coord(x -20, y-20);
                                }
                            break;
                        case TouchEvent.ACTION_CANCEL:
                        case TouchEvent.ACTION_UP:
                            for (Star s: level.stars)
                                if (pointerID == s.pointerID)
                                {
                                    s.coord = new Coord(x-20, y-20);
                                    s.pointerID = -1;
                                }
                    }
                for (Star s: level.stars)
                {
                    s.coord.x = (int)s.coord.x;
                    s.coord.y = (int)s.coord.y;
                    if (s.coord.x < C.blocksSize/2) s.coord.x = C.blocksSize/2;
                    if (s.coord.x > C.width - C.blocksSize/2) s.coord.x = C.width - C.blocksSize/2;
                    if (s.coord.y > C.height - C.blocksSize/2) s.coord.y = C.height - C.blocksSize/2;
                    if (s.coord.y < C.blocksSize/2) s.coord.y = C.blocksSize/2;
                    s.setPosition((int)s.coord.x -20, (int)s.coord.y -20);
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

	}

    public void back() {
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

    public ArrayList<Sprite> tilesListSprite = new ArrayList<Sprite>();
    public boolean switchReady = false;
    public EditorType ss;
    public void switchTo(EditorType s) {
        ss = s;
        switchReady = true;

    }

    public void switchTo2(EditorType s) {
        switch (state) { //DELOAD
            case Block:
                detachChild(overlay);
                detachChild(returnIcon);
                for (Sprite spr: tilesListSprite) {
                    spr.detachSelf();
                }
                tilesListSprite.clear();
                break;
            case Placement:
                detachChild(returnIcon);
                for (Sprite spr: tilesListSprite) {
                    spr.detachSelf();
                }
                for (int x = 0; x < 16; x++)
                    for (int y= 0; y<10; y++)
                        tempLevelS[x][y].detachSelf();
                tempLevelS = null;
                for (Chaser chaser: tempLevelC)
                    chaser.detachSelf();
                tempLevelC = null;
                for (Orb orb: tempLevelO)
                    orb.detachSelf();
                tempLevelO = null;
                for (Star star: tempLevelST)
                    star.detachSelf();
                tempLevelST = null;
                tilesListSprite.clear();
                break;
            case Warps:
                detachChild(returnIcon);
                try {
                    warpIcon.detachSelf();
                } catch (Exception e) {}
                break;
            case Select:
                detachChild(overlay);
                detachChild(selectedBlock);
                break;
            case Test:
                detachChild(returnIcon);
                levelText.detachSelf();
                levelTime = 0;
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
                break;
        }

        switch (s) { //LOAD
            case Block:
                A.mt("alleditor", 3);
                overlay = new Sprite(320,200,A.menu,A.vbom);
                overlay.setScale(2);
                attachChild(overlay);
                attachChild(returnIcon);
                int x = 0, y= 0;
                for (int k = 0; k < A.tilesList.size(); k++)
                {
                    ITiledTextureRegion i = A.tilesList.get(k);
                    TiledSprite sp = new TiledSprite(x + 20,y + 20,i,A.vbom);
                    if (k==4) sp.setPosition(x+20,y+10);
                    sp.setScale(1.5f);
                    int cti = k == 7 ? 1 : 0;
                    cti = k == 5 || k == 4 ? 12 : cti;
                    sp.setCurrentTileIndex(cti);
                    attachChild(sp);
                    tilesListSprite.add(sp);
                    x+=C.blocksSize * 1.5;
                    if (x >= 10*120) {
                        x = 0;
                        y += C.blocksSize * 1.5;
                    }
                }
                break;
            case Placement:
                attachChild(returnIcon);
                tempLevelC = level.chasers;
                tempLevelO = level.orbs;
                tempLevelS = level.tiles;
                tempLevelST = level.stars;
                break;
            case Warps:
                attachChild(returnIcon);
                break;
            case Select:
                A.mt("alleditor", 2);
                overlay = new Sprite(320,200,A.menu,A.vbom);
                overlay.setScale(2);
                attachChild(overlay);
                selectedBlock = new TiledSprite(C.editorCurrentBlockX,C.editorCurrentBlockY,selectedImage,A.vbom);
                int cti = currentTile == 7 ? 1 : 0;
                cti = currentTile == 5 || currentTile == 4? 12 : cti;
                selectedBlock.setCurrentTileIndex(cti);
                attachChild(selectedBlock);
                break;
            case Test:
                attachChild(returnIcon);
                levelText = new Text(10,3,A.mFont,"0.0",new TextOptions(HorizontalAlign.CENTER), A.vbom);
                attachChild(levelText);
                break;
            case TooManyWarps:
                A.mt("alleditor", 5);
                overlay = new Sprite(320,200,A.menu,A.vbom);
                overlay.setScale(2);
                attachChild(overlay);
                break;
            case Save:
                A.saveB.attachButtons(this);
                break;
            case Medal:
                A.mt("alleditor", 4);
                overlay = new Sprite(320,200,A.menu,A.vbom);
                overlay.setScale(2);
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
