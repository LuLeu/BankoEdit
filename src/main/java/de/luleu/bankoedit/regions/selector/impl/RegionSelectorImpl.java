package de.luleu.bankoedit.regions.selector.impl;


import de.luleu.bankoedit.math.BlockVector;
import de.luleu.bankoedit.regions.Region;
import de.luleu.bankoedit.regions.impl.RegionImpl;
import de.luleu.bankoedit.regions.selector.RegionSelector;
import org.bukkit.World;
import org.jetbrains.annotations.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;

public class RegionSelectorImpl implements RegionSelector {

    protected final World world;
    protected BlockVector position1;
    protected BlockVector position2;
    protected Region region;

//    /**
//     * Create a new region selector with the given two positions.
//     *
//     * @param world the world
//     * @param position1 position 1
//     * @param position2 position 2
//     */
//    public RegionSelectorImpl(@Nullable World world, BlockVector position1, BlockVector position2) {
//        this.region = new RegionImpl(world);
//        this.world = world;
//
//        checkNotNull(position1);
//        checkNotNull(position2);
//        this.position1 = position1;
//        this.position2 = position2;
//
//        region.setFirstVector(this.position1);
//        region.setSecondVector(this.position2);
//    }

    /**
     * Create a new region selector in given world
     *
     * @param world the world
     */
    public RegionSelectorImpl(@Nullable World world) {
        this.world = world;

        this.init();
    }

    private void init() {
        checkNotNull(this.world);

        new RegionImpl(world);
        this.region = new RegionImpl(this.world);
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
}
