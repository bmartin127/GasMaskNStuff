package com.axolotl.pressureandstuff.entity;


import com.axolotl.pressureandstuff.PressureAndStuff;
import net.minecraft.world.entity.EntityType;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, PressureAndStuff.MODID);

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }


}
