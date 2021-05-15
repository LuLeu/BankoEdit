package de.luleu.bankoedit.command;

import de.luleu.bankoedit.Main;
import de.luleu.bankoedit.operation.UndoOperation;
import de.luleu.bankoedit.sessions.SessionManager;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class UndoCommand implements CommandExecutor {

    public UndoCommand() {
        Objects.requireNonNull(Main.getPlugin(Main.class).getCommand("undo")).setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Component.text("§cUm diesen Befehl benutzen zu können musst du ein Spieler sein!"));
            return false;
        }

        final Player player = (Player) sender;

        if (!Main.sessionManager.contains(player)) {
            player.sendMessage(Component.text("§cDu hast keine Session, erstelle eine Session mit §8\"§3/session§8\""));
            return false;
        }

        SessionManager.SessionHolder holder = Main.sessionManager.getIfPresent(player);

        if (holder.getSession().getClipBoard().getBlocks().isEmpty()) {
            player.sendMessage(Component.text("§cDu musst erst eine Operation durch führen!"));
            return false;
        }

        holder.getSession().executeOperation(new UndoOperation(holder));

        return true;
    }
}
