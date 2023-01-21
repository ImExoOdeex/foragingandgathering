package imexoodeex.foragingandgathering.items.customItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PruningShears extends Item {

    public PruningShears(Settings settings) {
        super(settings);
    }

//    @Override
//    public ActionResult useOnBlock(ItemUsageContext context) {
//        World world = context.getWorld();
//        BlockPos blockPos = context.getBlockPos();
//        BlockState blockState = world.getBlockState(blockPos);
//        Block block = blockState.getBlock();
//        if (block == Blocks.SWEET_BERRY_BUSH) {
//
//        }
//
//        return super.useOnBlock(context);
//    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        Block block = blockState.getBlock();
        PlayerEntity playerEntity = context.getPlayer();
        ItemStack itemStack = context.getStack();

        if (block == Blocks.SWEET_BERRY_BUSH) {
            if (playerEntity.isSneaking()) {
                // prune the bush
                int age = blockState.get(SweetBerryBushBlock.AGE);
                if (age >= 2) {
                    // prune the bush
                    world.setBlockState(blockPos, blockState.with(SweetBerryBushBlock.AGE, 0));
                    // play sound and particle effects
                    world.playSound(null, blockPos, SoundEvents.BLOCK_BEEHIVE_SHEAR, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    world.addParticle(ParticleTypes.POOF, blockPos.getX() + 0.5, blockPos.getY() + 0.5, blockPos.getZ() + 0.5, 0.0, 0.0, 0.0);

                    if (age == 2) {
                        //drop berries
                        ItemEntity itemEntity = new ItemEntity(world, blockPos.getX(), blockPos.getY(), blockPos.getZ(), new ItemStack(Items.SWEET_BERRIES, 2));
                        world.spawnEntity(itemEntity);
                    } else if (age == 3) {
                        ItemEntity itemEntity = new ItemEntity(world, blockPos.getX(), blockPos.getY(), blockPos.getZ(), new ItemStack(Items.SWEET_BERRIES, 3));
                        world.spawnEntity(itemEntity);
                    }

                }

                // check if player is in survival mode and decrement item use count
                if (!playerEntity.getAbilities().creativeMode) {
                    itemStack.damage(1, playerEntity, (player) -> {
                        player.sendToolBreakStatus(context.getHand());
                    });
                }
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }

}