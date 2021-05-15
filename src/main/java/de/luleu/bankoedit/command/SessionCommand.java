package de.luleu.bankoedit.command;

import de.luleu.bankoedit.Main;
import de.luleu.bankoedit.sessions.Session;
import de.luleu.bankoedit.sessions.SessionManager;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SessionCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cUm diesen Befehl benutzen zu können musst du ein Spieler sein!");
            return false;
        }

        final Player player = (Player) sender;

        if (args.length >= 1) {
            switch (args[0].toLowerCase()) {
                case "create": {
                    if (Main.sessionManager.contains(player)) {
                        player.sendMessage(Component.text("§cDu hast bereits eine Session!"));
                        return false;
                    }

                    Main.sessionManager.add(player);

                    player.getInventory().setItem(0, new ItemStack(Material.WOODEN_SHOVEL));
                    player.sendMessage(Component.text("§aEs wurde erfolgreich eine Session für dich erstellt."));
                }
                break;

                case "info": {
                    if (!Main.sessionManager.contains(player)) {
                        player.sendMessage(Component.text("§cDu hast keine Session, erstelle eine Session mit §8\"§3/session§8\""));
                        return false;
                    }

                    Session session = Main.sessionManager.getIfPresent(player).getSession();

                    player.sendMessage(Component.text(">--------------[Session]--------------<"));
                    player.sendMessage(Component.text(" - Execution size: " + session.getExecutionSize()));
                    player.sendMessage(Component.text(">--------------[Session]--------------<"));
                }
                break;
            }
        }

        return false;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        return null;
    }
}
