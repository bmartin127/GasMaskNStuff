package com.axolotl.pressureandstuff.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class WearableItem extends Item {
    public WearableItem(Properties properties) {
        super(properties);
    }

    public WearableItem() {
        this(new Properties());
    }

    // Remove attribute modifier handling
    public void onEquip(LivingEntity entity, ItemStack stack) {
        // Handle the logic when the item is equipped
        // For now, we can leave this empty or add any specific behavior
    }

    public void onUnequip(LivingEntity entity, ItemStack stack) {
        // Handle the logic when the item is unequipped
        // For now, we can leave this empty or add any specific behavior
    }

    // Optional: You can keep this method if you want to perform logic every tick while worn
    public void wornTick(LivingEntity entity, ItemStack stack) {
        // Handle the logic every tick while the item is worn
    }

    // Override methods for sound effects, key mappings, etc., if needed
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_GENERIC;
    }


}
