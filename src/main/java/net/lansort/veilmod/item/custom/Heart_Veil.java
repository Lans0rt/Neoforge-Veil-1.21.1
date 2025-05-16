package net.lansort.veilmod.item.custom;

import net.lansort.veilmod.item.ModItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;


public class Heart_Veil extends Item {

    public Heart_Veil(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean isSelected) {
        if(entity instanceof Player player) {
            if (player.getMainHandItem().is(ModItems.Heart_Veil.get())) {
                int lightLevel = level.getLightEngine().getRawBrightness(player.blockPosition(), 0);
                if (lightLevel <= 8) {
                    if (player.isCrouching()) {
                        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 2));
                    } else {
                        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200));
                    }
                }

            }
        }
    }
}
