package de.luleu.bankoedit.regions;

import de.luleu.bankoedit.math.BlockVector;
import org.bukkit.World;
import org.jetbrains.annotations.Nullable;

public interface Region extends Iterable<BlockVector>, Cloneable {

    /**
     * Get the lower point of a region.
     *
     * @return min. point
     */
    BlockVector getFirstVector();

    /**
     * Get the upper point of a region.
     *
     * @return max. point
     */
    BlockVector getSecondVector();

    /**
     * Sets the world that the selection is in.
     *
     * @return the world, or null
     */
    @Nullable World getWorld();

    /**
     * Sets the world that the selection is in.
     *
     * @param world the world, which may be null
     */
    void setWorld(@Nullable World world);

    /**
     * Returns true based on whether the region contains the point.
     *
     * @param position the position
     * @return true if contained
     */
    boolean contains(BlockVector position);

}
