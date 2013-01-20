package com.dinnerbone.bukkit.sample;

import net.minecraft.server.v1_4_R1.*;
import org.bukkit.craftbukkit.v1_4_R1.entity.CraftHumanEntity;

/**
 * A class in a plugin extending an NMS interface, for inheritance testing
 */
public class SamplePluginNMSInheritor implements
        IInventory  // obf la
{
    public int getSize() // MCP getSizeInventory, obf k_
    {
        return 0;
    }

    public ItemStack getItem(int i) // MCP getStackInSlot, obf a
    {
        return null;
    }

    public ItemStack splitStack(int i, int j) // MCP decrStackSize, obf a
    {
        return null;
    }

    public ItemStack splitWithoutUpdate(int i) // MCP getStackInSlotOnClosing, obf a_
    {
        return null;
    }

    public void setItem // MCP setInventorySlotContents, obf a
            (int i,
             ItemStack itemstack)
    {
        return;
    }

    public String getName() // MCP getInvName(), obf b
    {
        return "";
    }

    public int getMaxStackSize() // MCP getInventoryStackLimit, a_
    {
        return 0;
    }

    public void update() // MCP onInventoryChanged, obf d
    {
        return;
    }

    public boolean a_ // MCP isUseableByPlayer, obf a_
            (EntityHuman entityhuman) // MCP EntityPlayer, obf qx
    {
        return false;
    }

    public void startOpen() // MCP openChest, obf l_
    {
        return;
    }

    public void f() // MCP closeChest, obf f
    {
        return;
    }

    // CraftBukkit start
    public ItemStack[] getContents()
    {
        return null;
    }

    public void onOpen(CraftHumanEntity who)
    {
        return;
    }

    public void onClose(CraftHumanEntity who)
    {
        return;
    }

    public java.util.List<org.bukkit.entity.HumanEntity> getViewers()
    {
        return null;
    }

    public org.bukkit.inventory.InventoryHolder getOwner()
    {
        return null;
    }

    public void setMaxStackSize(int size)
    {
        return;
    }

    int MAX_STACK = 64;
    // CraftBukkit end
}
