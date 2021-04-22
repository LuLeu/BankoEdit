package de.luleu.bankoedit.regions.impl;

import de.luleu.bankoedit.regions.Region;
import de.luleu.bankoedit.regions.iterator.RegionIterator;
import org.bukkit.World;
import org.jetbrains.annotations.Nullable;
import de.luleu.bankoedit.math.BlockVector;


import java.util.Iterator;

import static com.google.common.base.Preconditions.checkNotNull;

public class RegionImpl implements Region {

    protected World world;

    private BlockVector firstVector;
    private BlockVector secondVector;

    /**
     * Construct an instance.
     *
     * @param world   The world of the region
     */
    public RegionImpl(World world) {
        this.world = world;
    }

    public RegionImpl(World world, int x1, int y1, int z1, int x2, int y2, int z2) {
        this.world = world;
        this.firstVector = BlockVector.at(x1, y1, z1);
        this.secondVector = BlockVector.at(x2, y2, z2);
    }

    @Override
    public BlockVector getFirstVector() throws NullPointerException {
        checkNotNull(firstVector);

        return this.firstVector;
    }

    @Override
    public BlockVector getSecondVector() throws NullPointerException{
        checkNotNull(this.secondVector);

        return this.secondVector;
    }

    @Override
    public void setFirstVector(BlockVector blockVector) {
        this.firstVector = blockVector;
    }

    @Override
    public void setSecondVector(BlockVector blockVector) {
        this.secondVector = blockVector;
    }

    @Override
    public boolean contains(BlockVector position) {
        return position.containedWithin(this.getFirstVector(), this.getSecondVector());
    }

    @Override
    public Iterator<BlockVector> iterator() {
        return new RegionIterator(this);
    }

    @Override
    public World getWorld() {
        return world;
    }

    @Override
    public void setWorld(@Nullable World world) {
        this.world = world;
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
