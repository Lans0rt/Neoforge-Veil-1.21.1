package net.lansort.veilmod.item;

import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class VeilArmorItem extends ArmorItem {

    public VeilArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public void onCraftedBy(ItemStack stack, Level level, Player player) {
        super.onCraftedBy(stack, level, player);

        CustomData customData = stack.get(DataComponents.CUSTOM_DATA);
        if (customData == null) {
            customData = CustomData.of(new CompoundTag());
        }
        CompoundTag tag = customData.copyTag();


        if (!tag.contains("veilmod:veil_direction")) {
            String[] directions = {"north", "south", "east", "west"};
            String chosen = directions[player.getRandom().nextInt(directions.length)];
            tag.putString("veilmod:veil_direction", chosen);


            stack.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip,
                                TooltipFlag flag) {
        super.appendHoverText(stack, context, tooltip, flag);

        CustomData customData = stack.get(DataComponents.CUSTOM_DATA);
        if (customData != null) {
            CompoundTag tag = customData.copyTag();
            if (tag.contains("veilmod:veil_direction")) {
                String dir = tag.getString("veilmod:veil_direction");
                String capitalized = dir.substring(0, 1).toUpperCase() + dir.substring(1);
                tooltip.add(Component.translatable("tooltip.veilmod.direction", capitalized).withStyle(ChatFormatting.RED));
            }
        }
    }
}
