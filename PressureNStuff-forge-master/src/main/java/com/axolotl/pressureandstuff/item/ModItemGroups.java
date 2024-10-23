package com.axolotl.pressureandstuff.item;


import com.axolotl.pressureandstuff.PressureAndStuff;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.EventBus;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModItemGroups {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PressureAndStuff.MODID);

    public static final RegistryObject<CreativeModeTab> GeneralItems = CREATIVE_MODE_TABS.register("generalitems",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModIItems.GAS_DEBUGGER.get()))
                    .title(Component.translatable("creativetab.generalitems"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModIItems.GAS_DEBUGGER.get());
                        pOutput.accept(ModIItems.GAS_MASK.get());
                    })
                    .build());

    public static final void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
