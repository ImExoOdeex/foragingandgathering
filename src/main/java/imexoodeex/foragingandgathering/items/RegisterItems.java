package imexoodeex.foragingandgathering.items;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static imexoodeex.foragingandgathering.Foragingandgathering.ModID;

public class RegisterItems {

    public static void registerItems() {
        Registry.register(Registries.ITEM, new Identifier(ModID, "pruning_shears"), Items.PRUNING_SHEARS);
    }
}