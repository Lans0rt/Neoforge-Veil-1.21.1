package net.lansort.veilmod.item;

import net.lansort.veilmod.VeilMod;
import net.lansort.veilmod.item.custom.Heart_Veil;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(VeilMod.MOD_ID);


    public static final DeferredItem<Item> Misty_Ashes = ITEMS.register("misty_ashes",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> MISTBERRY = ITEMS.register("mistberry",
            () -> new Item(new Item.Properties().food(ModFoodProperties.MISTBERRY)));


    public static final DeferredItem<Item> Heart_Veil = ITEMS.register("heart_veil",
            () -> new Heart_Veil(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

    }
}
