package com.jerhis.chaseorb;

import android.widget.Toast;

import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.util.HorizontalAlign;

public class GameDrawer {

    public static Sprite bg;
    public static Text text = new Text(640,225,A.mFont,"",new TextOptions(HorizontalAlign.CENTER), A.vbom);
	public static void draw(Level level, SceneBase scene)
    {
        bg = new Sprite(0,0,A.bg,A.vbom);
        scene.attachChild(bg);

        for (int x = C.xBlocks-1; x >= 0; x--) {
            for (int y = C.yBlocks-1; y >= 0; y--) {
                Tile t = level.tiles[x][y];
                if (t instanceof TileEmpty) continue;
                //g.drawImage(i,(int)t.coord.x,(int)t.coord.y,(int)a.coord.x,(int)a.coord.y,C.blocksSize,i.getHeight());
                scene.attachChild(t);
            }
        }

        for (Chaser c: level.chasers)
        {
            scene.attachChild(c);
        }

        for (Star s: level.stars)
        {
        	scene.attachChild(s);
        }

        for (Orb o: level.orbs)
        {
        	scene.attachChild(o);
        }

    }
	
	public static void unDraw(Level level, SceneBase scene)
    {
        scene.detachChild(bg);

        for (int x = C.xBlocks-1; x >= 0; x--) {
            for (int y = C.yBlocks-1; y >= 0; y--) {
                Tile t = level.tiles[x][y];
                if (t instanceof TileEmpty) continue;
                //g.drawImage(i,(int)t.coord.x,(int)t.coord.y,(int)a.coord.x,(int)a.coord.y,C.blocksSize,i.getHeight());
                scene.detachChild(t);
                if (t instanceof TileBomb) {
                	try{
                		((TileBomb)t).smoke.detachSelf();
                	} catch (Exception e) {}
                }
            }
        }

        for (Chaser c: level.chasers)
        {
            scene.detachChild(c);
        }

        for (Star s: level.stars)
        {
        	scene.detachChild(s);
        }

        for (Orb o: level.orbs)
        {
        	scene.detachChild(o);
        }

        //text.detachSelf();
    }

}
