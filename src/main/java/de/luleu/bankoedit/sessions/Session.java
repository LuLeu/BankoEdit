package de.luleu.bankoedit.sessions;

import de.luleu.bankoedit.clipboard.ClipBoard;
import de.luleu.bankoedit.operation.Operation;
import de.luleu.bankoedit.selector.RegionSelector;
import org.bukkit.entity.Player;

public interface Session {

    Player getPlayer();

    ClipBoard getClipBoard();

    boolean isActive();

    void setActive(boolean active);

    RegionSelector getRegionSelector();

    Session clone();

    default int getExecutionSize() {
        return 0;
    }

    void executeOperation(Operation operation);

    void setExecutionSize(int size);



}