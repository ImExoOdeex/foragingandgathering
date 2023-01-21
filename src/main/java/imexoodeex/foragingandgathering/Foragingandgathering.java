package imexoodeex.foragingandgathering;

import imexoodeex.foragingandgathering.items.RegisterItems;
import net.fabricmc.api.ModInitializer;

public class Foragingandgathering implements ModInitializer {

    @Override
    public void onInitialize() {
        RegisterItems.registerItems();
    }
}
