package de.luleu.bankoedit.regions;

import de.luleu.bankoedit.math.BlockVector;
import org.bukkit.World;
import org.jetbrains.annotations.Nullable;

public interface Region extends Iterable<BlockVector>, Cloneable {

    /**
     * Get the first point of a region.
     *
     * @throws NullPointerException throws null when first or second vector is null
     * @return first point
     */
    BlockVector getFirstVector() throws NullPointerException;

    /**
     * Get the second point of a region.
     *
     * @return second point
     */
    BlockVector getSecondVector();

    /**
     * Set the first point of a region.
     */
    void setFirstVector(BlockVector blockVector);

    /**
     * Set the second point of a region.
     */
    void setSecondVector(BlockVector blockVector);

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
