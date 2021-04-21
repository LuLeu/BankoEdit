package de.luleu.bankoedit.regions.iterator;

import de.luleu.bankoedit.math.BlockVector3D;
import de.luleu.bankoedit.regions.Region;

import java.util.Iterator;

import static com.google.common.base.Preconditions.checkNotNull;

public class RegionIterator implements Iterator<BlockVector3D> {

    private final Region region;

    private final BlockVector3D max;
    private final BlockVector3D min;

    private final int maxX;
    private final int maxY;
    private final int maxZ;
    private int nextX;
    private int nextY;
    private int nextZ;

    public RegionIterator(Region region) {
        checkNotNull(region);

        this.region = region;

        this.max = region.getMaximumPoint();
        this.min = region.getMinimumPoint();

        this.maxX = this.max.getX();
        this.maxY = this.max.getY();
        this.maxZ = this.max.getZ();

        this.nextX = this.min.getX();
        this.nextY = this.min.getY();
        this.nextZ = this.min.getZ();
    }


    @Override
    public boolean hasNext() {
        return nextX != Integer.MIN_VALUE;
    }

    private void forward() {
        while (hasNext() && !region.contains(BlockVector3D.at(nextX, nextY, nextZ))) {
            forwardOne();
        }
    }

    private void forwardOne() {
        if (++this.nextX <= this.maxX) {
            return;
        }

        this.nextX = this.min.getX();

        if (++this.nextY <= this.maxY) {
            return;
        }

        this.nextY = this.min.getY();

        if (++this.nextZ <= this.maxZ) {
            return;
        }

        this.nextX = Integer.MIN_VALUE;
    }

    @Override
    public BlockVector3D next() {
        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public Region getRegion() {
        return region;
    }

    public BlockVector3D getMax() {
        return max;
    }

    public BlockVector3D getMin() {
        return min;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public int getMaxZ() {
        return maxZ;
    }

    public int getNextX() {
        return nextX;
    }

    public int getNextY() {
        return nextY;
    }

    public int getNextZ() {
        return nextZ;
    }
}
