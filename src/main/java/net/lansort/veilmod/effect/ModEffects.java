package net.lansort.veilmod.effect;

import net.lansort.veilmod.VeilMod;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, VeilMod.MOD_ID);


    public static final Holder<MobEffect> CALL_VEIL_EFFECT = MOB_EFFECTS.register("call_veil",
            ()-> new Call_Veil_Effect(MobEffectCategory.NEUTRAL, 0x9E00FF));


    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
