package net.iryme.itis.item;

import net.iryme.itis.ItisMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ItisMod.MODID);

    public static final DeferredItem<Item> CHOICEBOOK = ITEMS.register("choicebook",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> SILICADUST = ITEMS.register("silicadust",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
