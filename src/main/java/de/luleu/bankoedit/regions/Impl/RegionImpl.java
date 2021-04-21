package de.luleu.bankoedit.regions.Impl;

import de.luleu.bankoedit.math.BlockVector;
import de.luleu.bankoedit.regions.Region;
import de.luleu.bankoedit.regions.iterator.RegionIterator;
import org.bukkit.World;

import java.util.Iterator;

public class RegionImpl implements Region {

    protected final World world;
    /**
     * <p>first coordinates</p>
     * <p>
     * x, y, z coordinate of first corner
     */
    private final int firstX,
            firstY,
            firstZ;

    /**
     * <p>second coordinates</p>
     * <p>
     * x, y, z coordinate of second corner
     */
    private final int secondX,
            secondY,
            secondZ;

    /**
     * Construct an instance.
     *
     * @param world   The world of the region
     * @param firstX  x coordinate of first corner
     * @param firstY  y coordinate of first corner
     * @param firstZ  z coordinate of first corner
     * @param secondX x coordinate of second corner
     * @param secondY y coordinate of second corner
     * @param secondZ z coordinate of second corner
     */
    public RegionImpl(World world, int firstX, int firstY, int firstZ, int secondX, int secondY, int secondZ) {
        this.world = world;
        this.firstX = firstX;
        this.firstY = firstY;
        this.firstZ = firstZ;
        this.secondX = secondX;
        this.secondY = secondY;
        this.secondZ = secondZ;
    }

    @Override
    public BlockVector getFirstVector() {
        return new BlockVector(firstX, firstY, firstZ);
    }

    @Override
    public BlockVector getSecondVector() {
        return new BlockVector(secondX, secondY, secondZ);
    }

    @Override
    public boolean contains(BlockVector position) {
        return position.containedWithin(this.getFirstVector(), this.getSecondVector());
    }

    @Override
    public Iterator<BlockVector> iterator() {
        return new RegionIterator(this);
    }

    public World getWorld() {
        return world;
    }

    @Override
    public RegionImpl clone() {
        try {
            return (RegionImpl) super.clone();
        } catch (CloneNotSupportedException exc) {
            return null;
        }
    }
}
