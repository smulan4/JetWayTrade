package se.jetway.jetwaytrade;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import se.jetway.jetwaytrade.command.CommandHandler;
import se.jetway.jetwaytrade.menu.MenuEventHandler;

public final class JetWayTrade extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        registerCommand();
        registerEvents();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerEvents() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new MenuEventHandler(), this);
    }

    private void registerCommand() {
        try {
            getCommand("trade").setExecutor(new CommandHandler());
        } catch (NullPointerException e) {
            e.getMessage();
        }
    }

}
