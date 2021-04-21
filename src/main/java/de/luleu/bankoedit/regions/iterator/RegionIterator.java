package de.luleu.bankoedit.regions.iterator;

import de.luleu.bankoedit.math.BlockVector;
import de.luleu.bankoedit.regions.Region;

import java.util.Iterator;

import static com.google.common.base.Preconditions.checkNotNull;

public class RegionIterator implements Iterator<BlockVector> {

    private final Region region;

    private final BlockVector max;
    private final BlockVector min;

    private final int maxX;
    private final int maxY;
    private final int maxZ;
    private int nextX;
    private int nextY;
    private int nextZ;

    public RegionIterator(Region region) {
        checkNotNull(region);

        this.region = region;

        this.max = region.getSecondVector();
        this.min = region.getFirstVector();

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
        while (hasNext() && !region.contains(BlockVector.at(nextX, nextY, nextZ))) {
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
    public BlockVector next() {
        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public Region getRegion() {
        return region;
    }

    public BlockVector getMax() {
        return max;
    }

    public BlockVector getMin() {
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
