package com.chefsdelights.farmersrespite.common.block.entity.inventory;

import com.chefsdelights.farmersrespite.common.block.entity.KettleBlockEntity;
import com.nhoryzon.mc.farmersdelight.entity.block.CookingPotBlockEntity;
import com.nhoryzon.mc.farmersdelight.entity.block.inventory.ItemStackInventory;
import net.minecraft.core.Direction;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.stream.IntStream;

public interface KettlePotInventory extends ItemStackInventory, WorldlyContainer {
    static final int SLOTS_INPUT = 2;
    static final int SLOT_CONTAINER_INPUT = 3;
    static final int SLOT_MEAL_OUTPUT = 4;


    default int[] getSlotsForFace(Direction side) {
        if (side == Direction.DOWN) {
            return new int[]{SLOT_MEAL_OUTPUT};
        }

        if (side == Direction.UP) {
            return IntStream.range(0, SLOTS_INPUT).toArray();
        }

        return new int[]{SLOT_CONTAINER_INPUT};
    }

    @Override
    default boolean canPlaceItemThroughFace(int slot, ItemStack stack, @Nullable Direction dir) {
        if (dir == null || dir.equals(Direction.UP)) {
            return slot < SLOTS_INPUT;
        } else {
            return slot == SLOT_CONTAINER_INPUT;
        }
    }

    @Override
    default boolean canTakeItemThroughFace(int slot, ItemStack stack, Direction dir) {
        if (dir == null || dir.equals(Direction.UP)) {
            return slot < SLOTS_INPUT;
        } else {
            return slot == SLOT_MEAL_OUTPUT;
        }
    }
}

