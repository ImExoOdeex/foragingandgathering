package imexoodeex.foragingandgathering.items;

import imexoodeex.foragingandgathering.utils.ModItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static imexoodeex.foragingandgathering.Foragingandgathering.ModID;

public class RegisterItems {

    public static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void addItemsToModItemGroup() {
        addToItemGroup(ModItemGroup.MOD_ITEM_GROUP, Items.PRUNING_SHEARS);
        addToItemGroup(ModItemGroup.MOD_ITEM_GROUP, Items.LEAF);
    }

    public static void registerItems() {
        Registry.register(Registries.ITEM, new Identifier(ModID, "pruning_shears"), Items.PRUNING_SHEARS);
        Registry.register(Registries.ITEM, new Identifier(ModID, "leaf"), Items.LEAF);
        addItemsToModItemGroup();
    }
}