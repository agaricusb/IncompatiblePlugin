package com.dinnerbone.bukkit.sample;

import net.minecraft.server.v1_4_R1.*;

/**
 * A class in a plugin extending an NMS interface, for inheritance testing
 */
public class SamplePluginNMSInheritor implements IRecipe {
    public boolean a // MCP matches
            (InventoryCrafting inventoryCrafting,
             World world)
    {
        return false;
    }

    public ItemStack a // MCP getCraftingResult
        (InventoryCrafting inventoryCrafting)
    {
        return null;
    }

    public int a() // MCP getRecipeSize
    {
        return 9;
    }

    public ItemStack b() // MCP getRecipeOutput
    {
        return null;
    }

    public org.bukkit.inventory.Recipe toBukkitRecipe()
    {
        return null;
    }
}
