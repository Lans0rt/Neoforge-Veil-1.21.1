package net.lansort.veilmod.util;

import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class VeilArmorDirectionHelper {

    public static String getMatchedDirection(Player player) {
        Map<String, Integer> directionCounts = new HashMap<>();

        for (ItemStack armor : player.getArmorSlots()) {
            if (!(armor.getItem() instanceof ArmorItem)) continue;

            CustomData data = armor.get(DataComponents.CUSTOM_DATA);
            if (data == null) continue;

            CompoundTag tag = data.copyTag();
            if (!tag.contains("veilmod:veil_direction")) continue;

            String direction = tag.getString("veilmod:veil_direction").toLowerCase(Locale.ROOT);
            directionCounts.put(direction, directionCounts.getOrDefault(direction, 0) + 1);
        }

        String mostCommonDirection = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : directionCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostCommonDirection = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return mostCommonDirection;
    }
}
