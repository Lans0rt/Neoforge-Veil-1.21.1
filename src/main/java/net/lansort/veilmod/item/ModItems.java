package net.lansort.veilmod.item;

import net.lansort.veilmod.VeilMod;
import net.lansort.veilmod.item.custom.Heart_Veil;
import net.minecraft.world.item.ArmorItem;
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


    public static final DeferredItem<ArmorItem> MIST_HELMET = ITEMS.register("mist_helmet",
            () -> new VeilArmorItem(ModArmorMaterials.MIST_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(25))));

    public static final DeferredItem<ArmorItem> MIST_LEGGINGS = ITEMS.register("mist_leggings",
            () -> new VeilArmorItem(ModArmorMaterials.MIST_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(25))));

    public static final DeferredItem<ArmorItem> MIST_CHESTPLATE = ITEMS.register("mist_chestplate",
            () -> new VeilArmorItem(ModArmorMaterials.MIST_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(25))));

    public static final DeferredItem<ArmorItem> MIST_BOOTS = ITEMS.register("mist_boots",
            () -> new VeilArmorItem(ModArmorMaterials.MIST_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(25))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

    }
}
