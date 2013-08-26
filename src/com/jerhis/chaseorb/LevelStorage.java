package com.jerhis.chaseorb;

public class LevelStorage {
	
	/*pack ids:
    0: test

    name#background#level

    TILE CHAR IDS (YOU CANT USE # or $)
    '  ' : empty space
    'f!' : finish tile

    'b+' : basic tile
    'b^' : snow tile
    'b&' : metal tile
    'b<' : dirt tile
    'b~' : grass tile
    'b_' : ice tile
    'b]' : fire base tile

    'xx' : bomb tile

    'c-' : gray stone cracked tile (midtile)
    'c/' : brown stone cracked tile (stonetile)
    'c[' : glass cracked tile

    'd*' : fire tile

    'h+' : half tile (no bottom/left/right collisions)

    'Kr' by: key tile (unlocks keyhole)
    'kr' by: keyhole tile

    'tf' : touch tile (filled default)
    'te' : touch tile (empty default)

    'vc' : vanish cloud tile

    'w0'123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ : warp tile
            (their id is the order they appear, they target the # representing them )

    CHASER/ORB IDS 'a-j' 'A-J'
    'Ca' - 'Cj' : default chaser
    'Oa' - 'Oj; : default orb

    TO REMEMBER WHEN ADDING TILES:
    1) add picture in assets folder
    2) load picture in assets class
    3) define char here
    4) make it recognised by the level class switch statement
    5) add a class that extends tile, implements methods (jordan only)
    6) getImage needs to return the correct image
    7) animations
    8) add functionality (in the class, in GameRunner) (jordan only)
    9) add it to a level

    HOW TO ADD A NEW BACKGROUND
    1) put it in assets folder, name it backgroundwhatever.png
    2) add string in load method
    3) add it to a level after the first hashtag
    */

    public static String getLevelString(int packID, int levelNum)
    {
        if (packID == -1) {
            String j = A.readFromMemory(C.fileName + levelNum + ".txt");
            if (!j.equals("")) return j;
        }
        switch (packID * 100 + levelNum)
        {
            case -1: return SceneLevelEditor.levelName + "#" + SceneLevelEditor.backgroundString + "#" + SceneLevelEditor.starString + "#" + SceneLevelEditor.medalString + "#" + SceneLevelEditor.levelString;
            case 1:
                return "test1##(200,50)$(120,600)$(1200,150)#7.77$15.01$25.40#" +
                        "  w0                            " +
                        "  Kb            w2kr    Ob      " +
                        "              Oakrf!kr          " +
                        "              Ca  b+      Cb    " +
                        "        tetftfb+b+c/d*b+b+b+    " +
                        "b~  w1            c-b]  c/      " +
                        "b+kb                            " +
                        "b<Krb+                  xx      " +
                        "b<h+h+h+h+            w0  c-b+d*" +
                        "b<b&b^b_b+b+vcvcvcb+b+b+c[c/b+b+";
            case 2:
                return "test2#mountain#(200,50)$(400,50)$(1000,50)#7.77$15.01$25.40#" +
                        "  w0                            " +
                        "                w2      Ob      " +
                        "            Oa    f!            " +
                        "                  b+      Cb    " +
                        "            b+b+b+b+d*b+b+b+    " +
                        "b+  w1                          " +
                        "  b+                            " +
                        "  b+b+          Ca              " +
                        "b+b+b+b+b+            w0  b+b+d*" +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 3:
                return "test3#night#(200,50)$(400,50)$(1000,50)#7.77$15.01$25.40#" +
                        "  w0                            " +
                        "                w2      Ob      " +
                        "            Oa    f!            " +
                        "                  b+      Cb    " +
                        "            b+b+b+b+d*b+b+b+    " +
                        "b+  w1                          " +
                        "  b+                            " +
                        "  b+b+          Ca              " +
                        "  b+b+b+b+            w0  b+b+d*" +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 4:
                return "test4##(200,50)$(400,50)$(1000,50)#7.77$15.01$25.40#" +
                        "  w0                            " +
                        "                w2      Ob      " +
                        "            Oa    f!            " +
                        "                  b+      Cb    " +
                        "            b+b+b+b+d*b+b+b+    " +
                        "b+  w1                          " +
                        "  b+                            " +
                        "  b+b+          Ca              " +
                        "  b+b+b+b+            w0  b+b+d*" +
                        "  b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 5:
                return "le0#moon#(200,50)$(400,50)$(1000,50)#7.77$15.01$25.40#" +
                        "b+                              " +
                        "  b+b+                        b+" +
                        "    b+      Oa              b+  " +
                        "b+    b+  b+            b+b+    " +
                        "      b+b+            b+b+b+    " +
                        "          b+b+        b+        " +
                        "    b+  b+  b+      b+          " +
                        "        b+    b+  b+            " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 6:
                return "le0#grassland#(200,50)$(400,50)$(1000,50)#7.77$15.01$25.40#" +
                        "b+                              " +
                        "  b+b+                        b+" +
                        "    b+      Oa              b+  " +
                        "b+    b+  b+            b+b+    " +
                        "      b+b+            b+b+b+    " +
                        "          b+b+        b+        " +
                        "    b+  b+  b+      b+          " +
                        "        b+    b+  b+            " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 7:
                return "le0#sunset#(200,50)$(400,50)$(1000,50)#7.77$15.01$25.40#" +
                        "b+                              " +
                        "  b+b+                        b+" +
                        "    b+      Oa              b+  " +
                        "b+    b+  b+            b+b+    " +
                        "      b+b+            b+b+b+    " +
                        "          b+b+        b+        " +
                        "    b+  b+  b+      b+          " +
                        "        b+    b+  b+            " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 8:
                return "le0#sunset#(200,50)$(400,50)$(1000,50)#7.77$15.01$25.40#" +
                        "b+                              " +
                        "  b+b+                        b+" +
                        "    b+      Oa              b+  " +
                        "b+    b+  b+            b+b+    " +
                        "      b+b+            b+b+b+    " +
                        "          b+b+        b+        " +
                        "    b+  b+  b+      b+          " +
                        "        b+    b+  b+            " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 9:
                return "le0#sunset#(200,50)$(400,50)$(1000,50)#7.77$15.01$25.40#" +
                        "b+                              " +
                        "  b+b+                        b+" +
                        "    b+      Oa              b+  " +
                        "b+    b+  b+            b+b+    " +
                        "      b+b+            b+b+b+    " +
                        "          b+b+        b+        " +
                        "    b+  b+  b+      b+          " +
                        "        b+    b+  b+            " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 10:
                return "le0#sunset#(200,50)$(400,50)$(1000,50)#7.77$15.01$25.40#" +
                        "b+                              " +
                        "  b+b+                        b+" +
                        "    b+      Oa              b+  " +
                        "b+    b+  b+            b+b+    " +
                        "      b+b+            b+b+b+    " +
                        "          b+b+        b+        " +
                        "    b+  b+  b+      b+          " +
                        "        b+    b+  b+            " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 11:
                return "le0#sunset#(200,50)$(400,50)$(1000,50)#7.77$15.01$25.40#" +
                        "b+                              " +
                        "  b+b+                        b+" +
                        "    b+      Oa              b+  " +
                        "b+    b+  b+            b+b+    " +
                        "      b+b+            b+b+b+    " +
                        "          b+b+        b+        " +
                        "    b+  b+  b+      b+          " +
                        "        b+    b+  b+            " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 12:
                return "le0#sunset#(200,50)$(400,50)$(1000,50)#7.77$15.01$25.40#" +
                        "b+                              " +
                        "  b+b+                        b+" +
                        "    b+      Oa              b+  " +
                        "b+    b+  b+            b+b+    " +
                        "      b+b+            b+b+b+    " +
                        "          b+b+        b+        " +
                        "    b+  b+  b+      b+          " +
                        "        b+    b+  b+            " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 13:
                return "le0#sunset#(200,50)$(400,50)$(1000,50)#7.77$15.01$25.40#" +
                        "b+                              " +
                        "  b+b+                        b+" +
                        "    b+      Oa              b+  " +
                        "b+    b+  b+            b+b+    " +
                        "      b+b+            b+b+b+    " +
                        "          b+b+        b+        " +
                        "    b+  b+  b+      b+          " +
                        "        b+    b+  b+            " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 14:
                return "le0#sunset#(200,50)$(400,50)$(1000,50)#7.77$15.01$25.40#" +
                        "b+                              " +
                        "  b+b+                        b+" +
                        "    b+      Oa              b+  " +
                        "b+    b+  b+            b+b+    " +
                        "      b+b+            b+b+b+    " +
                        "          b+b+        b+        " +
                        "    b+  b+  b+      b+          " +
                        "        b+    b+  b+            " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 15:
                return "le0#sunset#(200,50)$(400,50)$(1000,50)#7.77$15.01$25.40#" +
                        "b+                              " +
                        "  b+b+                        b+" +
                        "    b+      Oa              b+  " +
                        "b+    b+  b+            b+b+    " +
                        "      b+b+            b+b+b+    " +
                        "          b+b+        b+        " +
                        "    b+  b+  b+      b+          " +
                        "        b+    b+  b+            " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 16:
                return "le0#sunset#(200,50)$(400,50)$(1000,50)#7.77$15.01$25.40#" +
                        "b+                              " +
                        "  b+b+                        b+" +
                        "    b+      Oa              b+  " +
                        "b+    b+  b+            b+b+    " +
                        "      b+b+            b+b+b+    " +
                        "          b+b+        b+        " +
                        "    b+  b+  b+      b+          " +
                        "        b+    b+  b+            " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 17:
                return "le0#sunset#(200,50)$(400,50)$(1000,50)#7.77$15.01$25.40#" +
                        "b+                              " +
                        "  b+b+                        b+" +
                        "    b+      Oa              b+  " +
                        "b+    b+  b+            b+b+    " +
                        "      b+b+            b+b+b+    " +
                        "          b+b+        b+        " +
                        "    b+  b+  b+      b+          " +
                        "        b+    b+  b+            " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 18:
                return "le0#sunset#(200,50)$(400,50)$(1000,50)#7.77$15.01$25.40#" +
                        "b+                              " +
                        "  b+b+                        b+" +
                        "    b+      Oa              b+  " +
                        "b+    b+  b+            b+b+    " +
                        "      b+b+            b+b+b+    " +
                        "          b+b+        b+        " +
                        "    b+  b+  b+      b+          " +
                        "        b+    b+  b+            " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 19:
                return "le0#sunset#(200,50)$(400,50)$(1000,50)#7.77$15.01$25.40#" +
                        "b+                              " +
                        "  b+b+                        b+" +
                        "    b+      Oa              b+  " +
                        "b+    b+  b+            b+b+    " +
                        "      b+b+            b+b+b+    " +
                        "          b+b+        b+        " +
                        "    b+  b+  b+      b+          " +
                        "        b+    b+  b+            " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 20:
                return "le0#sunset#(200,50)$(400,50)$(1000,50)#7.77$15.01$25.40#" +
                        "b+                              " +
                        "  b+b+                        b+" +
                        "    b+      Oa              b+  " +
                        "b+    b+  b+            b+b+    " +
                        "      b+b+            b+b+b+    " +
                        "          b+b+        b+        " +
                        "    b+  b+  b+      b+          " +
                        "        b+    b+  b+            " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 21:
                return "le0#sunset#(200,50)$(400,50)$(1000,50)#7.77$15.01$25.40#" +
                        "b+                              " +
                        "  b+b+                        b+" +
                        "    b+      Oa              b+  " +
                        "b+    b+  b+            b+b+    " +
                        "      b+b+            b+b+b+    " +
                        "          b+b+        b+        " +
                        "    b+  b+  b+      b+          " +
                        "        b+    b+  b+            " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 22:
                return "le0#sunset#(200,50)$(400,50)$(1000,50)#7.77$15.01$25.40#" +
                        "b+                              " +
                        "  b+b+                        b+" +
                        "    b+      Oa              b+  " +
                        "b+    b+  b+            b+b+    " +
                        "      b+b+            b+b+b+    " +
                        "          b+b+        b+        " +
                        "    b+  b+  b+      b+          " +
                        "        b+    b+  b+            " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 23:
                return "le0#sunset#(200,50)$(400,50)$(1000,50)#7.77$15.01$25.40#" +
                        "b+                              " +
                        "  b+b+                        b+" +
                        "    b+      Oa              b+  " +
                        "b+    b+  b+            b+b+    " +
                        "      b+b+            b+b+b+    " +
                        "          b+b+        b+        " +
                        "    b+  b+  b+      b+          " +
                        "        b+    b+  b+            " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 24:
                return "le0#sunset#(200,50)$(400,50)$(1000,50)#7.77$15.01$25.40#" +
                        "b+                              " +
                        "  b+b+                        b+" +
                        "    b+      Oa              b+  " +
                        "b+    b+  b+            b+b+    " +
                        "      b+b+            b+b+b+    " +
                        "          b+b+        b+        " +
                        "    b+  b+  b+      b+          " +
                        "        b+    b+  b+            " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 25:
                return "le0#sunset#(200,50)$(400,50)$(1000,50)#7.77$15.01$25.40#" +
                        "b+                              " +
                        "  b+b+                        b+" +
                        "    b+      Oa              b+  " +
                        "b+    b+  b+            b+b+    " +
                        "      b+b+            b+b+b+    " +
                        "          b+b+        b+        " +
                        "                                " +
                        "                                " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
    /*LEVEL PACK 1 -------------1--------------1-----------------1---------------------1--------1 */
            case 101:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 102:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 103:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 104:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 105:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 106:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 107:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 108:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 109:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 110:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 111:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 112:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 113:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 114:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 115:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 116:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 117:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 118:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 119:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 120:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 121:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 122:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 123:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 124:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 125:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
    /* LEVEL PACK 2 -------------2-------------------2-----------------------2------------------2 */
            case 201:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 202:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 203:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 204:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 205:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 206:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 207:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 208:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 209:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 210:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 211:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 212:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 213:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 214:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 215:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 216:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 217:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 218:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 219:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 220:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 221:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 222:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 223:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 224:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 225:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
    /*LEVEL PACK 3 -------------3--------------3-----------------3---------------------3--------3 */
            case 301:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 302:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 303:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 304:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 305:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 306:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 307:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 308:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 309:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 310:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 311:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 312:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 313:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 314:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 315:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 316:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 317:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 318:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 319:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 320:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 321:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 322:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 323:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 324:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 325:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
    /*LEVEL PACK 4 -------------4--------------4-----------------4---------------------4--------4 */
            case 401:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 402:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 403:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 404:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 405:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 406:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 407:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 408:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 409:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 410:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 411:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 412:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 413:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 414:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 415:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 416:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 417:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 418:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 419:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 420:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 421:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 422:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 423:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 424:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 425:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
    /*LEVEL PACK 5 -------------5--------------5-----------------5---------------------5-------5- */
            case 501:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 502:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 503:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 504:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 505:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 506:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 507:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 508:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 509:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 510:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 511:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 512:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 513:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 514:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 515:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 516:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 517:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 518:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 519:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 520:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 521:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 522:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 523:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 524:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
            case 525:
                return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "    Oa                          " +
                        "  f!                        Ca  " +
                        "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
        }

        return "le0##(200,650)$(400,650)$(1000,650)#7.77$15.01$25.40#" +
            "                                " +
            "                                " +
            "                                " +
            "                                " +
            "                                " +
            "                                " +
            "                                " +
            "    Oa                          " +
            "  f!                        Ca  " +
            "b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+";
    }

}
