
package agaricus.plugins.IncompatiblePlugin;

import java.util.HashMap;

import net.minecraft.server.v1_4_R1.IInventory;
import net.minecraft.server.v1_4_R1.MinecraftServer;
import net.minecraft.v1_4_R1.org.bouncycastle.asn1.bc.BCObjectIdentifiers;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_4_R1.CraftChunk;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;

/**
 * Sample plugin for Bukkit
 *
 * @author Dinnerbone
 */
public class SamplePlugin extends JavaPlugin {
    private final SamplePlayerListener playerListener = new SamplePlayerListener(this);
    private final SampleBlockListener blockListener = new SampleBlockListener();
    private final HashMap<Player, Boolean> debugees = new HashMap<Player, Boolean>();

    @Override
    public void onDisable() {
        // TODO: Place any custom disable code here

        // NOTE: All registered events are automatically unregistered when a plugin is disabled

        // EXAMPLE: Custom code, here we just output some info so we can check all is well
        getLogger().info("Goodbye world!");
    }

    @Override
    public void onEnable() {
        // TODO: Place any custom enable code here including the registration of any events

        System.out.println("IncompatiblePlugin");

        // test un-renamed map
        System.out.println("net.minecraft.server.v1_4_R1.MinecraftServer.currentTick = "+MinecraftServer.currentTick);

        // test bouncycastle is available
        System.out.println("bouncycastle="+net.minecraft.v1_4_R1.org.bouncycastle.asn1.bc.BCObjectIdentifiers.class);

        try {
            System.out.println("codeSource URI="+getClass().getProtectionDomain().getCodeSource().getLocation().toURI());
            System.out.println(" file = ="+new File(getClass().getProtectionDomain().getCodeSource().getLocation().toURI()));
            System.out.println("new canonical file = ="+(new File(getClass().getProtectionDomain().getCodeSource().getLocation().toURI())).getCanonicalFile());
        } catch (Throwable t) {
            System.out.println("codeSource URI exception="+t);
            t.printStackTrace();
        }

        System.out.println("SNOW.id="+net.minecraft.server.v1_4_R1.Block.SNOW.id);

   
        // test tasks
        Block b = Bukkit.getServer().getWorlds().get(0).getBlockAt(0, 100, 0);
        System.out.println("a="+((CraftChunk)b.getChunk()).getHandle().a(b.getX() & 15, b.getY(), b.getZ() & 15, 48, 0));

        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            public void run() {
                Block b = Bukkit.getServer().getWorlds().get(0).getBlockAt(0, 99, 0);
                System.out.println("a(task)="+((CraftChunk)b.getChunk()).getHandle().a(b.getX() & 15, b.getY(), b.getZ() & 15, 48, 0));
            }
        });

        // test inheritance remapping
        getLogger().info("creating class inheriting from NMS...");
        IInventory iInventory = new SamplePluginNMSInheritor();
        getLogger().info("iInventory= "+iInventory);
        // if subclass/implementator not remapped: java.lang.AbstractMethodError: SamplePluginNMSInheritor.k_()I
        getLogger().info("getSize="+iInventory.getSize());

        // Register our events
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(playerListener, this);
        pm.registerEvents(blockListener, this);

        // Register our commands
        getCommand("pos").setExecutor(new SamplePosCommand());
        getCommand("debug").setExecutor(new SampleDebugCommand(this));

        // EXAMPLE: Custom code, here we just output some info so we can check all is well
        PluginDescriptionFile pdfFile = this.getDescription();
        getLogger().info( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!" );
    }

    public boolean isDebugging(final Player player) {
        if (debugees.containsKey(player)) {
            return debugees.get(player);
        } else {
            return false;
        }
    }

    public void setDebugging(final Player player, final boolean value) {
        debugees.put(player, value);
    }
}
