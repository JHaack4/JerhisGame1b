package com.jerhis.chaseorb;

import java.util.ArrayList;
import java.util.Scanner;

public class Level {
	
	public ArrayList<Chaser> chasers = new ArrayList<Chaser>();
    public ArrayList<Orb> orbs = new ArrayList<Orb>();
    public ArrayList<Star> stars = new ArrayList<Star>();
    public Tile[][] tiles = new Tile[C.xBlocks][C.yBlocks];
    public float gold, silver, bronze;

    public int packID;
    public int levelNum;
    public String name = "";

    public Level(int packID, int levelNum)
    {
        this.packID = packID;
        this.levelNum = levelNum;
    }

    public int getStars()
    {
        int k = 0;
        for (Star s: stars)
            if (s.caughtYet)
                k++;
        return k;
    }

    public int getMedal(double time)
    {
        if (time <= gold) return 3;
        if (time <= silver) return 2;
        if (time <= bronze) return 1;
        return 0;
    }

    public void load()
    {
        Scanner sc = new Scanner(LevelStorage.getLevelString(packID, levelNum));
        sc.useDelimiter("#");

        name = sc.next();
        String bg = sc.next();
        String starString = sc.next();
        String medalString = sc.next();
        String levelString = sc.next();

        TileWarp.otherWarps = new ArrayList<TileWarp>();
        TileWarp.currentID = 0;
        chasers = new ArrayList<Chaser>();
        orbs = new ArrayList<Orb>();
        stars = new ArrayList<Star>();
        tiles = new Tile[C.xBlocks][C.yBlocks];
        A.b(bg);

        Scanner starSC = new Scanner(starString);
        starSC.useDelimiter("[$]+");
        stars.add(new Star(new Coord(starSC.next()),0));
        stars.add(new Star(new Coord(starSC.next()),1));
        stars.add(new Star(new Coord(starSC.next()),2));

        Scanner medalSC = new Scanner(medalString);
        medalSC.useDelimiter("[$]+");
        gold = Float.parseFloat(medalSC.next());
        silver = Float.parseFloat(medalSC.next());
        bronze = Float.parseFloat(medalSC.next());

        for (int y = 0; y < C.yBlocks; y++) {
            for (int x = 0; x < C.xBlocks; x++) {
                char typeID = levelString.charAt(2*(x + C.xBlocks*y));
                char charID = levelString.charAt(2*(x + C.xBlocks*y) + 1);
                int pix = C.blocksSize;

                if (typeID == ' ') tiles[x][y] = new TileEmpty(new Coord(x*pix,y*pix),charID);
                else if (typeID == 'f') tiles[x][y] = new TileFinish(new Coord(x*pix,y*pix),charID);
                else if (typeID == 'b') tiles[x][y] = new TileBasic(new Coord(x*pix,y*pix),charID);
                else if (typeID == 'c') tiles[x][y] = new TileCracked(new Coord(x*pix,y*pix),charID);
                else if (typeID == 'd') tiles[x][y] = new TileDeath(new Coord(x*pix,y*pix),charID);
                else if (typeID == 'h') tiles[x][y] = new TileHalf(new Coord(x*pix,y*pix),charID);
                else if (typeID == 'K') tiles[x][y] = new TileKey(new Coord(x*pix,y*pix),charID);
                else if (typeID == 'k') tiles[x][y] = new TileKeyhole(new Coord(x*pix,y*pix),charID);
                else if (typeID == 't') tiles[x][y] = new TileTouch(new Coord(x*pix,y*pix),charID);
                else if (typeID == 'v') tiles[x][y] = new TileVanish(new Coord(x*pix,y*pix),charID);
                else if (typeID == 'x') tiles[x][y] = new TileBomb(new Coord(x*pix,y*pix),charID);
                else if (typeID == 'w') {
                    tiles[x][y] = new TileWarp(new Coord(x*pix,y*pix),'0',TileWarp.currentID++,charID);
                    TileWarp.otherWarps.add((TileWarp)tiles[x][y]);
                }

                else if (typeID == 'C') {
                    tiles[x][y] = new TileEmpty(new Coord(x*pix,y*pix),charID);
                    chasers.add(new Chaser(new Coord(x*pix,y*pix),charID));
                }
                else if (typeID == 'O') {
                    tiles[x][y] = new TileEmpty(new Coord(x*pix,y*pix),charID);
                    orbs.add(new Orb(new Coord(x*pix+C.blocksSize/2,y*pix+C.blocksSize/2),charID));
                }
                else tiles[x][y] = new TileEmpty(new Coord(x*pix,y*pix),charID);
            }
        }
        
        Tile.tiles = tiles;

    }
}
