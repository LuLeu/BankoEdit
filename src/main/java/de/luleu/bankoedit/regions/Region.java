package de.luleu.bankoedit.regions;

import de.luleu.bankoedit.math.BlockVector;

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
     * Returns true based on whether the region contains the point.
     *
     * @param position the position
     * @return true if contained
     */
    boolean contains(BlockVector position);

}
