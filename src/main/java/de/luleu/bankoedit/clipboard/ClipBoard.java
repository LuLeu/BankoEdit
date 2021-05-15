package de.luleu.bankoedit.clipboard;

import de.luleu.bankoedit.sessions.Session;
import de.luleu.bankoedit.sessions.SessionManager;
import org.bukkit.block.BlockState;

import java.util.ArrayList;
import java.util.List;

public interface ClipBoard extends Cloneable {

    default List<BlockState> getBlocks() {
        return new ArrayList<>();
    }

    void copyBlocks();

    Session getSession();

    SessionManager.SessionHolder getSessionHolder();

    ClipBoard clone();

}
