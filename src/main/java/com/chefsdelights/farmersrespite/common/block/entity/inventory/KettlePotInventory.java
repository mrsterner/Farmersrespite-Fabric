package com.chefsdelights.farmersrespite.common.block.entity.inventory;

import com.chefsdelights.farmersrespite.common.block.entity.KettleBlockEntity;
import io.github.fabricators_of_create.porting_lib.transfer.item.ItemStackHandler;
import io.github.fabricators_of_create.porting_lib.transfer.item.ItemStackHandlerContainer;
import net.minecraft.core.Direction;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.block.entity.CookingPotBlockEntity;
import vectorwing.farmersdelight.common.block.entity.inventory.CookingPotItemHandler;

import java.util.stream.IntStream;

public class KettlePotInventory extends ItemStackHandlerContainer {
    private static final int SLOTS_INPUT = 2;
    private static final int SLOT_CONTAINER_INPUT = 3;
    private static final int SLOT_MEAL_OUTPUT = 4;
    private final KettleBlockEntity kettleBlockEntity;

    public KettlePotInventory(KettleBlockEntity kettleBlockEntity) {
        super(9);
        this.kettleBlockEntity = kettleBlockEntity;
    }

    public int[] getSlotsForFace(Direction side) {
        if (side == Direction.DOWN) {
            return new int[]{SLOT_MEAL_OUTPUT};
        }

        if (side == Direction.UP) {
            return IntStream.range(0, SLOTS_INPUT).toArray();
        }

        return new int[]{SLOT_CONTAINER_INPUT};
    }

    public void onInventorySlotChanged(int slot) {
        if (slot >= 0 && slot < CookingPotBlockEntity.MEAL_DISPLAY_SLOT) {
            this.kettleBlockEntity.setCheckNewRecipe(true);
        }
    }
}

