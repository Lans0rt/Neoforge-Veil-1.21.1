package net.lansort.veilmod.effect;

import net.lansort.veilmod.util.VeilArmorDirectionHelper;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

import java.util.Locale;

public class Call_Veil_Effect extends MobEffect {
    public Call_Veil_Effect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        if (!(entity instanceof Player player)) return true;
        if (player.level().isClientSide()) return true;

        String commonDirection = VeilArmorDirectionHelper.getMatchedDirection(player);
        if (commonDirection == null) return true;

        Vec3 directionVector = switch (commonDirection.toLowerCase(Locale.ROOT)) {
            case "north" -> new Vec3(0, 0, -1);
            case "south" -> new Vec3(0, 0, 1);
            case "east"  -> new Vec3(1, 0, 0);
            case "west"  -> new Vec3(-1, 0, 0);
            default -> Vec3.ZERO;
        };

        double speed = 0.05 + 0.05 * amplifier;
        Vec3 currentMotion = player.getDeltaMovement();
        player.setDeltaMovement(currentMotion.add(directionVector.scale(speed)));

        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
