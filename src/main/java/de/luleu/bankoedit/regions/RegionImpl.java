package de.luleu.bankoedit.regions;

import de.luleu.bankoedit.math.BlockVector;
import org.bukkit.World;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.google.common.base.Preconditions.checkNotNull;

public class RegionImpl implements Region {

    protected World world;

    private BlockVector firstVector;
    private BlockVector secondVector;

    /**
     * Construct an instance.
     *
     * @param world The world of the region
     */
    public RegionImpl(World world) {
        this.world = world;
    }

    public RegionImpl(World world, int x1, int y1, int z1, int x2, int y2, int z2) {
        this.world = world;
        this.firstVector = BlockVector.at(x1, y1, z1);
        this.secondVector = BlockVector.at(x2, y2, z2);
    }

    public RegionImpl(World world, BlockVector firstVector, BlockVector secondVector) {
        this.world = world;
        this.firstVector = firstVector;
        this.secondVector = secondVector;
    }

    @Override
    public BlockVector getFirstVector() throws NullPointerException {
        checkNotNull(firstVector);

        return this.firstVector;
    }

    @Override
    public void setFirstVector(BlockVector blockVector) {
        this.firstVector = blockVector;
    }

    @Override
    public BlockVector getSecondVector() throws NullPointerException {
        checkNotNull(this.secondVector);

        return this.secondVector;
    }

    @Override
    public void setSecondVector(BlockVector blockVector) {
        this.secondVector = blockVector;
    }

    @Override
    public BlockVector getMinimumPoint() {
        return this.getFirstVector().getMinimum(this.getSecondVector());
    }

    @Override
    public BlockVector getMaximumPoint() {
        return this.getFirstVector().getMaximum(this.getSecondVector());
    }

    @Override
    public boolean contains(BlockVector position) {
        return position.containedWithin(this.getFirstVector(), this.getSecondVector());
    }

    @Override
    public Iterator<BlockVector> iterator() {
        return new Iterator<BlockVector>() {
            private final BlockVector min = getMinimumPoint();
            private final BlockVector max = getMaximumPoint();
            private int nextX = min.getBlockX();
            private int nextY = min.getBlockY();
            private int nextZ = min.getBlockZ();

            @Override
            public boolean hasNext() {
                return (nextX != Integer.MIN_VALUE);
            }

            @Override
            public BlockVector next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                BlockVector answer = BlockVector.at(nextX, nextY, nextZ);
                if (++nextX > max.getBlockX()) {
                    nextX = min.getBlockX();
                    if (++nextZ > max.getBlockZ()) {
                        nextZ = min.getBlockZ();
                        if (++nextY > max.getBlockY()) {
                            nextX = Integer.MIN_VALUE;
                        }
                    }
                }
                return answer;
            }
        };
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
    public Region clone() {
        try {
            return (Region) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean isSelected() {
        return this.firstVector != null || this.secondVector != null;
    }
}
