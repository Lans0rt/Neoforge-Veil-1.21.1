package net.lansort.veilmod.item;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties MISTBERRY = new FoodProperties.Builder().nutrition(4).saturationModifier(0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 420), 0.85f).build();
}
