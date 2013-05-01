package agaricus.plugins.IncompatiblePlugin;

import net.minecraft.server.v1_5_R3.*;
import org.bukkit.craftbukkit.v1_5_R3.entity.CraftHumanEntity;

/**
 * A class in a plugin extending an NMS interface, for inheritance testing
 */
public class SamplePluginNMSInheritor implements
        IInventory  // obf la
{
    public int getSize() // MCP getSizeInventory, obf j_
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

    public ItemStack splitWithoutUpdate(int i) // MCP getStackInSlotOnClosing, obf b
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

    public boolean c() // MCP isInvNameLocalized, obf c
    {
        return true;
    }

    public int getMaxStackSize() // MCP getInventoryStackLimit, a_
    {
        return 0;
    }

    public void update() // MCP onInventoryChanged, obf k_
    {
        return;
    }

    public boolean a // MCP isUseableByPlayer, obf a
            (EntityHuman entityhuman) // MCP EntityPlayer, obf qx
    {
        return false;
    }

    public void startOpen() // MCP openChest, obf f
    {
        return;
    }

    public void g() // MCP closeChest, obf g
    {
        return;
    }

    public boolean b(int i, ItemStack itemStack) // MCP isStackValidForSlot, obf b
    {
        return true;
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
