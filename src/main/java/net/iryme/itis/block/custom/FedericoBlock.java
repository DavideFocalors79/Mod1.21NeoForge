package net.iryme.itis.block.custom;

import net.iryme.itis.ItisMod;
import net.iryme.itis.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class FedericoBlock extends Block {
    public FedericoBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos,
                                               Player player, BlockHitResult hitResult) {
        level.playSound(player, pos, SoundEvents.ENDER_DRAGON_DEATH, SoundSource.BLOCKS, 4f, 10f);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof ItemEntity ItemEntity) {
            if(ItemEntity.getItem().getItem() == ModItems.SILICADUST.get()){
                ItemEntity.setItem(new ItemStack(Items.REDSTONE,ItemEntity.getItem().getCount()));
            }

            if(ItemEntity.getItem().getItem() == ModItems.CHOICEBOOK.get()){
                ItemEntity.setItem(new ItemStack(Items.DIAMOND_BLOCK,ItemEntity.getItem().getCount()));
            }
        }

        super.stepOn(level, pos, state, entity);
    }
}
