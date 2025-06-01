package net.lansort.veilmod.item;

import net.lansort.veilmod.VeilMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, VeilMod.MOD_ID);

    public static final Supplier<CreativeModeTab> VEIL_ITEMS_TAB = CREATIVE_MODE_TAB.register("veil_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.Heart_Veil.get()))
                    .title(Component.translatable("Veil"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.Misty_Ashes);
                        output.accept(ModItems.MISTBERRY);
                        output.accept(ModItems.Heart_Veil);
                        output.accept(ModItems.MIST_HELMET);
                        output.accept(ModItems.MIST_CHESTPLATE);
                        output.accept(ModItems.MIST_LEGGINGS);
                        output.accept(ModItems.MIST_BOOTS);
                    }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
