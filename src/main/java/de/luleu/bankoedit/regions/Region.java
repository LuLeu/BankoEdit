package de.luleu.bankoedit.regions;

import de.luleu.bankoedit.math.BlockVector;
import org.bukkit.World;
import org.jetbrains.annotations.Nullable;

public interface Region extends Iterable<BlockVector>, Cloneable {

    /**
     * Get the first point of a region.
     *
     * @return first point
     * @throws NullPointerException throws null when first or second vector is null
     */
    BlockVector getFirstVector() throws NullPointerException;

    /**
     * Set the first point of a region.
     */
    void setFirstVector(BlockVector blockVector);

    /**
     * Get the second point of a region.
     *
     * @return second point
     */
    BlockVector getSecondVector();

    /**
     * Set the second point of a region.
     */
    void setSecondVector(BlockVector blockVector);

    /**
     * Get the lower point of a region.
     *
     * @return min. point
     */
    BlockVector getMinimumPoint();

    /**
     * Get the upper point of a region.
     *
     * @return max. point
     */
    BlockVector getMaximumPoint();

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

    /**
     * Make a clone of the region.
     *
     * @return a cloned version
     */
    Region clone();

    /**
     * @return true if both vectors aren't null
     */
    boolean isSelected();
}
