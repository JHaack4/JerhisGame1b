package com.jerhis.chaseorb;

import java.util.ArrayList;

import org.andengine.input.touch.TouchEvent;

public class GameRunner {
	
	public static SceneGame.GameState update(SceneBase scene, float deltaTime, Level level)
    {
        updateBlocks(scene, level.tiles, deltaTime);
        chasersFollowOrbs(level.chasers, level.orbs, deltaTime);
        chasersFallDown(level.chasers, deltaTime);
        chasersMove(level.chasers, deltaTime);
        chasersCollide(level.chasers, level.tiles);
        chasersStar(level.chasers, level.stars);
        
        for (Chaser c: level.chasers)
        	c.setPosition((int)c.coord.x, (int)c.coord.y);
        
        //TODO update chaser, orb, star for anim
        
        if (chasersFinish(level.chasers))
            return SceneGame.GameState.Finish;
        else if (chasersDie(level.chasers))
            return SceneGame.GameState.Fail;
        else
            return SceneGame.GameState.Running;
    }

    private static void updateBlocks(SceneBase scene, Tile[][] tiles, float deltaTime) {
        for (int x = 0; x < C.xBlocks; x++)
            for (int y = 0; y < C.yBlocks; y++)
                tiles[x][y].update(scene, deltaTime);
    }

    private static void chasersStar(ArrayList<Chaser> chasers, ArrayList<Star> stars) {
        for (Star s: stars)
            if (!s.caughtYet)
                for (Chaser c: chasers)
                    s.checkCollision(c);
    }

    private static boolean chasersDie(ArrayList<Chaser> chasers) {
        for (Chaser c: chasers)
        {
            if (c.finished) continue;
            if (c.dead) return true;
            if (c.coord.y > C.height + C.blocksSize && !c.finished) return true;
        }
        return false;
    }

    private static boolean chasersFinish(ArrayList<Chaser> chasers) {
        for (Chaser c: chasers)
        {
            if (!c.finished) return false;
        }
        return true;
    }

    private static void chasersMove(ArrayList<Chaser> chasers, float deltaTime) {
        for(Chaser c: chasers)
        {
            if (c.finished) continue;
            c.coord.y -= c.upwardVelocity * deltaTime;
            c.coord.x += c.sideVelocity * deltaTime;
        }
    }

    private static void chasersCollide(ArrayList<Chaser> chasers, Tile[][] tiles) {
        for (int z = 0; z < chasers.size(); z++)
        {
            Chaser c = chasers.get(z);
            if (c.finished) continue;
            ArrayList<Tile> ti = Tile.getAdjacentTiles(tiles,c.coord);
            for (int k = 0; k < ti.size(); k++)
            {
                Tile t = ti.get(k);
                Tile.CollisionType type = t.checkForCollision(c);
                t.collision(c,type);
            }
        }
    }

    private static void chasersFallDown(ArrayList<Chaser> chasers, float deltaTime) {
        for (Chaser c: chasers) {
            if (c.finished) continue;
            c.upwardVelocity += c.gravity * deltaTime;
            if (c.upwardVelocity < C.maxFall) c.upwardVelocity = C.maxFall;
        }
    }

    private static void chasersFollowOrbs(ArrayList<Chaser> chasers, ArrayList<Orb> orbs, float deltaTime) {
        for (Chaser c: chasers)
        {
            if (c.finished) continue;
            for (Orb o: orbs)
                if (c.color == o.color)
                {
                    if (c.coord.x > o.coord.x-C.blocksSize/2 + C.buffer)
                        c.sideVelocity -= deltaTime * c.momentum;
                    else if (c.coord.x + C.buffer < o.coord.x-C.blocksSize/2)
                        c.sideVelocity += deltaTime * c.momentum;
                    if (c.upwardVelocity>=0 && !c.jumping && c.coord.y > o.coord.y && c.coord.y < o.coord.y +C.jumpBuffer &&
                            c.coord.x < o.coord.x-40 + C.jumpWidth && c.coord.x + C.jumpWidth > o.coord.x-40) {
                        c.jumping = true;
                        c.upwardVelocity = C.jump;
                    }
                }

            if (c.sideVelocity > c.maxVelocity) c.sideVelocity = c.maxVelocity;
            if (c.sideVelocity < -c.maxVelocity) c.sideVelocity = -c.maxVelocity;

            if (c.sideVelocity > 0)
            {
                c.sideVelocity -= c.resistance * deltaTime;
                if (c.sideVelocity < 0) c.sideVelocity = 0;
            }
            if (c.sideVelocity < 0) {
                c.sideVelocity += c.resistance * deltaTime;
                if (c.sideVelocity > 0) c.sideVelocity = 0;
            }
        }
    }

	public static void orbsByTouch(int action, int pointerID, float x, float y,
			ArrayList<Orb> orbs, Tile[][] tiles) {
		if (x > 1240) x = 1240;
		if (y > 760) y = 760;
		if (x < 40) x = 40;
		if (x < 40) x = 40;
		switch (action) {
		case TouchEvent.ACTION_DOWN:
			double distance = C.orbRadius;
			Orb closest = null;
			for (Orb o : orbs) {
				double orbDistance = A.distance(o.coord, new Coord(x, y));
				if (orbDistance < distance) {
					distance = orbDistance;
					closest = o;
				}
			}
			if (closest != null && closest.trackable) {
				closest.pointerID = pointerID;
				closest.coord = new Coord(x - 40, y - 40);
				closest.setPosition(x - 40, y - 40);
				closest.trackable = true;
			} else {
				tiles[((int) x) / C.blocksSize][((int) y) / C.blocksSize].touch();
			}
			break;
		case TouchEvent.ACTION_MOVE:
			for (Orb o : orbs)
				if (pointerID == o.pointerID) {
					o.coord = new Coord(x - 40, y - 40);
					o.setPosition(x - 40, y - 40);
				}
			break;
		case TouchEvent.ACTION_UP:
		case TouchEvent.ACTION_CANCEL:
			for (Orb o : orbs)
				if (pointerID == o.pointerID) {
					o.coord = new Coord(x - 40, y - 40);
					o.setPosition(x - 40, y - 40);
					o.pointerID = -1;
				}
		}
	}

}
