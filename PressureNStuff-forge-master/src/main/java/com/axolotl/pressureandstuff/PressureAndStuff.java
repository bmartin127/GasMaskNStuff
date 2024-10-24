package com.axolotl.pressureandstuff;

import com.axolotl.pressureandstuff.client.CuriosLayerDefinitions;
import com.axolotl.pressureandstuff.client.model.GasMaskModel;
import com.axolotl.pressureandstuff.client.render.GasMaskRenderer;
import com.axolotl.pressureandstuff.item.ModIItems;
import com.axolotl.pressureandstuff.item.ModItemGroups;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(PressureAndStuff.MODID)
public class PressureAndStuff
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "pressureandstuff";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace


    public PressureAndStuff(FMLJavaModLoadingContext context)
    {
        var bus = FMLJavaModLoadingContext.get().getModEventBus();


        //IEventBus modEventBus = context.getModEventBus();


        ModItemGroups.register(bus);

        ModIItems.register(bus);

        // Register the commonSetup method for modloading
        bus.addListener(this::commonSetup);


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        bus.addListener(this::registerLayers);
        bus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

    }


    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
   // @SubscribeEvent
    //private void ClientSetup(final FMLClientSetupEvent evt)
    //{


    //}

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
            LOGGER.info("Registering curios renderers");
            CuriosRendererRegistry.register(ModIItems.GAS_DEBUGGER.get(), GasMaskRenderer::new);

        }
    }
    private void registerLayers(final EntityRenderersEvent.RegisterLayerDefinitions evt) {
        evt.registerLayerDefinition(CuriosLayerDefinitions.GAS_MASK, GasMaskModel::createLayer);

    }
}
