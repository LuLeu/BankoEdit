package de.luleu.bankoedit.regions;

import de.luleu.bankoedit.math.BlockVector3D;
import de.luleu.bankoedit.regions.iterator.RegionIterator;
import org.bukkit.World;

import java.util.Iterator;

public class RegionImpl implements Region {

    protected final World world;

    public RegionImpl(World world) {
        this.world = world;
    }

    @Override
    public BlockVector3D getMinimumPoint() {
        return null;
    }

    @Override
    public BlockVector3D getMaximumPoint() {
        return ;
    }

    @Override
    public boolean contains(BlockVector3D position) {
        return position.containedWithin(this.getMinimumPoint(), this.getMaximumPoint());
    }

    @Override
    public Iterator<BlockVector3D> iterator() {
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
