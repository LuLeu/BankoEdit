package de.luleu.bankoedit.selector;

import de.luleu.bankoedit.math.BlockVector;
import de.luleu.bankoedit.regions.Region;
import org.bukkit.World;

public interface RegionSelector {

    /**
     * Get the world for the region selector.
     *
     * @return a world
     */
    World getWorld();

    /**
     * Called when the first point is selected.
     *
     * @param position the position
     * @return true if something changed
     */
    boolean selectPrimary(BlockVector position);

    /**
     * Called when the second point is selected.
     *
     * @param position the position
     * @return true if something changed
     */
    boolean selectSecondary(BlockVector position);

    /**
     * Returns whether the region has been fully defined.
     *
     * @return true if a selection is available
     */
    boolean isDefined();

    /**
     * Get the selection.
     *
     * @return the created region
     */
    Region getRegion();

    String toString();
}
