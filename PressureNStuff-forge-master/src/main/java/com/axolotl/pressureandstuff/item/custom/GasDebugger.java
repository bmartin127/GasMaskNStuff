package com.axolotl.pressureandstuff.item.custom;


import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class GasDebugger extends Item {

    public GasDebugger(Properties properties) {
        super(properties);
    }
    @Override
    public boolean isFoil(ItemStack stack) {
        // Always return true to show enchanted glint
        return true;
    }
}

