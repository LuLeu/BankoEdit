package de.luleu.bankoedit.regions;

import de.luleu.bankoedit.math.BlockVector;
import de.luleu.bankoedit.regions.iterator.RegionIterator;
import org.bukkit.World;

import java.util.Iterator;

public abstract class AbstractRegion implements Region {

    protected World world;

    public AbstractRegion(World world) {
        this.world = world;
    }

    /**
     * Get the iterator.
     *
     * @return iterator of points inside the region
     */
    @Override
    public Iterator<BlockVector> iterator() {
        return new RegionIterator(this);
    }

}
