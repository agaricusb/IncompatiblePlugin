package com.dinnerbone.bukkit.sample;

import net.minecraft.server.v1_4_R1.IDispenseBehavior;
import net.minecraft.server.v1_4_R1.ISourceBlock;
import net.minecraft.server.v1_4_R1.ItemStack;

/**
 * A class in a plugin extending an NMS interface, for inheritance testing
 */
public class SamplePluginNMSInheritor implements IDispenseBehavior { // MCP IBehaviorDispenseItem, obf bb
    public ItemStack a // MCP dispense, obf bb/a
                (ISourceBlock src, // MCP IBlockSource, obf ahx
                 ItemStack item) // MCP ItemStack, obf bq
    {
        return item;
    }
}
