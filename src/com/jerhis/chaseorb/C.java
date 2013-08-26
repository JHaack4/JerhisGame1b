package com.jerhis.chaseorb;

public class C {

	//full version, cheats (unlocks levels, shows fps)
    public static boolean full = true;
    public static boolean cheats = true;
    public static float maxDeltaTime = 3.15f;

    //dimensions of screen
    public static int width = 1280, height = 800;

    //size of tiles array
    public static int xBlocks = 16;
    public static int yBlocks = 10;
    public static int blocksSize = 80;

    //size of pause area and return areas
    public static int pauseArea = 50;

    //buffer of orbs&chasers
    public static int buffer = 35, jumpBuffer = 200, jump = 5;
    //chaser speeds
    public static double chaserGravity = -0.1, chaserMomentum = 1, chaserResistance = .2;
    public static double maxVelocity = 5, maxFall = -10;

    //collision area ratios for star, blocks
    public static double starRatio = 0.75;
    public static double blockInsideRatio = .5;

    //level select and editor select touch areas
    public static int initX = 150, initY = 200, sizeX = 150, sizeY = 100, gapX = 57, gapY = 15;

    //special level editor select constants
    public static int editorSelectWidth = 350, editorCurrentBlockX = 600, editorCurrentBlockY = 660;
    public static String fileName = "lvld", defaultLevelName = "le";
    public static int specialLoadConstant = -1;
    public static int[][] medalLocs = {{400,140},{400,240},{400,340},{600,140},{600,240},{600,340},{400,540},{400,640},{400,740},{600,540},{600,640},{600,740},{400,940},{400,1040},{400,1140},{600,940},{600,1040},{600,1140},{450,240},{450,640},{450,1040}};
    public static int medalWidth = 75, paintSize = 75;

    //file header for pack
    public static String packFileName = "packa";

    //num of current implemented packs
    public static int numPacks = 6;

    //darkness when used
    public static int darkness = 200;

    //button locations
    public static int center = 1280/2 - 402/2, buttonWidth = 402, buttonHeight = 82;
    public static int[][] buttonNormal3 = {{center,400},{center,500},{center,600}}, buttonNormal2 = {{center,400},{center,500}}, buttonNormal1 = {{center,700}}, buttonHelp = {{800,95}};




    public static int packY1 = 300, packY2 = 500, packX1 = 50, packX2 = 150;
    public static int finStarX = 200, finStarY = 200, finTextY = 375;
    
}
