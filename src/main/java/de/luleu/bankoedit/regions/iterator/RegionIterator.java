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

        forward();
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
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }

        BlockVector answer = BlockVector.at(nextX, nextY, nextZ);

        forwardOne();
        forward();

        return answer;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
