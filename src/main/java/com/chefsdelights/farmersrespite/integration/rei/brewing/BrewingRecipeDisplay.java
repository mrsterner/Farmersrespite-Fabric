package com.chefsdelights.farmersrespite.integration.rei.brewing;

import com.chefsdelights.farmersrespite.crafting.KettleRecipe;
import com.chefsdelights.farmersrespite.integration.rei.FarmersRespiteReiPlugin;
import com.google.common.collect.ImmutableList;
import com.nhoryzon.mc.farmersdelight.recipe.CookingPotRecipe;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Environment(EnvType.CLIENT)
public class BrewingRecipeDisplay extends BasicDisplay {
    private final EntryIngredient containerOutput;
    private final int cookTime;

    public BrewingRecipeDisplay(KettleRecipe recipe) {
        super(EntryIngredients.ofIngredients(recipe.getIngredients()), Collections.singletonList(EntryIngredients.of(recipe.getOutput())), Optional.ofNullable(recipe.getId()));
        this.containerOutput = EntryIngredients.of(recipe.getContainer());
        this.brewTime = recipe.getBrewTime();
    }

    public BrewingRecipeDisplay() {

    }

    public CategoryIdentifier<?> getCategoryIdentifier() {
        return FarmersRespiteReiPlugin.BREWING;
    }

    public List<EntryIngredient> getInputEntries() {
        List<EntryIngredient> inputEntryList = new ArrayList(super.getInputEntries());
        inputEntryList.add(this.getContainerOutput());
        return ImmutableList.copyOf(inputEntryList);
    }

    public List<EntryIngredient> getIngredientEntries() {
        return super.getInputEntries();
    }

    public EntryIngredient getContainerOutput() {
        return this.containerOutput;
    }

    public int getCookTime() {
        return this.cookTime;
    }
}