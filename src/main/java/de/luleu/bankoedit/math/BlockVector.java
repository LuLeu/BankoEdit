package de.luleu.bankoedit.math;

public final class BlockVector {

    private final int x, y, z;

    /**
     * Construct an instance.
     *
     * @param x the X coordinate
     * @param y the Y coordinate
     * @param z the Z coordinate
     */
    public BlockVector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static BlockVector at(double x, double y, double z) {
        return at((int) Math.floor(x), (int) Math.floor(y), (int) Math.floor(z));
    }

    public static BlockVector at(int x, int y, int z) {
        return new BlockVector(x, y, z);
    }

    /**
     * Checks to see if a vector is contained with another.
     *
     * @param min the minimum point (X, Y, and Z are the lowest)
     * @param max the maximum point (X, Y, and Z are the lowest)
     * @return true if the vector is contained
     */
    public boolean containedWithin(BlockVector min, BlockVector max) {
        return x >= min.x && x <= max.x && y >= min.y && y <= max.y && z >= min.z && z <= max.z;
    }

    /**
     * Get the X coordinate.
     *
     * @return the x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Get the Y coordinate.
     *
     * @return the y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Get the Z coordinate.
     *
     * @return the z coordinate
     */
    public int getZ() {
        return z;
    }

    /**
     * Subtract another vector from this vector and return the result
     * as a new vector.
     *
     * @param other the other vector
     * @return a new vector
     */
    public BlockVector subtract(BlockVector other) {
        return subtract(other.x, other.y, other.z);
    }

    /**
     * Subtract another vector from this vector and return the result
     * as a new vector.
     *
     * @param x the value to subtract
     * @param y the value to subtract
     * @param z the value to subtract
     * @return a new vector
     */
    public BlockVector subtract(int x, int y, int z) {
        return BlockVector.at(this.x - x, this.y - y, this.z - z);
    }

    /**
     * Add another vector to this vector and return the result as a new vector.
     *
     * @param other the other vector
     * @return a new vector
     */
    public BlockVector add(BlockVector other) {
        return add(other.x, other.y, other.z);
    }

    /**
     * Add another vector to this vector and return the result as a new vector.
     *
     * @param x the value to add
     * @param y the value to add
     * @param z the value to add
     * @return a new vector
     */
    public BlockVector add(int x, int y, int z) {
        return BlockVector.at(this.x + x, this.y + y, this.z + z);
    }

    /**
     * Get the X coordinate.
     *
     * @return the x coordinate
     */
    public int getBlockX() {
        return x;
    }

    /**
     * Get the Y coordinate.
     *
     * @return the y coordinate
     */
    public int getBlockY() {
        return y;
    }

    /**
     * Get the Z coordinate.
     *
     * @return the z coordinate
     */
    public int getBlockZ() {
        return z;
    }

    /**
     * Gets the maximum components of two vectors.
     *
     * @param blockVector the second vector
     * @return maximum
     */
    public BlockVector getMaximum(BlockVector blockVector) {
        return new BlockVector(
                Math.max(x, blockVector.x),
                Math.max(y, blockVector.y),
                Math.max(z, blockVector.z)
        );
    }

    /**
     * Gets the minimum components of two vectors.
     *
     * @param blockVector the second vector
     * @return minimum
     */
    public BlockVector getMinimum(BlockVector blockVector) {
        return new BlockVector(
                Math.min(x, blockVector.x),
                Math.min(y, blockVector.y),
                Math.min(z, blockVector.z)
        );
    }


    @Override
    public String toString() {
        return "BlockVector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
