package de.luleu.bankoedit.sessions;

import de.luleu.bankoedit.regions.selector.RegionSelector;
import org.bukkit.entity.Player;

public interface Session {

    Player getPlayer();

    boolean isActive();

    void setActive(boolean active);

    RegionSelector getRegionSelector();

    Session clone();

    default int getExecutionSize() {
        return 0;
    }

    void setExecutionSize(int size);

}