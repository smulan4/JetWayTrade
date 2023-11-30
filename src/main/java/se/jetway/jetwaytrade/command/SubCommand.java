package se.jetway.jetwaytrade.command;

import org.bukkit.command.CommandSender;

public interface SubCommand {

    /**
     * Method which executes when Player uses the Command.
     *
     * @param commandSender The sender of the Command.
     * @param args List of arguments.
     */
    void execute(CommandSender commandSender, String[] args);

}


