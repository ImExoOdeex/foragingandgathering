package imexoodeex.foragingandgathering;

import imexoodeex.foragingandgathering.items.RegisterItems;
import net.fabricmc.api.ModInitializer;

public class Foragingandgathering implements ModInitializer {

    public static String ModID = "foragingandgathering";

    @Override
    public void onInitialize() {
        RegisterItems.registerItems();
    }
}
