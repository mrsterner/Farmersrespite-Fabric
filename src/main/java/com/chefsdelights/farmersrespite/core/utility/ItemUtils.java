package com.chefsdelights.farmersrespite.core.utility;

import io.github.fabricators_of_create.porting_lib.transfer.item.ItemStackHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Containers;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/**
 * Util for handling ItemStacks and inventories containing them.
 */
public class ItemUtils {
    public static void dropItems(Level level, BlockPos pos, ItemStackHandler inventory) {
        for (int slot = 0; slot < inventory.getSlots(); slot++)
            Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), inventory.getStackInSlot(slot));
    }

    public static boolean isInventoryEmpty(ItemStackHandler inventory) {
        for (int i = 0; i < inventory.getSlots(); i++) {
            if (!inventory.getStackInSlot(i).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static void spawnItemEntity(Level level, ItemStack stack, double x, double y, double z, double xMotion, double yMotion, double zMotion) {
        ItemEntity entity = new ItemEntity(level, x, y, z, stack);
        entity.setDeltaMovement(xMotion, yMotion, zMotion);
        level.addFreshEntity(entity);
    }
}
