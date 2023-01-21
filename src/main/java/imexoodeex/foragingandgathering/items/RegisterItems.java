package imexoodeex.foragingandgathering.items;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RegisterItems {

    public static void registerItems() {

        Registry.register(Registries.ITEM, new Identifier("foragingandgathering", "garden_shears"), Items.GARDEN_SHEARS);
    }
}