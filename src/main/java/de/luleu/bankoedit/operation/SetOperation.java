package de.luleu.bankoedit.operation;

import de.luleu.bankoedit.sessions.SessionManager;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class SetOperation implements Operation {

    private final SessionManager.SessionHolder sessionHolder;
    private final Material material;

    public SetOperation(SessionManager.SessionHolder sessionHolder, Material material) {
        this.sessionHolder = sessionHolder;
        this.material = material;
    }

    @Override
    public SessionManager.SessionHolder getSessionHolder() {
        return this.sessionHolder;
    }

    public Material getMaterial() {
        return material;
    }

    @Override
    public void execute() {
        this.getRegionSelector().getRegion().forEach(blockVector -> {
            Block block = this.getRegionSelector().getWorld().getBlockAt(blockVector.getX(), blockVector.getY(), blockVector.getZ());

            block.setType(this.getMaterial());
        });
    }
}
