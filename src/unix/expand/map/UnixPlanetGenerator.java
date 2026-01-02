package unix.expand.map;

import arc.math.*;
import arc.math.geom.Vec3;
import arc.util.noise.Simplex;
import mindustry.content.Blocks;
import mindustry.maps.generators.PlanetGenerator;
import mindustry.world.*;
import unix.content.EnvironmentBlocks;

public class UnixPlanetGenerator extends PlanetGenerator {

    public float seaLevel = 0.42f;          // 0-1, batas laut

    /* ---------- tinggi dasar ---------- */
    @Override
    public float getHeight(Vec3 position) {
        float h = Simplex.noise3d(seed, 8, 0.55f, 1f, position.x, position.y, position.z);
        return Math.max(h, seaLevel) - 0.2f; // agar tidak negatif
    }

    /* ---------- generator blok per-tile ---------- */
    @Override
    public void genTile(Vec3 position, TileGen tile) {
        float height = getHeight(position);

        if (height < seaLevel) {                 // daerah rendah → laut es
            tile.floor = EnvironmentBlocks.iceFloor;
            tile.block = Blocks.air;
        } else if (height < 0.55f) {             // dataran
            tile.floor = EnvironmentBlocks.dustyFloor;
            tile.block = EnvironmentBlocks.rockyWall;
        } else if (height < 0.7f) {              // bukit
            tile.floor = EnvironmentBlocks.rockyFloor;
            tile.block = EnvironmentBlocks.rockyWall;
        } else {                                 // puncak
            tile.floor = EnvironmentBlocks.crystalFloor;
            tile.block = EnvironmentBlocks.crystalWall;
        }

        // sedikit randomisasi dinding
        if (noise(position.x, position.y, 4, 0.6f, 12f) > 0.5f) {
            tile.block = Blocks.air;
        }
    }

    /* ---------- ukuran planet (opsional) ---------- */
    @Override
    public float getSizeScl() { return 1800; }

    /* ---------- warna di planet-map ---------- */
    @Override
    public void getColor(Vec3 position, Color out) {
        TileGen gen = new TileGen();
        genTile(position, gen);
        out.set(gen.floor.mapColor);
    }
}