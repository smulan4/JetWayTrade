package se.jetway.jetwaytrade;

import org.bukkit.plugin.java.JavaPlugin;
import se.jetway.jetwaytrade.command.CommandHandler;

public final class JetWayTrade extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        registerCommand();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerCommand() {
        try {
            getCommand("trade").setExecutor(new CommandHandler());
        } catch (NullPointerException e) {
            e.getMessage();
        }
    }

}
