package de.luleu.bankoedit.regions.selector;


import de.luleu.bankoedit.math.BlockVector;
import de.luleu.bankoedit.regions.Region;
import de.luleu.bankoedit.regions.RegionImpl;
import org.bukkit.World;
import org.jetbrains.annotations.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;

public class RegionSelectorImpl implements RegionSelector {

    protected final World world;
    protected BlockVector position1;
    protected BlockVector position2;
    protected Region region;

    /**
     * Create a new region selector in given world
     *
     * @param world the world
     */
    private RegionSelectorImpl(@Nullable World world) {
        this.world = world;
        this.region = RegionImpl.create(world);
    }

    public static RegionSelector create(@Nullable World world) {
        return new RegionSelectorImpl(world);
    }

    @Override
    public @Nullable World getWorld() {
        return null;
    }

    @Override
    public boolean selectPrimary(BlockVector position) {
        checkNotNull(position);

        if (position.equals(position1)) {
            return false;
        }

        position1 = position;
        region.setFirstVector(position1);
        return true;
    }

    @Override
    public boolean selectSecondary(BlockVector position) {
        checkNotNull(position);

        if (position.equals(position2)) {
            return false;
        }

        position2 = position;
        region.setSecondVector(position2);
        return true;
    }

    @Override
    public boolean isDefined() {
        return position1 != null && position2 != null;
    }

    @Override
    public Region getRegion() {
        return this.region;
    }

    @Override
    public String toString() {
        return "RegionSelectorImpl{" +
                "world=" + world +
                ", position1=" + position1 +
                ", position2=" + position2 +
                ", region=" + region +
                '}';
    }
}
