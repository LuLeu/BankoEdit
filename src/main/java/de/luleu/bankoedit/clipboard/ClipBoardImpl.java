package de.luleu.bankoedit.clipboard;

import de.luleu.bankoedit.sessions.Session;
import de.luleu.bankoedit.sessions.SessionManager;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.BlockState;

import java.util.ArrayList;
import java.util.List;

public class ClipBoardImpl implements ClipBoard {

    private final SessionManager.SessionHolder sessionHolder;
    private final List<BlockState> blocks;

    private final Session session;

    public ClipBoardImpl(SessionManager.SessionHolder sessionHolder, Session session) {
        this.sessionHolder = sessionHolder;
        this.blocks = new ArrayList<>();
        this.session = session;
    }

    @Override
    public void copyBlocks() {
        if (!this.getSession().getRegionSelector().isDefined()) {
            this.getSessionHolder().getPlayer().sendMessage(Component.text("§cSession is not defined"));
            return;
        }

        this.getBlocks().clear();
        World world = this.getSession().getRegionSelector().getRegion().getWorld();

        this.getSession().getRegionSelector().getRegion().forEach(blockVector -> {
            BlockState blockState = world.getBlockAt(blockVector.getBlockX(), blockVector.getBlockY(), blockVector.getBlockZ()).getState();

            this.getBlocks().add(blockState);
        });
    }

    @Override
    public List<BlockState> getBlocks() {
        return this.blocks;
    }

    @Override
    public Session getSession() {
        return this.session;
    }

    @Override
    public SessionManager.SessionHolder getSessionHolder() {
        return this.sessionHolder;
    }

    @Override
    public ClipBoard clone() {
        try {
            return (ClipBoard) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
