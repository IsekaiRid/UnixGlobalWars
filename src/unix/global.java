package unix;         
import arc.Core;
import mindustry.mod.Mod;
import unix.content.UnixPlanets;
import unix.content.EnvironmentBlocks;

public class global extends Mod {

    @Override
    public void loadContent() {
        // 1. load blok lingkungan
        EnvironmentBlocks.load();

        // 2. load planet (akan otomatis mendaftarkan ke game)
        UnixPlanets.load();
    }
}