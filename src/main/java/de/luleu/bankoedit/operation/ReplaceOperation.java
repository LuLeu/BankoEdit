package de.luleu.bankoedit.operation;

import de.luleu.bankoedit.sessions.SessionManager;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class ReplaceOperation implements Operation {

    private final SessionManager.SessionHolder sessionHolder;
    private final Material replace;
    private final Material toReplace;

    public ReplaceOperation(SessionManager.SessionHolder sessionHolder, Material replace, Material toReplace) {
        this.sessionHolder = sessionHolder;
        this.replace = replace;
        this.toReplace = toReplace;
    }

    @Override
    public SessionManager.SessionHolder getSessionHolder() {
        return this.sessionHolder;
    }

    @Override
    public void execute() {
        this.getRegionSelector().getRegion().forEach(blockVector -> {
            Block block = this.getRegionSelector().getWorld().getBlockAt(blockVector.getX(), blockVector.getY(), blockVector.getZ());

            if(block.getType().equals(this.getToReplace())) {
                block.setType(this.getReplace());
            }
        });
    }

    public Material getReplace() {
        return replace;
    }

    public Material getToReplace() {
        return toReplace;
    }
}
