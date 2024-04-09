package com.chefsdelights.farmersrespite.core.event;

import com.chefsdelights.farmersrespite.core.registry.FRBiomeFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;

public class FRGeneration {

    public static void init() {
        BiomeModifications.addFeature(context -> context.hasTag(ConventionalBiomeTags.SWAMP), GenerationStep.Decoration.VEGETAL_DECORATION,
                FRBiomeFeatures.FRConfiguredFeaturesRegistry.PATCH_WILD_TEA_BUSH.key());
        BiomeModifications.addFeature(context -> context.getBiomeKey().equals(Biomes.BASALT_DELTAS), GenerationStep.Decoration.VEGETAL_DECORATION,
                FRBiomeFeatures.FRConfiguredFeaturesRegistry.PATCH_COFFEE_BUSH.key());
    }
}