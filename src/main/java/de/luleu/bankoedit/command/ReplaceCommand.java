package de.luleu.bankoedit.command;

import de.luleu.bankoedit.Main;
import de.luleu.bankoedit.operation.ReplaceOperation;
import de.luleu.bankoedit.selector.RegionSelector;
import de.luleu.bankoedit.sessions.SessionManager;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class ReplaceCommand implements CommandExecutor, TabExecutor {

    public ReplaceCommand() {
        Objects.requireNonNull(Main.getPlugin(Main.class).getCommand("replace")).setExecutor(this);
        Objects.requireNonNull(Main.getPlugin(Main.class).getCommand("replace")).setTabCompleter(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cUm diesen Befehl benutzen zu können musst du ein Spieler sein!");
            return false;
        }

        final Player player = (Player) sender;
        final Material toReplace = Material.getMaterial(args[0].toUpperCase(Locale.ROOT));
        final Material replace = Material.getMaterial(args[1].toUpperCase(Locale.ROOT));


        if (toReplace == null) {
            player.sendMessage(Component.text("§cDu must ein valides Material angeben!"));
            return false;
        }

        if (replace == null) {
            player.sendMessage(Component.text("§cDu must ein valides Material angeben!"));
            return false;
        }

        if (!Main.sessionManager.contains(player)) {
            player.sendMessage(Component.text("§cDu hast keine Session, erstelle eine Session mit §8\"§3/session§8\""));
            return false;
        }

        SessionManager.SessionHolder holder = Main.sessionManager.getIfPresent(player);

        RegionSelector selector = holder.getSession().getRegionSelector();

        if (!selector.getRegion().isSelected()) {
            player.sendMessage(Component.text("§cDu musst erst 2 Positionen markieren!"));
            return false;
        }

        holder.getSession().setExecutionSize(holder.getSession().getExecutionSize() + 1);

        holder.getSession().executeOperation(new ReplaceOperation(holder, replace, toReplace));

        return true;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        List<String> strings = new ArrayList<>();

        if (args.length == 1) {
            for (Material material : Material.values()) {

                if (material.toString().startsWith(args[0].toUpperCase()) && material.isBlock())
                    strings.add(material.toString().toLowerCase());
            }
        } else if (args.length == 2) {
            for (Material material : Material.values()) {

                if (material.toString().startsWith(args[1].toUpperCase()) && material.isBlock())
                    strings.add(material.toString().toLowerCase());
            }
        }

        return strings;
    }

}
