package de.luleu.bankoedit.sessions;

import de.luleu.bankoedit.Main;
import de.luleu.bankoedit.clipboard.ClipBoard;
import de.luleu.bankoedit.clipboard.ClipBoardImpl;
import de.luleu.bankoedit.math.BlockVector;
import de.luleu.bankoedit.operation.Operation;
import de.luleu.bankoedit.selector.RegionSelector;
import de.luleu.bankoedit.selector.RegionSelectorImpl;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class SessionImpl implements Session, Listener {

    private final Player player;
    private final RegionSelector regionSelector;

    private final ClipBoard clipBoard;

    private int executionSize;

    private boolean isActive;

    public SessionImpl(Player player) {
        this.player = player;
        this.isActive = true;
        this.executionSize = 0;

        Bukkit.getPluginManager().registerEvents(this, Main.getPlugin(Main.class));

        this.regionSelector = new RegionSelectorImpl(player.getWorld());
        this.clipBoard = new ClipBoardImpl(Main.sessionManager.getIfPresent(player), this);
    }

    @Override
    public Player getPlayer() {
        return this.player;
    }

    @Override
    public boolean isActive() {
        return this.isActive;
    }

    @Override
    public void setActive(boolean active) {
        this.isActive = active;
    }

    @Override
    public RegionSelector getRegionSelector() {
        return this.regionSelector;
    }

    @Override
    public Session clone() {
        try {
            return (Session) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (!event.getPlayer().equals(player)) {
            return;
        }

        if (event.getClickedBlock() == null) {
            return;
        }

        if (!player.getInventory().getItemInMainHand().getType().equals(Material.WOODEN_SHOVEL)) {
            return;
        }

        if (event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
            this.getRegionSelector().selectPrimary(BlockVector.at(event.getClickedBlock().getX(), event.getClickedBlock().getY(), event.getClickedBlock().getZ()));
            event.setCancelled(true);
        } else if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            this.getRegionSelector().selectSecondary(BlockVector.at(event.getClickedBlock().getX(), event.getClickedBlock().getY(), event.getClickedBlock().getZ()));
            event.setCancelled(true);
        }

        event.setCancelled(true);
    }

    @Override
    public int getExecutionSize() {
        return this.executionSize;
    }

    @Override
    public void setExecutionSize(int size) {
        this.executionSize = size;
    }

    @Override
    public void executeOperation(Operation operation) {
        this.getClipBoard().copyBlocks();

        operation.execute();
        this.setExecutionSize(this.getExecutionSize() + 1);
    }

    @Override
    public ClipBoard getClipBoard() {
        return clipBoard;
    }

}
