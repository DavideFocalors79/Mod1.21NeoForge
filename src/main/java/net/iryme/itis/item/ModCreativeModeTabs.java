package net.iryme.itis.item;

import net.iryme.itis.ItisMod;
import net.iryme.itis.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ItisMod.MODID);

    public static final Supplier<CreativeModeTab> ITIS_MOD_TAB = CREATIVE_MODE_TAB.register("itis_mod_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CHOICEBOOK.get()))
                    .title(Component.translatable("creativetab.itismod.itis_mod_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                      output.accept(ModItems.CHOICEBOOK);
                      output.accept(ModItems.SILICADUST);

                      output.accept(ModBlocks.SILICA_BLOCK);
                      output.accept(ModBlocks.DEEPSLATE_SILICA_CLUSTER);
                      output.accept(ModBlocks.FEDERICO_BLOCK);
                      output.accept(ModBlocks.SILICA_CLUSTER);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
