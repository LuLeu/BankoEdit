package de.luleu.bankoedit.math;

public class BlockVector2D {

    private final int x, z;

    /**
     * Construct an instance.
     *
     * @param x the x coordinate
     * @param z the z coordinate
     */
    private BlockVector2D(int x, int z) {
        this.x = x;
        this.z = z;
    }

    public static BlockVector2D at(double x, double z) {
        return at((int) Math.floor(x), (int) Math.floor(z));
    }

    public static BlockVector2D at(int x, int z) {
        return new BlockVector2D(x, z);
    }

    /**
     * Add a list of vectors to this vector and return the
     * result as a new vector.
     * @param others an array of vectors
     * @return a new {@code BlockVector2D}
     */
    public BlockVector2D add(BlockVector2D... others) {
        int newX = x;
        int newZ = z;

        for (BlockVector2D other : others) {
            newX += other.x;
            newZ += other.z;
        }

        return BlockVector2D.at(newX, newZ);
    }

    /**
     * Subtract a list of vectors from this vector and return the result
     * as a new vector.
     *
     * @param others an array of vectors
     * @return a new {@code BlockVector2D}
     */
    public BlockVector2D subtract(BlockVector2D... others) {
        int newX = x;
        int newZ = z;

        for (BlockVector2D other : others) {
            newX -= other.x;
            newZ -= other.z;
        }

        return BlockVector2D.at(newX, newZ);
    }

    /**
     * Get the length of the vector.
     *
     * @return length
     */
    public double length() {
        return Math.sqrt(x * x + z * z);
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
     * Get the Z coordinate.
     *
     * @return the z coordinate
     */
    public int getZ() {
        return z;
    }
}
