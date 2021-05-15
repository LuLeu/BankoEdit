package de.luleu.bankoedit.operation;

import de.luleu.bankoedit.selector.RegionSelector;
import de.luleu.bankoedit.sessions.SessionManager;

public interface Operation {

    SessionManager.SessionHolder getSessionHolder();

    default RegionSelector getRegionSelector() {
        return this.getSessionHolder().getSession().getRegionSelector();
    }

    void execute();

}
