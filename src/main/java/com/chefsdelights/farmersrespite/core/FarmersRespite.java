package com.chefsdelights.farmersrespite.core;

import com.chefsdelights.farmersrespite.core.event.FRCommonSetup;
import com.chefsdelights.farmersrespite.core.event.FRGeneration;
import com.chefsdelights.farmersrespite.core.registry.*;
import com.google.common.reflect.Reflection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nhoryzon.mc.farmersdelight.FarmersDelightMod;
import com.nhoryzon.mc.farmersdelight.registry.BlocksRegistry;
import com.nhoryzon.mc.farmersdelight.registry.ItemsRegistry;
import fuzs.forgeconfigapiport.api.config.v2.ForgeConfigRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class FarmersRespite implements ModInitializer {
    public static final String MOD_ID = "farmersrespite";
    public static final ResourceKey<CreativeModeTab> CREATIVE_TAB = ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(MOD_ID, "group"));


    @Override
    public void onInitialize() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CREATIVE_TAB, FabricItemGroup.builder()
                .icon(() -> new ItemStack(FRBlocks.KETTLE.get()))
                .title(Component.translatable(MOD_ID + ".group.main"))
                .build());

        FRBlocks.registerAll();
        FRItems.registerAll();

        Reflection.initialize(
                FRRecipeSerializers.class,
                FREffects.class,
                FRBlockEntityTypes.class,
                FRContainerTypes.class,
                FRSounds.class,
                FRBiomeFeatures.class
        );

        ForgeConfigRegistry.INSTANCE.register(MOD_ID, ModConfig.Type.COMMON, FRConfiguration.COMMON_CONFIG);
        FRCommonSetup.init();
        FRBiomeFeatures.FRConfiguredFeaturesRegistry.registerAll();
        FRBiomeFeatures.registerAll();
        FRGeneration.init();
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    public static MutableComponent i18n(String key, Object... args) {
        return Component.translatable(MOD_ID + "." + key, args);
    }
}