package de.luleu.bankoedit;

import de.luleu.bankoedit.regions.Impl.RegionImpl;
import de.luleu.bankoedit.regions.Region;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        getCommand("mark").setExecutor(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        Region region = new RegionImpl(
                player.getWorld(),
                player.getLocation().getBlockX(),
                player.getLocation().getBlockY(),
                player.getLocation().getBlockZ(),
                player.getLocation().getBlockX() + 10,
                player.getLocation().getBlockY() + 10,
                player.getLocation().getBlockZ() + 10);

        region.forEach(blockVector -> {
            Block block = region.getWorld().getBlockAt(blockVector.getX(), blockVector.getY(), blockVector.getZ());

            block.setType(Material.STONE);
        });

        return false;
    }
}

