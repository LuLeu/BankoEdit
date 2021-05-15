package de.luleu.bankoedit.operation;

import de.luleu.bankoedit.clipboard.ClipBoard;
import de.luleu.bankoedit.sessions.SessionManager;
import net.kyori.adventure.text.Component;

public class UndoOperation implements Operation {

    private final SessionManager.SessionHolder sessionHolder;

    public UndoOperation(SessionManager.SessionHolder sessionHolder) {
        this.sessionHolder = sessionHolder;
    }

    @Override
    public SessionManager.SessionHolder getSessionHolder() {
        return this.sessionHolder;
    }

    @Override
    public void execute() {
        ClipBoard clipBoard = this.getSessionHolder().getSession().getClipBoard();

        clipBoard.getBlocks().forEach(blockState -> blockState.getWorld().getBlockAt(blockState.getLocation()).setBlockData(blockState.getBlockData()));


        this.getSessionHolder().getPlayer().sendMessage(Component.text("§aDie Operation wurde rückgängig gemacht. §7Es wurden " + clipBoard.getBlocks().size() + " Blöcke ersetzt"));
    }
}
