package com.axolotl.pressureandstuff.item;

import com.axolotl.pressureandstuff.PressureAndStuff;
import com.axolotl.pressureandstuff.item.custom.GasDebugger;

import com.axolotl.pressureandstuff.item.custom.GasMask;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.minecraft.world.item.Items.registerItem;

public class ModIItems {
    public static final DeferredRegister<Item>REGISTRY =
            DeferredRegister.create(ForgeRegistries.ITEMS, PressureAndStuff.MODID);

    public static final RegistryObject<Item> GAS_DEBUGGER = register("gas_debugger",() -> new GasDebugger(new Item.Properties()));
    public static final RegistryObject<Item> GAS_MASK = register("gas_mask",() -> new GasMask(new Item.Properties()));

    private static RegistryObject<Item> register(String name, Supplier<? extends Item> item) {
        return REGISTRY.register(name, item);
    }
    public static void register(IEventBus eventBus) {
        REGISTRY.register(eventBus);
    }


    //public  static final Item GAS_MASK = registerItem("gas_mask",
    //        new GasMask(ModArmorMaterials.GAS_MASK, ArmorItem.Type.HELMET, new FabricItemSettings()));
}
