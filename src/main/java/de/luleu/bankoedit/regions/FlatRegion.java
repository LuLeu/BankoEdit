package de.luleu.bankoedit.regions;

import de.luleu.bankoedit.math.BlockVector2D;

public interface FlatRegion extends Region {

    /**
     * Gets the minimum Y value.
     *
     * @return the Y value
     */
    int getMinimumY();

    /**
     * Gets the maximum Y value.
     *
     * @return the Y value
     */
    int getMaximumY();

    /**
     * Get this region as an iterable flat region.
     *
     * @return a flat region iterable
     */
    Iterable<BlockVector2D> asFlatRegion();
}