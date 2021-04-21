package de.luleu.bankoedit.math;

public final class BlockVector3D {

    private final int x, y, z;

    /**
     * Construct an instance.
     *
     * @param x the X coordinate
     * @param y the Y coordinate
     * @param z the Z coordinate
     */
    public BlockVector3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static BlockVector3D at(double x, double y, double z) {
        return at((int) Math.floor(x), (int) Math.floor(y), (int) Math.floor(z));
    }

    public static BlockVector3D at(int x, int y, int z) {
        return new BlockVector3D(x, y, z);
    }

    /**
     * Checks to see if a vector is contained with another.
     *
     * @param min the minimum point (X, Y, and Z are the lowest)
     * @param max the maximum point (X, Y, and Z are the lowest)
     * @return true if the vector is contained
     */
    public boolean containedWithin(BlockVector3D min, BlockVector3D max) {
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
}
