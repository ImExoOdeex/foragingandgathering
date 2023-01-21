package imexoodeex.foragingandgathering.utils;

import imexoodeex.foragingandgathering.Foragingandgathering;
import imexoodeex.foragingandgathering.items.Items;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup MOD_ITEM_GROUP = FabricItemGroup.builder(new Identifier(Foragingandgathering.ModID, "group"))
            .icon(() -> new ItemStack(Items.LEAF)).displayName(Text.literal("Foraging & Gathering")).build();

}
