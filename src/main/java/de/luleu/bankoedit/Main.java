package de.luleu.bankoedit;

import de.luleu.bankoedit.command.SessionCommand;
import de.luleu.bankoedit.command.SetCommand;
import de.luleu.bankoedit.sessions.SessionManager;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements CommandExecutor {

    public static SessionManager sessionManager;

    @Override
    public void onEnable() {
        sessionManager = new SessionManager();

        this.getCommand("set").setExecutor(new SetCommand());
        this.getCommand("set").setTabCompleter(new SetCommand());

        this.getCommand("session").setExecutor(new SessionCommand());
        this.getCommand("session").setTabCompleter(new SessionCommand());
    }
}
