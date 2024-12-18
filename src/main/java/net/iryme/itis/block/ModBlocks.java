package net.iryme.itis.block;

import net.iryme.itis.ItisMod;
import net.iryme.itis.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ItisMod.MODID);

    public static final DeferredBlock<Block> SILICA_BLOCK = registerBlock("silica_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1f).requiresCorrectToolForDrops().sound(SoundType.SAND)));

    public static final DeferredBlock<Block> SILICA_CLUSTER = registerBlock("silica_cluster",
            () -> new DropExperienceBlock(UniformInt.of(3, 4),
                    BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(2f)));


    public static final DeferredBlock<Block> DEEPSLATE_SILICA_CLUSTER = registerBlock("deepslate_silica_cluster",
            () -> new DropExperienceBlock(UniformInt.of(3, 7),
                    BlockBehaviour.Properties.of().sound(SoundType.DEEPSLATE).strength(2f)));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
