package imexoodeex.foragingandgathering.items;

import imexoodeex.foragingandgathering.items.customItems.PruningShears;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public class Items {
    public static final PruningShears PRUNING_SHEARS = new PruningShears(new FabricItemSettings().maxDamage(100));
    public static final Item LEAF = new Item(new FabricItemSettings().maxCount(64));

}