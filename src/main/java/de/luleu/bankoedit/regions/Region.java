package de.luleu.bankoedit.regions;

import de.luleu.bankoedit.math.BlockVector3D;

public interface Region extends Iterable<BlockVector3D>, Cloneable {

    /**
     * Get the lower point of a region.
     *
     * @return min. point
     */
    BlockVector3D getMinimumPoint();

    /**
     * Get the upper point of a region.
     *
     * @return max. point
     */
    BlockVector3D getMaximumPoint();

    /**
     * Returns true based on whether the region contains the point.
     *
     * @param position the position
     * @return true if contained
     */
    boolean contains(BlockVector3D position);

}
