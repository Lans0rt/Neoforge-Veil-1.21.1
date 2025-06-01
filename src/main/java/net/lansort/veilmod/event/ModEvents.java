package net.lansort.veilmod.event;

import net.lansort.veilmod.VeilMod;
import net.lansort.veilmod.effect.ModEffects;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;

@EventBusSubscriber(modid = VeilMod.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {

    @SubscribeEvent
    public static void onLevelTick(LevelTickEvent.Post event) {
        Level level = event.getLevel();

        if (level.isClientSide()) return;

        for (Player player : level.players()) {
            Vec3 look = player.getViewVector(1.0F);
            String lookDir = getHorizontalDirection(look);
            if (lookDir == null) continue;

            int matchCount = 0;

            for (ItemStack armor : player.getArmorSlots()) {
                if (!(armor.getItem() instanceof ArmorItem)) continue;
                CustomData data = armor.get(DataComponents.CUSTOM_DATA);
                if (data == null) continue;
                CompoundTag tag = data.copyTag();
                if (!tag.contains("veilmod:veil_direction")) continue;
                String dir = tag.getString("veilmod:veil_direction");
                if (dir.equalsIgnoreCase(lookDir)) {
                    matchCount++;
                }
            }

            if (matchCount > 0) {
                int amplifier = Math.min(matchCount - 1, 2);

                MobEffectInstance current = player.getEffect(ModEffects.CALL_VEIL_EFFECT);
                if (current == null || current.getAmplifier() != amplifier || current.getDuration() <= 10) {
                    player.addEffect(new MobEffectInstance(
                            ModEffects.CALL_VEIL_EFFECT, 140, amplifier, false, true
                    ));
                }
            }
        }
    }


    private static String getHorizontalDirection(Vec3 motion) {
        double x = motion.x;
        double z = motion.z;

        if (Math.abs(x) > Math.abs(z)) {
            return x > 0 ? "east" : "west";
        } else if (Math.abs(z) > 0) {
            return z > 0 ? "south" : "north";
        }

        return null;
    }
}
