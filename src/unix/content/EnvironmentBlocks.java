package unix.content;

import mindustry.world.Block;
import mindustry.world.blocks.environment.Floor;
import arc.graphics.Color;

public class EnvironmentBlocks {
    public static Floor rockyFloor, dustyFloor, crystalFloor, iceFloor;
    public static Block rockyWall, crystalWall;   // Block saja

    public static void load() {
        rockyFloor = new Floor("rocky-floor") {{
            mapColor = Color.valueOf("7b6952");
            variants = 3;
        }};

        dustyFloor = new Floor("dusty-floor") {{
            mapColor = Color.valueOf("a0926b");
            variants = 3;
        }};

        crystalFloor = new Floor("crystal-floor") {{
            mapColor = Color.valueOf("c5d7f0");
            variants = 3;
        }};

        iceFloor = new Floor("ice-floor") {{
            mapColor = Color.valueOf("b3e5fc");
            variants = 3;
        }};

        /* dinding = Block biasa, solid & breakable */
        rockyWall = new Block("rocky-wall") {{
            solid = true;
            breakable = true;
            mapColor = Color.valueOf("5a4a3a");
            variants = 2;
        }};

        crystalWall = new Block("crystal-wall") {{
            solid = true;
            breakable = true;
            mapColor = Color.valueOf("9bb7e0");
            variants = 2;
        }};
    }
}