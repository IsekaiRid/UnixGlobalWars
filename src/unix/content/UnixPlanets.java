package unix.content;

import arc.graphics.Color;
import mindustry.content.Planets;
import mindustry.game.Rules;
import mindustry.game.Team;
import mindustry.graphics.g3d.HexMesh;
import mindustry.type.ItemStack;
import mindustry.type.Planet;
import mindustry.content.Items;
import unix.expand.map.UnixPlanetGenerator;

public class UnixPlanets {
    public static Planet unix;   // planet baru kita

    public static void load() {
        unix = new Planet("unix", Planets.sun, 1f, 2) {{   // nama, parent, radius, grid-size
            visible      = true;          // muncul di planet-grid
            accessible   = true;          // bisa dipilih
            alwaysUnlocked = true;

            /* generator relief yg sudah kita buat */
            generator = new UnixPlanetGenerator();

            /* mesh 3D sederhana */
            meshLoader = () -> new HexMesh(this, 6);

            /* warna orbit & atmosfer */
            iconColor       = Color.valueOf("4a90e2");
            atmosphereColor = Color.valueOf("6bb6ff");
            atmosphereRadIn  = 0.08f;
            atmosphereRadOut = 0.35f;

            /* aturan main di setiap sektor */
            ruleSetter = r -> {
                r.waves          = true;
                r.waveTeam       = Team.crux;
                r.placeRangeCheck = false;
                r.showSpawns     = true;
                r.initialWaveSpacing = 60 * 60; // 1 menit
                r.loadout        = ItemStack.list(
                    Items.copper,   200,
                    Items.lead,     200,
                    Items.silicon,  100
                );
            };
        }};
    }
}