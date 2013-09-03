package com.jerhis.chaseorb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.andengine.audio.sound.Sound;
import org.andengine.audio.sound.SoundFactory;
import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.bitmap.BitmapTexture;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.texture.region.TextureRegionFactory;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.adt.io.in.IInputStreamOpener;
import org.andengine.util.debug.Debug;

import android.util.Log;

public class A {
	
	public static Font mFont, bigFont;
	public static ITiledTextureRegion menu, packs;
    public static ITextureRegion bg, locked, returnIcon, pauseIcon, selectedWarp;
	public static ITextureRegion tAbout, tHelp, tLE, tLS, tNL, tPlay, tQuit, 
		tResume, tRetry, tReturn, tSave;
	public static ITiledTextureRegion buttonDefault, chaser, cloudTile, basicTile, 
		bomb, dirtTile, emptyTile, finishTile, fireBaseTile, finishMedal, finishStar, fireTile,
		glassTile, grassTile, halfTile, iceTile, keyRed, keyBlue, keyYellow, 
		keyHoleRed, keyHoleBlue, keyHoleYellow, levelMedal, levelStar, metalTile, 
		midTile, orb, smoke, star, snowTile, stoneTile, touchTile, warp;
	public static MyButtonGroup mainB, returnB, failB, finishB, pauseB, saveB, helpB;
    public static ArrayList<String> backgrounds = new ArrayList<String>();
    public static ArrayList<ITiledTextureRegion> tilesList = new ArrayList<ITiledTextureRegion>();
    public static ArrayList<String> charCodes = new ArrayList<String>();
	//public static Sound bounceSound;
    //test
    public static String currentBG = "none", currentMenu = "none";
	
	
	public static void load() {
		b("");
        backgrounds.add("");
        backgrounds.add("moon");
        backgrounds.add("night");
        backgrounds.add("sunset");
        backgrounds.add("grassland");
        backgrounds.add("mountain");



		//buttons
		buttonDefault = t("button",2);
		tAbout = i("textabout");
		tHelp = i("texthelp");
		tLE = i("textleveleditor");
		tLS = i("textlevelselect");
		tNL = i("textnextlevel");
		tPlay = i("textplay");
		tQuit = i("textquit");
		tResume = i("textresume");
		tRetry = i("textretry");
		tReturn = i("textreturn");
		tSave = i("textsave");
		
		ArrayList<ITextureRegion> mainButtons = new ArrayList<ITextureRegion>();
		mainButtons.add(tPlay); mainButtons.add(tLE); mainButtons.add(tAbout);
		mainB = new MyButtonGroup(mainButtons, C.buttonNormal3, buttonDefault);
		ArrayList<ITextureRegion> returnButtons = new ArrayList<ITextureRegion>();
		returnButtons.add(tReturn);
		returnB = new MyButtonGroup(returnButtons, C.buttonNormal1, buttonDefault);
		ArrayList<ITextureRegion> failButtons = new ArrayList<ITextureRegion>();
		failButtons.add(tRetry); failButtons.add(tLS);
		failB = new MyButtonGroup(failButtons, C.buttonNormal2, buttonDefault);
		ArrayList<ITextureRegion> finishButtons = new ArrayList<ITextureRegion>();
		finishButtons.add(tNL); finishButtons.add(tRetry); finishButtons.add(tLS);
		finishB = new MyButtonGroup(finishButtons, C.buttonNormal3, buttonDefault);
		ArrayList<ITextureRegion> pauseButtons = new ArrayList<ITextureRegion>();
		pauseButtons.add(tResume); pauseButtons.add(tRetry); pauseButtons.add(tLS);
		pauseB = new MyButtonGroup(pauseButtons, C.buttonNormal3, buttonDefault);
		ArrayList<ITextureRegion> saveButtons = new ArrayList<ITextureRegion>();
		saveButtons.add(tSave); saveButtons.add(tQuit); saveButtons.add(tReturn);
		saveB = new MyButtonGroup(saveButtons, C.buttonNormal3, buttonDefault);
		ArrayList<ITextureRegion> helpButtons = new ArrayList<ITextureRegion>();
		helpButtons.add(tHelp);
		helpB = new MyButtonGroup(helpButtons, C.buttonHelp, buttonDefault);
		
		locked = i("locked");
		returnIcon = i("returnicon");
		pauseIcon = i("pauseicon");
		selectedWarp = i("selectedwarp");
        packs = tt("packs",2,4);
		bomb = t("bomb", 1);
		chaser = t("chaser", 30);
		cloudTile = t("cloudtile", 30);
		basicTile = tt("basictile", 10,6);
		dirtTile = t("dirttile", 1);
		emptyTile = t("emptytile", 1);
		finishTile = t("finish", 10);
		finishMedal = t("finishmedal", 4);
		finishStar = t("finishstar", 4);
		fireTile = tt("firetile", 15,4);
        fireBaseTile = t("firebasetile", 1);
		glassTile = t("glasstile", 1);
		grassTile = t("grasstile", 1);
		halfTile = t("halftile", 1);
		iceTile = t("icetile", 1);
		keyRed = t("keyred", 1);
		keyBlue = t("keyblue", 1);
		keyYellow = t("keyyellow", 1);
		keyHoleRed = t("keyholered", 1);
		keyHoleBlue = t("keyholeblue", 1);
		keyHoleYellow = t("keyholeyellow", 1);
		levelMedal = t("levelmedal", 3);
		levelStar = t("levelstar", 3);
		metalTile = t("metaltile", 1);
		midTile = t("midtile", 1);
		orb = t("orb", 1);
		smoke = tt("smoke", 6,5);
		star = t("star", 1);
		snowTile = t("snowtile", 1);
		stoneTile = t("stonetile", 1);
		touchTile = t("touchtile", 2);
		warp = t("warp", 30);

        //id imp
        charCodes.add("  "); tilesList.add(emptyTile);
        charCodes.add("w0"); tilesList.add(warp);
        charCodes.add("f!"); tilesList.add(finishTile);
        charCodes.add("Ca"); tilesList.add(chaser);
        charCodes.add("Oa"); tilesList.add(orb);
        charCodes.add("b+"); tilesList.add(basicTile);
        charCodes.add("te"); tilesList.add(touchTile);
        charCodes.add("tf"); tilesList.add(touchTile);
        //id non imp
        charCodes.add("b~"); tilesList.add(grassTile);
        charCodes.add("b<"); tilesList.add(dirtTile);
        charCodes.add("b]"); tilesList.add(fireBaseTile);
        charCodes.add("d*"); tilesList.add(fireTile);
        charCodes.add("b_"); tilesList.add(iceTile);
        charCodes.add("b&"); tilesList.add(metalTile);
        charCodes.add("b^"); tilesList.add(snowTile);
        charCodes.add("c-"); tilesList.add(midTile);
        charCodes.add("c/"); tilesList.add(stoneTile);
        charCodes.add("c["); tilesList.add(glassTile);
        charCodes.add("vc"); tilesList.add(cloudTile);
        charCodes.add("h+"); tilesList.add(halfTile);
        charCodes.add("Kr"); tilesList.add(keyRed);
        charCodes.add("kr"); tilesList.add(keyHoleRed);
        charCodes.add("Kb"); tilesList.add(keyBlue);
        charCodes.add("kb"); tilesList.add(keyHoleBlue);
        charCodes.add("Ky"); tilesList.add(keyYellow);
        charCodes.add("ky"); tilesList.add(keyHoleYellow);
        charCodes.add("xx"); tilesList.add(bomb);

    }
	public static void loadSplash() {
		A.mt("allmain",5);
	}
	
	
	//ENGINE STUFF
	public static Engine engine;
	public static GameActivity activity;
	public static Camera camera;
	public static VertexBufferObjectManager vbom;
	public static void prepare(Engine e, GameActivity a, Camera c, VertexBufferObjectManager v) {
		engine = e;
		activity = a;
		camera = c;
		vbom = v;
	}
	
	
	//FILE STUFF
	public static File fileLocation;
	public static void writeToMemory(String fileName, String text)
    {//needed to instantiate file directory in sample game activity
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fileLocation+File.separator+fileName)));
            bufferedWriter.write(text);
            bufferedWriter.close();
        } catch (IOException e) {}
    }
    public static String readFromMemory(String fileName)
    {
        String a = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileLocation+File.separator+fileName)));
            String read;
            StringBuilder builder = new StringBuilder("");
            while((read = bufferedReader.readLine()) != null){
                builder.append(read);
            }
            a = builder.toString();
            bufferedReader.close();
        } catch (IOException e) {}
        return a;
    }
	
	
    //MENU/BG stuff
    //about, block, buy, editor, editorselect, fail, finish, help, level, main, medal, pack, pause, ready, splash, toomanywarps
    public static void mt(String menuFile, int k)
    {
        if (currentMenu.equals(menuFile)) {
            menu.setCurrentTileIndex(k);
            return;
        }
        currentMenu = menuFile;
        if (menuFile.equals("allgame"))
            menu = tt(menuFile + "menu", 2,2);
        else if (menuFile.equals("alleditor"))
            menu = tt(menuFile + "menu", 2,3);
        else if (menuFile.equals("allmain"))
            menu = tt(menuFile + "menu", 2,3);
        else menu = tt(menuFile + "menu", 2,2);
        menu.setCurrentTileIndex(k);
    }
    public static void b(String bgFile) {
        if (bgFile.equals(currentBG)) return;
        currentBG = bgFile;
    	bg = i("background" + bgFile);
    }
    
    
	//IMAGE/SOUND LOADING STUFF
	public static ITextureRegion i(final String file) {	
		try {
			ITexture mTexture = new BitmapTexture(activity.getTextureManager(), new IInputStreamOpener() {
				@Override
				public InputStream open() throws IOException {
					return activity.getAssets().open("gfx/" + file + ".png");
				}
			});
			mTexture.load();
			return TextureRegionFactory.extractFromTexture(mTexture);
		} catch (IOException e) {
			Debug.e(e);
			return null;
		}
	}
	public static ITiledTextureRegion t(final String file, final int num) {
        try {
            ITexture mTexture = new BitmapTexture(activity.getTextureManager(), new IInputStreamOpener() {
                @Override
                public InputStream open() throws IOException {
                    return activity.getAssets().open("gfx/" + file + ".png");
                }
            });
            mTexture.load();
            return TextureRegionFactory.extractTiledFromTexture(mTexture, num, 1);
        } catch (IOException e) {
            Debug.e(e);
            return null;
        }
    }
    public static ITiledTextureRegion tt(final String file, final int num, final int high) {
        try {
            ITexture mTexture = new BitmapTexture(activity.getTextureManager(), new IInputStreamOpener() {
                @Override
                public InputStream open() throws IOException {
                    return activity.getAssets().open("gfx/" + file + ".png");
                }
            });
            mTexture.load();
            return TextureRegionFactory.extractTiledFromTexture(mTexture, num, high);
        } catch (IOException e) {
            Debug.e(e);
            return null;
        }
    }
	public static Sound s(String file) {
		SoundFactory.setAssetBasePath("mfx/");
		try {
			return SoundFactory.createSoundFromAsset(engine.getSoundManager(), activity, file);
		} catch (final IOException e) {
			Debug.e(e);
			return null;
		}
	}
	public static void p(String message) {
		Log.d("chasegemstag", message);
	}
	
	
	//UTIL STUFF
	public static double distance(Coord a, Coord b) {
        return Math.sqrt((a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y));
    }
    public static boolean inBounds(Coord a, Coord b, Coord c) {
        return a.x>b.x && a.x<c.x && a.y>b.y && a.y < c.y;
    }

}

